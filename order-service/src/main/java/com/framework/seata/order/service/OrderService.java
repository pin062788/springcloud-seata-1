package com.framework.seata.order.service;

import java.math.BigDecimal;

import com.framework.seata.order.entity.Order;
import com.framework.seata.order.feign.UserFeignClient;
import com.framework.seata.order.repository.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Description：
 *
 * @author fangliangsheng
 * @date 2019-04-04
 */
@Service
public class OrderService {

    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private OrderDAO orderDAO;

    @Transactional
    public void create(String userId, String commodityCode, Integer count) {

        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));

        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setMoney(orderMoney);

        orderDAO.save(order);

        userFeignClient.debit(userId, orderMoney);

    }

}
