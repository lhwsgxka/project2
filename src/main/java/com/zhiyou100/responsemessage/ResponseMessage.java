package com.zhiyou100.responsemessage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseMessage {
   private int  code;
   private String message;
   private String error;
   private boolean isSuccess;

   public int getCode() {
      return code;
   }

   public void setCode(int code) {
      this.code = code;
   }

   public ResponseMessage() {
   }
}
