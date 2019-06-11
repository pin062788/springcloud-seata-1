package com.framework.seata.order.repository;

import com.framework.seata.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Description：
 *
 * @author fangliangsheng
 * @date 2019-04-04
 */
public interface OrderDAO extends JpaRepository<Order, Long> {

}
