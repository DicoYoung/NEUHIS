package Controller;

import BO.PatientBO;
import VO.DragVO;
import VO.PatientVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 挂号员主界面的controllerngj
 *
 * @author dico
 */

public class MainWindowController {//主界面窗口控制器
    @FXML
    public AnchorPane MainWindow;
    public Pane TopPane;
    public Label TopLabelText;
    public javafx.scene.control.SplitPane SplitPane;
    public Accordion TitleZone;
    public TitledPane RegisteredPaymentTitle;
    public Button OnRegisterButton;
    public Button WithdrawButton;
    public Button ChargeButton;
    public Button RefondButton;
    public AnchorPane MainPane;
    public TabPane RegisteredPaymentPane;
    public Tab RegisterTable;

    //现场挂号的界面控件
    public TextField InvoiceText;//
    public Button RegisterButton;//
    public Button ClearButton;//
    public TextField NumberText;//
    public TextField NameText;//
    public ComboBox SexButton;//
    public TextField OldText;//
    public TextField IDNumberText;//
    public TextField AddressText;//
    public ComboBox JiesuanButton;//
    public DatePicker LookDoctorPicker;//
    public DatePicker BirthdayPicker;//
    public TextField MoneyText;//
    public ComboBox WayofPayButton;//
    public ComboBox AfterNoonButton;//
    public ComboBox RoomButton;//
    public ComboBox HaoBieButton;//
    public ComboBox DoctorButton;//
    //现场挂号的界面控件

    public TabPane GetMoneyTabPane;
    public TextField InfoIDText;
    public TextField InfoAddressText;
    public Button SearchButton;
    public TextField InfoNameText;
    public TextField OutBingLiHaoText;
    public TextField OutIDText;
    public TextField OutAddressText;
    public Button OutSearchBuuton;
    public TextField OutNameText;
    public TableView InfoTable1;
    public TextField InfoNumberText;
    public AnchorPane leftPane;
    public AnchorPane GuahaoPane;
    public TitledPane UnkonwPane1;
    public AnchorPane AnchorPane1;
    public TitledPane UnknowPane2;
    public AnchorPane AnchorPane2;
    public AnchorPane OnRegisterAnchorPane;
    public Label FaPiaoLabel;
    public Label RedStar1;
    public Label BingLiHaoLabel;
    public Label GuaHaoInfoLabel;
    public Label NameLabel;
    public MenuItem Man;
    public Label SexLabel;
    public MenuItem Woman;
    public Label AgeLabel;
    public Label BirthLabel;
    public Label IDLabel;
    public Label AddLabel;
    public Label JieSuanLabel;
    public Label KanDoctorLabel;
    public Label BingLibenLabel;
    public Label ShouldMoneyLabel;
    public Label WayofChargeLabel;
    public Label RedStar2;
    public Label NoonLabel;
    public Label RoomLabel;
    public Label RedStar4;
    public Label RedStar3;
    public Label HaoBieLabel;
    public Label DoctorLabe;
    public Label RedStar5;
    public Label RedStar6;
    public Label RedStar7;
    public Label RedStar8;
    public Label RedStar9;
    public Label RedStar10;
    public Label RedStar11;
    public Label RedStar12;
    public Label RedStar13;
    public Tab ChargeTab;
    public AnchorPane ChargeAnchorPane;
    public Label InfoSearchLabel;
    public Label InfoBLHLabel;
    public Label InfoIDLabel;
    public Label InfoAddL;
    public Label CheckL;
    public Label InfoNameL;
    public Label RedStar14;
    public TabPane OutTabPane;
    public Tab OutTab;
    public Label OutSearchL;
    public AnchorPane OutAnchorPane;
    public Label OutBLHL;
    public Label OutIDL;
    public Label OutAddL;
    public Label OutGuahaoInfoL;
    public Label OutCheckL;
    public Label OytNameL;
    public Label RedStar15;
    public Label XiaofeiL;
    public TabPane BackTabPane;
    public Tab BackTab;
    public AnchorPane BackAnchorPane;
    public Label BackSearchL;
    public Label BackBLHL;
    public Label BackIDL;
    public Label BackAddL;
    public Label BackGuahaoInfoL;
    public TextField BackBingLiHaoText;
    public TextField OutIDText1;
    public TextField BackAddressText;
    public Button BackSearchBuuton;
    public Label BackCheckL;
    public Label BacktNameL;
    public Label RedStar16;
    public TextField BackNameText;
    public TextField BingLiNumberText;
    public CheckBox BingLiBen;
    public Label GuahaofeiLabel;
    public TextField GuahaofeiText;
    public Button JiaofeiButton;
    public Button TuihaoButton;

    //缴费Table控件组
    public TableView InfoTable;
    public TableColumn MoneyNameColumn;//需要缴费的项目名称Column
    public TableColumn MoneyPriceColumn;//需要缴费的项目价格Column
    public Label ErrorLabel;


    @FXML
    protected void OnRegisterMouseClicked(){//显示现场挂号界面的方法
        RegisteredPaymentPane.setVisible(true);//挂号显示
        OutTabPane.setVisible(false);//退号不显示
        GetMoneyTabPane.setVisible(false);//交钱不显示
        BackTabPane.setVisible(false);//退费不显示
    }
    @FXML
    protected void OutMouseClicked(){//显示退号界面的方法
        OutTabPane.setVisible(true);//退号显示
        RegisteredPaymentPane.setVisible(false);//挂号不显示
        GetMoneyTabPane.setVisible(false);//交钱不显示
        BackTabPane.setVisible(false);//退费不显示
    }
    @FXML
    protected void ChargeMouseClicked(){//显示交钱缴费界面的方法
        GetMoneyTabPane.setVisible(true);//交钱显示
        RegisteredPaymentPane.setVisible(false);//挂号不显示
        OutTabPane.setVisible(false);//退号不显示
        BackTabPane.setVisible(false);//退费不显示
    }
    @FXML
    protected void BackMouseClicked(){//显示退费界面的方法
        BackTabPane.setVisible(true);//退费显示
        OutTabPane.setVisible(false);//退号不显示
        GetMoneyTabPane.setVisible(false);//交钱不显示
        RegisteredPaymentPane.setVisible(false);//挂号不显示
    }
    @FXML
    protected void RegisterMouseClicked(){//点击挂号按钮后的方法
        try {
            PatientVO tempPatient = new PatientVO();//新建一个暂时的病人用于存放输入的数据
            //非空判断和数据赋值

            //发票号
            if (InvoiceText.getText()!=null){
                tempPatient.setInvoice(InvoiceText.getText());
            }
            else {
                InvoiceText.setText("***不能为空***");
            }

            //病历号
            if (BingLiNumberText.getText()!=null){
                tempPatient.setBingLiNumber(BingLiNumberText.getText());
            }
            else {
                BingLiNumberText.setText("***不能为空***");
            }

            //姓名
            if (NameText.getText()!=null){
                tempPatient.setPatientName(NameText.getText());
            }
            else {
                NameText.setText("***不能为空***");
            }

            //年龄
            if (OldText.getText()!=null){
                tempPatient.setOld(OldText.getText());
            }
            else {
                OldText.setText("***不能为空***");
            }

            //身份证号
            if (IDNumberText.getText()!= null){
                tempPatient.setIDNum(IDNumberText.getText());
            }
            else {
                IDNumberText.setText("***不能为空***");
            }

            tempPatient.setSex(SexButton.getSelectionModel().getSelectedItem().toString());//性别
            tempPatient.setAddress(AddressText.getText());//设置家庭住址
            tempPatient.setJiesuanLeiBie(JiesuanButton.getSelectionModel().getSelectedItem().toString());//设置结算类别
            tempPatient.setLookDoctorDay(LookDoctorPicker.getValue().toString());//设置看诊日期
            tempPatient.setBirthday(BirthdayPicker.getValue().toString());//设置生日
            tempPatient.setWayofMoney(WayofPayButton.getSelectionModel().getSelectedItem().toString());//设置结算方式
            tempPatient.setWubie(AfterNoonButton.getSelectionModel().getSelectedItem().toString());//设置午别
            tempPatient.setRoom(RoomButton.getSelectionModel().getSelectedItem().toString());//设置科室
            tempPatient.setLookDoctor(DoctorButton.getSelectionModel().getSelectedItem().toString());//设置看诊医生

            //计算挂不同的号以及是否要病历本所应该支付的挂号费
            if (!HaoBieButton.getSelectionModel().getSelectedItem().toString().isEmpty()){
                double sum = 0.00;
                double bingliben = 1.00;
                if (HaoBieButton.getSelectionModel().getSelectedItem().toString().equals("普通")){
                    sum = 10.00;
                }
                if (HaoBieButton.getSelectionModel().getSelectedItem().toString().equals("加急")){
                    sum = 20.00;
                }
                if (HaoBieButton.getSelectionModel().getSelectedItem().toString().equals("专家")){
                    sum = 30.00;
                }
                tempPatient.setHaobie(HaoBieButton.getSelectionModel().getSelectedItem().toString());
                if (BingLiBen.isSelected()){//设置是否需要病历本
                    tempPatient.setBingliben(true);
                    sum = sum + bingliben;
                }
                else {
                    tempPatient.setBingliben(false);
                }
                MoneyText.setText(String.valueOf(sum));
                tempPatient.setNeedMoney(MoneyText.getText());
            }
            //计算挂不同的号以及是否要病历本所应该支付的挂号费

            //挂号操作
            PatientBO patientBO = new PatientBO();
            patientBO.GuaHao(tempPatient);

            //挂号成功的界面
            ErrorLabel.setText("挂号成功！");
            //↑  懒得画了
        }catch (Exception e){
            ErrorLabel.setText("错误！请重新输入！");
        }


    }
    @FXML
    protected void ClearMouseClicked(){//点击清除按钮的方法
        InvoiceText.clear();
        BingLiNumberText.clear();
        NameText.clear();
        SexButton.getSelectionModel().clearSelection();
        OldText.clear();
        BirthdayPicker.setValue(null);
        IDNumberText.clear();
        AddressText.clear();
        JiesuanButton.getSelectionModel().clearSelection();
        LookDoctorPicker.setValue(null);
        AfterNoonButton.getSelectionModel().clearSelection();
        RoomButton.getSelectionModel().clearSelection();
        HaoBieButton.getSelectionModel().clearSelection();
        DoctorButton.getSelectionModel().clearSelection();
        MoneyText.clear();
        WayofPayButton.getSelectionModel().clearSelection();

    }
    private ObservableList<DragVO> dragVOObservableList = FXCollections.observableArrayList();//药品类List

    public void OnSearchMouseCliked() {//用于在收费界面根据病历号寻找病人的方法

        //包装药品类的属性，用于在Table里显示
        MoneyNameColumn.setCellValueFactory(new PropertyValueFactory("DragName"));
        MoneyPriceColumn.setCellValueFactory(new PropertyValueFactory("DragPrice"));

        PatientVO tempPatient = new PatientVO();//暂时的病人实例，用于储存病历号
        tempPatient.setBingLiNumber(InfoNumberText.getText());//将输入的病历号赋予新的暂时对象，然后去寻找此对象

        PatientBO patientBO = new PatientBO();

        PatientVO patientVO = new PatientVO();//真正找到的病人实例的储存对象

        if (patientBO.findThePatient(tempPatient) != null){//判断是否为空
            if (patientBO.findThePatient(tempPatient).getJiaoFeiOrNot().equals(false)){//判断是否缴费
                patientVO = patientBO.findThePatient(tempPatient);

                //显示病人具体信息
                InfoNameText.setText(patientVO.getPatientName());
                InfoIDText.setText(patientVO.getIDNum());
                InfoAddressText.setText(patientVO.getAddress());
                GuahaofeiText.setText(patientVO.getNeedMoney());

                //在Table里显示所需缴费的内容
                DragVO dragVO = patientVO.getNeedDrag();
                dragVO.setDragName(dragVO.getDragName());
                dragVO.setDragPrice(dragVO.getDragPrice());
                dragVOObservableList.add(dragVO);
                InfoTable.setItems(dragVOObservableList);
            }
            else {
                //启动 已经缴费 的界面
                System.out.println("已经交费");

                try {

                    Parent root = FXMLLoader.load(getClass().getResource("../Controller/Yijingjiaofei.fxml"));
                    Scene scene = new Scene(root);
                    Stage primaryStageM = new Stage();
                    primaryStageM.setScene(scene);
                    primaryStageM.setTitle("NeuHIS System");
                    primaryStageM.show();


                }catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
        else {
            //启动 查无此人 的界面
            System.out.println("查无此人！");

            try {

                Parent root = FXMLLoader.load(getClass().getResource("../Controller/Chawuciren.fxml"));
                Scene scene = new Scene(root);
                Stage primaryStageM = new Stage();
                primaryStageM.setScene(scene);
                primaryStageM.setTitle("!");
                primaryStageM.show();


            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void OnJiaofeiMouseClicked() {//缴费的方法
        dragVOObservableList.remove(InfoTable.getSelectionModel().getSelectedIndex());//已缴费 移除需要缴费的内容

        PatientVO tempPatient = new PatientVO();//暂时的病人实例，用于储存病历号
        tempPatient.setBingLiNumber(InfoNumberText.getText());//将输入的病历号赋予新的暂时对象，然后去寻找此对象

        PatientBO patientBO = new PatientBO();

        PatientVO patientVO = new PatientVO();//真正找到的病人实例的储存对象

        if (patientBO.findThePatient(tempPatient) != null){
            patientVO = patientBO.findThePatient(tempPatient);

            patientVO.setNeedDrag(null);//将药品属性清空
            patientVO.setJiaoFeiOrNot(true);//设置为已缴费

            //覆盖写入新的信息
            patientBO.overWriteThePatient(patientVO);

            //启动 缴费成功 的界面
            try {

                Parent root = FXMLLoader.load(getClass().getResource("../Controller/Jiaofeichenggong.fxml"));
                Scene scene = new Scene(root);
                Stage primaryStageM = new Stage();
                primaryStageM.setScene(scene);
                primaryStageM.setTitle("!");
                primaryStageM.show();


            }catch (IOException e) {
                e.printStackTrace();
            }

        }




    }

    public void OnTuiHaoMouseClicked() {//进行患者退号的操作方法

        PatientVO tempPatient = new PatientVO();//暂时的病人实例，用于储存病历号
        tempPatient.setBingLiNumber(OutBingLiHaoText.getText());//将输入的病历号赋予新的暂时对象，然后去寻找此对象

        PatientBO patientBO = new PatientBO();

        PatientVO patientVO = new PatientVO();//真正找到的病人实例的储存对象

        if (patientBO.findThePatient(tempPatient) != null){

            try {
                patientVO = patientBO.findThePatient(tempPatient);

                patientBO.deleteThePatient(patientVO);

                OutNameText.setText("");
                OutIDText.setText("");
                OutAddressText.setText("");
                //启动 退号成功 的界面
                Parent root = FXMLLoader.load(getClass().getResource("../Controller/Tuihaochenggong.fxml"));
                Scene scene = new Scene(root);
                Stage primaryStageM = new Stage();
                primaryStageM.setScene(scene);
                primaryStageM.setTitle("!");
                primaryStageM.show();


            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("查无此人");
            //启动 查无此人 的界面
            try {

                Parent root = FXMLLoader.load(getClass().getResource("../Controller/Chawuciren.fxml"));
                Scene scene = new Scene(root);
                Stage primaryStageM = new Stage();
                primaryStageM.setScene(scene);
                primaryStageM.setTitle("!");
                primaryStageM.show();


            }catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    public void OnTuihaoSearchMouseClicked() {//在退号界面进行搜索病人信息的操作

        PatientVO tempPatient = new PatientVO();//暂时的病人实例，用于储存病历号
        tempPatient.setBingLiNumber(OutBingLiHaoText.getText());//将输入的病历号赋予新的暂时对象，然后去寻找此对象

        PatientBO patientBO = new PatientBO();

        PatientVO patientVO = new PatientVO();//真正找到的病人实例的储存对象

        if (patientBO.findThePatient(tempPatient) != null){
            patientVO = patientBO.findThePatient(tempPatient);

            //显示病人具体信息
            OutNameText.setText(patientVO.getPatientName());
            OutIDText.setText(patientVO.getIDNum());
            OutAddressText.setText(patientVO.getAddress());

        }
        else {
            System.out.println("查无此人");
            //启动 查无此人 的界面
            try {

                Parent root = FXMLLoader.load(getClass().getResource("../Controller/Chawuciren.fxml"));
                Scene scene = new Scene(root);
                Stage primaryStageM = new Stage();
                primaryStageM.setScene(scene);
                primaryStageM.setTitle("!");
                primaryStageM.show();


            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
