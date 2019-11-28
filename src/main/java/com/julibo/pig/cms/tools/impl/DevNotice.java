package com.julibo.pig.cms.tools.impl;

import com.julibo.pig.cms.tools.Notice;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author carson
 * @date 2019-11-28
 */
@Log4j2
@Component
@Profile("dev")
public class DevNotice implements Notice {

    @Override
    public void sendSms() {
        log.info("成功发送短信");
    }

    @Override
    public void sendMail() {
        log.info("成功发送邮件");
    }

    @Override
    public void sendDing() {
        log.info("成功发送钉钉");
    }
}
