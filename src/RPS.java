import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class RPS extends JFrame{
	//create label for computerChoice and for result
	JLabel computerChoice,result;

	//create label for displaying score 
	JLabel computerScore,playerScore;
	int player_score = 0;
	int computer_score = 0;

	ImageIcon image_rock,image_paper,image_scissor;
	public void setup() {
		image_rock = new ImageIcon(new ImageIcon("D:\\users\\Desktop\\RPS game\\rock.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));		
		image_paper = new ImageIcon(new ImageIcon("D:\\users\\Desktop\\RPS game\\paper.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		image_scissor = new ImageIcon(new ImageIcon("D:\\users\\Desktop\\RPS game\\scissor.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));

		//create label
		JLabel score = new JLabel("Score");
		score.setForeground(Color.RED);	// set the color for the texts
		score.setBounds(500,0,100,100);

		computerScore = new JLabel();
		computerScore.setText("Computer score: 0");
		computerScore.setForeground(Color.RED);	// set the color for the texts
		computerScore.setBounds(500,15,200,100); 

		playerScore = new JLabel();
		playerScore.setText("Player score: 0");
		playerScore.setForeground(Color.RED);	// set the color for the texts
		playerScore.setBounds(500,30,200,100);


		computerChoice = new JLabel();
		computerChoice.setHorizontalTextPosition(JLabel.CENTER);
		computerChoice.setVerticalTextPosition(JLabel.BOTTOM);
		computerChoice.setBounds(250,90,100,100);

		result = new JLabel();
		result.setFont(new Font("Serif", Font.BOLD,20));
		result.setBounds(250,450,100,100);

		JLabel computerLabel = new JLabel();
		computerLabel.setText("Computer");
		computerLabel.setForeground(Color.BLACK);	// set the color for the texts
		computerLabel.setBounds(260,180,100,100);

		JLabel VSLabel = new JLabel();
		VSLabel.setText("VS");
		VSLabel.setForeground(Color.BLACK);	// set the color for the texts
		VSLabel.setBounds(280,200,100,100);

		JLabel playerLabel = new JLabel();
		playerLabel.setText("Player");
		playerLabel.setForeground(Color.BLACK);	// set the color for the texts
		playerLabel.setBounds(265,220,100,100);

		JLabel rockLabel = new JLabel();
		rockLabel.setText("Rock");
		rockLabel.setIcon(image_rock);
		rockLabel.setHorizontalTextPosition(JLabel.CENTER);
		rockLabel.setVerticalTextPosition(JLabel.BOTTOM);
		rockLabel.setBounds(150,300,100,100);

		JLabel paperLabel = new JLabel();
		paperLabel.setText("Paper");
		paperLabel.setIcon(image_paper);
		paperLabel.setHorizontalTextPosition(JLabel.CENTER);
		paperLabel.setVerticalTextPosition(JLabel.BOTTOM);
		paperLabel.setBounds(250,300,100,100);


		JLabel scissorLabel = new JLabel();
		scissorLabel.setText("Scissor");
		scissorLabel.setIcon(image_scissor);
		scissorLabel.setHorizontalTextPosition(JLabel.CENTER);
		scissorLabel.setVerticalTextPosition(JLabel.BOTTOM);
		scissorLabel.setBounds(350,300,100,100);


		//add Mouse Listener to labels
		rockLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//call calculate method
				calculate(rockLabel.getText());	
			}
		});

		paperLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//call calculate method
				calculate(paperLabel.getText());	
			}
		});

		scissorLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//call calculate method
				calculate(scissorLabel.getText());	
			}
		});


		//add component in frame
		add(rockLabel);
		add(paperLabel);
		add(scissorLabel);
		add(computerChoice);
		add(result);
		add(score);
		add(computerScore);
		add(playerScore);
		add(computerScore);
		add(computerLabel);
		add(VSLabel);
		add(playerLabel);
		setLayout(null);

	}


	public void calculate(String player) {
		String[] plays = {"Rock", "Paper", "Scissor"};
		int randomChoice = (int) ((Math.random()*10) %3);
		String computer = plays[randomChoice];
		
		//display computer choice for frame
		computerChoice.setText(computer);
		if(randomChoice == 0) {
			computerChoice.setIcon(image_rock);
		}else if (randomChoice == 1) {
			computerChoice.setIcon(image_paper);
		}else {
			computerChoice.setIcon(image_scissor);
		}
		

		//logic for game winner
		String res = "";
		// if its tie
		if(computer.equals("Rock") && player.equals("Rock")) {
			res  = "It's a Tie";
		}
		if(computer.equals("Paper") && player.equals("Paper")) {	
			res  = "It's a Tie";
		}
		if(computer.equals("Scissor") && player.equals("Scissor")) {
			res  = "It's a Tie";
		}
	
		//cases for the computer to win	
		if(computer.equals("Rock") && player.equals("Scissor")) {
			res  = "You lost!";
			computer_score++;			
		}
		if(computer.equals("Paper") && player.equals("Rock")) {
			res  = "You lost!";
			computer_score++;		
		}
		if(computer.equals("Scissor") && player.equals("Paper")) {
			res  = "You lost!";
			computer_score++;		
		}

		//cases for the user to win
		if(computer.equals("Paper") && player.equals("Scissor")) {
			res  = "You Won!";
			player_score++;			
		}
		if(computer.equals("Scissor") && player.equals("Rock")) {
			res  = "You Won!";
			player_score++;			
		}
		if(computer.equals("Rock") && player.equals("Paper")) {
			res  = "You Won!";
			player_score++;			
		}

		// update the scores
		result.setText(res);
		playerScore.setText("Player : " + player_score);
		computerScore.setText("Computer : " + computer_score);
	}
	
	public static void main(String[] args) {
		//create frame
		RPS game = new RPS();
		game.setTitle("RPS Game");
		game.setBounds(200,200,700,600);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.getContentPane().setBackground(Color.WHITE); 
		game.setup();	
		game.setResizable(false);
		game.setVisible(true);
	}

}