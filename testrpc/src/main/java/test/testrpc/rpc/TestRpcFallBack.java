package test.testrpc.rpc;

import org.springframework.stereotype.Component;

/**
 * @author:ms.y
 * @create 2018/9/7-13:45
 */
@Component //不添加该注解会出现无法发现该类问题
public class TestRpcFallBack implements TestRpc{

    @Override
    public String login(String id) {
        return "request fallback";
    }
}
