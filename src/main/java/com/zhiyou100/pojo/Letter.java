package com.zhiyou100.pojo;

import java.util.Date;

public class Letter {
    private Integer leId;

    private Integer leUsAddresserid;

    private Integer leUsRecipientsid;

    private String leContent;

    private Date leCreateTime;

    public Integer getLeId() {
        return leId;
    }

    public void setLeId(Integer leId) {
        this.leId = leId;
    }

    public Integer getLeUsAddresserid() {
        return leUsAddresserid;
    }

    public void setLeUsAddresserid(Integer leUsAddresserid) {
        this.leUsAddresserid = leUsAddresserid;
    }

    public Integer getLeUsRecipientsid() {
        return leUsRecipientsid;
    }

    public void setLeUsRecipientsid(Integer leUsRecipientsid) {
        this.leUsRecipientsid = leUsRecipientsid;
    }

    public String getLeContent() {
        return leContent;
    }

    public void setLeContent(String leContent) {
        this.leContent = leContent == null ? null : leContent.trim();
    }

    public Date getLeCreateTime() {
        return leCreateTime;
    }

    public void setLeCreateTime(Date leCreateTime) {
        this.leCreateTime = leCreateTime;
    }
}