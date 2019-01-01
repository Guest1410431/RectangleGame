package model;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Rectangle
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	
	private int cellHeight;
	private int cellWidth;
	
	private Color color;
	
	public Rectangle(int xPos, int yPos, int width, int height, int cellWidth, int cellHeight, Color color)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.cellHeight = cellHeight;
		this.cellWidth = cellWidth;
		this.color = color;
	}
	
	public Rectangle(int xPos, int yPos, int width, int height, Color color)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public void setXPos(int xPos)
	{
		this.xPos = xPos;
	}
	
	public void setYPos(int yPos)
	{
		this.yPos = yPos;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public void setColor(Color color)
	{
		this.color = color;
	}
	
	public int getXPos()
	{
		return xPos;
	}
	
	public int getYPos()
	{
		return yPos;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public int getCellHeight()
	{
		return cellHeight;
	}
	
	public void setCellHeight(int cellHeight)
	{
		this.cellHeight = cellHeight;
	}
	
	public int getCellWidth()
	{
		return cellWidth;
	}
	
	public void setCellWidth(int cellWidth)
	{
		this.cellWidth = cellWidth;
	}
	
	public void rotate()
	{
		int temp = height;
		height = width;
		width = temp;
	}
	
	// Returns true if the given rectangle intersects this rectangle, false
	// otherwise
	// Used to check if the TestingRectangle intersects any previously played
	// ValidRectangles
	public boolean intersects(Rectangle rectangle)
	{ // I know this is ugly, but it's better than actually implementing
		// rectangle intersetion detection
		java.awt.Rectangle r1 = new java.awt.Rectangle(this.xPos, this.yPos, this.width, this.height);
		java.awt.Rectangle r2 = new java.awt.Rectangle(rectangle.xPos, rectangle.yPos, rectangle.width, rectangle.height);
		return r1.intersects(r2);
	}
	
	// Returns true if the given rectangle touches, but does not intersect with
	// this rectangle, false otherwise
	// Used to test if any TestingRectangles touches the current player's
	// territory before it is place
	// TODO: THIS MAY NOT WORK, **UNTESTED**
	public boolean touches(Rectangle rectangle)
	{
		int yPos1 = this.yPos + this.height;
	    int yPos2 = rectangle.yPos+rectangle.height;
	    int xPos1 = this.xPos+this.width;
	    int xPos2 = rectangle.xPos+rectangle.width;
	    boolean topShared = (yPos1 == rectangle.yPos && rectangle.xPos == this.xPos);
	    boolean bottomShared = (yPos2 == rectangle.yPos && rectangle.xPos==this.xPos);
	    boolean rightShared = (xPos1 == rectangle.xPos && rectangle.yPos==this.yPos);
	    boolean leftShared = (xPos2 == this.xPos && rectangle.yPos==this.yPos);
	   
	    if (topShared || bottomShared || rightShared || leftShared) 
	    {
	        return true;
	    }
	    return false;
	}
	
	public String toString()
	{
		return "Rectangle [xPos=" + xPos + ", yPos=" + yPos + ", width=" + width + ", height=" + height + ", cellHeight=" + cellHeight + ", cellWidth=" + cellWidth + ", color=" + color + "]";
	}
	
	public abstract void render(Graphics g);
}
