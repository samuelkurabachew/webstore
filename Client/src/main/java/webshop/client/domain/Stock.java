package webshop.client.domain;

public class Stock {

    private String stockId;
    private int quantity;


    public Stock() {

        quantity = 1;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String id){
        stockId = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity(int count) {
        this.quantity = quantity + count;
    }

    public void decrementQuantity(int count) {
        this.quantity = quantity - count;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId='" + stockId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
