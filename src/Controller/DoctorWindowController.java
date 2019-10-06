package Controller;

import BO.DragBO;
import BO.PatientBO;
import DAO.PatientDAO;
import VO.DragVO;
import VO.PatientVO;
import VO.UserVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 医生界面的controller类
 * @author dico
 *
 */

public class DoctorWindowController {
    //开药控件组
    public TabPane KaiyaoRightPane;
    public Tab KaiyaoTab;
    public AnchorPane KaiyaoMainPane;
    public Button QuerenKaiYaoButton;
    public Label PatienInfoLabel;
    public Label YaoPintableLabel;
    public Button KaiyaoButton;
    public AnchorPane DoctorWindow;
    public Pane TopPane1;
    public Label TopLabelText1;
    public SplitPane SplitPane1;
    public AnchorPane leftPane1;
    public Accordion DoctorZone;
    public TitledPane DoctorPane;
    public AnchorPane KaiyaoPane;
    public AnchorPane MainPane1;
    public Button ShowInfoButton;
    public ComboBox DocIDCombox;
    //开药控件组

    //病人表格控件组
    @FXML
    public TableView PatientInfoTable;//病人的table
    @FXML
    public TableColumn BLHColumn;//病历号Column
    @FXML
    public TableColumn PatientNameColumn;//病人姓名Column
    @FXML
    public TableColumn SexColumn;//性别Column
    @FXML
    public TableColumn OldColumn;//年龄Column

    //药品表格控件组
    @FXML
    public TableView YaoTable;//药品的Table
    @FXML
    public TableColumn DragNameColumn;//药品名字Column
    @FXML
    public TableColumn DragPriceColumn;//药品价格Column



    private ObservableList<PatientVO> patientVOObservableList = FXCollections.observableArrayList();//病人类OList
    private ObservableList<DragVO> dragVOObservableList = FXCollections.observableArrayList();//药品类List

    public void OnShowInfoMouseClicked(){//显示病人信息的按钮

        //包装药品类的属性，用于在Table里显示
        DragNameColumn.setCellValueFactory(new PropertyValueFactory("DragName"));
        DragPriceColumn.setCellValueFactory(new PropertyValueFactory("DragPrice"));

        //包装病人类的属性用于在TableView里显示
        BLHColumn.setCellValueFactory(new PropertyValueFactory("BingLiNumber"));
        PatientNameColumn.setCellValueFactory(new PropertyValueFactory("patientName"));
        SexColumn.setCellValueFactory(new PropertyValueFactory("sex"));
        OldColumn.setCellValueFactory(new PropertyValueFactory("old"));

        System.out.println(DocIDCombox.getValue().toString()+" ←");// just for text

        //寻找医生
        PatientBO patientBO = new PatientBO();
        UserVO tempUserVO =  new UserVO();//用于寻找目标医生的暂时用户
        tempUserVO.setID(DocIDCombox.getValue().toString());//将两边ID联动

        UserVO userVO = patientBO.returnDoc(tempUserVO);//根据ID找到对应的医生用户

        //寻找药品
        DragBO dragBO = new DragBO();

        //加载药品TableView
        ArrayList dragList = dragBO.whichDrag(userVO);//从药品列表找对应医生药房的药品列表
        if (dragList != null){//判断是否药品为空
            System.out.println("列表存在");
            for (int i = 0; i < dragList.size(); i++) {//循环加入药品
                DragVO dragVO = (DragVO) dragList.get(i);

                dragVO.setDragName(dragVO.getDragName());
                dragVO.setDragPrice(dragVO.getDragPrice());
                dragVOObservableList.add(dragVO);
                YaoTable.setItems(dragVOObservableList);

            }
        }
        else {
            System.out.println("没有");
            DragVO dragVO = new DragVO();
            dragVO.setDragName("没有药品");
            dragVO.setDragPrice(0.00);
        }

        //加载病人TableView
        ArrayList arrayList = patientBO.whichDoctor(userVO);//从病人列表里找到挂了指定医生号的病人列表
        if (arrayList.size() != 0){//判断是否这个医生有挂他号的病人，即读取病人数组判断是否为空
            for (int i = 0; i < arrayList.size(); i++) {//利用循环将病人信息加入到table里去
                PatientVO patientVO = (PatientVO) arrayList.get(i);
                patientVO.setBingLiNumber(patientVO.getBingLiNumber());
                patientVO.setPatientName(patientVO.getPatientName());
                patientVO.setSex(patientVO.getSex());
                patientVO.setOld(patientVO.getOld());
                patientVOObservableList.add(patientVO);
                PatientInfoTable.setItems(patientVOObservableList);
            }
        }
        else {//数组为空，即无人挂号时，给医生提示
            PatientVO patientVO = new PatientVO();
            patientVO.setBingLiNumber("无人挂号");
            patientVO.setPatientName("无人挂号");
            patientVO.setSex("无人挂号");
            patientVO.setOld("无人挂号");
            patientVOObservableList.add(patientVO);
            PatientInfoTable.setItems(patientVOObservableList);
        }

    }

    public void OnKaiyaoMouseCliked() {//显示开药主界面的方法
        KaiyaoRightPane.setVisible(true);//显示开药主界面

    }



    public void OnQuerenKaiyaoMouseClicked() {//确认开药按钮的方法
        //获取病人信息Table里选中的对象
        PatientVO tempPatient = patientVOObservableList.get(PatientInfoTable.getSelectionModel().getSelectedIndex());
        //获取药品信息Table里选中的对象
        DragVO tempDrag = dragVOObservableList.get(YaoTable.getSelectionModel().getSelectedIndex());

        //用获取の文件里的病人，将药的属性添加上
        tempPatient.setNeedDrag(tempDrag);
        //读取病人列表，将新的病人信息写入
        PatientBO patientBO = new PatientBO();
        patientBO.writeNewPatient(tempPatient);
        System.out.println("开药成功");

        //显示 开药成功 的界面
        try {

            Parent root = FXMLLoader.load(getClass().getResource("../Controller/KaiYaoChenggong.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStageM = new Stage();
            primaryStageM.setScene(scene);
            primaryStageM.setTitle("!");
            primaryStageM.show();


        }catch (IOException e) {
            e.printStackTrace();
        }


    }
    public DoctorWindowController(){

    }










}
