package DAO;

import VO.UserVO;
import com.sun.javafx.collections.MappingChange;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 医院用户文件的读写操作,数据层
 *
 * @author dc
 *
 */

public class LoginDAO {

    //将用户写入文件的预处理

//    public LoginDAO(){
//        UserVO root = new UserVO("root","open","employer");
//        writeInfo(root);//写入挂号员的信息
//        UserVO doc = new UserVO("doc","open","Doctor");
//        writeInfo(doc);//写入主（ce）管（shi）医生的信息
//
//        //心血管内科医生
//        UserVO bianque = new UserVO("bianque","bq","Doctor","心血管内科","扁鹊");
//        writeInfo(bianque);
//        UserVO huatuo = new UserVO("huatuo","ht","Doctor","心血管内科","华佗");
//        writeInfo(huatuo);
//
//        //泌尿外科医生
//        UserVO zhangzhongjing = new UserVO("zhangzhongjing","zzj","Doctor","泌尿外科","张仲景");
//        writeInfo(zhangzhongjing);
//        UserVO huangfumi = new UserVO("huangfumi","hfm","Doctor","泌尿外科","皇甫谧");
//        writeInfo(huangfumi);
//
//        //性功能障碍医生
//        UserVO lishizhen = new UserVO("lishizhen","lsz","Doctor","性功能障碍","李时珍");
//        writeInfo(lishizhen);
//        UserVO sunsimiao = new UserVO("sunsimiao","ssm","Doctor","性功能障碍","孙思邈");
//        writeInfo(sunsimiao);
//        //将科室与医生联系起来：渲染选项时，选择完科室后，进行搜索，在将科室是这个的医生名字打到选项上去并进行渲染
//    }
    public LoginDAO(){
        readInfo();//读取文件信息到列表里，将它开辟一段内存来存放
    }
    private static Map<String, UserVO> userMap = new HashMap<>();

    //需要读取文件，而不是借用暂时开辟的内存，完善读取功能
    private static void readInfo() {//从文件中读取用户信息

        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\dc\\eclipse-workspace\\NEUHIS\\UserInformation\\UserInfo.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);//对象序列化

            Object o = ois.readObject();//将存放在文件中的用户信息数组取出来
            userMap = (Map<String, UserVO>) o;



            ois.close();//关闭流
            fis.close();//关闭流
        } catch (EOFException | ClassNotFoundException e){
            System.out.println("------读取完毕------");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeInfo(UserVO userVO){//将用户信息写入文件中
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\dc\\eclipse-workspace\\NEUHIS\\UserInformation\\UserInfo.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            userMap.put(userVO.getID(),userVO);
            oos.writeObject(userMap);//把Map写入文件中去
            oos.flush();//关闭流
            fos.close();//关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UserVO CheckExist(UserVO vo)//判断用户是否存在的方法
    {

        for (Map.Entry<String,UserVO> entry : userMap.entrySet()){//从Map中寻找是否存在键值对，即用户
            String userMapKey = entry.getKey();
            UserVO userMapValue = entry.getValue();
            if (userMapKey.equals(vo.getID())){
                if (userMapValue.getPassword().equals(vo.getPassword())){
                    return userMapValue;
                }
            }
        }
        return null;
    }

    public UserVO getDoctor(UserVO userVO)//返回医生的对象的方法
    {
        for (Map.Entry<String,UserVO> entry : userMap.entrySet()){
            String docMapKey = entry.getKey();
            UserVO docMapValue = entry.getValue();
            if (docMapKey.equals(userVO.getID())){
                return docMapValue;
            }
        }
        return null;
    }

}
