package cn.ricardowang.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: wangqin
 * @Date: 2021/2/11 0011 - 02 -11 -8:43
 * @Description: cn.ricardowang.dao
 * @version: 1.0
 */
class BookDaoTest {
    @Test
    public void test01() throws IOException {
        String resource = "mybatis/mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        UserDao userDao = sqlSessionFactory.openSession().getMapper(UserDao.class);
//        System.out.println(userDao.getMaxId());
        System.out.println(userDao.addFavoriteTable("1_favorite"));
        System.out.println(userDao.addFavoriteTable("1_upload"));

    }

}