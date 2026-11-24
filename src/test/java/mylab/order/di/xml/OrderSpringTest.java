
package mylab.order.di.xml;

// JUnit에서 제공하는 테스트 관련 기능을 가져온다.
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

// Spring의 의존성 주입 기능을 가져온다.
import org.springframework.beans.factory.annotation.Autowired;

// Spring 설정 파일을 지정하는 기능을 가져온다.
import org.springframework.test.context.ContextConfiguration;

// JUnit과 Spring을 연결하는 기능을 가져온다.
import org.springframework.test.context.junit.jupiter.SpringExtension;

// 테스트 결과를 검증하는 메서드를 가져온다.
import static org.junit.jupiter.api.Assertions.*;


// JUnit 테스트에서 Spring을 사용할 수 있도록 연결한다.
@ExtendWith(SpringExtension.class)

// Spring에게 어떤 XML 설정 파일을 읽어야 하는지 알려준다.
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")

public class OrderSpringTest {


    // ==========================================
    // 1. Spring Bean 주입받기
    // ==========================================

    // Spring Container에서 관리하는 ShoppingCart 객체를
    // 찾아서 이 변수에 자동으로 주입한다.
    @Autowired
    private ShoppingCart shoppingCart;


    // Spring Container에서 관리하는 OrderService 객체를
    // 찾아서 이 변수에 자동으로 주입한다.
    @Autowired
    private OrderService orderService;


    // ==========================================
    // 2. ShoppingCart 테스트
    // ==========================================

    // @Test : JUnit에게 이 메서드가 테스트임을 알려준다.
    @Test
    public void testShoppingCart() {

        // 장바구니 객체가 정상적으로 주입되었는지 확인한다.
        // null이면 테스트 실패
        assertNotNull(shoppingCart);


        // 장바구니에 상품이 2개 들어 있는지 확인한다.
        // assertEquals(기대하는 값, 실제 값)
        assertEquals(2, shoppingCart.getProducts().size());


        // 첫 번째 상품의 이름이 "노트북"인지 확인한다.
        // 리스트의 순서는 0부터 시작한다.
        assertEquals("노트북",
                shoppingCart.getProducts().get(0).getName());


        // 두 번째 상품의 이름이 "스마트폰"인지 확인한다.
        assertEquals("스마트폰",
                shoppingCart.getProducts().get(1).getName());
    }


    // ==========================================
    // 3. OrderService 테스트
    // ==========================================

    @Test
    public void testOrderService() {

        // OrderService 객체가 정상적으로 주입되었는지 확인한다.
        assertNotNull(orderService);


        // OrderService 내부에 ShoppingCart 객체가
        // 정상적으로 연결되어 있는지 확인한다.
        assertNotNull(orderService.getShoppingCart());


        // 주문 총금액이 올바르게 계산되는지 확인한다.
        // 노트북 150000 + 스마트폰 800000 = 950000
        // 0.001은 double 자료형의 계산 오차 허용 범위이다.
        assertEquals(950000.0,
                orderService.calculateOrderTotal(), 0.001);
    }
}
