package com.zhiyou100.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Funding {
    private Integer fdId;

    private String fdUsId;

    private String fdPsId;

    private BigDecimal fdMoney;

    private Date fdTime;

    public Integer getFdId() {
        return fdId;
    }

    public void setFdId(Integer fdId) {
        this.fdId = fdId;
    }

    public String getFdUsId() {
        return fdUsId;
    }

    public void setFdUsId(String fdUsId) {
        this.fdUsId = fdUsId == null ? null : fdUsId.trim();
    }

    public String getFdPsId() {
        return fdPsId;
    }

    public void setFdPsId(String fdPsId) {
        this.fdPsId = fdPsId == null ? null : fdPsId.trim();
    }

    public BigDecimal getFdMoney() {
        return fdMoney;
    }

    public void setFdMoney(BigDecimal fdMoney) {
        this.fdMoney = fdMoney;
    }

    public Date getFdTime() {
        return fdTime;
    }

    public void setFdTime(Date fdTime) {
        this.fdTime = fdTime;
    }
}