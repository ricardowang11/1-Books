package cn.ricardowang.bean;


import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Author: wangqin
 * @Date: 2021/2/7 0007 - 02 -07 -17:15
 * @Description: main.cn.ricardowang.bean
 * @version: 1.0
 */
public class User{
    private int id;
    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9]{4,16}")
    private String username;
    @Pattern(regexp = "[a-zA-Z0-9]{8,16}",message = "密码格式不符")
    private String password;
    @Email
    @NotNull
    private String email;
    private int privilege;
    private String favoritesTableName;
    private String phone;
    private String uploadFilesTableName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public String getFavoritesTableName() {
        return favoritesTableName;
    }

    public void setFavoritesTableName(String favoritesTableName) {
        this.favoritesTableName = favoritesTableName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUploadFilesTableName() {
        return uploadFilesTableName;
    }

    public void setUploadFilesTableName(String uploadFilesTableName) {
        this.uploadFilesTableName = uploadFilesTableName;
    }

    public User(int id, @NotNull @Pattern(regexp = "[a-zA-Z0-9]{4,16}") String username, @Pattern(regexp = "[a-zA-Z0-9]{8,16}", message = "密码格式不符") String password, @Email String email, @NotNull int privilege, String favoritesTableName, @NotNull String phone, String uploadFilesTableName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.privilege = privilege;
        this.favoritesTableName = favoritesTableName;
        this.phone = phone;
        this.uploadFilesTableName = uploadFilesTableName;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (privilege != user.privilege) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (favoritesTableName != null ? !favoritesTableName.equals(user.favoritesTableName) : user.favoritesTableName != null)
            return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        return uploadFilesTableName != null ? uploadFilesTableName.equals(user.uploadFilesTableName) : user.uploadFilesTableName == null;
    }


}
