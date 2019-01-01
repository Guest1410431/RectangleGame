package view;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DicePanel extends JPanel
{
	private final int DICE_SIZE = 75; 
	
	private DiePanel leftDiePanel;
	private DiePanel rightDiePanel;
	
	public DicePanel()
	{
		leftDiePanel = new DiePanel();
		leftDiePanel.setBackground(Color.WHITE);
		
		rightDiePanel = new DiePanel();
		rightDiePanel.setBackground(Color.WHITE);
		
		ButtonPanel rollButton = new ButtonPanel();
		rollButton.setObserver(this);
		rollButton.setBackground(Color.LIGHT_GRAY);
		
		GroupLayout gl_diePanel = new GroupLayout(this);
		gl_diePanel.setHorizontalGroup(
			gl_diePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_diePanel.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_diePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(rollButton, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
						.addGroup(gl_diePanel.createSequentialGroup()
							.addComponent(leftDiePanel, GroupLayout.PREFERRED_SIZE, DICE_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(rightDiePanel, GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_diePanel.setVerticalGroup(
			gl_diePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_diePanel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_diePanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(rightDiePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(leftDiePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, DICE_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rollButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(162, Short.MAX_VALUE))
		);
		this.setLayout(gl_diePanel);
	}

	public void roll()
	{
		leftDiePanel.roll();
		rightDiePanel.roll();
		
		repaint();
	}

	public int[] getDiceRoll()
	{
		return new int[] {leftDiePanel.getRoll(), rightDiePanel.getRoll()};
	}
}
