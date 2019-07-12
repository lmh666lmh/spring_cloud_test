package test.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan
@EnableDiscoveryClient
@RestController
@RefreshScope
public class ConfigClientApplication {

	/**
	 * http://localhost:8881/actuator/bus-refresh   使用postman发送POST请求
	 * /actuator/bus-refresh接口可以指定服务，即使用"destination"参数，
	 * 比如 “/actuator/bus-refresh?destination=customers:**” 即刷新服务名为customers的所有服务。
	 *
	 * 当git文件更改的时候，通过pc端用post 向端口为8882的config-client发送请求/bus/refresh／；
	 * 此时8882端口会发送一个消息，由消息总线向其他服务传递，从而使整个微服务集群都达到更新配置文件。
	 */

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Value("${foo}")
	String foo;

	@RequestMapping(value = "/hi")
	public String hi(){
		return foo;
	}

}
