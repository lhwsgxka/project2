package com.zhiyou100.pojo;

public class Logs {
    private Integer logId;

    private Integer logUsId;

    private String logContent;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getLogUsId() {
        return logUsId;
    }

    public void setLogUsId(Integer logUsId) {
        this.logUsId = logUsId;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }
}