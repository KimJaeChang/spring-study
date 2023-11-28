package kr.co.kjc.spring.non_dip.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
