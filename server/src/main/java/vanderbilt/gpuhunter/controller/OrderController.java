package vanderbilt.gpuhunter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vanderbilt.gpuhunter.wroker.ExecutionTree;
import vanderbilt.gpuhunter.wroker.Order;
import vanderbilt.gpuhunter.payload.request.OrderBuilder;
import vanderbilt.gpuhunter.wroker.WaitQueue;

@RestController
@RequestMapping(path = "order")
public class OrderController {

    @Autowired
    ExecutionTree executionTree;

    @Autowired
    WaitQueue waitQueue;

    @PostMapping
    public Order newConfig(@RequestBody @Validated OrderBuilder req) {
        Order order = req.build();
        if (order.getScheduledTime() == null) {
            executionTree.insert(order);
        } else {
            waitQueue.insert(order);
        }
        return order;
    }

//    @DeleteMapping
//    public Order deleteConfig(@RequestBody @Validated OrderBuilder req) {
//        return order;
//    }
}
