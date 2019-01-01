package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame
{
	private final int WIDTH = 630;
	private final int HEIGHT = 450;
	private final int GRID_HEIGHT = 12;
	private final int GRID_WIDTH = 10;
	
	private JPanel contentPane;
	
	// TODO: Change these to specific panels (GridPanel, PlayerPanel, DiePanel)
	private GridPanel gridPanel;
	private PlayerPanel player_1_panel;
	private PlayerPanel player_2_panel;
	private DicePanel dicePanel;
	
	public Window()
	{
		setTitle("Rectangle Game Thingy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		initComponents();
		initListeners();
		System.out.println("GridPanel: " + gridPanel.getWidth() + ", " + gridPanel.getHeight());
	}
	
	private void initComponents()
	{
		player_1_panel = new PlayerPanel();
		player_1_panel.setBackground(Color.RED);
		player_2_panel = new PlayerPanel();
		player_2_panel.setBackground(Color.BLUE);
		dicePanel = new DicePanel();
		dicePanel.setBackground(Color.GREEN);
		gridPanel = new GridPanel(GRID_WIDTH, GRID_HEIGHT, this);
		gridPanel.setBackground(Color.WHITE);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(gridPanel, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(dicePanel, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
								.addComponent(player_1_panel, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE).addComponent(player_2_panel, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(gridPanel, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(player_1_panel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(dicePanel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(player_2_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap(153, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	
		gridPanel.init();
	}
	
	private void initListeners()
	{
		this.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent e)
			{
			}
			
			public void keyReleased(KeyEvent e)
			{
			}
			
			public void keyPressed(KeyEvent e)
			{
				System.out.println("GridPanel: " + gridPanel.getWidth() + ", " + gridPanel.getHeight());
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
				{
					System.exit(0);
				}
			}
		});
	}

	public int[] getDiceRoll()
	{
		return dicePanel.getDiceRoll();
	}
}
