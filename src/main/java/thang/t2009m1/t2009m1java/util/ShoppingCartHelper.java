package thang.t2009m1.t2009m1java.util;

import thang.t2009m1.t2009m1java.entity.ShoppingCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ShoppingCartHelper {
    private static final String SHOPPING_CART_SESSION_NAME = "SHOPPING_CART";
    HttpSession session;

    public ShoppingCartHelper(HttpServletRequest request) {
        this.session = request.getSession();
    }

    public ShoppingCart getCart() {
        ShoppingCart shoppingCart  = (ShoppingCart) session.getAttribute(SHOPPING_CART_SESSION_NAME);
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
        }
        return shoppingCart;
    }

    public void saveCart(ShoppingCart shoppingCart) {
        session.setAttribute(SHOPPING_CART_SESSION_NAME, shoppingCart);
    }
}
