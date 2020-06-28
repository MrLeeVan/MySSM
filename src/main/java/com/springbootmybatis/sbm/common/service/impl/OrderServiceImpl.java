package com.springbootmybatis.sbm.common.service.impl;

import com.springbootmybatis.sbm.common.dao.OrdersMapper;
import com.springbootmybatis.sbm.common.model.Orders;
import com.springbootmybatis.sbm.common.service.OrderService;

import com.springbootmybatis.sbm.enums.ResultEnum;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Author Leevan
 * @Date： 2020/6/10 14:47
 */
@Service
@Log4j2
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Override
    public int insertOrderData(Orders orders) {
        if(null == orders){
            return ResultEnum.ResultType.FAIL;
        }
        int result = ordersMapper.insert( orders );
        if(ResultEnum.ResultState.OK != result){
            return ResultEnum.ResultType.FAIL;
        }
        return ResultEnum.ResultType.OK;
    }
    OrdersMapper getBeanT(){
        return ordersMapper;
    }
    @Override
    public int insertDataInThread(Orders orders) {
        if(null == orders){
            return ResultEnum.ResultType.FAIL;
        }
//        OrdersMapper ordersMappers = (OrdersMapper) SpringContextHolder
//                .getBean("OrderMapper");
//        ordersMappers.insert( orders );
        return ResultEnum.ResultType.OK;
    }
}
