package com.phegondev.Phegon.Eccormerce.service.interf;

import com.phegondev.Phegon.Eccormerce.dto.OrderRequest;
import com.phegondev.Phegon.Eccormerce.dto.Response;
import com.phegondev.Phegon.Eccormerce.enums.OrderStatus;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface OrderItemService {
    Response placeOrder(OrderRequest orderRequest);
   
    Response filterOrderItems(OrderStatus status, LocalDateTime startDate, LocalDateTime endDate, Long itemId, Pageable pageable);
	Response filterOrderItems(OrderStatus status, LocalDateTime startDate, LocalDateTime endDate, String itemId,
			Pageable pageable);
	Response updateOrderItemStatus(Long orderItemId, String status);

	Response updateOrderItemStatus1(Long orderItemId, String status);
	
}
