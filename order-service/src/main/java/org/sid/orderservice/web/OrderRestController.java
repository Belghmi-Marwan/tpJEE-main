package org.sid.orderservice.web;

import org.sid.orderservice.entites.Order;
import org.sid.orderservice.model.Customer;
import org.sid.orderservice.model.Product;
import org.sid.orderservice.repository.OrderRepository;
import org.sid.orderservice.repository.ProductItemRepository;
import org.sid.orderservice.services.CustomerRestClientService;
import org.sid.orderservice.services.InventoryRestClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderRestController {
    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;

    public OrderRestController(OrderRepository orderRepository, ProductItemRepository productItemRepository, CustomerRestClientService customerRestClientService, InventoryRestClientService inventoryRestClientService) {
        this.orderRepository = orderRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClientService = customerRestClientService;
        this.inventoryRestClientService = inventoryRestClientService;
    }


    @GetMapping("/fullOrder/{id}")

    public Order getOrder(@PathVariable Long id){
        Order order=orderRepository.findById(id).get();
        Customer customer=customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItems().forEach(pi->{
            Product product=inventoryRestClientService.productById(pi.getProductId());
            pi.setProduct(product);
        });
        return order;
    }
    @GetMapping("/allOrders")

    public Iterable<Order> getAllOrders(){
        List<Order> orders = (List<Order>) orderRepository.findAll();
        orders.forEach(order -> {
            Customer customer = customerRestClientService.customerById(order.getCustomerId());
            order.setCustomer(customer);
            order.getProductItems().forEach(productItem -> {
                Product product = inventoryRestClientService.productById(productItem.getProductId());
                productItem.setProduct(product);
            });
        });
        return orders;
    }
}
