/**
 * Created by Administrator on 2018/1/18.
 * Copyright 2018 汉威科技.雪城软件.ONE Limited.
 * All rights reserved.
 */
package com.email;

import java.util.ArrayList;
import java.util.List;

import com.email.entities.Mail;
import com.email.entities.MailType;
import com.email.sender.HtmlEmailSender;
import com.email.sender.ImageHtmlEmailSender;
import com.email.sender.MultiPartMailSender;
import com.email.sender.SimpleMailSender;
import com.exception.OneException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;



/**
 * 邮件收发执行器
 * @author qunxing.du
 */
public class MailExecutor {

    /**
     * 发送邮件
     * @param mail
     * @return
     */
    public static String send(Mail mail) throws OneException {

        if(null == mail){
            return null;
        }
        MailType mailType = mail.getMailType();
        if(null == mailType){
            throw new ParameterException(String.format("参数：%s不能为空","mailType"));
        }
        switch (mailType){
            case SIMPLE:
                return new SimpleMailSender().executor(SimpleEmail.class,mail);
            case MULTIPART:
                return new MultiPartMailSender().executor(MultiPartEmail.class,mail);
            case HTML:
                return new HtmlEmailSender().executor(HtmlEmail.class,mail);
            case IMAGEHTML:
                return new ImageHtmlEmailSender().executor(ImageHtmlEmail.class,mail);
            default:
                return null;
        }
    }

    /**
     * 批量发送
     * @param mails
     * @return 发送成功返回的字符串
     * @throws OneException
     */
    public static List<String> batchSend(List<Mail> mails) throws OneException {
        List<String> mailIds = new ArrayList<>();
        for (Mail mail: mails ) {
            mailIds.add(send(mail));
        }
        return mailIds;
    }
    /**
     * 接收邮件
     */
    public static void recevie() throws OneException{

    }
}
