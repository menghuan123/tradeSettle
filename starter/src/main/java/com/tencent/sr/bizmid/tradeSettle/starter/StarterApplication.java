package com.tencent.sr.bizmid.tradeSettle.starter;

import com.tencent.sr.rmall.springbootstarter.starter.TMallSpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.tsf.annotation.EnableTsf;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy=true)
@ComponentScan({
    "com.tencent.sr.rmall.*",
})
@EnableTsf
@EnableFeignClients
public class StarterApplication{
    public static void main(String[] args) {
        TMallSpringApplication.run(StarterApplication.class, args);
    }
}
