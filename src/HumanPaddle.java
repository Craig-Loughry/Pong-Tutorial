import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle implements Paddle {
	double y, yVel;
	boolean upAcce1, downAcce1;
	int player, x;
	final double GRAVITY = .94;

	public HumanPaddle(int player) {
		upAcce1 = false;
		downAcce1 = false;
		y = 210;
		yVel = 0;
		if (player == 1)
			x = 20;
		else
			x = 660;
	}

	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, (int) y, 20, 80);

	}

	public void move() {
		if (upAcce1) {
			yVel -= 2; 
		} else if (downAcce1) {
			yVel += 2; 
		} else if (!upAcce1 && !downAcce1) {
			yVel *= GRAVITY; 
		}
			if(yVel >= 5)
				yVel = 5;
			else if(yVel <= -5)
				yVel = -5;
				
			y += yVel; 
			if (y < 0)
				y=0; 
			if (y > 420)
				y=420; 
	}

	public void setUpAcce1(boolean input) {
		upAcce1 = input;

	}

	public void setDownAcce1(boolean input) {
		downAcce1 = input;

	}

	public int getY() {
		return (int) y;
	}

}
