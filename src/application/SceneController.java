package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class SceneController implements Initializable{

	@FXML
    private Pane pane1;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView email;

    @FXML
    private ImageView pass;

    @FXML
    private Pane pane2;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		rotateAnimation();
		translateAnimation(0.5,pane2,600);
	}

	private void rotateAnimation()
	{
		RotateTransition rotar = new RotateTransition(Duration.seconds(100),logo);
		rotar.setByAngle(360*80);//lo multiplicamos por 10 para que gire más rapido los 360 grados
		rotar.play();
	}

	int slideActual=1;

	@FXML
	public void nextAction()
	{
		if(slideActual==1)
		{
			translateAnimation(0.8, pane2, -600);
			slideActual++;
		}
	}

	@FXML
	public void backAction()
	{
		if(slideActual==2)
		{
			translateAnimation(0.5, pane2, 600);
			slideActual--;
		}
	}

	private void translateAnimation(double duracion, Node node, int distancia) {
		TranslateTransition translateTransition =new TranslateTransition(Duration.seconds(0.5),node);
		translateTransition.setByY(distancia);
        translateTransition.play();
	}

}
