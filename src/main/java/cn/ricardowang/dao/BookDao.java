package cn.ricardowang.dao;

import cn.ricardowang.bean.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

/**
 * @Author: wangqin
 * @Date: 2021/2/8 0008 - 02 -08 -17:33
 * @Description: main.cn.ricardowang.dao
 * @version: 1.0
 */
public interface BookDao {
    boolean addBookToMain(Book book);
    boolean addBook(@Param("ISBN") String ISBN,@Param("tableName") String tableName);
//    boolean updateBook(Book book);
    boolean confirmBook(String ISBN);

    Book getBookWithISBN(String ISBN);
    Book getBookWithName(String name);
//    int getUpLoader(String ISBN);

    boolean deleteBookWithISBN(@Param("ISBN")String ISBN,@Param("tableName")String tableName);
//    boolean deleteBookWithName(@Param("name")String name,@Param("tableName")String tableName);

    LinkedList<Book> getBooks();
    LinkedList<String> getBooksISBN(String tableName);
}
