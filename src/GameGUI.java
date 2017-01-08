import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

public class GameGUI extends JFrame {

	private JPanel menuPanel;
	private JPanel gamePanel;
	private JLabel welcomeLabel;
	private JLabel gameLabel;
	private JMenuItem newGame;
	private JMenuItem savedGame;
	private JLabel gameRules;
	private JLabel levelRules;
	private JLabel score;
	
	public static Game game;

	public GameGUI() throws SQLException{
		GameGUI.game = new Game();
		//game.playGame();
		menuPanel = new JPanel();
		gamePanel = new JPanel();
		welcomeLabel = new JLabel("Welcome to Shabbos Table");
		gameLabel = new JLabel("THE SHABBOS TABLE");
		newGame = new JMenuItem("Play New Game");
		savedGame = new JMenuItem("Open Saved Game (Feature not yet available)");
		gameRules = new JLabel(game.getGameRules());
		levelRules = new JLabel(game.getCurrentLevel().toString());
		score = new JLabel("Score: " + game.getScore());
		
		//setUpMenu();
		setUpGame();
		
		//createFrame(game);
		//contentPane.setVisible(true);
			}	
	
	public void setUpMenu()
	{
		setTitle("Shabbos Table Menu");
		
		menuPanel.setForeground(Color.DARK_GRAY);
		menuPanel.setBackground(new Color(255, 255, 153));
	    getContentPane().add(menuPanel, BorderLayout.CENTER);
	    menuPanel.setLayout(null);
			
		
	    welcomeLabel.setBounds(22, 13, 427, 24);
	    welcomeLabel.setForeground(Color.DARK_GRAY);
	    welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    welcomeLabel.setFont(new Font("Algerian", Font.PLAIN, 22));
	    menuPanel.add(welcomeLabel);
	    
	    setUpMenuItem(newGame);
	    newGame.setBounds(77, 50, 450, 30);
	  //  newGame.addActionListener(new AddListener(mySB));
		
	    setUpMenuItem(savedGame);
	    savedGame.setBounds(77, 85, 450, 30);
	 //   savedGame.addActionListener(new RemoveListener(mySB));
	
	    
	    setSize(1300,800);
	    this.setLocationRelativeTo(null);
	    setVisible(true);
	}
	
	public void setUpMenuItem(JMenuItem item)
	{
	    item.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, null, null, null));
	    item.setBackground(new Color(255, 255, 153));
	    item.setForeground(Color.DARK_GRAY);
	    item.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
	    menuPanel.add(item);
	}
	
	public void setUpGame()
	{
		setTitle("Game");
		
		gamePanel.setForeground(Color.DARK_GRAY);
		gamePanel.setBackground(new Color(255, 255, 153));
	    getContentPane().add(gamePanel, BorderLayout.CENTER);
	    gamePanel.setLayout(null);
	
		gameLabel.setBounds(420, 13, 427, 24);
	    gameLabel.setForeground(Color.DARK_GRAY);
	    gameLabel.setHorizontalAlignment(SwingConstants.LEFT);
	    gameLabel.setFont(new Font("Algerian", Font.PLAIN, 22));
	    gamePanel.add(gameLabel);
	    
	    gameRules.setBounds(22,33,500,180);
	    gameRules.setForeground(Color.DARK_GRAY);
	    gameRules.setHorizontalAlignment(SwingConstants.LEFT);
	    gameRules.setFont(new Font("Arial", Font.PLAIN, 18));
	    gamePanel.add(gameRules);
	    
	    levelRules.setBounds(22,220,500,100);
	    levelRules.setForeground(Color.DARK_GRAY);
	    levelRules.setHorizontalAlignment(SwingConstants.LEFT);
	    levelRules.setFont(new Font("Arial", Font.PLAIN, 18));
	    gamePanel.add(levelRules);
	    
	    score.setBounds(0,630,250,50);
	    score.setForeground(Color.DARK_GRAY);
	    score.setHorizontalAlignment(SwingConstants.LEFT);
	    score.setFont(new Font("Arial", Font.PLAIN, 18));
	    gamePanel.add(score);
	
	    //setUpPeople();
	    
	    setSize(1300,800);
	    this.setLocationRelativeTo(null);
	    setVisible(true);
	}
	
	private void setUpPeople()
	{
		int i = 1;
		ArrayList<JLabel> pLabels= new ArrayList<JLabel>();
		for(Person p : game.getCurrentLevel().getCurrentRound().getPuzzle().getPeople())
		{
			pLabels.add(createNewPersonLabel(p));
			
		}
		for(JLabel l : pLabels)
		{
			l.setBounds(100*i, 300, 100, 500);
		    l.setForeground(Color.DARK_GRAY);
		    l.setHorizontalAlignment(SwingConstants.LEFT);
		    l.setFont(new Font("Arial", Font.PLAIN, 18));
		    gamePanel.add(l);
		}
	}
	
	private JLabel createNewPersonLabel(Person p)
	{ 
		return new JLabel(p.toString());
	}
}

