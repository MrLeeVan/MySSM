package com.springbootmybatis.sbm.common.controller;

import com.springbootmybatis.sbm.common.dao.OrdersMapper;
import com.springbootmybatis.sbm.common.model.Orders;
import com.springbootmybatis.sbm.common.service.OrderService;
import com.springbootmybatis.sbm.enums.ResultEnum;
import com.springbootmybatis.sbm.utils.InsertThread;
import com.springbootmybatis.sbm.utils.Result;
import com.springbootmybatis.sbm.utils.ThreadUtils;
import com.springbootmybatis.sbm.utils.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Leevan
 * @Date： 2020/6/11 16:39
 */
@RestController
@RequestMapping("/orders")
@Slf4j
public class OrdersController {
    private static final String INDEX = "index.html";
    @RequestMapping("/insert")
    @ResponseBody
    public Result insertOrders(@RequestBody Orders orders){
        if(null == orders){
            log.info( "插入失败！" );
            return new Result( ResultEnum.ResultType.FAIL, "插入失败，参数为空！" );
        }
        orders.setId( UuidUtil.randomUUID() );
        InsertThread thread = new InsertThread(orders.getUserId().toString());
        thread.setName( orders.getUserId().toString() );
        Thread old = ThreadUtils.findThread(orders.getUserId().toString());
        int result = 0;
        if(null != old){
            try {
                log.info( "有线程正在执行！" );
                thread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            result = thread.setThreadId( orders );
        }
        if(ResultEnum.ResultState.OK != result){
            return new Result( ResultEnum.ResultType.FAIL, "插入失败，重复插入！" );
        }
        return new Result( ResultEnum.ResultType.OK,"插入成功" );
    }
    @RequestMapping("/show")
    public String getIndex() {
        return INDEX;
    }
    @RequestMapping("/showindex")
    public String getShowIndex() {
        return "zhasjdhajsdhbasjhd";
    }
}

