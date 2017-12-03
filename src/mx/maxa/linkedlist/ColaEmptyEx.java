package mx.maxa.linkedlist;

public class ColaEmptyEx extends Exception {
    public ColaEmptyEx(){}
    public ColaEmptyEx(String Cause){
        super(Cause);
    }
    public ColaEmptyEx(Throwable Cause){
        super(Cause);
    }
}
