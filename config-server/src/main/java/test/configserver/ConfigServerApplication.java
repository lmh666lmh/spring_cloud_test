package test.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


//第六篇: 分布式配置中心(Spring Cloud Config)(Finchley版本)

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer   //@EnableConfigServer 注解 开启配置服务器的功能
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
