package webstore.productservicereplica2.util;

public class CustomMessageType<T> {
    private boolean message;
    private T t;


    public CustomMessageType(boolean message) {
        this.message = message;
    }

    public CustomMessageType(boolean message, T t) {
        this.message = message;
        this.t = t;
    }


    public boolean getsuccess() {
        return message;
    }

    public T getData() {
        return t;
    }

}
