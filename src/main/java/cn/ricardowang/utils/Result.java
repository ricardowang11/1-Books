package cn.ricardowang.utils;

/**
 * @Author: wangqin
 * @Date: 2021/2/10 0010 - 02 -10 -19:52
 * @Description: cn.ricardowang.utils
 * @version: 1.0
 */
public class Result {
    /*
        "title": "有理想就有疼痛",
        "subtitle": "中国当代文化名人访谈录",
        "pic": "http://api.jisuapi.com/isbn/upload/20161010/174050_28792.jpg",
        "author": "高晓春",
        "summary": "《有理想就有疼痛:中国当代文化名人访谈录》是一份关于当代中国文化的最真实底稿，收录了高晓春与白先勇、冯骥才、余华、莫言、余秋雨、陈忠实等20位当代中国文化大家的对话。通过近距离的访谈，展现了这些文化大家多彩的内心世界，也阐释了他们对生命、艺术、财富及文化的理解。",
        "publisher": "",
        "pubplace": "",*/
    private String title;
    //    private String subtitle;
    private String pic;
    private String author;
    private String summary;
//    private String publisher;
//    private String pubplace;




    /*
        "pubdate": "2013-1",
        "page": "256",
        "price": "29.00",
        "binding": "",
        "isbn": "9787212058937",
        "isbn10": "7212058939",
        "keyword": "",
        "edition": "",
        "impression": "",
        "language": "",
        "format": "",
        "class": ""
     */
//    private String pubdate;
//    private String page;
//    private String price;
//    private String binding;
    private String isbn;
    private String isbn10;
//    private String keyword;
//    private String edition;
//    private String impression;
//    private String language;
//    private String format;


    public Result() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pic='" + pic + '\'' +
                ", author='" + author + '\'' +
                ", summary='" + summary + '\'' +
                ", isbn='" + isbn + '\'' +
                ", isbn10='" + isbn10 + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public Result(String title, String pic, String author, String summary, String isbn, String isbn10) {
        this.title = title;
        this.pic = pic;
        this.author = author;
        this.summary = summary;
        this.isbn = isbn;
        this.isbn10 = isbn10;
    }
}
