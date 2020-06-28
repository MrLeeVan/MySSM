package com.springbootmybatis.sbm.utils;

import com.springbootmybatis.sbm.common.dao.OrdersMapper;
import com.springbootmybatis.sbm.common.model.Orders;
import com.springbootmybatis.sbm.common.model.OrdersExample;
import com.springbootmybatis.sbm.common.service.OrderService;
import com.springbootmybatis.sbm.enums.ResultEnum;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author Leevan
 * @Date： 2020/6/11 17:54
 */
@Log4j2
public class InsertThread extends Thread implements Runnable{
    private Orders orders;
    private OrderService orderService;
    private OrdersMapper ordersMapper;
    public InsertThread(){
    }
    @Autowired
    public InsertThread(String name) {
        this.ordersMapper = ApplicationProviderContext.getBean( OrdersMapper.class);
        this.orderService = ApplicationProviderContext.getBean(OrderService.class);
    }
    public int setThreadId( Orders orders){
        this.orders = orders;
        try {
            run();
        }catch (Exception e){
            return ResultEnum.ResultState.FAIL;
        }

        return ResultEnum.ResultState.OK;
    }
    public Orders getOrders(){
        return this.orders;
    }
    @SneakyThrows
    @Override
    public void run() {
        log.info( "用户ID：" + orders.getUserId().toString() + "订单ID：" + orders.getId());
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo( orders.getUserId() );
        List<Orders> ls =  ordersMapper.selectByExample(example);
        int result = 0;
        if(null == ls || 0 == ls.size()){
            result = orderService.insertOrderData( getOrders() );
        }else{
            log.info( "已执行操作" );
            ThreadUtils.clearThread( getOrders().getUserId().toString());
            throw new Exception();
        }
        if( 1 != result){
            Thread newT = ThreadUtils.findThread( getOrders().getUserId().toString() );
            if(null != newT){
                newT.notify();
            }
        }else{
            ThreadUtils.clearThread( getOrders().getUserId().toString() );
        }
    }
}
