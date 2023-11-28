package kr.co.kjc.spring.dip.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
