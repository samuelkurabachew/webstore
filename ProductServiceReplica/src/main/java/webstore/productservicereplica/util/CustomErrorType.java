package webstore.productservicereplica.util;

public class CustomErrorType {
    private String message;


    public CustomErrorType(String errorMessage) {
        this.message = errorMessage;
    }


    public String getMessage() {
        return message;
    }
}
