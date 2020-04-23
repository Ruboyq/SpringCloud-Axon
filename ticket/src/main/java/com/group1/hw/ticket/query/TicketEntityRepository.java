package com.group1.hw.ticket.query;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mavlarn on 2018/6/4.
 */
public interface TicketEntityRepository extends JpaRepository<TicketEntity, String> {
}
