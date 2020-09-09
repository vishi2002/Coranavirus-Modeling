import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SIRCorona extends JPanel {
	double beta = 0.2; //The coefficient between susceptibility and infection 
	double gamma = 5.0; //The coefficient between infection and removal 
	double dt = 0.01; //the size of the miniscule change in time (step size in Euler's Method)
	int N = 100; //The number of intervals (number of steps in Euler's method and the length of array)
	JTextField betafield;
	JTextField gammafield;
	public SIRCorona()
	{
	 betafield = new JTextField("Beta: ");
	 gammafield = new JTextField("Gamma: ");
		JButton Enter = new JButton("Enter");
		Enter.addActionListener(new ButtonListener());
		add(betafield);
		add(gammafield);
		add(Enter);
		
			
	}
	public int[] getplotS()
	{
		
		double[] S = new double[N + 1]; //An array of values for the people susceptible over time 
		double[] I = new double[N + 1]; //An array of values for the people infected over time
		double[] R = new double[N + 1]; //An array of values for the people removed over time (either cured or deceased)
		
		S[0] = 99.0; //Initially there are 99 people susceptible to get the disease 
		I[0] = 1.0; //Initially there is one person with the disease (flew in through China)
		R[0] = 0.0; //Initially there is no one recovered or dead
	
		
		for (int i = 0; i < N; i++) //Euler's Method 
		{
			S[i + 1] = S[i] + ((dSdt(beta, S[i], I[i])) * dt);
			I[i + 1] = I[i] + ((dIdt(beta, gamma, S[i], I[i])) * dt);
			R[i + 1] = R[i] + ((dRdt(gamma, I[i])) * dt);
		}
		
		int[] plotS = new int[N + 1];
		for (int i = 0; i < S.length; i++)
		{
			plotS[i] = (int) S[i];
		}
		
		
		return plotS;
	}
	
	public int[] getplotI()
	{
		
		double[] S = new double[N + 1]; //An array of values for the people susceptible over time 
		double[] I = new double[N + 1]; //An array of values for the people infected over time
		double[] R = new double[N + 1]; //An array of values for the people removed over time (either cured or deceased)
		
		S[0] = 99.0; //Initially there are 99 people susceptible to get the disease 
		I[0] = 1.0; //Initially there is one person with the disease (flew in through China)
		R[0] = 0.0; //Initially there is no one recovered or dead
		
		
		for (int i = 0; i < N; i++) //Euler's Method 
		{
			S[i + 1] = S[i] + ((dSdt(beta, S[i], I[i])) * dt);
			I[i + 1] = I[i] + ((dIdt(beta, gamma, S[i], I[i])) * dt);
			R[i + 1] = R[i] + ((dRdt(gamma, I[i])) * dt);
		}
		
		int[] plotI = new int[N + 1];
		for (int i = 0; i < I.length; i++)
		{
			plotI[i] = (int) I[i];
		}
		
		
		return plotI;
	}
	
	public int[] getplotR()
	{
		
		double[] S = new double[N + 1]; //An array of values for the people susceptible over time 
		double[] I = new double[N + 1]; //An array of values for the people infected over time
		double[] R = new double[N + 1]; //An array of values for the people removed over time (either cured or deceased)
		
		S[0] = 99.0; //Initially there are 99 people susceptible to get the disease 
		I[0] = 1.0; //Initially there is one person with the disease (flew in through China)
		R[0] = 0.0; //Initially there is no one recovered or dead
	
		
		for (int i = 0; i < N; i++) //Euler's Method 
		{
			S[i + 1] = S[i] + ((dSdt(beta, S[i], I[i])) * dt);
			I[i + 1] = I[i] + ((dIdt(beta, gamma, S[i], I[i])) * dt);
			R[i + 1] = R[i] + ((dRdt(gamma, I[i])) * dt);
		}
		
		int[] plotR = new int[N + 1];
		for (int i = 0; i < R.length; i++)
		{
			plotR[i] = (int) R[i];
		}
		
		
		return plotR;
	}
	
	private class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			beta = Double.parseDouble(betafield.getText());
			gamma = Double.parseDouble(gammafield.getText());
			repaint();
		}
		
	}
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		setBackground(Color.WHITE);
		g.setColor(Color.black);
		g.drawString("The SIR Model: Coronavirus", 600, 50);
		g.drawLine(150, 100, 150, 700);
		g.drawLine(150, 700, 1400, 700);
		g.drawString("Time", 650, 750);
		g.drawString("Number of People", 20, 350);
		g.setColor(Color.blue);
		int[] plotS = getplotS();
		for (int i = 0; i < plotS.length; i++)
		{
			g.fillOval((i * 12) + 150 , 700 - (plotS[i] * 6), 5, 5);
		}
		g.setColor(Color.red);
		int[] plotI = getplotI();
		for (int i = 0; i < plotI.length; i++)
		{
			g.fillOval((i * 12) + 150 , 700 - (plotI[i] * 6), 5, 5);
		}
		g.setColor(Color.green);
		int[] plotR = getplotR();
		for (int i = 0; i < plotI.length; i++)
		{
			g.fillOval((i * 12) + 150 , 700 - (plotR[i] * 6), 5, 5);
		}
		
		
	}
	
	public static double dSdt (double beta, double S, double I) //Rate of change of susceptibility 
	{
		return - 1.0 * beta * S * I;
	}
	
	public static double dIdt (double beta, double gamma, double S, double I) //Rate of change of susceptibility 
	{
		return (beta * S * I) - (gamma * I);
	}
	
	public static double dRdt (double gamma, double I) //Rate of removal
	{
		return gamma * I;
	}
	
	
}
