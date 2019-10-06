package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * 主界面的启动类，用于测试
 *
 * @author dico
 */
public class MainWindowMain extends Application {
    public static void main(String[] args) {
        Application.launch(MainWindowMain.class, args);

    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        // 加载布局信息配置文件
        Parent root = FXMLLoader.load(getClass().getResource("../Controller/MainWindow.fxml"));
        // Scene 相当于一个画布，是场景中的根节点
        Scene scence = new Scene(root);
        // 加载控件
        // initView(root);
        // Stage就是窗口，primaryStage是程序启动后的主窗口，由框架传入

        // 将scence场景绑定到主窗口中
        primaryStage.setScene(scence);
        // 设置窗口名称
        primaryStage.setTitle("NeuHIS System");
        // 显示窗口
        primaryStage.show();

    }
}
