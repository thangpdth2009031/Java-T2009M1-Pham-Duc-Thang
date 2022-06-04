package thang.t2009m1.t2009m1java.controller.myenum;

public enum ProductStatus {
    STOCK (1), OUT_OF_STOCK(0), APPROVED(2), NOT_APPROVED(-2),DELETED(-1), UNDEFINE(3);
    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static ProductStatus of(int value){
        for (ProductStatus productStatus: ProductStatus.values()
             ) {
            if (productStatus.getValue() == value) {
                return productStatus;
            }
        }
        return UNDEFINE;
    }
}
