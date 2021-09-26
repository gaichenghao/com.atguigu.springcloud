package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {


    /***
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_ok,id"+id+"\t"+"哈哈";
    }

    /***
     * 异常访问访问
     * @param id
     * @return
     */
    public String paymentInfo_TimeOut(Integer id){
        int timeOut=3;
        try {
            TimeUnit.SECONDS.sleep(timeOut);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_TimeOut,id"+id+"\t"+"耗时3秒钟";
    }
}
