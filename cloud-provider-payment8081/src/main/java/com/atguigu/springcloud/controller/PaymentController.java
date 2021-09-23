package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(Payment payment){
        int i = paymentService.create(payment);
        log.info("*****插入结果："+i);
        if(i>0){
            return new CommonResult(200,"插入成功",i);
        }
        else{
            return new CommonResult(444,"插入失败",null);
        }
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentId(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentId(id);
        log.info("*****查询结果："+payment.toString());

        if(payment!=null){
            return new CommonResult(200,"查询成功",payment);
        }
        else{
            return new CommonResult(444,"没有对应记录，查询id为"+id,null);
        }
    }
}
