import java.awt.*;

public class FractalFlake extends Shape{
	private final int limit = 25;
	private int branches = 10;

	public FractalFlake(int x, int y, Color color, int branches) {
		super(x, y, color);
		this.branches = branches;
	}
}
