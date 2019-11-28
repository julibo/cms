package com.julibo.pig.cms.config;

import com.julibo.pig.cms.domain.DatabaseType;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * 动态处理数据源，根据命名区分
 * @author carson
 * @date 2019-11-25
 */
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Log4j2
public class DataSourceAspect {

    @Pointcut("execution(* com.julibo.pig.cms.dao.*.*(..))")
    public void aspect() {

    }


    @Before("aspect()")
    public void before(JoinPoint point) {
        String className = point.getTarget().getClass().getName();
        String method = point.getSignature().getName();
        String args = StringUtils.join(point.getArgs(), ",");
        log.info("className:{}, method:{}, args:{} ", className, method, args);
        try {
            for (DatabaseType type : DatabaseType.values()) {
                List<String> values = DynamicDataSource.METHOD_TYPE_MAP.get(type);
                for (String key : values) {
                    if (method.startsWith(key)) {
                        log.info(">>{} 方法使用的数据源为:{}<<", method, key);
                        DatabaseContextHolder.setDatabaseType(type);
                        DatabaseType types = DatabaseContextHolder.getDatabaseType();
                        log.info(">>{}方法使用的数据源为:{}<<", method, types);
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
