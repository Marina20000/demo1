package util;

public class Increment extends Thread{
    private Integer n;


    public void run(){
        for (int i = 0; i < 10000; i++) {
            ++n;
            System.out.println(n);
        }
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return                 "n=" + n ;
    }

}
