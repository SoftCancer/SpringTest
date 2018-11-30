/**
 * Created by Administrator on 2018/1/18.
 * Copyright 2018 汉威科技.雪城软件.ONE Limited.
 * All rights reserved.
 */
package com.email.sender;

import com.email.entities.Mail;
import com.exception.OneException;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SimpleMailSender extends MailSender<SimpleEmail> {
    @Override
    public SimpleEmail transform(SimpleEmail email, Mail mail) throws OneException {
        //内容
        try {
            email.setMsg(mail.getSimpleMsg());
        } catch (EmailException e) {
            throw new OneException(e);
        }

        return  email;
    }

}
