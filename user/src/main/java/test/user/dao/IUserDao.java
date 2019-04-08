package test.user.dao;


import test.user.domain.User;

/**
 * @author:ms.y
 * @create 2018/7/30-11:13
 */
public interface IUserDao {

    User findUserById(String id);
}
