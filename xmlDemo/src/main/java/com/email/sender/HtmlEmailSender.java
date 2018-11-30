/**
 * Created by Administrator on 2018/1/18.
 * Copyright 2018 汉威科技.雪城软件.ONE Limited.
 * All rights reserved.
 */
package com.email.sender;

import com.email.entities.Mail;
import com.exception.OneException;
import org.apache.commons.mail.HtmlEmail;


/**
 * HTML类型邮件发送器
 *
 * @author qunxig.du
 */
public class HtmlEmailSender extends MailSender<HtmlEmail> {
    @Override
    public HtmlEmail transform(HtmlEmail email, Mail mail) throws OneException {

        try {
//            email.embed(new URL(mail.getBaseUrl()), mail.getSubject());
            email.setHtmlMsg(mail.getHtmlMsg());
            email.setTextMsg(mail.getSimpleMsg());
        } catch (Exception e) {
            throw new OneException(e);
        }
        return email;
    }
}
