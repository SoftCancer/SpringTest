/**
 * Created by Administrator on 2018/1/18.
 * Copyright 2018 汉威科技.雪城软件.ONE Limited.
 * All rights reserved.
 */
package com.email.sender;

import com.email.entities.Mail;
import com.email.entities.MailAttachment;
import com.exception.OneException;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import java.net.MalformedURLException;
import java.net.URL;

public class MultiPartMailSender extends MailSender<MultiPartEmail> {

    @Override
    public MultiPartEmail transform(MultiPartEmail email,Mail mail) throws OneException {
        //设置附件
        for (MailAttachment mailAttachment : mail.getAttachments()){
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(mailAttachment.getPath());
            attachment.setDisposition(mailAttachment.getDisposition());
            attachment.setDescription(mailAttachment.getDescription());
            attachment.setName(mailAttachment.getName());

            String url = mailAttachment.getUrl();
            if(null != url && !url.isEmpty()) {
                try {
                    attachment.setURL(new URL(mailAttachment.getUrl()));
                } catch (MalformedURLException e) {
                    throw new OneException(e);
                }
            }
            try {
                email.attach(attachment);
            } catch (EmailException e) {
                throw new OneException(e);
            }
        }
            //设置内容
        try {
            email.setMsg(mail.getSimpleMsg());
        } catch (EmailException e) {
            throw new OneException(e);
        }
        return email;
    }
}
