package com.email;

import com.email.entities.Mail;
import com.email.entities.MailAttachment;
import com.email.entities.MailType;
import org.apache.commons.mail.EmailAttachment;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: API： http://commons.apache.org/proper/commons-email/userguide.html
 * @author: YaoGuangXun
 * @date: 2018/11/29 10:59
 * @Version: 1.0
 */
public class EmailTest {

    public static void main(String[] args) throws Exception {
        Mail mail = new Mail();

        mail.setHostName("smtp.163.com");
        mail.setSmtpPort(25);
        mail.setUserName("scsoft_gitlab@163.com");
        mail.setPassword("scsoftgitlab123");

        Robot r = new Robot();
//        simpleTextEmail(mail);
//
//        sendAttachmentEmailByURI(mail);
//
//        sendAttachmentEmailByPath(mail);

//        sendHTMLEmail(mail);
//        r.delay(4000);
//        for (int i = 0; i <10 ; i++) {
//            sendImagesHTMLEmail(mail);
//        }
    }

    public static void simpleTextEmail(Mail mail) {

        // 发送的邮件类型： SIMPLE,MULTIPART,HTML,IMAGEHTML（普通，附件，HTML，图片）
        mail.setMailType(MailType.SIMPLE);

        mail.setSubject("Click mail");
        mail.setSimpleMsg("普通邮件发送成功!");
//        mail.setSimpleMsg("I Love You ! AIAI To Tonight?");
        //
        mail.setFromAddress("scsoft_gitlab@163.com");
        mail.setFromName("Chrome");

        mail.setToAddress("253869485@qq.com");
        mail.setCcAddress("1850057904@qq.com");
        mail.setCharSet("UTF-8");
        String mailId = MailExecutor.send(mail);
        System.out.println("mailId:" + mailId);

        System.out.println("普通邮件发送成功!");
    }


    public static void sendAttachmentEmailByURI(Mail mail) {

        mail.setMailType(MailType.MULTIPART);

        List<MailAttachment> list = new ArrayList<>();
        MailAttachment mailAttachment = new MailAttachment();
        // 发送附件图片
        mailAttachment.setUrl("http://img.zcool.cn/community/017c5d554909920000019ae9d202fe.jpg@1280w_1l_2o_100sh.jpg");//可添加网络上的附件
        mailAttachment.setName("100sh.jpg");
        mailAttachment.setDescription("java附件");
        mailAttachment.setDisposition(EmailAttachment.ATTACHMENT);
        list.add(mailAttachment);
        mail.setAttachments(list);

        mail.setSubject("Click mail");
        mail.setSimpleMsg("网址附件邮件发送成功!");
//        mail.setSimpleMsg("I Love You ! AIAI To Tonight?");
        //
        mail.setFromAddress("scsoft_gitlab@163.com");
        mail.setFromName("Chrome");

        mail.setToAddress("zzuygx@163.com");

        mail.setCcAddress("1850057904@qq.com");
        mail.setCharSet("UTF-8");

        MailExecutor.send(mail);

        System.out.println("网址附件邮件发送成功!");
    }

    public static void sendAttachmentEmailByPath(Mail mail) {

        mail.setMailType(MailType.MULTIPART);

        List<MailAttachment> list = new ArrayList<>();
        MailAttachment mailAttachment = new MailAttachment();
        //发送附件文档
        mailAttachment.setPath("D:/个人文档/GetOID.java");
        mailAttachment.setName("GetOID.java");
        mailAttachment.setDescription("java附件");
        mailAttachment.setDisposition(EmailAttachment.ATTACHMENT);
        list.add(mailAttachment);
        mail.setAttachments(list);

        // 标题  内容
        mail.setSubject("Click mail");
        mail.setSimpleMsg("I Love You ! AIAI To Tonight?");
        //发送人地址
        mail.setFromAddress("scsoft_gitlab@163.com");
        mail.setFromName("Chrome");
        // 接收人
        mail.setToAddress("zzuygx@163.com");
        // 抄送人
        mail.setCcAddress("1850057904@qq.com");
        mail.setCharSet("UTF-8");
        MailExecutor.send(mail);

        System.out.println("本地附件邮件发送成功!");
    }

    /**
     * 网页版   测试失败
     **/
    public static void sendHTMLEmail(Mail mail) {
        mail.setMailType(MailType.HTML);

//        mail.setBaseUrl("http://img.zcool.cn/community/017c5d554909920000019ae9d202fe.jpg@1280w_1l_2o_100sh.jpg");

        mail.setHtmlMsg("<html>\n" +
                "<body>\n" +
                "\n" +
                "<img src=" + "http://mail.163.com/js6/s?func=mbox:getMessageData&sid=gAxYEmxKiCVSLtDiVJKKUifEzBjdSvZJ&mid=205:1tbizRoPL1c7DZ+RRwAAsf&part=3" + "> \n" +
                "\n" +
                "<H1 style=" + "font-family:arial;color:red;font-size:20px;" + ">爱我你就CC我！</H1>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
        mail.setSubject("Chrome Me");
        mail.setSimpleMsg("I Love You ! AIAI To Tonight?");

        //发送人地址
        mail.setFromAddress("scsoft_gitlab@163.com");
        mail.setFromName("Chrome");
        // 接收人
        mail.setToAddress("zzuygx@163.com");
        // 抄送人
        mail.setCcAddress("253869485@qq.com");
        mail.setCharSet("UTF-8");
        String mailId = MailExecutor.send(mail);
        System.out.println("mailId:" + mailId);
        System.out.println("网页邮件发送成功!");

    }

    public static void sendImagesHTMLEmail(Mail mail) {
        mail.setMailType(MailType.IMAGEHTML);

        mail.setBaseUrl("http://img.zcool.cn/community/017c5d554909920000019ae9d202fe.jpg@1280w_1l_2o_100sh.jpg");
        mail.setHtmlMsg("<html>\n" +
                "<body>\n" +
                "\n" +
                "<img src=" + "https://img.zcool.cn/community/01e667554909920000019ae923c8cb.jpg@1280w_1l_2o_100sh.jpg" + "> \n" +
                "\n" +
                "<H1 style=" + "font-family:arial;color:red;font-size:20px;" + ">爱我你就CC我！</H1>\n" +

                "\n" +
                "</body>\n" +
                "</html>");
        mail.setSubject("Chrome Me");
        mail.setSimpleMsg("I Love You ! AIAI To Tonight?");

        //发送人地址
        mail.setFromAddress("scsoft_gitlab@163.com");
        mail.setFromName("Chrome");
        // 接收人
        mail.setToAddress("zzuygx@163.com");
        // 抄送人
        mail.setCcAddress("253869485@qq.com");
        mail.setCharSet("UTF-8");
        MailExecutor.send(mail);
        System.out.println("网页图片邮件发送成功!");
    }


}
