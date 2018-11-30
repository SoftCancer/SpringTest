/**
 * Created by Administrator on 2018/1/18.
 * Copyright 2018 汉威科技.雪城软件.ONE Limited.
 * All rights reserved.
 */
package com.email;


import com.config.PropertiesFactory;

public class MailConstants {

    public static final String HOSTNAME = PropertiesFactory.get("email.hostname");
    public static final String SSL_ON_CONNECT = PropertiesFactory.get("email.sslOnConnect");
    public static final int SMTP_PORT = PropertiesFactory.getInteger("email.smtp.port");
//    public static final int IMAP_PORT = PropertiesFactory.getInteger("email.imap.port");
    public static final String USERNAME = PropertiesFactory.get("email.username");
    public static final String PASSWORD = PropertiesFactory.get("email.password");
    public static final String FROM_ADDRESS = PropertiesFactory.get("email.from.address");
    public static final String FROM_NAME = PropertiesFactory.get("email.from.name");
    
    
    // 收件人信息
    public static final String TO = PropertiesFactory.get("email.to");
    public static final String CC = PropertiesFactory.get("email.cc");
    public static final String BCC = PropertiesFactory.get("email.bcc");
}
