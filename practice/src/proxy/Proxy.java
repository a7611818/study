package proxy;

import java.lang.reflect.InvocationTargetException;

public class Proxy {

    private Object o;

    public Proxy(Object o) {
        this.o = o;
    }


    public void invoke(String methodName, Object... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("代理");
    }


    //测试
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Proxy proxy = new Proxy(new Task());
//        proxy.执行xx方法
    }
}
