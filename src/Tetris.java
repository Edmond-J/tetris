import java.awt.Color;

import ecs100.UI;

public class Tetris {
	final static int WIDTH = 40;
	Color exist[][]=new Color[10][20];
	Block block;
	LType lt=new LType();

	public Tetris() {
		initialize();
		
	}

	private void initialize() {
		refresh();
	}

	private void refresh() {
		UI.clearGraphics();
		UI.drawRect(0, 0, WIDTH*10, WIDTH*20);
		UI.setColor(Color.lightGray);
		for (int i = 0; i < 10; i++) {
			UI.drawLine(i*WIDTH, 0, i*WIDTH, WIDTH*20);
		}
		for (int i = 0; i < 20; i++) {
			UI.drawLine(0, i*WIDTH, WIDTH*10, i*WIDTH);
		}
		for (int j = 0; j < 20; j++) {
			for (int i = 0; i < 10; i++) {
				if (exist[i][j] != null) {
					UI.setColor(exist[i][j]);
					UI.fillRect(j*WIDTH-4, i*WIDTH-4, WIDTH-8, WIDTH-8);
				}
			}
		}
	}

//	private void loop() {
//		
//		if (block.isContact(exist)) {
//			if(checkReachTop()){
//				UI.print("Game Over");
//			}
//			block.addExist(exist);
//			checkClearance();
//			//生成一个新的block
//		}
//	}




	private void checkClearance() {
		for (int i = 19; i > 0; i--) {
			for (int j = 0; j < 10; j++) {
				if (exist[j][i] == null)
					break;
				if (j == 9) {
					for (int k = 0; k < 10; k++) {
						exist[k][i] = null;
					}
				}
			}
		}
		//清除完之后要把上面的方块往下面挪。
	}

	private boolean checkReachTop() {
		for(int i=0;i<10;i++){
			if(exist[i][0]!=null)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		new Tetris();
	}
}
