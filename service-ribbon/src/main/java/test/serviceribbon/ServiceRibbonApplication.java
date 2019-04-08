package test.serviceribbon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan
@EnableEurekaClient
@EnableDiscoveryClient
//通过@EnableDiscoveryClient向服务中心注册；并且向程序的ioc注入一个bean: restTemplate

@EnableHystrix //注解开启Hystrix

@RestController
public class ServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class, args);
    }

    	@Bean
	@LoadBalanced  //注解表明这个restRemplate开启负载均衡的功能
	RestTemplate restTemplate() {
		return new RestTemplate();
	}


    @Value("${server.port}")
    String port;

    @RequestMapping("/hh")
    public String home(@RequestParam(value = "name", defaultValue = "LMH") String name) {
        return "hello " + name + " ,I am from port:" + port;
    }
}
