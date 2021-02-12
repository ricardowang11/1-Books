package cn.ricardowang.controller;

import cn.ricardowang.bean.User;
import cn.ricardowang.service.UserService;
import cn.ricardowang.utils.SignInInfo;
import cn.ricardowang.utils.SignUpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author: wangqin
 * @Date: 2021/2/8 0008 - 02 -08 -18:24
 * @Description: main.cn.ricardowang.controller
 * @version: 1.0
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/signIn")
    public boolean checkUserInfo(HttpSession session, SignInInfo info) {
        return userService.signinUser(session, info);
    }

    @ResponseBody
    @RequestMapping("/signUp")
    public SignUpResult signUp(User user) throws Exception {
        return userService.signUpUser(user);
    }

    @ResponseBody
    @RequestMapping("/signOut")
    public boolean signOut(HttpSession session) throws Exception {
        return userService.signOut(session);
    }

    @ResponseBody
    @RequestMapping("/getUser")
    public User getUser(HttpSession session) {
        return userService.getUser(session);
    }
    //todo:添加收藏
}
/*
org.springframework.beans.factory.UnsatisfiedDependencyException:
Error creating bean with name 'bookService': Unsatisfied dependency expressed through field 'bookDao';
nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'bookDao' defined in file
[F:\ideaProject\1-Books\out\artifacts\1_Books_war_exploded\WEB-INF\classes\cn\ricardowang\dao\BookDao.class]:
Cannot resolve reference to bean 'sqlSessionFactory' while setting bean property 'sqlSessionFactory';
nested exception is org.springframework.beans.factory.BeanCreationException:
Error creating bean with name 'sqlSessionFactory' defined in class path resource [applicationContext.xml]: Invocation of init method failed;
nested exception is org.springframework.core.NestedIOException:
Failed to parse mapping resource: 'file [F:\ideaProject\1-Books\out\artifacts\1_Books_war_exploded\WEB-INF\classes\mybatis\mapper\UserDao.xml]';
nested exception is org.apache.ibatis.builder.BuilderException:
 Error parsing Mapper XML. The XML location is 'file [F:\ideaProject\1-Books\out\artifacts\1_Books_war_exploded\WEB-INF\classes\mybatis\mapper\UserDao.xml]'.
 Cause: java.lang.IllegalArgumentException: Mapped Statements collection already contains value for cn.ricardowang.dao.UserDao.updateUserPrivilege.
 please check file [F:\ideaProject\1-Books\out\artifacts\1_Books_war_exploded\WEB-INF\classes\mybatis\mapper\UserDao.xml]
 and file [F:\ideaProject\1-Books\out\artifacts\1_Books_war_exploded\WEB-INF\classes\mybatis\mapper\UserDao.xml]

Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'bookDao' defined in file [F:\ideaProject\1-Books\out\artifacts\1_Books_war_exploded\WEB-INF\classes\cn\ricardowang\dao\BookDao.class]: Cannot resolve reference to bean 'sqlSessionFactory' while setting bean property 'sqlSessionFactory'; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'sqlSessionFactory' defined in class path resource [applicationContext.xml]: Invocation of init method failed; nested exception is org.springframework.core.NestedIOException: Failed to parse mapping resource: 'file [F:\ideaProject\1-Books\out\artifacts\1_Books_war_exploded\WEB-INF\classes\mybatis\mapper\UserDao.xml]'; nested exception is org.apache.ibatis.builder.BuilderException: Error parsing Mapper XML. The XML location is 'file [F:\ideaProject\1-Books\out\artifacts\1_Books_war_exploded\WEB-INF\classes\mybatis\mapper\UserDao.xml]'. Cause: java.lang.IllegalArgumentException: Mapped Statements collection already contains value for cn.ricardowang.dao.UserDao.updateUserPrivilege. please check file [F:\ideaProject\1-Books\out\artifacts\1_Books_war_exploded\WEB-INF\classes\mybatis\mapper\UserDao.xml] and file [F:\ideaProject\1-Books\out\artifacts\1_Books_war_exploded\WEB-INF\classes\mybatis\mapper\UserDao.xml]

 */
