package easydeploy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.CommonUtils;

public class EasyDeploy extends Application {

    // @Override
    // public void start(Stage primaryStage) throws Exception {
    // Parent root = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));
    // Scene scene = new Scene(root, 300, 250);
    // primaryStage.setTitle("JavaFX 示例");
    // primaryStage.setScene(scene);
    // primaryStage.show();
    // }

    @Override
    public void start(Stage primaryStage) {
        // 创建 5 个文本框
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();
        TextField textField5 = new TextField();

        // 创建一个按钮
        Button button = new Button("点击我");

        // 为按钮添加点击事件处理
        button.setOnAction(event -> {
            btnAction(textField1.getText());
            btnAction(textField2.getText());
            btnAction(textField3.getText());
            btnAction(textField4.getText());
            btnAction(textField5.getText());
        });

        // 创建垂直布局容器
        VBox vbox = new VBox(10); // 设置间距为 10
        vbox.getChildren().addAll(textField1, textField2, textField3, textField4, textField5, button);

        // 创建场景并设置到舞台
        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setTitle("JavaFX 示例");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * button点击事件
     *
     * @param command 要执行的 PowerShell 命令
     */
    private static void btnAction(String cmd) {
        CommonUtils.executePSCommand(cmd);
    }

}