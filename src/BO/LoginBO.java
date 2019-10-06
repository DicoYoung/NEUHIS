package BO;

import DAO.LoginDAO;
import VO.UserVO;

/**
 * 用户业务层，主要处理业务
 *
 * @author dico
 *
 */

public class LoginBO {
    public int isExist(UserVO userVO){//判断是否存在此用户userVO
        LoginDAO loginDAO = new LoginDAO();
        UserVO userVO1 = loginDAO.CheckExist(userVO);//调用数据层的判断方法
        if (userVO1 != null){
            System.out.println("用户：["+userVO1.getID()+"] 存在");
            return 1;//存在返回1
        }
        return 0;//不存在返回0
    }
    public int isDoctor(UserVO userVO){//判断用户职业
        LoginDAO loginDAO = new LoginDAO();
        UserVO userVO1 = loginDAO.CheckExist(userVO);//调用数据层的判断方法
        if (userVO1 != null){
            if (userVO1.getUserCategory().equals("Doctor")){
                return 2;//是医生返回2
            }
            return 3;//不是医生，返回3
        }
        return 0;//不存在返回0
    }



}
