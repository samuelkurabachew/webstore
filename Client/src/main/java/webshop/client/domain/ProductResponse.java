package webshop.client.domain;

public class ProductResponse {
    String success;
    Product data;

    @Override
    public String toString() {
        return "ProductResponse{" +
                "success='" + success + '\'' +
                ", data=" + data +
                '}';
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Product getData() {
        return data;
    }

    public void setData(Product data) {
        this.data = data;
    }
}
