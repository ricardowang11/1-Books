package cn.ricardowang.dao;

import cn.ricardowang.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: wangqin
 * @Date: 2021/2/8 0008 - 02 -08 -17:33
 * @Description: main.cn.ricardowang.dao
 * @version: 1.0
 */
public interface UserDao {
    int addUser(User user);
    int updateUserPrivilege(@Param("id") int id,@Param("privilege") int privilege);
    int updateUser(User user);
    User getUser(@Param("username")String username);
    int addFavoriteTable(@Param("tableName")String tableName);
    int addUploadTable(@Param("tableName")String tableName);
}
