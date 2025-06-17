package com.example.Store.Controllers;

import com.example.Store.Service.CustomerServiceI;
import com.example.Store.Service.OrderServiceI;
import com.example.Store.Service.ProductServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final ProductServiceI productServiceI;
    private final CustomerServiceI customerServiceI;
    private final OrderServiceI orderServiceI;

    @GetMapping("/counts")
    public Map<String, Long> getCounts() {
        Map<String, Long> counts = new HashMap<>();
        counts.put("products", productServiceI.countProducts());
        counts.put("customers", customerServiceI.countCustomers());
        counts.put("orders", orderServiceI.countOrders());
        return counts;
    }
}

