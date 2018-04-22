package javase04.t02;

import java.io.File;

class Getter {
    File getFile(String name) {
        ClassLoader cl = getClass().getClassLoader();
        return new File(cl.getResource(name).getFile());
    }
}