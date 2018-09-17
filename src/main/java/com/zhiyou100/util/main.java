package com.zhiyou100.util;

import com.aliyuncs.exceptions.ClientException;
import com.zhiyou100.util.SMSUtil;

import java.util.Random;

public class main {
    public static void main(String[] args) throws ClientException {
      /*  ;*/
        Random random = new Random();
        String result="";
        for (int i=0;i<6;i++)
        {
            result+=random.nextInt(10);
        }
        System.out.println(result);
        String cellPhone =new String("17320114371");


        SMSUtil.sendSms(cellPhone,result);
    }
}
