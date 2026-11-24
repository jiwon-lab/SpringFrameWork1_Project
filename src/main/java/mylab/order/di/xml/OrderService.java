
package mylab.order.di.xml;

public class OrderService {

    // ==========================================
    // 1. 필드 (Field)
    // ==========================================

    // 주문을 처리하기 위해 ShoppingCart 객체가 필요하다.
    // 이것을 의존 관계(Dependency)라고 한다.
    // 아직 실제 ShoppingCart 객체를 생성한 것은 아니다.

    private ShoppingCart shoppingCart;


    // ==========================================
    // 2. 기본 생성자
    // ==========================================

    // OrderService 객체를 생성한다.
    // ShoppingCart는 나중에 Setter를 통해 전달받는다.

    public OrderService() {
    }


    // ==========================================
    // 3. Getter와 Setter
    // ==========================================

    // 현재 연결되어 있는 장바구니 객체를 반환한다.
    // 나중에 JUnit 테스트에서 주입 여부를 확인할 때 사용한다.

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }


    // 외부에서 ShoppingCart 객체를 전달받는다.
    // 이번 과제에서는 Spring이 이 메서드를 호출한다.
    // 이것이 Setter Injection(세터 주입)이다.

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }


    // ==========================================
    // 4. 주문 총금액을 계산하는 메서드
    // ==========================================

    public double calculateOrderTotal() {

        // OrderService가 직접 상품 가격을 더하지 않는다.
        // ShoppingCart의 getTotalPrice() 메서드를 호출한다.
        // 그리고 계산된 결과를 그대로 반환한다.

        return shoppingCart.getTotalPrice();
    }


    // ==========================================
    // 5. toString() 메서드
    // ==========================================

    // 연결된 장바구니의 정보를 문자열로 반환한다.

    @Override
    public String toString() {
        return "OrderService [shoppingCart="
                + shoppingCart + "]";
    }
}
