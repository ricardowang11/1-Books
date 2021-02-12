package cn.ricardowang.service;


import cn.ricardowang.bean.User;
import cn.ricardowang.dao.BookDao;
import cn.ricardowang.dao.UserDao;
import cn.ricardowang.utils.BookSearcher;
import cn.ricardowang.utils.SearchResult;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.ricardowang.bean.Book;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;

/**
 * @Author: wangqin
 * @Date: 2021/2/8 0008 - 02 -08 -18:24
 * @Description: main.cn.ricardowang.service
 * @version: 1.0
 */
@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    public Book getBookWithISBN(String bookISBN){
        Book book = bookDao.getBookWithISBN(bookISBN);
        return book;
//        return null;
    }
    public Book getBookWithName(String bookName){
        Book book = bookDao.getBookWithName(bookName);
        return book;
//        return null;
    }
    //获取特定用户的收藏夹
    public LinkedList<Book> getFavoriteBooks(HttpSession session, int userId, int pageId){
        LinkedList<Book> favorites = (LinkedList<Book>) session.getAttribute("favorites");
        if (favorites==null){
            //从userId对应的收藏夹表中获取图书id----->获取书库中图书信息
            LinkedList<String> booksISBNs = bookDao.getBooksISBN( userId + "-favorite");
            favorites=new LinkedList<Book>();
            for (String booksISBN : booksISBNs) {
                favorites.add(bookDao.getBookWithISBN(booksISBN));
            }
            session.setAttribute("favorites",favorites);
        }
        LinkedList<Book> result=new LinkedList<Book>();
        int length=favorites.size();
        if (length<10*pageId&&length>=(pageId-1)*10){
            for (int i=(pageId-1)*10;i<length;i++){
                result.add(favorites.get(i));
            }

        }else if (length>pageId*10){
            for (int i=(pageId-1)*10;i<pageId*10;i++){
                result.add(favorites.get(i));
            }
        }
        return result;
//        return null;
    }
    //获取特定用户的 上传的书籍
    public LinkedList<Book> getUploadBooks(HttpSession session,int userId,int pageId){

        LinkedList<Book> uploads = (LinkedList<Book>) session.getAttribute("uploads");
        if (uploads==null){
            //从userId对应的收藏夹表中获取图书id----->获取书库中图书信息
            LinkedList<String> booksISBNs = bookDao.getBooksISBN( userId + "-upload");
            uploads=new LinkedList<Book>();
            for (String booksISBN : booksISBNs) {
                uploads.add(bookDao.getBookWithISBN(booksISBN));
            }
            session.setAttribute("uploads",uploads);
        }
        LinkedList<Book> result=new LinkedList<Book>();
        int length=uploads.size();
        if (length<10*pageId&&length>=(pageId-1)*10){
            for (int i=(pageId-1)*10;i<length;i++){
                result.add(uploads.get(i));
            }

        }else if (length>pageId*10){
            for (int i=(pageId-1)*10;i<pageId*10;i++){
                result.add(uploads.get(i));
            }
        }
        return result;
//        return null;
    }
    //获取所有图书
    public LinkedList<Book> getBooks(HttpSession session,int pageId){
        LinkedList<Book> books = (LinkedList<Book>) session.getAttribute("allBooks");
        if (books==null){
            //从userId对应的收藏夹表中获取图书id----->获取书库中图书信息
            books = bookDao.getBooks();

            session.setAttribute("allBooks",books);
        }
        LinkedList<Book> result=new LinkedList<Book>();
        int length=books.size();
        if (length<10*pageId&&length>=(pageId-1)*10){
            for (int i=(pageId-1)*10;i<length;i++){
                result.add(books.get(i));
            }

        }else if (length>pageId*10){
            for (int i=(pageId-1)*10;i<pageId*10;i++){
                result.add(books.get(i));
            }
        }
        return result;
//        return null;
    }
    //对用户收藏夹、上传文件夹的图书进行 增、删会清空session中的缓存
    //增加收藏
    public boolean addFavoriteBook(HttpSession session,int userId,String ISBN){
        session.removeAttribute("favorites");
        session.removeAttribute("uploads");
        boolean result = bookDao.addBook(ISBN, userId + "-favorite");
        return result;
//        return false;
    }
    //删除收藏
    public boolean deleteFavoriteBook(HttpSession session,String ISBN){
        User user = (User) session.getAttribute("user");
        int userId = user.getId();
        session.removeAttribute("favorites");
        session.removeAttribute("uploads");
        boolean result = bookDao.deleteBookWithISBN(ISBN, userId + "-favorite");
        return result;
//        return false;
    }

    public boolean addUploadBook(HttpSession session,String ISBN){
        User user = (User) session.getAttribute("user");
        int userId = user.getId();
//        session.removeAttribute("favorites");
        session.removeAttribute("uploads");
        session.removeAttribute("allBooks");
        Book book=new Book();
        SearchResult searchResult= BookSearcher.searchWithISBN(ISBN);
        book.setName(searchResult.getResult().getTitle());
        book.setISBN(searchResult.getResult().getIsbn());
        book.setIntroduction(searchResult.getResult().getSummary());
        book.setAuthor(searchResult.getResult().getAuthor());
        book.setUrl(searchResult.getResult().getPic());
        book.setUploader(userId);
        book.setConfirmed(false);
        boolean result1 = bookDao.addBook(book.getISBN(), userId + "-upload");
        boolean result2 = bookDao.addBookToMain(book);
        return result1||result2;
//        return false;
    }
    public boolean deleteUploadBook(HttpSession session,String ISBN){
        int userId = bookDao.getBookWithISBN(ISBN).getUploader();
        session.removeAttribute("favorites");
        session.removeAttribute("uploads");
        session.removeAttribute("allBooks");
        boolean result1 = bookDao.deleteBookWithISBN(ISBN, userId + "-upload");
        boolean result2 = bookDao.deleteBookWithISBN(ISBN, "Books");

        return result1&&result2;
//        return false;
    }
    //批准图书
    public boolean confirmUploadBook(HttpSession session,String ISBN){
        session.removeAttribute("allBooks");
        User user = (User) session.getAttribute("user");
        //检查是否有管理权限
        int privilege = user.getPrivilege();
        boolean result=false;
        if (privilege<=1&&privilege>=0){
            result = bookDao.confirmBook(ISBN);
        }
        return result;
//        return false;
    }
    //拒绝图书
    public boolean rejectUploadBook(HttpSession session,String ISBN){
        session.removeAttribute("allBooks");
        User user = (User) session.getAttribute("user");
        //检查是否有管理权限
        int privilege = user.getPrivilege();
        boolean result=false;
        if (privilege<=1&&privilege>=0){
            Book book = bookDao.getBookWithISBN(ISBN);
            int uploaderId = book.getUploader();
            boolean result1 = bookDao.deleteBookWithISBN(ISBN, uploaderId + "-upload");
            boolean result2 = bookDao.deleteBookWithISBN(ISBN, "Books");
            result=result1&&result2;
        }
        return result;
//        return false;
    }
}
