package com.julibo.pig.cms.tools;

/**
 * @author carson
 * @date 2019-11-28
 */
public interface Notice {

    /**
     * 发送邮件
     */
    void sendMail();

    /**
     * 发送短信
     */
    void sendSms();

    /**
     * 发送钉钉
     */
    void sendDing();
}
