package test.user.domain;


import test.user.base.BaseObject;

/**
 * @author:ms.y
 * @create 2018/7/30-11:00
 */

public class User extends BaseObject {
    private String id;
    private String pass;
    private int type;
    private String uname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
