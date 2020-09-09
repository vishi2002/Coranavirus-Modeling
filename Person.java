import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Person 
{
     int x, y;
     int color;
     int direction;
     boolean moving = false;
     Timer timer;
     int TimeSinceInfection = 0;
     
     public Person(int X, int Y, int Color, int Direction, boolean Moving) {
           x = X;
           y = Y;
          color = Color;
          direction = Direction;
          moving = Moving;
          
         timer = new Timer(10, new RecoveryListener());
       
     }
     
    private class RecoveryListener implements ActionListener
    {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			TimeSinceInfection++;
		}
    	
    }
	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	
	public int getDirection()
	{
		return direction;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
		if (color == 2)
		{
			timer.start();
		}
	}
	
	public int getTime()
	{
		return TimeSinceInfection;
	}
     

}