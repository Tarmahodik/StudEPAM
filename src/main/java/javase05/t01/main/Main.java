package javase05.t01.main;

import javax.swing.*;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        new FileTreeFrame();
    }
}

class FileTreeFrame extends JFrame {
    private JTree fileTree;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu newMenu;
    private JMenuItem txtFileItem;
    private JMenuItem save;
    private JTextArea fileDetailsTextArea = new JTextArea();
    private String directory = "";


    public FileTreeFrame() {
        super("JTree FileSystem viewer");
        try {
            directory = System.getProperty("os.name").toLowerCase().contains("windows") ? "C://" : "/";
        } catch (RuntimeException e) {
            JFrame inputFrame = new JFrame();
            JTextField inputField = new JTextField("Enter your root path name here. ex: \"C://\"");
            JButton button = new JButton("Ok");
            inputField.add(inputField);
            inputField.add(button);
            button.addActionListener(e1 -> {
                directory = inputField.getText();
                inputField.setVisible(false);
            });
            inputFrame.pack();
            inputFrame.setVisible(true);
        }
        fileDetailsTextArea.setEditable(false);
        createGui();
        setJMenuBar(menuBar);

        FileSystemModel fileSystemModel = new FileSystemModel(new File(directory));
        fileTree = new JTree(fileSystemModel);
        fileTree.setEditable(true);
        fileTree.addTreeSelectionListener(e -> {
            File file = (File) fileTree.getLastSelectedPathComponent();
            fileDetailsTextArea.setText(getFileDetails(file));
        });
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, new JScrollPane(
                fileTree), new JScrollPane(fileDetailsTextArea));
        getContentPane().add(splitPane);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);
    }

    private void createGui() {
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        newMenu = new JMenu("New");
        newMenu.setMnemonic('N');
        save = new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        fileMenu.add(newMenu);
        txtFileItem = new JMenuItem("Text file");
        txtFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        newMenu.add(txtFileItem);
        menuBar.add(fileMenu);
        JMenuItem modify = new JMenuItem("Open");
        modify.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        fileMenu.add(save);
        save.addActionListener(e -> {
            String text = fileDetailsTextArea.getText();
            if (fileTree.getLastSelectedPathComponent().toString().contains(".txt")) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileTree.getSelectionPath().toString().replaceAll("\\]| |\\[|", "").replaceAll(",", File.separator))));
                    bw.write(text);
                    bw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        fileMenu.add(modify);
        modify.addActionListener(e12 -> {
            try (BufferedReader br = new BufferedReader(new FileReader(new File(fileTree.getSelectionPath().toString().replaceAll("\\]| |\\[|", "").replaceAll(",", File.separator))))) {
                fileDetailsTextArea.setEditable(true);
                StringBuilder sb = new StringBuilder();
                br.lines().forEach(x -> sb.append(x).append("\n"));
                fileDetailsTextArea.setText(sb.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        txtFileItem.addActionListener(e -> {
            JFrame window = new JFrame();
            window.setLayout(new BorderLayout());
            JPanel pTop = new JPanel();
            JPanel pBot = new JPanel();
            JLabel label = new JLabel("Enter full path here:");
            JTextField inputArea = new JTextField(20);
            inputArea.setEditable(true);
            JButton create = new JButton("Ok");
            pTop.add(label);
            pTop.add(inputArea);
            pBot.add(create);
            window.add(pTop, BorderLayout.NORTH);
            window.add(pBot, BorderLayout.SOUTH);
            create.addActionListener(x -> {
                try {
                    String fileName = inputArea.getText();
                    File file = new File(fileName);
                    file.createNewFile();
                    fileTree.updateUI();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                window.setVisible(false);
            });
            fileDetailsTextArea.setText("");
            fileDetailsTextArea.setEditable(true);
            window.pack();
            window.setVisible(true);
        });
    }

    private String getFileDetails(File file) {
        if (file == null)
            return "";
        return ("Name: " + file.getName() + "\n") +
                "Path: " + file.getPath() + "\n" +
                "Size: " + file.length() + "\n";
    }
}

class FileSystemModel implements TreeModel {
    private File root;
    private Vector listeners = new Vector();

    public FileSystemModel(File root) {
        this.root = root;
    }


    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public Object getChild(Object parent, int index) {
        File directory = (File) parent;
        String[] children = directory.list();
        return new TreeFile(directory, children[index]);
    }

    @Override
    public int getChildCount(Object parent) {
        File file = (File) parent;
        if (file.isDirectory()) {
            String[] fileList = file.list();
            if (fileList != null)
                return file.list().length;
        }
        return 0;
    }

    @Override
    public boolean isLeaf(Object node) {
        File file = (File) node;
        return file.isFile();
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        File oldFile = (File) path.getLastPathComponent();
        String fileParentPath = oldFile.getParent();
        String newFileName = (String) newValue;
        File targetFile = new File(fileParentPath, newFileName);
        oldFile.renameTo(targetFile);
        File parent = new File(fileParentPath);
        int[] changedChildrenIndices = {getIndexOfChild(parent, targetFile)};
        Object[] changedChildren = {targetFile};
        fireTreeNodesChanged(path.getParentPath(), changedChildrenIndices, changedChildren);

    }

    private void fireTreeNodesChanged(TreePath parentPath, int[] changedChildrenIndices, Object[] changedChildren) {
        TreeModelEvent event = new TreeModelEvent(this, parentPath, changedChildrenIndices, changedChildren);
        Iterator iterator = listeners.iterator();
        TreeModelListener listener;
        while (iterator.hasNext()) {
            listener = (TreeModelListener) iterator.next();
            listener.treeNodesChanged(event);
        }
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        return 0;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        listeners.add(l);

    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        listeners.remove(l);

    }

    private class TreeFile extends File {
        public TreeFile(File parent, String child) {
            super(parent, child);
        }

        public String toString() {
            return getName();
        }
    }
}