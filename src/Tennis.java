import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Tennis extends Applet implements Runnable, KeyListener{
	final int WIDTH = 700, HEIGHT = 500;
	Thread thread;
	HumanPaddle p1; 
	Ball b1;
	AIPaddle p2;
	boolean gameStarted;
	
	
	public void init () {
		this.resize(WIDTH, HEIGHT);
		thread = new Thread(this);
		thread.start();
		
		this.addKeyListener(this);
		p1 = new HumanPaddle(1);
		p2 = new AIPaddle(2, b1); 
		b1 = new Ball();
		gameStarted = false; 
		
	
	}
	
	public void paint (Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if (b1.getX() < -10 || b1.getX() > 710) {
			g.setColor(Color.green);
			g.drawString("Game over", 350, 250);
		}
		else {
		
		p1.draw(g);
		b1.draw(g);
		p2.draw(g);
		}
	}
			
	public void update (Graphics g)	{
		paint (g); 
	}

	public void run() {
		for(;;) { 
			if (gameStarted) {
			p1.move();
			p2.move();
			b1.move();
			b1.checkPaddleCollision(p1, p2);
			}
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}
		
	}


	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAcce1(true);
		
		} 
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAcce1(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_ENTER)
			gameStarted = true;
	}

	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAcce1(false);
			
			
		} 
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAcce1(false);
		}
	}


	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
