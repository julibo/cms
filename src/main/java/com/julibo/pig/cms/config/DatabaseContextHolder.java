package com.julibo.pig.cms.config;

import com.julibo.pig.cms.domain.DatabaseType;

/**
 * 保存一个线程安全的DatabaseType容器
 * @author carson
 * @date 2019-11-28
 */
public class DatabaseContextHolder {

    /**
     * 用于存放多线程环境下的成员变量
     */
    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();

    public static void setDatabaseType(DatabaseType type) {
        contextHolder.set(type);
    }

    public static DatabaseType getDatabaseType() {
        return contextHolder.get();
    }

    public static void remove() {
        contextHolder.remove();
    }

}
