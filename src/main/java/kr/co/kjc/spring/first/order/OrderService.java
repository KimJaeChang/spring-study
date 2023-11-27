package kr.co.kjc.spring.first.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
