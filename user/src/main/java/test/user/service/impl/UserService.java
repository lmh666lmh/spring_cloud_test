package test.user.service.impl;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.user.dao.IUserDao;
import test.user.service.IUserService;

/**
 * @author:ms.y
 * @create 2018/7/30-11:13
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public boolean findUserById(String id){
       return userDao.findUserById(id)==null?false:true;
    }


}
