package kr.co.jaeyeong.controller;

import kr.co.jaeyeong.Event;
import kr.co.jaeyeong.service.EventProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final EventProducer eventProducer;

    public OrderController(EventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    @PostMapping("/create")
    public String createOrder(@RequestBody String orderId) {
        Event orderEvent = new Event("ORDER", orderId, "CREATED");
        eventProducer.sendOrderEvent(orderEvent);
        return "Order Created and Event Sent!";
    }
}