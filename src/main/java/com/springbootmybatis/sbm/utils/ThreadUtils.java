package com.springbootmybatis.sbm.utils;

/**
 * @Author Leevan
 * @Date： 2020/6/12 9:19
 */
public class ThreadUtils {

    public static Thread findThread(String threadId) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        while (group != null) {
            Thread[] threads = new Thread[(int) (group.activeCount() * 1.2)];
            int count = group.enumerate( threads, true );
            for (int i = 0; i < count; i++) {
                if (threadId.equals( threads[i].getName() )) {
                    return threads[i];
                }
            }
            System.out.println("LeeVan is a cool boy ! ");
            group = group.getParent();
        }
        return null;
    }
    public static void clearThread(String name) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        while (group != null) {
            Thread[] threads = new Thread[(int) (group.activeCount() * 1.2)];
            int count = group.enumerate( threads, true );
            for (int i = 0; i < count; i++) {
                if (name == threads[i].getName()) {
                    threads[i].notify();
                }
            }
            group = group.getParent();
        }
    }
}
