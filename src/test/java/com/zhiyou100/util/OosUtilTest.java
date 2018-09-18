package com.zhiyou100.util;

import com.aliyun.oss.model.PutObjectResult;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class OosUtilTest {

    @Test
    public void uploading() {
        PutObjectResult result = null;
        try {
             OosUtil.uploading("lhwapartment","1.txt",new FileInputStream(new File("d:\\1.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(result);

    }

    @Test
    public void download() {
        OosUtil.download("lhwapartment","02bfa5d560cd44bc8a7f987f95914a4f.jpeg","d:\\1.jpeg");
    }
}