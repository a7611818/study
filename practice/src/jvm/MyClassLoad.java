package jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoad extends ClassLoader {

    public String path;

    public MyClassLoad() {

    }

    public MyClassLoad(ClassLoader o) {
        super(o);
    }

    @Override
    public Class findClass(String name) {
        System.out.println("我是自定义");
        byte[] b = new byte[0];
        try {
            b = loadClassData(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String name) throws IOException {
        String str = "out/production/" + name.replace(".", "/") + ".class";
        if (this.path != null) {
            str = path + name.replace(".", "/") + ".class";
        }
        FileInputStream fis = new FileInputStream(str);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int len = -1;
        byte[] bytes = new byte[10];
        while ((len = fis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        bos.close();
        fis.close();

        return bos.toByteArray();
    }


    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoad mcl = new MyClassLoad(null);
        mcl.path = "d:/";
        mcl.loadClass("Solution");
    }
}
