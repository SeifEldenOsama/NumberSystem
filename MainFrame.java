package NumberSystem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainFrame extends Application{

	private Screen screen=Screen.getPrimary();
	private Rectangle2D bounds=screen.getVisualBounds();
	private double width=bounds.getWidth(),height=bounds.getHeight();
	private ImageView Background1,numberSystem;
	private Label NumberSystem,Dec,Bin,Oct,Hex;
	private TextField Input,DecInfo,BinInfo,OctInfo,HexInfo;
	private ComboBox<String> Choice;
	private Button Calc;
	private Alert A1=new Alert(Alert.AlertType.ERROR);
	@Override
	public void start(Stage stage) throws Exception {
		Group Root=new Group();
		Scene S1=new Scene(Root,width,height);
		stage.setScene(S1);
		stage.setTitle("نظام الاعداد");
		
		Background1=new ImageView(new Image(getClass().getResourceAsStream("number.jpg")));
		
		numberSystem=new ImageView(new Image(getClass().getResourceAsStream("numberSystem.png")));
		
		
		NumberSystem=new Label("نظام الاعداد");
		NumberSystem.setLayoutX(610);
		NumberSystem.setLayoutY(15);
		NumberSystem.setFont(new Font(60));
		NumberSystem.setBackground(Background.fill(Color.CRIMSON));
		NumberSystem.setGraphic(numberSystem);
		
		
		Input=new TextField();
		Input.setLayoutX(340);
		Input.setLayoutY(200);
		Input.setPrefSize(900,60);
		Input.setStyle("-fx-font-size: 40px;-fx-background-radius: 22px");
		Input.setPromptText("ادخل الرقم هنا");
		Input.setAlignment(Pos.TOP_CENTER);
		
		
		Choice=new ComboBox<>();
		Choice.setLayoutX(815);
		Choice.setLayoutY(320);
		Choice.setPrefSize(420,50);
		Choice.setStyle("-fx-font-size: 22px; -fx-background-radius: 22px;-fx-background-color: BURLYWOOD;");
		Choice.getItems().addAll("DECIMAL النظام العشري","BINARY النظام الثنائي","النظام الثماني OCTAL","النظام ال 16 HEX");
		Choice.setValue("DECIMAL النظام العشري");
		Choice.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
			S1.setCursor(Cursor.HAND);			
		});
		
		Choice.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			S1.setCursor(Cursor.DEFAULT);			
		});
	
		
		
		Calc=new Button("احسب");
		Calc.setLayoutX(340);
		Calc.setLayoutY(320);
		Calc.setPrefSize(450, 50);
		Calc.setStyle("-fx-font-size: 22px;-fx-background-radius: 22px;-fx-background-color: BURLYWOOD;");		
		Calc.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
			S1.setCursor(Cursor.HAND);			
		});
		
		Calc.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			S1.setCursor(Cursor.DEFAULT);			
		});
		
		
		Dec=new Label("النظام العشري");
		Dec.setLayoutX(100);
		Dec.setLayoutY(500);
		Dec.setFont(new Font(40));
		Dec.setBackground(Background.fill(Color.DARKGOLDENROD));
		
		DecInfo=new TextField();
		DecInfo.setLayoutX(370);
		DecInfo.setLayoutY(510);
		DecInfo.setPrefSize(300, 40);
		DecInfo.setEditable(false);
		DecInfo.setAlignment(Pos.TOP_CENTER);
		DecInfo.setStyle("-fx-background-radius: 18px; -fx-font-size: 16px");
		

		Bin=new Label("النظام الثنائي");
		Bin.setLayoutX(820);
		Bin.setLayoutY(500);
		Bin.setFont(new Font(40));
		Bin.setBackground(Background.fill(Color.DARKGOLDENROD));
		
		BinInfo=new TextField();
		BinInfo.setLayoutX(1090);
		BinInfo.setLayoutY(510);
		BinInfo.setPrefSize(300, 40);
		BinInfo.setEditable(false);
		BinInfo.setAlignment(Pos.TOP_CENTER);
		BinInfo.setStyle("-fx-background-radius: 18px; -fx-font-size: 16px");
		
		
		Oct=new Label("النظام الثماني");
		Oct.setLayoutX(100);
		Oct.setLayoutY(650);
		Oct.setFont(new Font(40));
		Oct.setBackground(Background.fill(Color.DARKGOLDENROD));
		
		OctInfo=new TextField();
		OctInfo.setLayoutX(370);
		OctInfo.setLayoutY(660);
		OctInfo.setPrefSize(300, 40);
		OctInfo.setEditable(false);
		OctInfo.setAlignment(Pos.TOP_CENTER);
		OctInfo.setStyle("-fx-background-radius: 18px; -fx-font-size: 16px");
		
		Hex=new Label("النظام ال 16");
		Hex.setLayoutX(820);
		Hex.setLayoutY(650);
		Hex.setPrefWidth(220);
		Hex.setFont(new Font(40));
		Hex.setBackground(Background.fill(Color.DARKGOLDENROD));
		
		HexInfo=new TextField();
		HexInfo.setLayoutX(1090);
		HexInfo.setLayoutY(660);
		HexInfo.setPrefSize(300, 40);
		HexInfo.setEditable(false);
		HexInfo.setAlignment(Pos.TOP_CENTER);
		HexInfo.setStyle("-fx-background-radius: 18px; -fx-font-size: 16px");
		
		
		Calc.setOnAction((ActionEvent E)->{
			try
			{
				if(Choice.getValue().equals("DECIMAL النظام العشري"))
				{
					int DecNum = Integer.parseInt(Input.getText());
                    String Bin = Integer.toBinaryString(DecNum);
                    String Oct = Integer.toOctalString(DecNum);
                    String Hex = Integer.toHexString(DecNum);
                    DecInfo.setText(String.valueOf(DecNum));
                    BinInfo.setText(Bin);
                    OctInfo.setText(Oct);
                    HexInfo.setText(Hex);
				}
				else if(Choice.getValue().equals("BINARY النظام الثنائي"))
				{
					String Binary = Input.getText();
                    int DecNum = Integer.parseInt(Binary, 2);
                    String Oct = Integer.toOctalString(DecNum);
                    String Hex = Integer.toHexString(DecNum);
                    DecInfo.setText(String.valueOf(DecNum));
                    BinInfo.setText(Binary);
                    OctInfo.setText(Oct);
                    HexInfo.setText(Hex);
				}
				else if(Choice.getValue().equals("النظام الثماني OCTAL"))
				{
					String Oct = Input.getText();
                    int DecNum = Integer.parseInt(Oct, 8);
                    String Bin = Integer.toBinaryString(DecNum);
                    String Hex = Integer.toHexString(DecNum);
                    DecInfo.setText(String.valueOf(DecNum));
                    BinInfo.setText(Bin);
                    OctInfo.setText(Oct);
                    HexInfo.setText(Hex);							
				}
				else if(Choice.getValue().equals("النظام ال 16 HEX"))
				{				
					String Hex = Input.getText();
                    int DecNum = Integer.parseInt(Hex, 16);
                    String Bin = Integer.toBinaryString(DecNum);
                    String Oct = Integer.toOctalString(DecNum);
                    DecInfo.setText(String.valueOf(DecNum));
                    BinInfo.setText(Bin);
                    OctInfo.setText(Oct);
                    HexInfo.setText(Hex);
				}
				
				
			}
			catch(Exception E1)
			{
				A1.setTitle("خطأ");
				A1.setContentText("حدث خطأ اثناء الادخال");
				A1.getDialogPane().setStyle("-fx-font-size: 15px");
				A1.show();
			}			
			
		});
		
		
		Root.getChildren().addAll(Background1,NumberSystem,Input,Choice,Calc,Dec,DecInfo,Bin,BinInfo,Oct,OctInfo,Hex,HexInfo);
		stage.show();
	}

}
