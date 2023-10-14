package enums;

public enum ProductStatus {
    ACTIVE(1),
    INACTIVE(0),
    STOP(-1);
    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getInvoke() {
        return value;
    }
}
