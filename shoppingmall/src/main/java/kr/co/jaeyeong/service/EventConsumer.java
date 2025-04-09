package kr.co.jaeyeong.service;

import kr.co.jaeyeong.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventConsumer {

    @KafkaListener(topics = "order-events", groupId = "order-processing-group")
    public void handleOrderEvent(Event event) {
        System.out.println("Order Event Received: " + event);
        // 주문 처리 로직 추가
    }

    @KafkaListener(topics = "payment-events", groupId = "payment-processing-group")
    public void handlePaymentEvent(Event event) {
        System.out.println("Payment Event Received: " + event);
        // 결제 처리 로직 추가
    }

    @KafkaListener(topics = "shipping-events", groupId = "shipping-processing-group")
    public void handleShippingEvent(Event event) {
        System.out.println("Shipping Event Received: " + event);
        // 배송 처리 로직 추가
    }


}
