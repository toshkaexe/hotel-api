package hotel;

import java.util.ArrayList;

public class Initializaers {
    public void start(){
        System.out.println("Start");
    }

    public void run(){
        System.out.println("run");

    }
public static int testmedon(){
        int i = 0;
    try{
        i = 1000/0;
    }
    catch (Exception e){
        i = 200;
        return i;
    }
    finally {
        i =300;
        return  i;

    }
}
    static public void main(String[] args){
 System.out.println("fff" + testmedon());

    }
}
