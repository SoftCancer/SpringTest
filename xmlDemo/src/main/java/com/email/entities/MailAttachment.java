/**
 * Created by Administrator on 2018/1/19.
 * Copyright 2018 汉威科技.雪城软件.ONE Limited.
 * All rights reserved.
 */
package com.email.entities;

import java.io.Serializable;

/**
 * @Description: 声明电子邮件附件对象
 * @Author: YaoGuangXun
 * @Date: 2018/11/28 17:43
 * @Param: No such property: code for class: Script1
 * @Return
 **/
public class MailAttachment implements Serializable {

    /**
     *  path和url选其一
     */
    private String path;
    // 描述
    private String description;
    // 文件名称需带后缀类型：如，GetOID.java
    private String name;

    private String disposition;
    private String url;


    public MailAttachment(){}

    public MailAttachment(String name, String path, String description, String disposition, String url){
        this.name = name;
        this.path = path;
        this.url = url;
        this.description = description;
        this.disposition = disposition;
    }

    public MailAttachment(String name, String path, String description, String disposition){
        this.name = name;
        this.path = path;
        this.description = description;
        this.disposition = disposition;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
