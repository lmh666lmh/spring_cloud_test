package test.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    //getForObject函数实际上是对getForEntity函数的进一步封装，如果你只关注返回的消息体的内容，对其他信息都不关注，
    // 此时可以使用getForObject，举一个简单的例子，如下：
    //如果放回的是一个实体对象 比如Book，那方法则-->>restTemplate.getForObject("http://TEST-FEIGN/hi?name=" + name, Book.class);
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        String result = restTemplate.getForObject("http://TEST-FEIGN/hi?name=" + name, String.class);
        return result;
    }
    public  String hiError(String name){
        return "hi,"+name+",sorry,error!";
    }


}
