package util;

import domain.Id;

public class ThreadExample extends Thread{
   private Id n;

    public ThreadExample(Id n) {
        this.n = n;
    }

    public void add() {
        Integer integer = n.getN();
        n.setN(++integer);
        System.out.println(n.getN());
    }


    public void run(){
        for (int i=0; i<1000; i++){
            add();
        }
    }

}
