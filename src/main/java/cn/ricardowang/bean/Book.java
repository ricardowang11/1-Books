package cn.ricardowang.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: wangqin
 * @Date: 2021/2/8 0008 - 02 -08 -17:33
 * @Description: main.cn.ricardowang.bean
 * @version: 1.0
 */

public class Book {
    private String name;
    private String ISBN;
    private String author;
    private String introduction;
    private String url;
    private boolean isConfirmed;
    private int uploader;

    public int getUploader() {
        return uploader;
    }

    public void setUploader(int uploader) {
        this.uploader = uploader;
    }

    public Book(String name, String ISBN, String author, String introduction, String url, boolean isConfirmed, int uploader) {
        this.name = name;
        this.ISBN = ISBN;
        this.author = author;
        this.introduction = introduction;
        this.url = url;
        this.isConfirmed = isConfirmed;
        this.uploader = uploader;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", author='" + author + '\'' +
                ", introduction='" + introduction + '\'' +
                ", url='" + url + '\'' +
                ", isConfirmed=" + isConfirmed +
                ", uploader=" + uploader +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public Book(String name, String ISBN, String author, String introduction, String url, boolean isConfirmed) {
        this.name = name;
        this.ISBN = ISBN;
        this.author = author;
        this.introduction = introduction;
        this.url = url;
        this.isConfirmed = isConfirmed;
    }

    public Book() {
    }
}
