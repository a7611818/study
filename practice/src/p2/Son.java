package p2;


import p.Supper;

public class Son extends Supper {
    @Override
    public void haha() {
        super.haha();
    }

    void ttt() throws CloneNotSupportedException {
        super.haha();
        super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Son son = new Son();
        son.clone();
        son.haha();
    }
}
