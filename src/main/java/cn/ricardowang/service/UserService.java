package cn.ricardowang.service;

import cn.ricardowang.bean.User;
import cn.ricardowang.dao.UserDao;
import cn.ricardowang.utils.SignInInfo;
import cn.ricardowang.utils.SignUpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpSession;

/**
 * @Author: wangqin
 * @Date: 2021/2/8 0008 - 02 -08 -18:24
 * @Description: main.cn.ricardowang.service
 * @version: 1.0
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    //检查登录信息
    public boolean signinUser(HttpSession session, SignInInfo info){
        User user = userDao.getUser(info.getUsername());
        if (user.getPassword().equals(info.getPassword())){
            session.setAttribute("user",user);
            return true;
        }
        return false;
    }
    public boolean checkUserInfo(User user){
        if (user==null){
            return false;
        }
        User realUser = userDao.getUser(user.getUsername());

        return user.equals(realUser);
    }
    //注册用户
    public SignUpResult signUpUser(@Validated User user) throws Exception {
        //初始化user
        user.setPrivilege(2);
        //添加user
        userDao.addUser(user);
        int userId=user.getId();
        //更新user
        user.setFavoritesTableName(userId+"_favorite");
        user.setUploadFilesTableName(userId+"_upload");
        userDao.updateUser(user);
        //创建新表
        userDao.addFavoriteTable(userId+"_favorite");
        userDao.addUploadTable(userId+"_upload");

        return new SignUpResult(true,"注册成功");
    }
    //获取当前用户
    public User getUser(HttpSession session){
        User user= (User) session.getAttribute("user");
        return user;
    }
    //退出用户
    public boolean signOut(HttpSession session){
        session.removeAttribute("user");
        if (session.getAttribute("user")!=null){
            return false;
        }
        return true;
    }

}
