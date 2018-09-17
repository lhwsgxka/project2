package com.zhiyou100.responsemessage;

import lombok.Data;

@Data
public class ResponseMessage {
   private int  code;
   private String message;
   private String error;
   private boolean isSuccess;

}
