package com.zhiyou100.exception;

import lombok.Data;

/*
*@ClassName:CrowdFundingException
 @Description:TODO
 @Author:
 @Date:2018/9/18 17:19
 @Version:v1.0
*/
@Data
public class CrowdFundingException extends Exception {
    private String error;
    public CrowdFundingException(String error){
        this.error=error;
    }
}
