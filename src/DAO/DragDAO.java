package DAO;

import VO.DragVO;
import VO.UserVO;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 药品类的读取文件操作，数据层
 * @author dico
 *
 */
public class DragDAO {
    private static Map<String, DragVO> dragVOMap = new HashMap<>();

    public DragDAO(){
        readInfo();
    }

    //测试用的main方法
//public static void main(String[] args) {
//    DragDAO dragDAO = new DragDAO();
//
//}

    //将药品写入文件的预处理
//    public DragDAO(){
//
//        //心血管内科的药品
//        DragVO dcc = new DragVO("断肠草",10.00,"心血管内科");
//        writeInfo(dcc);
//        DragVO lgt = new DragVO("雷公藤",15.00,"心血管内科");
//        writeInfo(lgt);
//
//        //泌尿外科的药品
//        DragVO gw = new DragVO("钩吻",12.00,"泌尿外科");
//        writeInfo(gw);
//        DragVO hdh = new DragVO("鹤顶红",20.00,"泌尿外科");
//        writeInfo(hdh);
//
//        //性功能障碍的药品
//        DragVO wtj = new DragVO("乌头碱",30.00,"性功能障碍");
//        writeInfo(wtj);
//        DragVO jxfh = new DragVO("见血封喉",37.00,"性功能障碍");
//        writeInfo(jxfh);
//    }
    private static void readInfo() {//从文件中读取药品信息
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\dc\\eclipse-workspace\\NEUHIS\\UserInformation\\DragInfo.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);//对象序列化

            Object o = ois.readObject();//将存放在文件中的用户信息数组取出来
            dragVOMap = (Map<String, DragVO>) o;



            ois.close();//关闭流
            fis.close();//关闭流
         } catch (EOFException | ClassNotFoundException e){
         System.out.println("------读取完毕------");
         } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void writeInfo(DragVO dragVO){//将药品信息写入文件中
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\dc\\eclipse-workspace\\NEUHIS\\UserInformation\\DragInfo.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            dragVOMap.put(dragVO.getDragName(),dragVO);
            oos.writeObject(dragVOMap);//把Map写入文件中去
            oos.flush();//关闭流
            fos.close();//关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList DragList(UserVO userVO){//读取药品列表找到对应药房的药品
        ArrayList arrayList = new ArrayList();

        for (Map.Entry<String, DragVO> entry : dragVOMap.entrySet()){

            DragVO dragMapValue = entry.getValue();
            String dragRoom = dragMapValue.getDragRoom();
            String userRoom = userVO.getUserDepartments();

            //将两个属性绑定到String上
//            System.out.println("DragRoom"+dragRoom);
//            System.out.println("UserRoom"+userRoom);

            //进行比较
            switch (CheckedString(dragRoom,userRoom)){
                case 1:{
//                    System.out.println("成功");
                    arrayList.add(dragMapValue);
                }break;
                case 0:{
//                    System.out.println("失败");
                }break;
            }

        }
        return arrayList;
    }

    public int CheckedString(String string1,String string2){//比较两个字符串的方法
        if (string1.equals(string2)){
            return 1;
        }else {
            return 0;
        }
    }
}
