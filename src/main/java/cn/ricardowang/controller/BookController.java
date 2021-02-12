package cn.ricardowang.controller;

import cn.ricardowang.bean.Book;
import cn.ricardowang.bean.User;
import cn.ricardowang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.util.LinkedList;

/**
 * @Author: wangqin
 * @Date: 2021/2/8 0008 - 02 -08 -18:24
 * @Description: main.cn.ricardowang.controller
 * @version: 1.0
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @ResponseBody
    @RequestMapping(value = "/getBookWithISBN/{bookId}",method = RequestMethod.GET)
    public Book getBookWithISBN(@PathVariable("bookId") String bookISBN){

        return bookService.getBookWithISBN(bookISBN);
    }
    @ResponseBody
    @RequestMapping(value = "/getBookWithName/{bookName}",method = RequestMethod.GET)
    public Book getBookWithName(@PathVariable("bookName") String bookName){

        return bookService.getBookWithName(bookName);
    }
    @ResponseBody
    @RequestMapping("/getFavoriteBooks")
    public LinkedList<Book> getFavoriteBooks(HttpSession session){
        User user = (User) session.getAttribute("user");
        LinkedList<Book> favoriteBooks = bookService.getFavoriteBooks(session, user.getId(), 1);
        return favoriteBooks;
    }
    @ResponseBody
    @RequestMapping("/getUploadBooks")
    public LinkedList<Book> getUploadBooks(HttpSession session){
        User user = (User) session.getAttribute("user");
        LinkedList<Book> uploadBooks = bookService.getUploadBooks(session,user.getId(),1);
        return uploadBooks;
    }
    @ResponseBody
    @RequestMapping("/getBooks")
    public LinkedList<Book> getBooks(HttpSession session){
        LinkedList<Book> books = bookService.getBooks(session,1);
        System.out.println(books);
        return books;
    }
    @ResponseBody
    @RequestMapping("/addFavoriteBook")
    public boolean addFavoriteBook(HttpSession session,String ISBN){
        User user = (User) session.getAttribute("user");
        boolean result = bookService.addFavoriteBook(session, user.getId(), ISBN);
        return result;
    }
    @ResponseBody
    @RequestMapping("/deleteFavoriteBook")
    public boolean deleteFavoriteBook(HttpSession session,String ISBN){
        boolean result = bookService.deleteFavoriteBook(session,ISBN);
        return result;
    }
    @ResponseBody
    @RequestMapping("/addUploadBook")
    public boolean addUploadBook(HttpSession session,String ISBN){
        boolean result = bookService.addUploadBook(session, ISBN);
        return result;
    }
    @ResponseBody
    @RequestMapping("/deleteUploadBook")
    public boolean deleteUploadBook(HttpSession session,String ISBN){
        boolean result = bookService.deleteUploadBook(session,ISBN);
        return result;
    }
    @ResponseBody
    @RequestMapping("/confirmUploadBook")
    public boolean confirmUploadBook(HttpSession session,String ISBN){
        User user = (User) session.getAttribute("user");
        boolean result = bookService.confirmUploadBook(session,ISBN);
        return result;
    }
    @ResponseBody
    @RequestMapping("/rejectUploadBook")
    public boolean rejectUploadBook(HttpSession session,String ISBN){
        User user = (User) session.getAttribute("user");
        boolean result = bookService.rejectUploadBook(session, ISBN);
        return result;
    }
}
