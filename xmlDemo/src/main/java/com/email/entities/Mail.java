/**
 * Created by Administrator on 2018/1/18.
 * Copyright 2018 汉威科技.雪城软件.ONE Limited.
 * All rights reserved.
 */
package com.email.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  邮件类
 *
 *  @author qunxing.du
 */
public class Mail implements Serializable{
    // SMTP邮件服务器地址:smtp.163.com
    private String hostName;
    // 服务器端口号：25
    private int smtpPort;
    // 用户名(邮箱地址)
    private String userName;
    // 发送邮件的授权码:
    private String password;

    private boolean sslOnConnect;

    // 发送的邮件类型： SIMPLE,MULTIPART,HTML,IMAGEHTML（普通，附件，HTML，图片）
    private MailType mailType;
    // 邮件标题
    private String subject;
    //简单文本消息
    private String simpleMsg;
    //html消息
    private String htmlMsg;

    private List<MailAttachment> attachments = new ArrayList<>();

    private String baseUrl;
    //发件人地址即：用户名(邮箱地址)：userName
    private String fromAddress;
    private String fromName;

    //收件人地址
    private String toAddress;
    //多收件人地址
    private List<String> to = new ArrayList<>();

    //抄送人地址
    private String ccAddress;
    //批量抄送人地址
    private List<String> cc = new ArrayList<>();

    //私密抄送人
    private String bccAddress;
    //批量私密抄送人
    private List<String> bcc = new ArrayList<>();

    //回复时收件人地址
    private String replyToAddress;
    private String replyToName;

    //邮件无法发送成功时回复的地址
    private String bounceAddress;
    // 邮件发送编码
    private String charSet;


    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public void setSmtpPort(int smtpPort) {
        this.smtpPort = smtpPort;
    }

    public int getSmtpPort() {
        return smtpPort;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSslOnConnect(boolean sslOnConnect) {
        this.sslOnConnect = sslOnConnect;
    }

    public boolean isSslOnConnect() {
        return sslOnConnect;
    }

    public MailType getMailType() {
        return mailType;
    }

    public void setMailType(MailType mailType) {
        this.mailType = mailType;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSimpleMsg() {
        return simpleMsg;
    }

    public void setSimpleMsg(String simpleMsg) {
        this.simpleMsg = simpleMsg;
    }

    public void setHtmlMsg(String htmlMsg) {
        this.htmlMsg = htmlMsg;
    }

    public String getHtmlMsg() {
        return htmlMsg;
    }

    public List<MailAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<MailAttachment> attachments) {
        this.attachments = attachments;
    }

    public void addAttachment(MailAttachment... attachments) {
        this.attachments.addAll(Arrays.asList(attachments));
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setReplyToName(String replyToName) {
        this.replyToName = replyToName;
    }

    public String getReplyToName() {
        return replyToName;
    }

    public void setCharSet(String charSet) {
        this.charSet = charSet;
    }

    public String getCharSet() {
        return charSet;
    }

    public void setReplyToAddress(String replyToAddress) {
        this.replyToAddress = replyToAddress;
    }

    public String getReplyToAddress() {
        return replyToAddress;
    }

    public void setToAddress(String toAddress) {
        this.addTo(toAddress);
    }

    public void setCcAddress(String ccAddress) {
        this.addToCc(ccAddress);
    }

    public void setBccAddress(String bccAddress) {
       this.addToBcc(bccAddress);
    }

    public void setBounceAddress(String bounceAddress) {
        this.bounceAddress = bounceAddress;
    }

    public String getBounceAddress() {
        return bounceAddress;
    }

    public void addTo(String... toAddress){
           to.addAll(Arrays.asList(toAddress));
    }
    public void addToCc(String... toCcAddress){
           cc.addAll(Arrays.asList(toCcAddress));
    }
    public void addToBcc(String... toBccAddress){
           bcc.addAll(Arrays.asList(toBccAddress));
    }


    public List<String> getTo() {
        return to;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public List<String> getCc() {
        return cc;
    }

}

