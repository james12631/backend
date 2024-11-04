package com.phegondev.Phegon.Eccormerce.service.impl;

import com.phegondev.Phegon.Eccormerce.dto.OrderItemDto;
import com.phegondev.Phegon.Eccormerce.dto.OrderRequest;
import com.phegondev.Phegon.Eccormerce.dto.Response;
import com.phegondev.Phegon.Eccormerce.entity.Order;
import com.phegondev.Phegon.Eccormerce.entity.OrderItem;
import com.phegondev.Phegon.Eccormerce.entity.Product;
import com.phegondev.Phegon.Eccormerce.entity.User;
import com.phegondev.Phegon.Eccormerce.enums.OrderStatus;
import com.phegondev.Phegon.Eccormerce.exception.NotFoundException;
import com.phegondev.Phegon.Eccormerce.mapper.EntityDtoMapper;
import com.phegondev.Phegon.Eccormerce.repository.OrderItemRepo;
import com.phegondev.Phegon.Eccormerce.repository.OrderRepo;
import com.phegondev.Phegon.Eccormerce.repository.ProductRepo;
import com.phegondev.Phegon.Eccormerce.service.interf.OrderItemService;
import com.phegondev.Phegon.Eccormerce.service.interf.UserService;
import com.phegondev.Phegon.Eccormerce.specification.OrderItemSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderRepo orderRepo;
    private final OrderItemRepo orderItemRepo;
    private final ProductRepo productRepo;
    private final UserService userService;
    private final EntityDtoMapper entityDtoMapper;
    private final MongoTemplate mongoTemplate;

    public OrderItemServiceImpl(OrderRepo orderRepo, OrderItemRepo orderItemRepo, ProductRepo productRepo,
			UserService userService, EntityDtoMapper entityDtoMapper, MongoTemplate mongoTemplate) {
		super();
		this.orderRepo = orderRepo;
		this.orderItemRepo = orderItemRepo;
		this.productRepo = productRepo;
		this.userService = userService;
		this.entityDtoMapper = entityDtoMapper;
		this.mongoTemplate = mongoTemplate;
	}

	@Override
    public Response placeOrder(OrderRequest orderRequest) {
        User user = userService.getLoginUser();

        // Map order request items to order entities
        List<OrderItem> orderItems = orderRequest.getItems().stream().map(orderItemRequest -> {
            Product product = productRepo.findById(orderItemRequest.getProductId())
                    .orElseThrow(() -> new NotFoundException("Product Not Found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(orderItemRequest.getQuantity());
            orderItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(orderItemRequest.getQuantity()))); // Set price according to the quantity
            orderItem.setStatus(OrderStatus.PENDING);
            orderItem.setUser(user);
            return orderItem;

        }).collect(Collectors.toList());

        // Calculate the total price
        BigDecimal totalPrice = orderRequest.getTotalPrice() != null && orderRequest.getTotalPrice().compareTo(BigDecimal.ZERO) > 0
                ? orderRequest.getTotalPrice()
                : orderItems.stream().map(OrderItem::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

        // Create order entity
        Order order = new Order();
        order.setOrderItemList(orderItems);
        order.setTotalPrice(totalPrice);

        // Set the order reference in each order item
        orderItems.forEach(orderItem -> orderItem.setOrder(order));

        orderRepo.save(order);

        return Response.builder()
                .status(200)
                .message("Order was successfully placed")
                .build();
    }

    @Override
    public Response updateOrderItemStatus1(Long orderItemId, String status) {
        OrderItem orderItem = orderItemRepo.findById(orderItemId)
                .orElseThrow(() -> new NotFoundException("Order Item not found"));

        orderItem.setStatus(OrderStatus.valueOf(status.toUpperCase()));
        orderItemRepo.save(orderItem);
        return Response.builder()
                .status(200)
                .message("Order status updated successfully")
                .build();
    }

    @Override
    public Response filterOrderItems(OrderStatus status, LocalDateTime startDate, LocalDateTime endDate, String itemId, Pageable pageable) {
        Query query = new Query();

        if (status != null) {
            query.addCriteria(Criteria.where("status").is(status));
        }
        if (startDate != null && endDate != null) {
            query.addCriteria(Criteria.where("createdAt").gte(startDate).lte(endDate));
        }
        if (itemId != null) {
            query.addCriteria(Criteria.where("id").is(itemId));
        }

        long totalElements = mongoTemplate.count(query, OrderItem.class);
        List<OrderItem> orderItems = mongoTemplate.find(query.with(pageable), OrderItem.class);

        if (orderItems.isEmpty()) {
            throw new NotFoundException("No Order Found");
        }

        List<OrderItemDto> orderItemDtos = orderItems.stream()
                .map(entityDtoMapper::mapOrderItemToDtoPlusProductAndUser)
                .collect(Collectors.toList());

        return Response.builder()
                .status(200)
                .orderItemList(orderItemDtos)
                .totalPage((int) Math.ceil((double) totalElements / pageable.getPageSize()))
                .totalElement(totalElements)
                .build();
    }

	@Override
	public Response updateOrderItemStatus(Long orderItemId, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response filterOrderItems(OrderStatus status, LocalDateTime startDate, LocalDateTime endDate, Long itemId,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
}
