package test.testrpc;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan
@EnableFeignClients
//表明自己是一个Client    好像不设置这个注解   eureka也能识别出来，啥情况？？  eureka红色警告，进入保护模式，重起eureka即可
@EnableEurekaClient
@RestController   //路由访问加了反而出现
public class TestrpcApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestrpcApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	public String home(@RequestParam(value = "name", defaultValue = "LMH") String name) {
		return "hello " + name + " ,I am from port:" + port;
	}
}
