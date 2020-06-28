package com.springbootmybatis.sbm.common.service;

import com.springbootmybatis.sbm.common.model.Orders;

/**
 * @Author Leevan
 * @Date： 2020/6/10 14:45
 */
public interface OrderService {
    int insertOrderData(Orders orders);

    int insertDataInThread(Orders orders);
}
