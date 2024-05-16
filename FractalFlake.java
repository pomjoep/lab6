import java.awt.Color;
import java.awt.Graphics;

/**
 *  FractalFlake.java
 *  ===============
 * @author M Mustafa Narejo
 * @version 5/15/2024
 */
public class FractalFlake extends Shape {
    private final int limit;
    private final int numBranches;

    public FractalFlake(int x, int y, Color color, int size, int limit, int numBranches) {
        super(x, y, color);
        this.limit = limit;
        this.numBranches = numBranches;
    }

    @Override
    public void draw(Graphics g) {
        draw(g, getX(), getY(), limit);
    }

    public void draw(Graphics g, int startX, int startY, int limit) {
        // Your implementation for drawing the fractal snowflake here
        if (limit < 3){
            for(int i = 0; i < numBranches; i++ ){
                int x2 = startX + (int) (limit * Math.cos((2 * Math.PI / numBranches) * i));
                int y2 = startY - (int) (limit * Math.sin((2 * Math.PI / numBranches) * i));
                g.drawLine(startX, startY, x2, y2);
                draw(g, x2, y2, limit/3);
            }
        }

    }
}
