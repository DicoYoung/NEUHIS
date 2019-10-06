package DAO;

import VO.PatientVO;
import VO.UserVO;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 病人文件的读写操作,数据层
 *
 * @author dc
 *
 */
public class PatientDAO {
    public PatientDAO(){
        readInfo();//读取病人信息
    }
    private static Map<String, PatientVO> patientVOMap = new HashMap<>();
    private static void readInfo() {//从文件中读取用户信息
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\dc\\eclipse-workspace\\NEUHIS\\UserInformation\\PatientInfo.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);//对象序列化

            Object o = ois.readObject();//将存放在文件中的用户信息MAP取出来
            patientVOMap = (Map<String, PatientVO>) o;
            ois.close();//关闭流
            fis.close();//关闭流
        } catch (EOFException | ClassNotFoundException e){
            System.out.println("------读取完毕------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeInfo(PatientVO patientVO){//将用户信息写入文件中
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\dc\\eclipse-workspace\\NEUHIS\\UserInformation\\PatientInfo.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            patientVOMap.put(patientVO.getBingLiNumber(),patientVO);
            oos.writeObject(patientVOMap);//把数组写入文件中去
            oos.flush();//关闭流
            fos.close();//关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList Duqu(UserVO userVO){//读取挂号对应的医生与病人
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, PatientVO> entry : patientVOMap.entrySet()){
            PatientVO patientMapValue = entry.getValue();
            if (patientMapValue.getLookDoctor().equals(userVO.getTrueName())){
                arrayList.add(patientMapValue);
            }
            return arrayList;

        }
        return null;
    }
    public void writePatient(PatientVO patientVO){//写入一个病人的信息
        writeInfo(patientVO);
    }

    public PatientVO findPatient(PatientVO patientVO){//寻找指定的病人并返回
        readInfo();
        for (Map.Entry<String,PatientVO> entry : patientVOMap.entrySet()){
            PatientVO patientMapValue = entry.getValue();
            if (patientVO.getBingLiNumber().equals(patientMapValue.getBingLiNumber())){
                return patientMapValue;
            }
        }
        return null;

    }

    public void OverWrite(PatientVO patientVO){//将病人信息覆盖写入
        readInfo();
        for (Map.Entry<String,PatientVO> entry : patientVOMap.entrySet()){
            String patientMapKey = entry.getKey();
            PatientVO patientMapValue = entry.getValue();
            if (patientVO.getBingLiNumber().equals(patientMapValue.getBingLiNumber())){
                if (patientVO.getBingLiNumber().equals(patientMapKey)){
                    patientVOMap.put(patientMapKey,patientVO);
                    try {
                        FileOutputStream fos = new FileOutputStream("C:\\Users\\dc\\eclipse-workspace\\NEUHIS\\UserInformation\\PatientInfo.txt");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);

                        oos.writeObject(patientVOMap);//把数组写入文件中去
                        oos.flush();//关闭流
                        fos.close();//关闭流
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public void deletePatient(PatientVO patientVO){
        readInfo();
        for (Map.Entry<String,PatientVO> entry : patientVOMap.entrySet()){
            String patientMapKey = entry.getKey();
            if (patientVO.getBingLiNumber().equals(patientMapKey)){
                patientVOMap.remove(patientMapKey);//移除对应的病人键值对
                try {
                    FileOutputStream fos = new FileOutputStream("C:\\Users\\dc\\eclipse-workspace\\NEUHIS\\UserInformation\\PatientInfo.txt");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    oos.writeObject(patientVOMap);//把数组写入文件中去
                    oos.flush();//关闭流
                    fos.close();//关闭流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
