import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class LType extends Block {
	boolean pos[][]=new boolean[3][3];
	public LType() {
		direction = Direction.randomDir();
		pattern=Pattern.L;
		rotate( );
	}
	public void show(Direction direction){
		
	}
	@Override
	public Pane rotate(){
		Direction d[]=Direction.values();
		direction=d[(direction.num+1)%4];
//		System.out.println((direction.num));
		pos=new boolean[3][3];
		switch (direction){
		case UP ->{pos[0][0]=true;pos[0][1]=true;pos[0][2]=true;pos[1][2]=true;break;}
		case LEFT ->{pos[0][2]=true;pos[1][2]=true;pos[2][2]=true;pos[2][1]=true;break;}
		case DOWN ->{pos[0][0]=true;pos[1][0]=true;pos[1][1]=true;pos[1][2]=true;break;}
		case RIGHT ->{pos[0][1]=true;pos[1][1]=true;pos[2][1]=true;pos[0][2]=true;break;}
		}
		Pane controlBlock = new Pane();
		controlBlock.getChildren().clear();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (pos[i][j]) {
					Rectangle rec = new Rectangle((i+baseX)*Tetris.WIDTH+2, (j+baseY)*Tetris.WIDTH+2, Tetris.WIDTH-4,
							Tetris.WIDTH-4);
					rec.setFill(pattern.getColor());
					rec.setTranslateX(TetrisFx.WIDTH*baseX);
					rec.setTranslateY(TetrisFx.WIDTH*baseY);
//					recList.add(rec);
					controlBlock.getChildren().add(rec);
				}
			}
		}
		return controlBlock;
	}
}
