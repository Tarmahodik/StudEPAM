package javase04.t03;

import java.io.File;

class Getter {
    File getFile(String name) {
        ClassLoader cl = getClass().getClassLoader();
        return new File(cl.getResource(name).getFile());
    }
}