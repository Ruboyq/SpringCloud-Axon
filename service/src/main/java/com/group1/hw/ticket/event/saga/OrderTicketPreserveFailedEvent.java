package com.group1.hw.ticket.event.saga;

public class OrderTicketPreserveFailedEvent {

    private String orderId;

    public OrderTicketPreserveFailedEvent(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
