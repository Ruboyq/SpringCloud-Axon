package com.group1.hw.ticket.event;

public class OrderTicketUnlockedEvent {

    private String ticketId;

    public OrderTicketUnlockedEvent(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketId() {
        return ticketId;
    }
}
