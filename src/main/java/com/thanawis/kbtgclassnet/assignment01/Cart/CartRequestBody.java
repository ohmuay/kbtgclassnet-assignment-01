package com.thanawis.kbtgclassnet.assignment01.Cart;

public class CartRequestBody {

    private Long productId;
    private Integer quantity;

    public CartRequestBody(){};

    public CartRequestBody(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
