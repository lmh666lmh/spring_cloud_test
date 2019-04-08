package test.testrpc.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author:ms.y
 * @create 2018/9/6-15:37
 */
@FeignClient(value="user",fallback = TestRpcFallBack.class)
public interface TestRpc {
    @RequestMapping(value="/user/login.do",method = RequestMethod.POST)
    String login(@RequestParam(value="id") String id);
}
