package cn.ricardowang.utils;

/**
 * @Author: wangqin
 * @Date: 2021/2/10 0010 - 02 -10 -19:52
 * @Description: cn.ricardowang.utils
 * @version: 1.0
 */
public class SearchResult {
    private String status;
    private String msg;
    private Result result;

    @Override
    public String toString() {
        return "SearchResult{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public SearchResult(String status, String msg, Result result) {
        this.status = status;
        this.msg = msg;
        this.result = result;
    }

    public SearchResult() {
    }
}
