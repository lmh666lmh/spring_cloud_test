package test.service;

import org.springframework.stereotype.Service;

@Service
public class ZuulService {

    public boolean checkAothority(String str){
        boolean tag=true;
        if("1".equals(str)){
            tag=false;
        }
        return tag;
    }
}
