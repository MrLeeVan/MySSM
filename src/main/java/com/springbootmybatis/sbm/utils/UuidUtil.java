package com.springbootmybatis.sbm.utils;

import java.util.UUID;

/**
 * @Author Leevan
 * @Date： 2020/6/11 17:49
 */
public class UuidUtil {
    public static String randomUUID() {
        UUID uuid = UUID.randomUUID();
        if (uuid != null) {
            return uuid.toString();
        }
        return new com.eaio.uuid.UUID().toString();
    }
    public static void main(String[] args) {
        for (int i=0; i < 40; i++)
        {
            System.out.println(UuidUtil.randomUUID());
        }
    }
}
