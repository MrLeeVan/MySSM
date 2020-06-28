package com.springbootmybatis.sbm;

import com.springbootmybatis.sbm.common.dao.OrdersMapper;
import com.springbootmybatis.sbm.common.model.Orders;
import com.springbootmybatis.sbm.common.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Author Leevan
 * @Date： 2020/6/10 16:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceTest {
    @Autowired
    private OrderService orderService;
    @Test
    public void test(){
        Orders orders = new Orders();
        orders.setId( "1211223" );
        orders.setMoney( new Double(12) );
        orders.setOrdertime( new Date() );
        orders.setPaystate( 1 );
        orders.setUserId( 222 );
        int result = orderService.insertOrderData( orders );
        if(0 == result){
            System.out.println("插入失败！！！！！！！！！！！！！！！！");
        }else{
            System.out.println("插入成功！！！！！！！！！！！！！！！！");
        }
    }

}