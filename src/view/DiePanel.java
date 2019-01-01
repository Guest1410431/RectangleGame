package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DiePanel extends JPanel
{
	private final int DOT_SIZE = 10;
	
	private int roll;
	
	public DiePanel(int roll)
	{
		this.roll = roll;
	}
	
	public DiePanel()
	{
		roll = (int) (Math.random() * 6) + 1;
	}
	public int getRoll()
	{
		return roll;
	}
	
	public void roll()
	{
		roll = (int) (Math.random() * 6) + 1;
	}
	
	protected void paintComponent(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		
		if (roll == 1 || roll == 3 || roll == 5)
		{
			// Center dot
			g.fillOval((int) ((getWidth() / 2) - (DOT_SIZE / 2)), (int) ((getHeight() / 2) - (DOT_SIZE / 2)), DOT_SIZE, DOT_SIZE);
		}
		if (roll == 2 || roll == 3 || roll == 4 || roll == 5 || roll == 6)
		{
			// Top left, bottom right
			g.fillOval((int) ((getWidth() / 4) - (DOT_SIZE / 2)), (int) ((getHeight() / 4) - (DOT_SIZE / 2)), DOT_SIZE, DOT_SIZE);
			g.fillOval((int) ((3 * (getWidth() / 4)) - (DOT_SIZE / 2)), (int) ((3 * (getHeight() / 4)) - (DOT_SIZE / 2)), DOT_SIZE, DOT_SIZE);
		}
		if (roll == 4 || roll == 5 || roll == 6)
		{
			// Top right, bottom left
			g.fillOval((int) ((getWidth() / 4) - (DOT_SIZE / 2)), (int) ((3 * (getHeight() / 4)) - (DOT_SIZE / 2)), DOT_SIZE, DOT_SIZE);
			g.fillOval((int) ((3 * (getWidth() / 4)) - (DOT_SIZE / 2)), (int) ((getHeight() / 4) - (DOT_SIZE / 2)), DOT_SIZE, DOT_SIZE);
		}
		if (roll == 6)
		{
			// Middle left, middle right
			g.fillOval((int) ((getWidth() / 4) - (DOT_SIZE / 2)), (int) ((getHeight() / 2) - (DOT_SIZE / 2)), DOT_SIZE, DOT_SIZE);
			g.fillOval((int) ((3 * (getWidth() / 4)) - (DOT_SIZE / 2)), (int) ((getHeight() / 2) - (DOT_SIZE / 2)), DOT_SIZE, DOT_SIZE);
		}
	}
}
