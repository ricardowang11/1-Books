package cn.ricardowang.utils;

/**
 * @Author: wangqin
 * @Date: 2021/2/8 0008 - 02 -08 -17:58
 * @Description: main.cn.ricardowang.utils
 * @version: 1.0
 */
public class SignInInfo {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SignInInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SignInInfo() {
    }
}
