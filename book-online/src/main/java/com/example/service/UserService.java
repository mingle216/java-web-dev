package com.example.service;

import com.example.entity.User;
//import com.example.utils.Md5Util;
import java.util.List;

/**
 * @author mingle
 * @date 2022/2/24 16:49
 * @description 用户业务逻辑类
 */
public class UserService {
    private List<User> userList;

    public void setUserList(List<User> userList){
        this.userList=userList;
    }
    
    /**
     * @author mingle
     * @date 2022/2/24 16:51
     * @description 用户登录功能
     */
    public User signIn(String account,String password){
        for(User user:userList){
            if(user.getAccount().equals(account)&&user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        User user=new UserService().signIn("13951905171", "111");
        if(user!=null){
            System.out.println(user);
        }
        else {
            System.out.println("登录失败！");
        }
    }
}
