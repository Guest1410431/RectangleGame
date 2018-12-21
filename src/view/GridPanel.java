package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GridPanel extends JPanel
{
	private final int OFFSET = 10;
	
	private int boardWidth;
	private int boardHeight;
	
	public GridPanel(int boardWidth, int boardHeight)
	{
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int cellHeight = (getHeight()-OFFSET) / boardHeight;
		int cellWidth = (getWidth()-(4*OFFSET)) / boardWidth;
		
		g.setColor(Color.BLACK);
		
		for (int i = 0; i < getHeight(); i += cellHeight)
		{
			g.drawLine(i+OFFSET, 0+OFFSET, i+OFFSET, (boardWidth*cellWidth)+OFFSET);
		}
		for (int i = 0; i < getWidth(); i += cellWidth)
		{
			g.drawLine(0+OFFSET, i+OFFSET, (boardHeight*cellHeight)+OFFSET, i+OFFSET);
		}
	}
}
