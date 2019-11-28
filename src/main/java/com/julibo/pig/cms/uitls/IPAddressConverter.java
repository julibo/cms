package com.julibo.pig.cms.uitls;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import lombok.extern.log4j.Log4j2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 获取IP地址
 *
 * @author zhangjianbing
 * time 2019/7/9
 */
@Log4j2
public class IPAddressConverter extends ClassicConverter {

    private static String ipAddress;

    static {
        try {
            ipAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.error("fetch localhost host address failed", e);
            ipAddress = "UNKNOWN";
        }
    }

    @Override
    public String convert(ILoggingEvent event) {
        return ipAddress;
    }


}
