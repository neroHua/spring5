package asm.chapter04.case04;

public class CChange {

    public static long timer;

    public void m() throws Exception {
        timer -= System.currentTimeMillis();
        Thread.sleep(100);
        timer += System.currentTimeMillis();
    }

}
