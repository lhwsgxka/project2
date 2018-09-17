package com.zhiyou100.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data

public class Comments {
    private Integer cmId;

    private Integer cmUsId;

    private Integer cmPsId;

    private Date cmTime;

    private String cmContent;

    public Integer getCmId() {
        return cmId;
    }

    public void setCmId(Integer cmId) {
        this.cmId = cmId;
    }

    public Integer getCmUsId() {
        return cmUsId;
    }

    public void setCmUsId(Integer cmUsId) {
        this.cmUsId = cmUsId;
    }

    public Integer getCmPsId() {
        return cmPsId;
    }

    public void setCmPsId(Integer cmPsId) {
        this.cmPsId = cmPsId;
    }

    public Date getCmTime() {
        return cmTime;
    }

    public void setCmTime(Date cmTime) {
        this.cmTime = cmTime;
    }

    public String getCmContent() {
        return cmContent;
    }

    public void setCmContent(String cmContent) {
        this.cmContent = cmContent == null ? null : cmContent.trim();
    }

}