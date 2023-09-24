import java.util.Random;

public enum Direction {
	UP(0),
	LEFT(1),
	DOWN(2),
	RIGHT(3);
	int num;
	
	private Direction(int i){
		num=i;
	}
	public static Direction randomDir() {
		Random random = new Random();
		return values()[random.nextInt(4)];
	}
}
