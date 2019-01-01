package model;

import java.awt.Color;
import java.awt.Graphics;

public class ValidRectangle extends Rectangle
{
	public ValidRectangle(Rectangle rectangle)
	{
		super(rectangle.getXPos(), rectangle.getYPos(), rectangle.getWidth(), rectangle.getHeight(), rectangle.getCellWidth(), rectangle.getCellHeight(), rectangle.getColor());
	}
	public ValidRectangle(int xPos, int yPos, int width, int height, int cellHeight, int cellWidth, Color color)
	{
		super(xPos, yPos, width, height, cellHeight, cellWidth, color);
	}
	
	public ValidRectangle(int xPos, int yPos, int width, int height, Color color)
	{
		super(xPos, yPos, width, height, color);
	}
	public void render(Graphics g)
	{
		g.setColor(getColor());
		
		for (int i = 0; i < getWidth(); i++)
		{
			for (int h = 0; h < getHeight(); h++)
			{
				g.fillRect((getXPos() + i) * getCellWidth(), (getYPos() + h) * getCellHeight(), getCellWidth(), getCellHeight());
			}
		}
	}
}
