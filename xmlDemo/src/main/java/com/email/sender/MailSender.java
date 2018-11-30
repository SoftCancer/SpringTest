/**
 * Created by Administrator on 2018/1/18.
 * Copyright 2018 汉威科技.雪城软件.ONE Limited.
 * All rights reserved.
 */
package com.email.sender;


import com.email.MailConstants;
import com.email.ParameterException;
import com.email.entities.Mail;
import com.exception.OneException;
import com.util.ObjectUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 *  邮件发送接口
 */
public abstract class MailSender<T extends Email>{

    Logger log = LoggerFactory.getLogger(MailSender.class);
    /**
     * 发送邮件
     * @param mail
     * @return
     */
    public String executor(Class<T> t,Mail mail) throws OneException {
        String mailId;
        Mail mailVerified = verify(mail);
        T mailTransformed = stanardTransform(t,mailVerified);
        mailId = send(mailTransformed);
        log.info("邮件发送成功:{}",mailId);
        return  mailId;
    }

    private T stanardTransform(Class<T> t,Mail mail) throws OneException{

        T email = baseTranform(t,mail);
        return  transform(email,mail);
    }

    //1、若子类覆盖了某方法，则父类引用调用子类重新定义的新方法
    abstract T transform(T email,Mail mail) throws OneException;

    private String send(T t) throws OneException{
        try {
            return t.send();
        } catch (EmailException e) {
            throw  new OneException(e);
        }
    }

    private T baseTranform(Class<T> t,Mail mail) throws OneException{
        //基础配置
        T email = null;
        try {
            email = t.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //邮箱地址，端口，认证
        email.setHostName(mail.getHostName());
        email.setSmtpPort(mail.getSmtpPort());
        email.setAuthenticator(new DefaultAuthenticator(mail.getUserName(), mail.getPassword()));
        email.setSSLOnConnect(mail.isSslOnConnect());
        try {
            //发件人
            email.setFrom(mail.getFromAddress(),mail.getFromName());


            //收件人
            email.addTo(mail.getTo().toArray(new String[mail.getTo().size()]));
            //抄送人
            if(!ObjectUtils.isNullList(mail.getCc())){
                email.addCc(mail.getCc().toArray(new String[mail.getCc().size()]));
            }
            //私密抄送人
            if(!ObjectUtils.isNullList(mail.getBcc())){
                email.addBcc(mail.getBcc().toArray(new String[mail.getBcc().size()]));
            }
            //邮件回复人
            if(!ObjectUtils.isNull(mail.getReplyToAddress())){
                email.addReplyTo(mail.getReplyToAddress(),mail.getReplyToAddress());
            }
        } catch (EmailException e) {
            throw  new OneException(e);
        }
        //无法投递邮件时回复地址
        email.setBounceAddress(mail.getBounceAddress());

        //设置主题
        email.setSubject(mail.getSubject());
        //设置编码
        String charSet = mail.getCharSet();
        if(null != charSet){
            email.setCharset(charSet);

        }
        return email;
    }

    private Mail verify(Mail mail) throws ParameterException {
        if(StringUtils.isBlank(mail.getHostName())){
            if(StringUtils.isBlank(MailConstants.HOSTNAME)){
                // 异常输出：  参数：hostname不能为空
                throw new ParameterException(String.format("参数：%s不能为空","hostname"));
            }
            mail.setHostName(MailConstants.HOSTNAME);
        }
        if(mail.getSmtpPort() <= 0){
            if(MailConstants.SMTP_PORT <= 0){
                throw new ParameterException(String.format("参数：%s不正确","smtpPort"));
            }
            mail.setSmtpPort(MailConstants.SMTP_PORT);
        }
        if(StringUtils.isBlank(mail.getUserName())){
            if(StringUtils.isBlank(MailConstants.USERNAME)){
                throw new ParameterException(String.format("参数：%s不能为空","username"));
            }
            mail.setUserName(MailConstants.USERNAME);
        }

        if(StringUtils.isBlank(mail.getPassword())){
            if(StringUtils.isBlank(MailConstants.PASSWORD)){
                throw new ParameterException(String.format("参数：%s不能为空","password"));
            }
            mail.setPassword(MailConstants.PASSWORD);
        }
        if(StringUtils.isBlank(mail.getFromAddress())){
            if(StringUtils.isBlank(MailConstants.FROM_ADDRESS)){
                throw new ParameterException(String.format("参数：%s不能为空","fromAddress"));
            }
            mail.setFromAddress(MailConstants.FROM_ADDRESS);
        }
        if(ObjectUtils.isNullList(mail.getTo())){
            throw new ParameterException(String.format("参数：%s不能为空","toAddress"));
        }
        return mail;
    }


}
