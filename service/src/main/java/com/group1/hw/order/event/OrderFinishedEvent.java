package com.group1.hw.order.event;

public class OrderFinishedEvent {

    private String orderId;

    public OrderFinishedEvent(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
