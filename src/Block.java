import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {
	Pattern pattern;
	Direction direction;
	int baseX;
	int baseY = -2;
	Pane controlBlock;
	boolean isEngaged = false;
	boolean pos[][];

	public Block() {
		pattern = Pattern.randomPat();
//		pattern = Pattern.O;
		direction = Direction.randomDir();
//		if (pattern == Pattern.I && direction == Direction.LEFT && direction == Direction.RIGHT)
//			baseX = 3;
//		else if (pattern == Pattern.I && direction == Direction.UP && direction == Direction.DOWN)
//			baseX = 5;
//		else baseX = 4;
		baseX = 4;
	}

	public void drop(Color exist[][]) {
		while (!isContact(exist)) {
			baseY += 1;
		}
	}

// public void addExist(Color exist[][]) {
//		for (int i = 0; i < 4; i++) {
//			exist[x[i]][y[i]] = pattern.getColor();
//		}
//	}
	public boolean isContact(Color exist[][]) {// 如果任何一块的下面挡着现有的块，则视为接触
		if (baseY >= 17)
			return true;
		for (Node node : controlBlock.getChildren()) {
			Rectangle rec = (Rectangle)node;
//			System.out.println("y:"+rec.getY());
//			System.out.println("lay:"+rec.getLayoutY());
		}
		return false;
	}
//	public boolean isContact(Color exist[][]) {// 如果任何一块的下面挡着现有的块，则视为接触
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				if (pos[i][j]) {
//					if (baseY+1 > 0) {
//						if (exist[i+baseX][j+baseY+1] != null || baseY >= 17) {
//							for (int k = 0; k < 3; k++) {
//								for (int l = 0; l < 3; l++) {
//									if (pos[k][l]) {
//										exist[k+baseX][l+baseY] = pattern.getColor();
//									}
//								}
//							}
//						}
//						return true;
//					}
//				}
//			}
//		}
//		return false;
//	}

	public Color[][] executeClearance() {
		return null;
	}
	
	public Pane drawBlock(Color exist[][]) {
		pos = new boolean[3][3];
		switch (pattern) {
//		case I -> { pattern = Pattern.J; drawBlock(); break; }// I型暂不可用
		case O -> { pos = rotateO(); break; }
		case T -> { pos = rotateT(); break; }
		case L -> { pos = rotateL(); break; }
		case J -> { pos = rotateJ(); break; }
		case S -> { pos = rotateS(); break; }
		case Z -> { pos = rotateZ(); break; }
		}
		controlBlock = new Pane();
//		controlBlock.getChildren().clear();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (pos[i][j]) {
					Rectangle rec = new Rectangle((i+baseX)*TetrisFx_Main.WIDTH+2, (j+baseY)*TetrisFx_Main.WIDTH+2,
							TetrisFx_Main.WIDTH-4, TetrisFx_Main.WIDTH-4);
					rec.setFill(pattern.getColor());
					controlBlock.getChildren().add(rec);
//					if (baseY+1 > 0) {
//						if (exist[i+baseX][j+baseY+1] != null || baseY >= 17) {
//							isEngaged = true;
//							for (int k = 0; k < 3; k++) {
//								for (int l = 0; l < 3; l++) {
//									if (pos[k][l]) {
//										exist[k+baseX][l+baseY] = pattern.getColor();
//									}
//								}
//							}
//						}
//					}
//					rec.setTranslateX(0);
//					rec.setTranslateY((j+baseY)*Tetris.WIDTH);
//					recList.add(rec);
				}
			}
		}
		return controlBlock;
	}

	public boolean[][] rotateO() {
		Direction d[] = Direction.values();
		direction = d[(direction.num+1)%4];
		boolean pos[][] = new boolean[3][3];
		pos[1][1] = true;
		pos[1][2] = true;
		pos[2][1] = true;
		pos[2][2] = true;
		return pos;
	}

	public boolean[][] rotateT() {
		Direction d[] = Direction.values();
		direction = d[(direction.num+1)%4];
		boolean pos[][] = new boolean[3][3];
		switch (direction) {
		case UP -> { pos[0][1] = true; pos[1][1] = true; pos[2][1] = true; pos[1][2] = true; break; }// L
		case LEFT -> { pos[0][0] = true; pos[0][1] = true; pos[0][2] = true; pos[1][1] = true; break; }
		case DOWN -> { pos[1][1] = true; pos[0][2] = true; pos[1][2] = true; pos[2][2] = true; break; }
		case RIGHT -> { pos[1][0] = true; pos[1][1] = true; pos[1][2] = true; pos[0][1] = true; break; }
		}
		return pos;
	}

	public boolean[][] rotateL() {
		Direction d[] = Direction.values();
		direction = d[(direction.num+1)%4];
		boolean pos[][] = new boolean[3][3];
		switch (direction) {
		case UP -> { pos[0][0] = true; pos[0][1] = true; pos[0][2] = true; pos[1][2] = true; break; }
		case LEFT -> { pos[0][2] = true; pos[1][2] = true; pos[2][2] = true; pos[2][1] = true; break; }
		case DOWN -> { pos[0][0] = true; pos[1][0] = true; pos[1][1] = true; pos[1][2] = true; break; }
		case RIGHT -> { pos[0][1] = true; pos[1][1] = true; pos[2][1] = true; pos[0][2] = true; break; }
		}
		return pos;
	}

	public boolean[][] rotateJ() {
		Direction d[] = Direction.values();
		direction = d[(direction.num+1)%4];
		boolean pos[][] = new boolean[3][3];
		switch (direction) {
		case UP -> { pos[1][0] = true; pos[1][1] = true; pos[0][2] = true; pos[1][2] = true; break; }
		case LEFT -> { pos[0][1] = true; pos[1][1] = true; pos[2][2] = true; pos[2][1] = true; break; }
		case DOWN -> { pos[0][0] = true; pos[0][1] = true; pos[0][2] = true; pos[1][0] = true; break; }
		case RIGHT -> { pos[0][1] = true; pos[1][2] = true; pos[2][2] = true; pos[0][2] = true; break; }
		}
		return pos;
	}

	public boolean[][] rotateS() {
		Direction d[] = Direction.values();
		direction = d[(direction.num+1)%4];
		boolean pos[][] = new boolean[3][3];
		switch (direction) {
		case UP -> { pos[0][2] = true; pos[1][2] = true; pos[1][1] = true; pos[2][1] = true; break; }// S
		case LEFT -> { pos[0][0] = true; pos[0][1] = true; pos[1][1] = true; pos[1][2] = true; break; }
		case DOWN -> { pos[0][2] = true; pos[1][2] = true; pos[1][1] = true; pos[2][1] = true; break; }
		case RIGHT -> { pos[0][0] = true; pos[0][1] = true; pos[1][1] = true; pos[1][2] = true; break; }
		}
		return pos;
	}

	public boolean[][] rotateZ() {
		Direction d[] = Direction.values();
		direction = d[(direction.num+1)%4];
		boolean pos[][] = new boolean[3][3];
		switch (direction) {
		case UP -> { pos[0][1] = true; pos[1][1] = true; pos[1][2] = true; pos[2][2] = true; break; }// Z
		case LEFT -> { pos[0][1] = true; pos[0][2] = true; pos[1][0] = true; pos[1][1] = true; break; }
		case DOWN -> { pos[0][1] = true; pos[1][1] = true; pos[1][2] = true; pos[2][2] = true; break; }
		case RIGHT -> { pos[0][1] = true; pos[0][2] = true; pos[1][0] = true; pos[1][1] = true; break; }
		}
		return pos;
	}
}
