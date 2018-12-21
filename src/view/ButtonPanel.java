package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class ButtonPanel extends JPanel
{
	private boolean enabled;
	private DicePanel dicePanel;
	
	public ButtonPanel()
	{
		enabled = true;
		initListener();
	}
	public void setObserver(DicePanel dicePanel)
	{
		this.dicePanel = dicePanel;
	}
	
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}
	
	private void initListener()
	{
		this.addMouseListener(new MouseListener()
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
			
			public void mouseClicked(MouseEvent e)
			{
				if(enabled)
				{
					dicePanel.roll();
				}
			}
		});
	}
	protected void paintComponent(Graphics g)
	{
		g.setColor((enabled) ? Color.WHITE : Color.LIGHT_GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
		
		g.setFont(new Font("ARIAL", Font.BOLD, 24));
		g.drawString("Roll", 45, (int)(2*(getHeight()/3)));
	}
}
