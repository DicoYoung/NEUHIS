package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 登录界面的启动程序
 *
 * @author dico
 */
public class LoginGuiMain extends Application {
    public static void main(String[] args) {
        Application.launch(LoginGuiMain.class, args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 加载布局信息配置文件
        Parent root = FXMLLoader.load(getClass().getResource("../Controller/LoginGUI.fxml"));
        // Scene 相当于一个画布，是场景中的根节点
        Scene scence = new Scene(root);
        // 加载控件

        // Stage就是窗口，primaryStage是程序启动后的主窗口，由框架传入

        // 将scence场景绑定到主窗口中
        primaryStage.setScene(scence);
        // 设置窗口名称
        primaryStage.setTitle("NeuHIS登录界面");
        // 显示窗口
        primaryStage.show();

    }
}

