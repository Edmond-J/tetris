import java.util.ArrayList;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {
	Pattern pattern;
	Direction direction;
//	int xc;
//	int yc;
	int baseX = 2;
	int baseY = 0;
//	boolean pos[][] = new boolean[3][3];
//	ArrayList<Rectangle> recList = new ArrayList<>();

	public Block() {
		pattern = Pattern.randomPat();
	}

	public Pane rotate() {
		return null;
	};

	public void drop(Color exist[][]) {
		while (!isContact(exist)) {
			baseY += 1;
		}
	}


//	public void addExist(Color exist[][]) {
//		for (int i = 0; i < 4; i++) {
//			exist[x[i]][y[i]] = pattern.getColor();
//		}
//	}

	public boolean isContact(Color exist[][]) {// 如果任何一块的下面挡着现有的块，则视为接触
		return false;
	}
}
