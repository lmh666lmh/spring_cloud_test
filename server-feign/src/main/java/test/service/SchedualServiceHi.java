package test.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "test-feign",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {

    //调用服务名为 test-feign 中 /hi接口   返回String类型，所以sayHiFromClientOne也返回String类型
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
