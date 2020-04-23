package com.group1.hw.order.query;


import com.group1.hw.user.event.saga.OrderPaidEvent;
import com.group1.hw.order.event.saga.OrderCreatedEvent;
import com.group1.hw.order.event.OrderFailedEvent;
import com.group1.hw.order.event.OrderFinishedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mavlarn on 2018/5/22.
 */
@Service
@ProcessingGroup("OrderEventProcessor")
public class OrderProjector {

    @Autowired
    private OrderEntityRepository repository;

    @EventHandler
    public void on(OrderCreatedEvent event) {
        OrderEntity order = new OrderEntity();
        order.setId(event.getOrderId());
        order.setCustomerId(event.getCustomerId());
        order.setTicketId(event.getTicketId());
        order.setAmount(event.getAmount());
        order.setCreatedDate(event.getCreatedDate());
        order.setTitle(event.getTitle());
        order.setStatus("NEW");
        repository.save(order);
    }

    @EventSourcingHandler
    public void onPaid(OrderPaidEvent event) {
        OrderEntity order = repository.findOne(event.getOrderId());
        order.setStatus("PAID");
        repository.save(order);
    }

    @EventSourcingHandler
    public void onFinished(OrderFinishedEvent event) {
        OrderEntity order = repository.findOne(event.getOrderId());
        order.setStatus("FINISH");
        repository.save(order);
    }

    @EventSourcingHandler
    public void onFailed(OrderFailedEvent event) {
        OrderEntity order = repository.findOne(event.getOrderId());
        order.setStatus("FAILED");
        order.setReason(event.getReason());
        repository.save(order);
    }
}
