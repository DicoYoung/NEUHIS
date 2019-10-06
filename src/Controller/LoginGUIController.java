package Controller;

import BO.LoginBO;
import BO.PatientBO;
import VO.UserVO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 主界面及二级界面的controller
 *
 * @author dico
 */

public class LoginGUIController {
    public Pane LoginGUI;
    @FXML
    private Button LoginButton;
    @FXML
    private TextField IDText;
    @FXML
    private PasswordField PasswordText;
    @FXML
    private Pane TopPicture;
    @FXML
    private Label TopText;
    @FXML
    private Label StateLabel;
    @FXML
    protected void mousePressed(){
        LoginButton.setStyle("-fx-background-color: red");
    }
    @FXML
    protected void mouseReleased(){
        LoginButton.setStyle("-fx-background-color: #8A2BE2");
    }
    @FXML
    protected void mouseClicked(){//点击登录后触发的事件
        StateLabel.setText("");
        String tID = IDText.getText();
        String tpassword = PasswordText.getText();
        UserVO tempUser = new UserVO(null,null);
        tempUser.setID(tID);
        tempUser.setPassword(tpassword);
        LoginBO loginBO = new LoginBO();
        switch (loginBO.isExist(tempUser)){//调用判断ID是否存在的方法

            case 1:{
                StateLabel.setText("登陆成功");

                //暂停一秒钟用于给后面界面以缓冲时间
                try {
                    Thread.sleep(1000);
                    StateLabel.setText("");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                switch (loginBO.isDoctor(tempUser)){//判断登陆者的职业以显示不同界面
                    case 2:{//是医生，渲染医生界面
                        try {

                            Parent root = FXMLLoader.load(getClass().getResource("../Controller/DoctorWindow.fxml"));
                            Scene scene = new Scene(root);
                            Stage primaryStageM = new Stage();
                            primaryStageM.setScene(scene);
                            primaryStageM.setTitle("NeuHIS System");
                            primaryStageM.show();

                            //显示登录医生的ID，用于给后面读取信息
                            ComboBox<String> DocIDCombox =(ComboBox<String>)
                                    root.lookup("#DocIDCombox");
                            DocIDCombox.getItems().addAll(tempUser.getID());

                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                    }break;
                    case 3: {//不是医生，渲染挂号员界面
                        //渲染挂号员主界面的代码
                        try {
                            Parent root = FXMLLoader.load(getClass().getResource("../Controller/MainWindow.fxml"));
                            Scene scene = new Scene(root);
                            Stage primaryStageM = new Stage();
                            primaryStageM.setScene(scene);
                            primaryStageM.setTitle("NeuHIS System");
                            primaryStageM.show();

                            //设置挂号界面中的性别选项
                            ComboBox<String> SexButton =(ComboBox<String>)
                                    root.lookup("#SexButton");
                            SexButton.getItems().addAll("男","女");

                            //设置挂号界面中的结算类别选项
                            ComboBox<String> JiesuanButton =(ComboBox<String>)
                                    root.lookup("#JiesuanButton");
                            JiesuanButton.getItems().addAll("自费","医保","其他");

                            //设置挂号界面中的午别选项
                            ComboBox<String> AfterNoonButton =(ComboBox<String>)
                                    root.lookup("#AfterNoonButton");
                            AfterNoonButton.getItems().addAll("上午","下午");

                            //设置挂号界面中的号别选项
                            ComboBox<String> HaoBieButton =(ComboBox<String>)
                                    root.lookup("#HaoBieButton");
                            HaoBieButton.getItems().addAll("普通","加急","专家");

                            //设置挂号界面中的缴费方式选项
                            ComboBox<String> WayofPayButton =(ComboBox<String>)
                                    root.lookup("#WayofPayButton");
                            WayofPayButton.getItems().addAll("现金","医保卡","信用卡","银行卡","支付宝","微信支付","PayPal","刷脸");

                            //设置挂号界面中的科室选项
                            ComboBox<String> RoomButton =(ComboBox<String>)
                                    root.lookup("#RoomButton");
                            RoomButton.getItems().addAll("心血管内科","泌尿外科","性功能障碍");
                            RoomButton.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                                @Override
                                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                                    System.out.println(newValue);

                                    //设置挂号界面中的医生选项

                                    //心血管科医生
                                    if (newValue.equals("心血管内科")){
                                        ComboBox<String> DoctorButton =(ComboBox<String>)
                                                root.lookup("#DoctorButton");
                                        DoctorButton.getItems().clear();//每次先清除所有添加的医生，只添加对应科室的医生
                                        DoctorButton.getItems().addAll("扁鹊","华佗");
                                    }

                                    //泌尿科医生
                                    if (newValue.equals("泌尿外科")){
                                        ComboBox<String> DoctorButton =(ComboBox<String>)
                                                root.lookup("#DoctorButton");
                                        DoctorButton.getItems().clear();//每次先清除所有添加的医生，只添加对应科室的医生
                                        DoctorButton.getItems().addAll("张仲景","皇甫谧");
                                    }
                                    //性功能障碍医生
                                    if (newValue.equals("性功能障碍")){
                                        ComboBox<String> DoctorButton =(ComboBox<String>)
                                                root.lookup("#DoctorButton");
                                        DoctorButton.getItems().clear();//每次先清除所有添加的医生，只添加对应科室的医生
                                        DoctorButton.getItems().addAll("李时珍","孙思邈");
                                    }

                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }break;
                }
            }break;
            case 0:{
                StateLabel.setText("登陆失败，请重新输入");

                try {//清空提示信息
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }break;
        }



    }
}
