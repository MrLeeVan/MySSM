package com.springbootmybatis.sbm.utils;

import com.springbootmybatis.sbm.common.model.Orders;
import com.springbootmybatis.sbm.common.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Leevan
 * @Date： 2020/6/12 8:41
 */
public class InsertDataTest {
    @Autowired
    private OrderService orderService;
    private String threadId;
    private Orders orders;
    public void setThreadId(String id, Orders orders){
        this.threadId = id;
        this.orders = orders;
        insertData();
    }

    public int insertData(){
        return orderService.insertOrderData( orders );
    }
}
