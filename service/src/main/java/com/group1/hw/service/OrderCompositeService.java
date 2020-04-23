package com.group1.hw.service;

import com.group1.hw.dto.OrderDTO;

import java.util.List;

public interface OrderCompositeService {

    List<OrderDTO> getMyOrder(Long id);
}
