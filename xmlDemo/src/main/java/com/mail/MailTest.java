package com.mail;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/27 14:50
 * @Version: 1.0
 */
public class MailTest {
    public static void main(String[] args) {
        /**
         *  SMTP邮件服务器地址:smtp.163.com
         *  服务器端口号：25
         *  是否开启ssl: true/false
         *  发送邮件的用户名（地址）: scsoft_gitlab@163.com
         *  发送邮件的授权码: gitlab.admin.com
         *
         **/
        MailSender mailSender = new MailSender("scsoft_gitlab@163.com","scsoftgitlab123","false","25");

        try {
            /**
             *  收件人地址:ygxzzu@163.com
             *  发送主题:253869485@qq.com
             *  发送内容：
             **/
            for (int i = 0; i < 1 ; i++) {
                mailSender.send("253869485@qq.com","Ropemaker","远端攻击第"+i+"封电子邮件风险,正在遭受Computer Virus攻击！");
            }

            /**
             *  收件人地址:ygxzzu@163.com
             *  发送主题:253869485@qq.com
             *  发送内容：发送附件
             **/
            List<String> list  = new ArrayList<>();
            String path = "D:/ProgramFiles/personDocument/个人证件照/图片/1.jpg";
            String path1 = "D:/ProgramFiles/personDocument/个人证件照/图片/12.png";
            String path2 = "D:/ProgramFiles/personDocument/个人证件照/图片/13.jpg";
            list.add(path);
            list.add(path1);
            list.add(path2);

            mailSender.send("1850057904@qq.com","253869485@qq.com","Ropemaker","附件",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("邮件发送成功！");
    }
}
