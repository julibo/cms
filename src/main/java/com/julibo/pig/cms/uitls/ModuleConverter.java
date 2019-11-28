package com.julibo.pig.cms.uitls;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * 获取日志模块的名称
 *
 * @author carson
 * @date 2019-11-28
 */
public class ModuleConverter extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {
        return event.getLoggerName();
    }
}
