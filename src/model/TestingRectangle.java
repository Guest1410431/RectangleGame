package model;

import java.awt.Color;
import java.awt.Graphics;

public class TestingRectangle extends Rectangle
{
	private boolean inBounds;
	private boolean touches;
	private boolean intersects;
	
	public TestingRectangle(int xPos, int yPos, int width, int height, int cellHeight, int cellWidth, Color color)
	{
		super(xPos, yPos, width, height, cellHeight, cellWidth, color);
		inBounds = false;
		touches = true;
		intersects = true;
	}
	
	public TestingRectangle(int xPos, int yPos, int width, int height, Color color)
	{
		super(xPos, yPos, width, height, color);
		inBounds = false;
		touches = true;
		intersects = true;
	}
	
	// Returns true if this rectangle is within the bounds of the grid
	public boolean isInBounds(int gridWidth, int gridHeight)
	{
		inBounds = (getXPos() >= 0 && getYPos() >= 0 && getXPos() + getWidth() < gridWidth && getYPos() + getHeight() < gridHeight);
		return inBounds; 
	}

	public boolean touches()
	{
		return touches;
	}

	public boolean intersects()
	{
		return intersects;
	}

	public void setTouches(boolean touches)
	{
		this.touches = touches;
	}

	public void setIntersects(boolean intersects)
	{
		this.intersects = intersects;
	}
	// TODO: factor in grid offset
	public void render(Graphics g)
	{
		System.out.println("Intersects: " + intersects + " | Touches: " + touches);
		
		g.setColor((intersects || inBounds) ? Color.RED : (!touches) ? Color.GRAY : new Color(76, 247, 105));
		
		for (int i = 0; i < getWidth(); i++)
		{
			for (int h = 0; h < getHeight(); h++)
			{
				g.fillRect((getXPos() + i) * getCellWidth(), (getYPos() + h) * getCellHeight(), getCellWidth(), getCellHeight());
			}
		}
	}
}









