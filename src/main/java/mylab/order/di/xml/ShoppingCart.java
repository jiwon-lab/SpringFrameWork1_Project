
package mylab.order.di.xml;

// Java에서 제공하는 List 자료구조를 사용하기 위해 가져온다.
// List는 여러 개의 데이터를 순서대로 저장할 수 있다.
import java.util.List;

public class ShoppingCart {

    // ==========================================
    // 1. 필드 (Field)
    // ==========================================

    // Product 객체 여러 개를 담을 수 있는 리스트를 선언한다.
    // List<Product>는 Product 타입만 담을 수 있는 리스트이다.
    // 아직 리스트 객체를 생성하거나 상품을 넣은 것은 아니다.

    private List<Product> products;


    // ==========================================
    // 2. 기본 생성자
    // ==========================================

    // 장바구니 객체를 생성한다.
    // 상품 목록은 나중에 Setter를 통해 전달받는다.

    public ShoppingCart() {
    }


    // ==========================================
    // 3. Getter와 Setter
    // ==========================================

    // 현재 장바구니에 저장된 상품 목록을 반환한다.

    public List<Product> getProducts() {
        return products;
    }


    // 외부에서 상품 목록을 전달받아 장바구니에 저장한다.
    // 이번 과제에서는 Spring이 이 메서드를 호출하여
    // product1과 product2가 담긴 리스트를 주입한다.

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    // ==========================================
    // 4. 상품 가격을 모두 더하는 메서드
    // ==========================================

    // double: 계산 결과를 숫자로 반환한다.
    public double getTotalPrice() {

        // 합계 금액을 저장할 변수를 0으로 초기화한다.
        double total = 0.0;

        // 향상된 for문 (Enhanced For Loop)
        // products 리스트에서 상품을 하나씩 꺼낸다.
        // 꺼낸 상품은 product라는 변수에 저장된다.

        for (Product product : products) {

            // getPrice()로 해당 상품의 가격을 가져온다.
            // += 는 기존 값에 새로운 값을 더한다는 뜻이다.

            total += product.getPrice();
        }

        // 모든 상품의 가격을 더한 결과를 반환한다.
        return total;
    }


    // ==========================================
    // 5. toString() 메서드
    // ==========================================

    // 장바구니에 담긴 상품 목록을 문자열로 반환한다.

    @Override
    public String toString() {
        return "ShoppingCart [products=" + products + "]";
    }
}
