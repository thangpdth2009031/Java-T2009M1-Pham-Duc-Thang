package thang.t2009m1.t2009m1java.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCart {
    private BigDecimal totalPrice;
    private String shipName;
    private String shipAddress;
    private String shipPhone;
    private String shipNote;
    private HashMap<Integer, CartItem> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public List<CartItem> getListItems() {
        return new ArrayList<>(items.values());
    }

    public boolean add(Product product, int quantity) {

        CartItem cartItem = null;
        if (items.containsKey(product.getId())) {
            cartItem = items.get(product.getId());
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            cartItem = CartItem.CartItemBuilder.aCartItem()
                    .withProductId(product.getId())
                    .withProductName(product.getName())
                    .withProductThumbnail(product.getThumbnail())
                    .withUnitPrice(product.getPrice())
                    .withQuantity(quantity)
                    .build();
        }
        items.put(product.getId(), cartItem);
        return true;
    }

    public boolean sub(Product product, int quantity) {
        CartItem cartItem = null;
        if (items.containsKey(product.getId())) {
            cartItem = items.get(product.getId());
            int updateQuantity = cartItem.getQuantity() - quantity;
            if (updateQuantity <= 0) {
                items.remove(product.getId());
            } else {
                cartItem.setQuantity(updateQuantity);
            }
        }
        return true;
    }

    public boolean remove(int productId) {
        if (items.containsKey(productId)) {
            items.remove(productId);
            return true;
        }
        return false;
    }

    public void clear() {
        items.clear();
    }

    public BigDecimal getTotalPrice() {
        if (items.size() == 0) {
            return BigDecimal.valueOf(0);
        }
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartItem item : getListItems()) {
            totalPrice = totalPrice.add(item.getUnitPrice().multiply(new BigDecimal(item.getQuantity())));
        }
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    public String getShipNote() {
        return shipNote;
    }

    public void setShipNote(String shipNote) {
        this.shipNote = shipNote;
    }
}
