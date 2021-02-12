package cn.ricardowang.utils;



/**
 * @Author: wangqin
 * @Date: 2021/2/8 0008 - 02 -08 -20:16
 * @Description: main.cn.ricardowang.utils
 * @version: 1.0
 */

public class SignUpResult {
    private boolean isSuccessed;
    private String errorInfo;

    public boolean isSuccessed() {
        return isSuccessed;
    }

    public void setSuccessed(boolean successed) {
        isSuccessed = successed;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public SignUpResult() {
    }

    public SignUpResult(boolean isSuccessed, String errorInfo) {
        this.isSuccessed = isSuccessed;
        this.errorInfo = errorInfo;
    }
}
