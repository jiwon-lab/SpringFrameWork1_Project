
// 이 클래스가 소속된 패키지(폴더)를 지정한다.
package mylab.order.di.xml;

// Product라는 이름의 클래스를 정의한다.
// public: 다른 클래스에서도 이 클래스를 사용할 수 있다.
public class Product {

    // ==========================================
    // 1. 필드 (Field) : 상품의 정보를 저장하는 변수
    // ==========================================

    // String: 문자열을 저장하는 자료형
    // double: 소수점이 있는 숫자도 저장할 수 있는 자료형
    // private: 외부에서 변수에 직접 접근하지 못하도록 제한

    private String id;      // 상품 고유 번호
    private String name;    // 상품 이름
    private double price;   // 상품 가격


    // ==========================================
    // 2. 기본 생성자 (Default Constructor)
    // ==========================================

    // 상품 정보를 전달하지 않고 빈 객체를 생성한다.
    // 이번 과제에서 product1을 생성할 때 사용한다.
    // 객체 생성 후 Setter로 값을 넣을 수 있다.

    public Product() {
    }


    // ==========================================
    // 3. 매개변수가 있는 생성자 (Constructor)
    // ==========================================

    // 객체를 생성하는 동시에 상품 정보를 전달받는다.
    // 이번 과제에서 product2를 생성할 때 사용한다.

    public Product(String id, String name, double price) {

        // this.id: 이 객체가 가지고 있는 필드
        // id: 외부에서 전달받은 매개변수

        this.id = id;
        this.name = name;
        this.price = price;
    }


    // ==========================================
    // 4. Getter와 Setter
    // ==========================================

    // Getter: 저장된 값을 외부에서 읽을 수 있게 한다.
    // Setter: 외부에서 전달받은 값을 저장한다.


    // 상품 ID를 반환한다.
    public String getId() {
        return id;
    }

    // 상품 ID를 변경한다.
    // void: 반환하는 값이 없다는 의미
    public void setId(String id) {
        this.id = id;
    }


    // 상품 이름을 반환한다.
    public String getName() {
        return name;
    }

    // 상품 이름을 변경한다.
    public void setName(String name) {
        this.name = name;
    }


    // 상품 가격을 반환한다.
    public double getPrice() {
        return price;
    }

    // 상품 가격을 변경한다.
    public void setPrice(double price) {
        this.price = price;
    }


    // ==========================================
    // 5. toString() 메서드
    // ==========================================

    // 객체의 정보를 사람이 읽기 쉬운 문자열로 반환한다.
    // @Override: 부모 클래스의 기존 메서드를 재정의한다.

    @Override
    public String toString() {
        return "Product [id=" + id
                + ", name=" + name
                + ", price=" + price + "]";
    }
}
