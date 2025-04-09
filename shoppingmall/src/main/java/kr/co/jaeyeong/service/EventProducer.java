package kr.co.jaeyeong.service;

import kr.co.jaeyeong.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventProducer {

    private final StreamBridge streamBridge;


    public void sendOrderEvent(Event event){
        streamBridge.send("order-out", event);
    }

    public void sendPaymentEvent(Event event){
        streamBridge.send("payment-out", event);
    }

    public void sendShopping(Event event){
        streamBridge.send("shipping-out", event);
    }

}
