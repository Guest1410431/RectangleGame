package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//proof that I can type in document
//you cant see any of this? --

public class Window extends JFrame
{
	private final int WIDTH = 630;
	private final int HEIGHT = 450;

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
		contentPane = new JPanel();
		setContentPane(contentPane);

		initComponents();
		initListeners();
	}

	private void initComponents()
	{
		gridPanel = new GridPanel(27, 18);
		gridPanel.setBackground(Color.WHITE);
		player_1_panel = new PlayerPanel();
		player_1_panel.setBackground(Color.RED);
		player_2_panel = new PlayerPanel();
		player_2_panel.setBackground(Color.BLUE);
		dicePanel = new DicePanel();
		dicePanel.setBackground(Color.GREEN);

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
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
				{
					System.exit(0);
				}
			}
		});
	}
}
