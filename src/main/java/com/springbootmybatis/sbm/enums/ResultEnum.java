package com.springbootmybatis.sbm.enums;

/**
 * @Author Leevan
 * @Date： 2020/6/10 14:55
 */
public class ResultEnum {
    public interface ResultType {
        public final static int FAIL = 0;// 失败
        public final static int OK = 1;// 正常
        public final static int MSG = 2;// 异常
    }
    public interface ResultState {
        public final static int FAIL = 0;// 失败
        public final static int OK = 1;// 正常
        public final static int MSG = 2;// 异常
    }
}
