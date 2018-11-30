/**
 * Created by Administrator on 2018/1/18.
 * Copyright 2018 汉威科技.雪城软件.ONE Limited.
 * All rights reserved.
 */
package com.email.sender;

import com.email.entities.Mail;
import com.exception.OneException;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;

import java.net.MalformedURLException;
import java.net.URL;

public class ImageHtmlEmailSender extends MailSender<ImageHtmlEmail> {

    @Override
    public ImageHtmlEmail transform(ImageHtmlEmail email,Mail mail) throws OneException {

        try {
            URL url = new URL(mail.getBaseUrl());
            email.setDataSourceResolver(new DataSourceUrlResolver(url));
            email.setHtmlMsg(mail.getHtmlMsg());

            email.setTextMsg(mail.getSimpleMsg());
        } catch (EmailException | MalformedURLException e) {
            throw new OneException(e);
        }
        return email;
    }
}
