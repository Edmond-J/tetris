import java.util.Random;

import javafx.scene.paint.Color;

public enum Pattern {
	I(Color.web("#16417C")), O(Color.web("#EB3324")), T(Color.web("#507F80")), L(Color.web("#F09B59")), J(Color.web("#741B7C")), S(Color.web("#EA3680")), Z(Color.web("#817F26"));

	private Color color;

	private Pattern(Color c) {
		color = c;
	}

	public Color getColor() {
		return color;
	}

	public static Pattern randomPat() {
		Random random = new Random();
		return values()[random.nextInt(7)];
	}
}
