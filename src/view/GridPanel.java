package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import model.TestingRectangle;
import model.ValidRectangle;

public class GridPanel extends JPanel
{
	private final int NUM_PLAYERS = 2;
	private final int OFFSET = 0;
	
	private int boardWidth;
	private int boardHeight;
	
	private int cellWidth;
	private int cellHeight;
	// TODO: Grab this from somewhere...prolly window :/
	private int currentPlayer = 0;
	// Same TestingRectangle the ENTIRE time. Just change xPos, yPos, width,
	// height, color as it comes
	private TestingRectangle currentTestingRectangle;
	private HashMap<Integer, ArrayList<ValidRectangle>> validRectangles;
	
	private Window window;
	
	public GridPanel(int boardWidth, int boardHeight, Window window)
	{
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
		this.window = window;
		
		// TODO: Make this player dynamic
		validRectangles = new HashMap<Integer, ArrayList<ValidRectangle>>();
		for (int i = 0; i < NUM_PLAYERS; i++)
		{
			validRectangles.put(i, new ArrayList<ValidRectangle>());
		}
		initListeners();
	}
	// TODO: figure out how to grab the dimensions of the gridPanel cleanly before it gets displayed to the screen
	public void init()
	{
		System.out.println("Width : " + this.getMinimumSize().getWidth() + " | Height: " + this.getHeight());
		currentTestingRectangle = new TestingRectangle(0, 0, 0, 0, Color.BLACK);
		refreshCurrentTestingRectangle();
	}
	
	private void initListeners()
	{
		addMouseListener(new MouseListener()
		{
			public void mouseReleased(MouseEvent e)
			{
			}
			
			public void mousePressed(MouseEvent e)
			{
			}
			
			public void mouseExited(MouseEvent e)
			{
			}
			
			public void mouseEntered(MouseEvent e)
			{
			}
			
			// TODO: This
			public void mouseClicked(MouseEvent e)
			{
				// Left click
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					// If the current testing rectangle is valid
					if (currentTestingRectangle.isInBounds(boardWidth, boardHeight) && 
							!currentTestingRectangle.intersects() && 
							(currentTestingRectangle.touches() || validRectangles.get(currentPlayer).size() == 0))
					{
						ValidRectangle rect = new ValidRectangle(currentTestingRectangle);
						
						System.out.println(rect.toString() + "\n" + currentTestingRectangle.toString());
						
						validRectangles.get(currentPlayer).add(new ValidRectangle(currentTestingRectangle));
						System.out.println(validRectangles.get(currentPlayer).size());
						
						refreshCurrentTestingRectangle();
						
						repaint();
					}
				}
				// Right click
				if (e.getButton() == MouseEvent.BUTTON3)
				{
					currentTestingRectangle.rotate();
					testCurrentTestingRectangleValidity();
					repaint();
				}
			}
		});
		addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseMoved(MouseEvent e)
			{
				int xPos = e.getX() + OFFSET;
				int yPos = e.getY() + OFFSET;
				
				currentTestingRectangle.setXPos(xPos / cellWidth);
				currentTestingRectangle.setYPos(yPos / cellHeight);
				testCurrentTestingRectangleValidity();
				
				repaint();
			}
			
			public void mouseDragged(MouseEvent e)
			{
			}
		});
	}
	// TODO: Factor in current player
	private void testCurrentTestingRectangleValidity()
	{
		currentTestingRectangle.setIntersects(false);
		currentTestingRectangle.setTouches(false);
		
		for(int i=0; i<NUM_PLAYERS; i++)
		{
			ArrayList<ValidRectangle> validRectangleList = validRectangles.get(i);
			
			for(ValidRectangle validRectangle : validRectangleList)
			{
				if(currentTestingRectangle.intersects(validRectangle))
				{
					currentTestingRectangle.setIntersects(true);
				}
			}
		}
		ArrayList<ValidRectangle> validRectangleList = validRectangles.get(currentPlayer);
		
		for(ValidRectangle validRectangle : validRectangleList)
		{
			if(currentTestingRectangle.touches(validRectangle))
			{
				currentTestingRectangle.setTouches(true);
			}
		}
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		cellHeight = (getHeight() - (2 * OFFSET)) / boardHeight;
		cellWidth = (getWidth() - (2 * OFFSET)) / boardWidth;
		
		currentTestingRectangle.render(g);
		
		for (int i = 0; i < NUM_PLAYERS; i++)
		{
			for (ValidRectangle validRectangle : validRectangles.get(i))
			{
				validRectangle.render(g);
			}
		}
		
		g.setColor(Color.BLACK);
		
		for (int k = 0; k <= boardHeight; k++)
		{
			g.drawLine(OFFSET, (k * cellHeight) + OFFSET, (getWidth() - (2 * OFFSET)) + OFFSET, (k * cellHeight) + OFFSET);
		}
		for (int k = 0; k <= boardWidth; k++)
		{
			g.drawLine((k * cellWidth) + OFFSET, OFFSET, (k * cellWidth) + OFFSET, (getHeight() - (2 * OFFSET)) + OFFSET);
		}
	}

	private void refreshCurrentTestingRectangle()
	{		
		// TODO: Set color based on player
		// currentTestingRectangle.setColor(window.getCurrentPlayerColor());
		currentTestingRectangle.setWidth(window.getDiceRoll()[0]);
		currentTestingRectangle.setHeight(window.getDiceRoll()[1]);
		
		cellHeight = (getHeight() - (2 * OFFSET)) / boardHeight;
		cellWidth = (getWidth() - (2 * OFFSET)) / boardWidth;
		currentTestingRectangle.setCellWidth(cellWidth);
		currentTestingRectangle.setCellHeight(cellHeight);
	}
}
