import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TetrisFx extends Application {
	final static int WIDTH = 40;
	Color exist[][] = new Color[10][20];
	Pane grid = new Pane();
	Block curBlock = new Block();
	Pane controlBlock;

	@Override
	public void start(Stage primaryStage) {
		try {
			drawGrid();
			Pane container = new Pane();
			controlBlock = curBlock.drawBlock();
			container.getChildren().addAll(grid, controlBlock);
			Scene scene = new Scene(container, 10*WIDTH, 20*WIDTH);
			KeyFrame frame = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent t) {
					if (!curBlock.isContact(exist)) {
						curBlock.baseY += 1;
						for (Node rec : controlBlock.getChildren()) {
							rec.setTranslateY(rec.getTranslateY()+WIDTH);
//						rec.setTranslateX(WIDTH*lt.baseX);
						}
					} else {
						exist = curBlock.executeClearance();
						curBlock = new Block();
						controlBlock = curBlock.drawBlock();
						container.getChildren().add(controlBlock);
					}
				}
			});
			scene.setOnKeyPressed(e -> {
				if (e.getCode() == KeyCode.LEFT) {
					curBlock.baseX -= 1;
					for (Node rec : controlBlock.getChildren()) {
						rec.setTranslateX(rec.getTranslateX()-WIDTH);
					}
				} else if (e.getCode() == KeyCode.DOWN) {
					if (!curBlock.isContact(exist)) {
						curBlock.baseY += 1;
						for (Node rec : controlBlock.getChildren()) {
							rec.setTranslateY(rec.getTranslateY()+WIDTH);
//						rec.setTranslateX(WIDTH*lt.baseX);
						}
					} else {
						exist = curBlock.executeClearance();
						curBlock = new Block();
						controlBlock = curBlock.drawBlock();
						container.getChildren().add(controlBlock);
					}
				} else if (e.getCode() == KeyCode.RIGHT) {
					curBlock.baseX += 1;
					for (Node rec : controlBlock.getChildren()) {
						rec.setTranslateX(rec.getTranslateX()+WIDTH);
					}
				} else if (e.getCode() == KeyCode.SPACE) {
//					lt.rotate();
					controlBlock.getChildren().clear();
					controlBlock.getChildren().add(curBlock.drawBlock());
					
//					for (Node rec : controlBlock.getChildren()) {
//						rec.setTranslateY(WIDTH*lt.baseY);
//						rec.setTranslateX(WIDTH*lt.baseX);
//					}
				}
			});
			Timeline timeline = new Timeline();
			timeline.setCycleCount(javafx.animation.Animation.INDEFINITE);
			timeline.getKeyFrames().add(frame);
			timeline.play();
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void drawGrid() {
		Rectangle edge = new Rectangle(0, 0, WIDTH*10, WIDTH*20);
		edge.setFill(null);  // Set fill to transparent
//		frame.setStroke(Color.BLACK);
		grid.getChildren().add(edge);
		for (int i = 0; i < 10; i++) {
			Line verticalLine = new Line(i*WIDTH, 0, i*WIDTH, WIDTH*20);
			verticalLine.setStroke(Color.LIGHTGRAY);
			grid.getChildren().add(verticalLine);
		}
		for (int i = 0; i < 20; i++) {
			Line horizonLine = new Line(0, i*WIDTH, WIDTH*10, i*WIDTH);
			horizonLine.setStroke(Color.LIGHTGRAY);
			grid.getChildren().add(horizonLine);
		}
		for (int j = 0; j < 20; j++) {
			for (int i = 0; i < 10; i++) {
				if (exist[i][j] != null) {
					Rectangle rec = new Rectangle(j*WIDTH-4, i*WIDTH-4, WIDTH-8, WIDTH-8);
					rec.setFill(exist[i][j]);
				}
			}
		}
	}

	public void executeClearance() {
	}

	public static void main(String[] args) {
		launch(args);
	}
}
