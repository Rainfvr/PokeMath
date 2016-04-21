

//Sidd Rao & Akhil Parvathaneni
//4/1/16
//PokeTest.java is the first testing iteration of Sidd and Akhil's PokeMath Game
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.event.*;

public class PokeTest extends JFrame {
	
	private PanelHolder pHolder;
	
	public static void main(String[] args) 
	{
	PokeTest pt = new PokeTest();
	}

public PokeTest() {
		
	super("PokeTest");
	// setLayout(new BorderLayouyt());
	setSize(1000, 800);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setLocation(400, 50);
	setResizable(true);

	pHolder = new PanelHolder();
	setContentPane(pHolder);	
	setVisible(true);
	// rp = new BottomPanel();
	// add( pHolder);
	// add( rp , BorderLayout.SOUTH);

	setVisible(true);
}

class PanelHolder extends JPanel { //  Panel holder (Holds all the Panels, for the Card Layout)(essentially) boolean dirPressed; 
	//make proper boolean variables for directions, start button, and the scores button, so it can can conduct the corresponding actions 
	boolean startPressed;
	 boolean hsPressed; 
	 String tempString; 
	 Image PokeMathLogo = Toolkit.getDefaultToolkit().getImage("D:\\Akhil\\workspace\\AkhilFirstJava\\src\\PokeMathlogo1.jpg");	//PokeLogo.JPG // D:\\Akhil\\workspace\\AkhilFirstJava\\src\\KJCEdpF.png //gets Image from my computer using the get DefaultToolKit 
	 Image PokeBack = Toolkit.getDefaultToolkit().getImage("D:\\Akhil\\workspace\\AkhilFirstJava\\src\\KJCEdpF.png");    //PokeBack1.JPG // g.drawImage(PokeMathLogo, 60,150,800,625,this);
	 

	public PanelHolder() {
			setLayout(new BorderLayout(10, 0)); //Use BorderLayout in main panel. Incorporate Card Layout for all the others 
			//Card Layout made( needs more pseudocode)
		setBackground(Color.WHITE);
		Font titleFont = new Font("Serif", Font.BOLD, 20); //Set Fonts
		setFont(titleFont);
		StartPanel bp = new StartPanel(); //Instantiate the Start Panel
		add(bp, BorderLayout.SOUTH);
}

public void paintComponent(Graphics g) { //graphics method header
	super.paintComponent(g); // draw Images first, draws background then Pokemath logo
	g.drawImage(PokeBack, 0,0,1000,800,this);
	g.drawImage(PokeMathLogo, 390,10,200,80, this);
	//System.out.println("Brodie this is a test");
	//g.drawImage(PokeBack, 0,0,600,400,this);
	if (startPressed) { //boolean for startPressed and hsPressed to trigger the corresponding CardLayout. For testing we'll just use a String
		g.drawString("you just pressed start bro", 100, 100);
		startPressed = false;
	}
	if (hsPressed) {
		g.drawString("you just pressed high scores bro", 100, 100);
		hsPressed = false;

	}

	}
}		// end class

class StartPanel extends JPanel { //Start Panel Header

	public StartPanel() { //Start Panel Constructor
		setLayout(new GridLayout(0, 2)); //Sets the layout as gridLayout for the bottom two buttons

		JButton start = new JButton("Start Game");
		JButtonHandlerS jbhs = new JButtonHandlerS();
		start.addActionListener(jbhs);
		add(start);

		JButton highScores = new JButton("High Scores");			//creates the buttons
		JButtonHandlerH jbhh = new JButtonHandlerH();
		highScores.addActionListener(jbhh);
		add(highScores);
	}
}

	class JButtonHandlerS implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	// pHolder.tempString = "you just pressed start bro"; //For Testing
		pHolder.startPressed = true; //Set the booleanc created in Panel Holder as true
		System.out.println("Start"); //testing part to see if program "sees" this
		pHolder.repaint();
	}
	}
	class JButtonHandlerH implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		// pHolder.tempString = "you just pressed the high scores button brodie"; //For testing
		pHolder.hsPressed = true;//Set the booleanc created in Panel Holder as true
		//System.out.println("High Scores"); // Test for output result
		pHolder.repaint();

	}
}

}
	


