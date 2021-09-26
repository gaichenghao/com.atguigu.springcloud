package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeOut=3;
        try {
            TimeUnit.SECONDS.sleep(timeOut);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_TimeOut,id"+id+"\t"+"耗时3秒钟";
    }

    public String paymentInfo_TimeOutHandler(Integer id){

        return "线程池："+Thread.currentThread().getName()+" paymentInfo_TimeOutHandler,id"+id+"\t"+"哭哭·";
    }

}
