package VO;

import java.io.Serializable;
/**
 *用户实体类
 *
 * @author dico
 *
 */

public class UserVO implements Serializable {
    private String ID;//用户的登录账号
    private String password;//用户的密码
    private String trueName;//用户的真实姓名
    private String userDepartments;//用户的科室
    private String userCategory;//用户类别

    public UserVO(){

    }
    public UserVO(String ID, String password){//构造方法--用于在数据层中只获取ID和密码，然后来进行下一步的操作
        this.ID = ID;
        this.password = password;
    }
    public UserVO(String ID,String password,String userCategory){//构造方法：建立带职业的用户
        this.ID = ID;
        this.password = password;
        this.userCategory = userCategory;
    }
    public UserVO(String ID,String password,String userCategory,String userDepartments,String trueName){//构造方法：具体医生信息，带科室的，真名
        this.ID =  ID;
        this.password = password;
        this.userCategory = userCategory;
        this.userDepartments = userDepartments;
        this.trueName = trueName;
    }
    //Set方法
    public void setID(String ID) {//设置用户ID
        this.ID = ID;
    }

    public void setPassword(String password) {//设置密码
        this.password = password;
    }

    public void setTrueName(String trueName) {//设置真实姓名
        this.trueName = trueName;
    }

    public void setUserCategory(String userCategory) {//设置用户类别
        this.userCategory = userCategory;
    }

    public void setUserDepartments(String userDepartments) {//设置用户科室
        this.userDepartments = userDepartments;
    }

    //Get方法

    public String getID() {//获得ID
        return ID;
    }

    public String getPassword() {//获得密码
        return password;
    }

    public String getTrueName() {//获得真实姓名
        return trueName;
    }

    public String getUserCategory() {//获得用户类别
        return userCategory;
    }

    public String getUserDepartments() {//获得用户科室
        return userDepartments;
    }

}
