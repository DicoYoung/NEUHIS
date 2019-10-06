package BO;

import DAO.LoginDAO;
import DAO.PatientDAO;
import VO.PatientVO;
import VO.UserVO;

import java.util.ArrayList;


/**
 * 病人-业务层
 *
 * @author dico
 */
public class PatientBO {
    public void GuaHao(PatientVO patientVO){//将病人挂号信息写入
        PatientDAO patientDAO = new PatientDAO();
        patientDAO.writeInfo(patientVO);
    }
    public ArrayList whichDoctor(UserVO userVO){//读取具体挂某个医生的号的病人
        LoginDAO loginDAO = new LoginDAO();
        UserVO userVO1 = loginDAO.CheckExist(userVO);
        if (userVO1 != null){
            if (userVO1.getUserCategory().equals("Doctor")){
                PatientDAO patientDAO = new PatientDAO();
                ArrayList arrayList = patientDAO.Duqu(userVO1);
                return arrayList;
            }
        }
        return null;
    }
    public UserVO returnDoc(UserVO userVO){//返回寻找到的医生用户
        LoginDAO loginDAO = new LoginDAO();
        return loginDAO.getDoctor(userVO);

    }
    public void writeNewPatient(PatientVO patientVO){//将开完药的病人写入到文件中去
        PatientDAO patientDAO = new PatientDAO();
        patientDAO.writePatient(patientVO);
    }
    public PatientVO findThePatient(PatientVO patientVO){//搜索病人信息并返回
        PatientDAO patientDAO = new PatientDAO();

        if (patientDAO.findPatient(patientVO) != null){
            return patientDAO.findPatient(patientVO);
        }
        return null;
    }
    public void overWriteThePatient(PatientVO patientVO){//覆盖写入病人信息
        PatientDAO patientDAO = new PatientDAO();
        patientDAO.OverWrite(patientVO);
    }
    public void deleteThePatient(PatientVO patientVO){
        PatientDAO patientDAO = new PatientDAO();
        patientDAO.deletePatient(patientVO);
    }
}
