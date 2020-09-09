//OriginalPanel
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CoronaPanel extends JPanel {
private Timer timer;
int x1;
int x2;
int y1;
int y2;
int direction;
boolean movement = false;
int patientmeter1 = 0;
int patientmeter2 = 0;
int patientzero1 = 0;
ArrayList<Person> Person1;
ArrayList<Person> Person2;
Color c;
	public CoronaPanel()
	{
		setBackground(Color.white);
		setPreferredSize(new Dimension(1000,1000));

		timer = new Timer(15, new CircleListener());
		timer.start();
		Person1 = new ArrayList<Person>();
		Person2 = new ArrayList<Person>();
		JButton Start = new JButton("Start");
		Start.addActionListener(new StartListener());
		add(Start);
		for (int i = 0; i < 200; i++) 
		{
			Random generator = new Random();
			x1 = generator.nextInt(450) + 30;
			y1 = generator.nextInt(650) + 40;
			x2 = generator.nextInt(450) + 530;
			y2 = generator.nextInt(650) + 40;
			direction = generator.nextInt(8) + 1;
			if (i < 25)
			{
				movement = true;
			}
			else
			movement = false;
			Person p1 = new Person(x1, y1, 1, direction, true);
			Person p2 = new Person(x2, y2, 1, direction, movement);
			Person1.add(p1);
			Person2.add(p2);
		}
	}
	
	public void move()
	{
		for (int i = 0; i < 200; i++) // for loop to set the original direction 
		{
			if (Person1.get(i).getDirection() == 1 && Person1.get(i).isMoving())
			{
				Person1.get(i).x += 1;
			}
			else if (Person1.get(i).getDirection() == 2 && Person1.get(i).isMoving())
			{
				Person1.get(i).y += 1;
			}
			else if (Person1.get(i).getDirection() == 3 && Person1.get(i).isMoving())
			{
				Person1.get(i).y += -1;
			}
			else if (Person1.get(i).getDirection() == 4 && Person1.get(i).isMoving())
			{
				Person1.get(i).x += -1;
			}
			else if (Person1.get(i).getDirection() == 5 && Person1.get(i).isMoving())
			{
				Person1.get(i).x += -1;
				Person1.get(i).y += -1;
			}
			else if (Person1.get(i).getDirection() == 6 && Person1.get(i).isMoving())
			{
				Person1.get(i).x += 1;
				Person1.get(i).y += 1;
			}
			else if (Person1.get(i).getDirection() == 7 && Person1.get(i).isMoving())
			{
				Person1.get(i).x += 1;
				Person1.get(i).y += -1;
			}
			else if (Person1.get(i).getDirection() == 8 && Person1.get(i).isMoving())
			{
				Person1.get(i).x += -1;
				Person1.get(i).y += 1;
			}
			
			if (Person2.get(i).getDirection() == 1 && Person2.get(i).isMoving())
			{
				Person2.get(i).x += 1;
			}
			else if (Person2.get(i).getDirection() == 2 && Person2.get(i).isMoving())
			{
				Person2.get(i).y += 1;
			}
			else if (Person2.get(i).getDirection() == 3 && Person2.get(i).isMoving())
			{
				Person2.get(i).y += -1;
			}
			else if (Person2.get(i).getDirection() == 4 && Person2.get(i).isMoving())
			{
				Person2.get(i).x += -1;
			}
			else if (Person2.get(i).getDirection() == 5 && Person2.get(i).isMoving())
			{
				Person2.get(i).x += -1;
				Person2.get(i).y += -1;
			}
			else if (Person2.get(i).getDirection() == 6 && Person2.get(i).isMoving())
			{
				Person2.get(i).x += 1;
				Person2.get(i).y += 1;
			}
			else if (Person2.get(i).getDirection() == 7 && Person2.get(i).isMoving())
			{
				Person2.get(i).x += 1;
				Person2.get(i).y += -1;
			}
			else if (Person2.get(i).getDirection() == 8 && Person2.get(i).isMoving())
			{
				Person2.get(i).x += -1;
				Person2.get(i).y += 1;
			}
		}
		
	}
	
	private class StartListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Random generator = new Random();
			patientzero1 = generator.nextInt(200);
			int patientzero2 = generator.nextInt(25);
			Person1.get(patientzero1).setColor(2);
			Person2.get(patientzero2).setColor(2);

			repaint();
		}
		
	}
	
	private class CircleListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			move();
			
			for (int i = 0; i < 200; i++)
			{
				if (Person1.get(i).getColor() == 2)
				{
					patientmeter1++;
				}
				
				if (Person2.get(i).getColor() == 2)
				{
					patientmeter2++;
				}
				
				
			}
			
			patientmeter1 = patientmeter1 / 20;
			patientmeter2 = patientmeter2 / 20;
			
			for (int i = 0; i < 200; i++) // for loop for border control
			{
				
				if (Person1.get(i).getColor() == 2 && patientmeter1 >= 9 && patientmeter1 <= 10)
	    		{
					Random generator = new Random();
					int deathchance = generator.nextInt(100);
	    			if (deathchance < (3 + (patientmeter1)))
	    			{
	    				Person1.get(i).setColor(3);
	    				Person1.get(i).setMoving(false);
	    			}
		
	    		}
				
				else if (Person1.get(i).getColor() == 2 && Person1.get(i).getTime() >= 1500)
	    		{
	    			Random generator = new Random();
	    			int recovery = generator.nextInt(100);
	    			if (recovery > (10 + (patientmeter1 * 2)))
	    			{
	    				Person1.get(i).setColor(4);
	    			}
	    		}
				
				if (Person2.get(i).getColor() == 2 && Person2.get(i).getTime() >= 1500)
	    		{
	    			Random generator = new Random();
	    			int recovery = generator.nextInt(100);
	    			if (recovery > (10 + (patientmeter1 * 2)))
	    			{
	    				Person2.get(i).setColor(4);
	    			}
	    		}
				
				if (Person1.get(i).x <= 0)
				{
					Person1.get(i).setDirection(1);
				}
				
				else if (Person1.get(i).x >= 490)
				{
					Person1.get(i).setDirection(4);
				}
				
				else if (Person1.get(i).y >= 690)
				{
					Person1.get(i).setDirection(3);
				}
				
				else if (Person1.get(i).y <= 50)
				{
					Person1.get(i).setDirection(2);
				}
				
				if (Person2.get(i).x <= 500)
				{
					Person2.get(i).setDirection(1);
				}
				
				else if (Person2.get(i).x >= 990)
				{
					Person2.get(i).setDirection(4);
				}
				
				else if (Person2.get(i).y >= 690)
				{
					Person2.get(i).setDirection(3);
				}
				
				else if (Person2.get(i).y <= 50)
				{
					Person2.get(i).setDirection(2);
				}
				
						

			}
			
			for(int i = 0; i < 200; i++) //nested for loop for collisions
			{
			    for(int j = 0; j < 200; j++)
			    {
			    	if (i == j)
			    	{
			    		continue;
			    	}
			    	if (Math.sqrt(Math.pow((Person1.get(i).x)-(Person1.get(j).x), 2)) + Math.pow((Person1.get(i).y) - (Person1.get(j).y), 2) <= 20)
			    	{
			    		Random generator = new Random();
			    		if(Person1.get(j).getColor() == 2 && Person1.get(i).getColor() == 1)
			    		{
			    			Person1.get(i).setColor(2);
			    			/*
			    			int deathchance = generator.nextInt(100);
			    			if (deathchance < (3 + patientmeter1) & Person1.get(i).getTime() > 500)
			    			{
			    				Person1.get(i).setColor(3);
			    				Person1.get(i).setMoving(false);
			    			}
			    			*/
			    		}
			    	
						int directionchange = generator.nextInt(8) + 1;
						while (directionchange == Person1.get(i).getDirection())
						{
						directionchange = generator.nextInt(8) + 1;
						}
						Person1.get(i).setDirection(directionchange);
			    	
			    	}
			    	if (Math.sqrt(Math.pow(((Person2.get(i).x)-(Person2.get(j).x)), 2)) + Math.pow(((Person2.get(i).y) - (Person2.get(j).y)), 2) <= 20)
			    	{
			    		
			    		Random generator = new Random();
						int directionchange = generator.nextInt(8) + 1;
						while (directionchange == Person2.get(i).getDirection())
						{
						directionchange = generator.nextInt(8) + 1;
						}
						Person2.get(i).setDirection(directionchange);
						
			    		if(Person2.get(j).getColor() == 2 && Person2.get(i).getColor() == 1)
			    		{
			    			Person2.get(i).setColor(2);
			    			int deathchance = generator.nextInt(100);
			    			if (deathchance < (3 + patientmeter2))
			    			{
			    				Person2.get(i).setColor(3);
			    				Person2.get(i).setMoving(false);
			    			}
			    		}
			    	}
			    	
			    
			    	
			    }
		
			}
			
		repaint();
		}
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawLine(500, 0, 500, 1000);
		g.drawLine(0, 700, 1000, 700);
		g.drawLine(0, 40, 1000, 40);
		Font x = new Font("HelveticaNeue-CondensedBlack", Font.PLAIN, 23);
		g.setFont(x);
		g.drawString("Coronavirus Spreading WITHOUT Social Distancing", 10, 30);
		g.drawString("Coronavirus Spreading WITH Social Distancing", 510, 30);
		Font y = new Font("HelveticaNeue-CondensedBlack", Font.PLAIN, 12);
		g.setFont(y);
		g.drawString("Hospital Patient Meter", 10, 720);
		g.drawString("Hospital Patient Meter", 510, 720);
		g.drawRect(10, 730, 400, 60);
		g.drawRect(510, 730, 400, 60);
		g.fillRect(10, 730, 40 * patientmeter1, 60);
		g.fillRect(510, 730, 40 * patientmeter2, 60);
		for (int i = 0; i <= 10; i++)
		{
			g.drawString("" + i, (40 * i) + 10, 800);
			g.drawString("" + i, (40 * i) + 510, 800);
		}
		
		
		for (int i = 0; i < 200; i++)
		{
			if (Person1.get(i).getColor() == 1)
			{
				c= Color.green;
			}
			
			if (Person1.get(i).getColor() == 2)
			{
				
				c= Color.RED;
			}
			if (Person1.get(i).getColor() == 3)
			{
				c = Color.black;
			}
			if (Person1.get(i).getColor() == 4)
			{
				c = Color.cyan;
			}
			g.setColor(c);
			g.fillOval(Person1.get(i).x, Person1.get(i).y, 10, 10);
			
			if (Person2.get(i).getColor() == 1)
			{
				c= Color.green;
			}
			if (Person2.get(i).getColor() == 2)
			{
				c= Color.RED;
			}
			if (Person2.get(i).getColor() == 3)
			{
				c = Color.black;
			}
			if (Person2.get(i).getColor() == 4)
			{
				c = Color.cyan;
			}
			g.setColor(c);
			g.fillOval(Person2.get(i).x, Person2.get(i).y, 10, 10);
		}
	}
	
}


