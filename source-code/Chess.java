//Name: Dhir Patel
//Date: December 14, 2018
//Purpose: Harry Potter Themed Chess Game

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
import java.util.*;
import java.text.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.border.*; 

public class Chess extends Applet implements ActionListener
{

	JLabel turnpic;
	JTextArea TAB;
	JTextArea TAW;
	char turn ='w';
	int last = -1;
	Panel p_card;  //to hold all of the screens
	Panel card1, card2, card3, card4, card5; //the two screens
	CardLayout cdLayout = new CardLayout ();
	//grid
	int row = 8;
	int col = 8;
	JButton a[] = new JButton [row * col];

	char bg[] [] = {	
			{'w','b','w','b','w','b','w','b',}, 
			{'b','w','b','w','b','w','b','w',}, 
			{'w','b','w','b','w','b','w','b',}, 
			{'b','w','b','w','b','w','b','w',}, 
			{'w','b','w','b','w','b','w','b',}, 
			{'b','w','b','w','b','w','b','w',}, 
			{'w','b','w','b','w','b','w','b',}, 
			{'b','w','b','w','b','w','b','w',}};

	char pcs [] [] = {	
			{'r','n','b','q','k','b','n','r'},
			{'p','p','p','p','p','p','p','p'},
			{'x','x','x','x','x','x','x','x'},
			{'x','x','x','x','x','x','x','x'},
			{'x','x','x','x','x','x','x','x'},
			{'x','x','x','x','x','x','x','x'},
			{'p','p','p','p','p','p','p','p'},
			{'r','n','b','q','k','b','n','r'}};

	char fg [] [] = {	
			{'b','b','b','b','b','b','b','b'},
			{'b','b','b','b','b','b','b','b'},
			{'x','x','x','x','x','x','x','x'},
			{'x','x','x','x','x','x','x','x'},
			{'x','x','x','x','x','x','x','x'},
			{'x','x','x','x','x','x','x','x'},
			{'w','w','w','w','w','w','w','w'},
			{'w','w','w','w','w','w','w','w'}};

	char sel [] [] = {	
			{'u','u','u','u','u','u','u','u'},
			{'u','u','u','u','u','u','u','u'},
			{'u','u','u','u','u','u','u','u'},
			{'u','u','u','u','u','u','u','u'},
			{'u','u','u','u','u','u','u','u'},
			{'u','u','u','u','u','u','u','u'},
			{'u','u','u','u','u','u','u','u'},
			{'u','u','u','u','u','u','u','u'}};
	// A copy of the bg array for the reset button.
	char bg2 [] [] = {	
			{'w','b','w','b','w','b','w','b',}, 
			{'b','w','b','w','b','w','b','w',}, 
			{'w','b','w','b','w','b','w','b',}, 
			{'b','w','b','w','b','w','b','w',}, 
			{'w','b','w','b','w','b','w','b',}, 
			{'b','w','b','w','b','w','b','w',}, 
			{'w','b','w','b','w','b','w','b',}, 
			{'b','w','b','w','b','w','b','w',}};
	// A copy of the pcs array for the reset button.
	char pcs2 [] [] = {	
			{'r','n','b','q','k','b','n','r'},
			{'p','p','p','p','p','p','p','p'},
			{'x','x','x','x','x','x','x','x'},
			{'x','x','x','x','x','x','x','x'},
			{'x','x','x','x','x','x','x','x'},
			{'x','x','x','x','x','x','x','x'},
			{'p','p','p','p','p','p','p','p'},
			{'r','n','b','q','k','b','n','r'}};
	// A copy of the fg array for the reset button.
	char fg2 [] [] = {	
			{'b','b','b','b','b','b','b','b'},
			{'b','b','b','b','b','b','b','b'},
			{'x','x','x','x','x','x','x','x'},
			{'x','x','x','x','x','x','x','x'},
			{'x','x','x','x','x','x','x','x'},
			{'x','x','x','x','x','x','x','x'},
			{'w','w','w','w','w','w','w','w'},
			{'w','w','w','w','w','w','w','w'}};
	// A copy of the sel array for the reset button.
	char sel2 [] [] = {	
			{'u','u','u','u','u','u','u','u'},
			{'u','u','u','u','u','u','u','u'},
			{'u','u','u','u','u','u','u','u'},
			{'u','u','u','u','u','u','u','u'},
			{'u','u','u','u','u','u','u','u'},
			{'u','u','u','u','u','u','u','u'},
			{'u','u','u','u','u','u','u','u'},
			{'u','u','u','u','u','u','u','u'}};

	public void init ()
	{
		p_card = new Panel ();
		p_card.setLayout (cdLayout);
		//	screen1 ();
		//	screen2 ();
		screen3 ();
		screen4 ();
		screen5 ();
		resize (700, 680);
		//		resize (496, 550);
		setLayout (new BorderLayout ());
		add ("Center", p_card);
	}
	public void screen1 ()
	{ //screen 1 is set up.
		card1 = new Panel ();
		card1.setBackground (Color.white);
		JLabel title = new JLabel ("Welcome");
		JButton next = new JButton ("Next");
		next.setActionCommand ("s2");
		next.addActionListener (this);
		card1.add (title);
		card1.add (next);
		p_card.add ("1", card1);
	}


	public void screen2 ()
	{ //screen 2 is set up.
		card2 = new Panel ();
		card2.setBackground (Color.orange);
		JLabel title = new JLabel ("Instructions");
		JButton next = new JButton ("Next");
		next.setActionCommand ("s3");
		next.addActionListener (this);
		card2.add (title);
		card2.add (next);
		p_card.add ("2", card2);
	}

	public void screen3 ()
	{ //screen 3 is set up.
		card3 = new Panel ();
		//		(250,236,139)
		card3.setBackground (new Color (188,143,143));
		JLabel title = new JLabel ("CHESS");
		turnpic = new JLabel (createImageIcon ("GTurn.png"));
		JButton reset = new JButton ("Reset");
		reset.setActionCommand("reset");
		reset.addActionListener(this);
		JButton instructions = new JButton ("Instructions");
		instructions.setActionCommand("s2");
		instructions.addActionListener(this);
		JLabel SubHeading1 = new JLabel ("Black Moves");
		SubHeading1.setFont (new Font ("Arial", Font.BOLD, 12));
		JLabel SubHeading2 = new JLabel ("White Moves");
		SubHeading2.setFont (new Font ("Arial", Font.BOLD, 12));
		JLabel turn1 = new JLabel ("Player's Turn");
		turn1.setFont (new Font ("Arial", Font.BOLD, 12));
		JButton save = new JButton("Save");
		save.addActionListener(this);
		save.setActionCommand("save");
		JButton open = new JButton("Open");
		open.addActionListener(this);
		open.setActionCommand("open");
		JButton surrender = new JButton ("surrender");
		surrender.addActionListener(this);
		surrender.setActionCommand("surrender");
		JButton movement = new JButton ("Movement");
		movement.addActionListener(this);
		movement.setActionCommand ("movement");
		JLabel info = new JLabel ("Move Info");
		JLabel pic1 = new JLabel (createImageIcon("WMoves.png"));
		JLabel pic2 = new JLabel (createImageIcon("BMoves.png"));
		TAB = new JTextArea (15,7);
		TAB.setEditable(false);
		TAB.setBorder(BorderFactory.createLineBorder(new Color(120,48,49),3));
		TAB.setBackground(new Color (245,222,179));
		JScrollPane ScrollP1 = new JScrollPane(TAB, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		TAW = new JTextArea (15,7);
		TAW.setEditable(false);
		TAW.setBorder(BorderFactory.createLineBorder(new Color(120,48,49),3));
		TAW.setBackground(new Color (245,222,179));
		JScrollPane ScrollP2 = new JScrollPane(TAW, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//Set up grid
		//		Ask Mrs.Gorski i I can turn a panel into a JPanel and make a border around the grid.
		JPanel p = new JPanel (new GridLayout (row, col));
		p.setBorder(BorderFactory.createLineBorder(new Color(120,48,49),5));
		int move = 0;
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{ //take out when you've got pictures
				a [move] = new JButton ("");
				//add in when you have pictures
				a [move] = new JButton (createImageIcon (fg [i] [j] + ""+pcs [i] [j] + ""+bg [i] [j] +  "u.png"));
				a [move].setPreferredSize (new Dimension (60, 60));
				a [move].addActionListener (this);
				a [move].setActionCommand ("" + move);
				if(bg[i][j]=='b')
					a[move].setBackground(new Color(180,136,99));
				else
					a[move].setBackground(new Color(240,218,181));
				p.add (a [move]);
				move++;
			}
		}
		
/*		Panel border = new Panel (new BorderLayout());
		border.add("Center",p);
		border.add("North",title);
		border.add("West",ScrollP1);
		border.add("East",ScrollP2); */
		
		Panel flow3 = new Panel ();
		flow3.add(pic1);
		flow3.add(pic2);
		
		Panel flow2 = new Panel ();
		flow2.add(ScrollP1);
		flow2.add(p);
		flow2.add(ScrollP2);
		
		Panel flow1 = new Panel ();
		flow1.add(turn1);
		flow1.add(turnpic);
		flow1.add(surrender);
		flow1.add(reset);
		flow1.add(info);
		
		Panel flow = new Panel ();
		flow.add(save);
		flow.add(movement);
		flow.add(open);
		flow.add(instructions);
		
//		card3.add (title);
		card3.add (SubHeading1);
//		card3.add(ScrollP1);
//		card3.add (p);
		card3.add(SubHeading2);
//		card3.add (ScrollP2);
//		card3.add(turn1);
//		card3.add (turnpic);
//		card3.add(surrender);
//		card3.add(reset);
//		card3.add (save);
//		card3.add (movement);
//		card3.add(open);
//		card3.add (instructions);
//		card3.add (info);
//		card3.add(border);
		card3.add(flow3);
		card3.add(flow2);
		card3.add(flow);
		card3.add(flow1);
		p_card.add ("3", card3);
	}
	public void screen4 ()
	{ //screen 4 is set up.
		card4 = new Panel ();
		card4.setBackground (Color.yellow);
		JLabel title = new JLabel ("You Win!");
		JButton next = new JButton ("Next");
		next.setActionCommand ("s5");
		next.addActionListener (this);
		card4.add (title);
		card4.add (next);
		p_card.add ("4", card4);
	}


	public void screen5 ()
	{ //screen 5 is set up.
		card5 = new Panel ();
		card5.setBackground (Color.cyan);
		JLabel title = new JLabel ("You Lose.");
		JButton next = new JButton ("Back to Introduction?");
		next.setActionCommand ("s1");
		next.addActionListener (this);
		JButton end = new JButton ("Quit?");
		end.setActionCommand ("s6");
		end.addActionListener (this);
		card5.add (title);
		card5.add (next);
		card5.add (end);
		p_card.add ("5", card5);
	}


	protected static ImageIcon createImageIcon (String path)
	{ //change the red to your class name
		java.net.URL imgURL = Chess.class.getResource (path);
		if (imgURL != null)
		{
			return new ImageIcon (imgURL);
		}
		else
		{
			System.err.println ("Couldn't find file: " + path);
			return null;
		}
	}
	public void redraw ()
	{
		int move = 0;
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{
				if(bg[i][j]=='b' && sel[i][j]=='u')
					a[move].setBackground(new Color(180,136,99));
				else if(sel[i][j]=='u')
					a[move].setBackground(new Color(240,218,181));
				else //selected 
					a[move].setBackground(new Color(240,50,50));
				a [move].setIcon (createImageIcon (fg [i] [j] + ""+pcs [i] [j] + ""+bg [i] [j] + "u.png"));

				move++;
			}
		}
	}
	public void reset ()
	{
		//copy every element of r into b
		//that sets it back to the original
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{
				fg [i][j] = fg2 [i][j];
				pcs [i][j] = pcs2 [i][j];
				bg [i][j] = bg2 [i][i];
				sel [i][j] = sel2[i][j];
			}	
		}
		//call redraw to update b on the screen
		redraw ();
	}
	//	Save method to save the file/game
	public void save (String filename) 
	{
		PrintWriter out;
		try {
			out = new PrintWriter (new FileWriter (filename));
			for(int i=0; i<row; i++)
			{
				for(int j=0; j<col; j++)
				{
					out.println (""+fg [i] [j]);
				}
			}
				for(int i=0; i<row; i++)
				{
					for(int j=0; j<col; j++)
					{
						out.println (""+pcs [i] [j]);
					}
				}
				for(int i=0; i<row; i++)
				{
					for(int j=0; j<col; j++)
					{
						out.println (""+bg [i] [j]);
					}
				}
				for(int i=0; i<row; i++)
				{
					for(int j=0; j<col; j++)
					{
						out.println (""+sel [i] [j]);
					}
				}
				out.close ();
		}
		catch (IOException e) {
			System.out.println ("Error opening file " + e);
		}
	}
	//	 Open method to open the saved file
	public void open(String filename){
		BufferedReader in;
		try {
			in = new BufferedReader (new FileReader (filename));
			String input = in.readLine ();
			for(int i=0; i<row; i++) 
			{
				for(int j=0; j<col; j++) 
				{
					input = String.valueOf(fg[i][j]);
					input = in.readLine ();
				}
			}
				for(int i=0; i<row; i++) 
				{
					for(int j=0; j<col; j++) 
					{
					input = String.valueOf(pcs[i][j]);
					input = in.readLine ();
					}
				}
				for(int i=0; i<row; i++) 
				{
					for(int j=0; j<col; j++) 
					{
					input = String.valueOf(bg[i][j]);
					input = in.readLine ();
					}
				}
				for(int i=0; i<row; i++) 
				{
					for(int j=0; j<col; j++) 
					{
					input = String.valueOf(sel[i][j]);
					input = in.readLine ();
					}
				}
			in.close ();
		}
		catch (IOException e) {
			System.out.println ("Error opening file " + e);
		}
		redraw();
	}

	public void selectPawn(int x, int y) 
	{
		if (fg [x][y] == 'w' && x == 6)
		{
			if(fg[x-1][y]=='x')
				sel [x-1][y] = 's';
			if(fg[x-2][y]=='x' && fg[x-1][y]=='x')
				sel [x-2][y] = 's';
		}
		else if (fg [x][y] == 'b' && x == 1)
		{
			if(fg[x+1][y]=='x')
				sel [x+1][y] = 's';
			if(fg[x+2][y]=='x' && fg[x+1][y] == 'x')
				sel [x+2][y] = 's';
		}
		else if (fg [x][y] == 'w')
		{
			if(x-1 >= 0 && fg[x-1][y]=='x')
				sel [x-1][y] = 's';
		}
		else if (fg [x][y] == 'b')
		{
			if(x+1 <= 7 && fg[x+1][y]=='x')
				sel [x+1][y] = 's';
		}
		//kill code for white pawn (going  up and left)
		if (x-1 >= 0 && y-1 >= 0 && fg [x][y] == 'w' && fg[x-1][y-1] != fg[x][y] && fg [x-1][y-1] != 'x')
		{
			sel [x-1][y-1] = 's';
		}
		//		 kill code for white pawn (going up and right)
		if (x-1 >= 0 && y+1 <= 7 && fg [x][y] == 'w' && fg[x-1][y+1] != fg[x][y] && fg [x-1][y+1] != 'x')
		{
			sel [x-1][y+1] = 's';
		}
		//		 kill code for black pawn (going down and left)
		if (x+1 <= 7 && y-1 >= 0 && fg [x][y] == 'b' && fg[x+1][y-1] != fg[x][y] && fg [x+1][y-1] != 'x')
		{
			sel [x+1][y-1] = 's';
		}
		//		 kill code for black pawn (going down and right)
		if (x+1 <= 7 && y+1 <=7 && fg [x][y] == 'b' && fg[x+1][y+1] != fg[x][y] && fg [x+1][y+1] != 'x')
		{
			sel [x+1][y+1] = 's';
		}
	}
	public void selectRook (int x, int y)
	{
		//		up code
		int cxl = x-1;
		while (cxl >= 0 && fg [cxl][y] == 'x')
		{
			sel [cxl][y] = 's';
			cxl--;
		}
		if (cxl >= 0 && fg [cxl][y] != fg [x][y] && fg [cxl][y] != 'x')
		{
			sel [cxl][y] = 's';
		}
		//		down code
		int cxl1 = x+1;
		while (cxl1 <= 7 && fg [cxl1][y] == 'x')
		{
			sel [cxl1][y] = 's';
			cxl1++;
		}
		if (cxl1 <= 7 && fg [cxl1][y] != fg [x][y] && fg [cxl1][y] != 'x')
		{
			sel [cxl1][y] = 's';
		}
		//		right code (across)
		int cyl = y+1;
		while (cyl <= 7 && fg [x][cyl] == 'x')
		{
			sel [x][cyl] = 's';
			cyl++;
		}
		if (cyl <= 7 && fg [x][cyl] != fg [x][y] && fg [x][cyl] != 'x')
		{
			sel [x][cyl] = 's';
		}
		//		left code (across)
		int cyl1 = y-1;
		while (cyl1 >= 0 && fg [x][cyl1] == 'x')
		{
			sel [x][cyl1] = 's';
			cyl1--;
		}
		if (cyl1 >= 0 && fg [x][cyl1] != fg [x][y] && fg [x][cyl1] != 'x')
		{
			sel [x][cyl1] = 's';
		}
	}
	public void selectBishop (int x, int y)
	{
		//		Moving up and to the right corner
		int cxl2 = x-1;
		int cyl2 = y+1;
		while (cxl2 >= 0 && cyl2 <= 7 && fg [cxl2][cyl2] == 'x')
		{
			sel [cxl2][cyl2] = 's';
			cxl2--;
			cyl2++;
		}
		if (cxl2 >= 0 && cyl2 <= 7 && fg [cxl2][cyl2] != fg [x][y] && fg [cxl2][cyl2] != 'x')
		{
			sel [cxl2][cyl2] = 's';
		}
		//		Moving up and to the left corner
		int cxl3 = x-1;
		int cyl3 = y-1;
		while (cxl3 >= 0 && cyl3 >= 0 && fg [cxl3][cyl3] == 'x')
		{
			sel [cxl3][cyl3] = 's';
			cxl3--;
			cyl3--;
		}
		if (cxl3 >= 0 && cyl3 >= 0 && fg [cxl3][cyl3] != fg[x][y] && fg [cxl3][cyl3] != 'x' )
		{
			sel [cxl3][cyl3] = 's';
		}
		//		Moving down and to the right corner
		int cxl4 = x+1;
		int cyl4 = y+1;
		while (cxl4 <=7 && cyl4 <= 7 && fg [cxl4][cyl4] == 'x')
		{
			sel [cxl4][cyl4] = 's';
			cxl4++;
			cyl4++;
		}
		if (cxl4 <=7 && cyl4 <= 7 && fg [cxl4][cyl4] != fg [x][y] && fg [cxl4][cyl4] != 'x' )
		{
			sel [cxl4][cyl4] = 's';
		}
		//		Moving down and to the let corner
		int cxl5 = x+1;
		int cyl5 = y-1;
		while (cxl5 <= 7 && cyl5 >= 0 && fg [cxl5][cyl5] == 'x')
		{
			sel [cxl5][cyl5] = 's';
			cxl5++;
			cyl5--;
		}
		if (cxl5 <= 7 && cyl5 >= 0 && fg [cxl5][cyl5] != fg [x][y] && fg [cxl5][cyl5] != 'x')
		{
			sel [cxl5][cyl5] = 's';
		}
	}
	public void selectQueen (int x, int y)
	{
		//		Code from rook
		//		up code
		int cxl = x-1;
		while (cxl >= 0 && fg [cxl][y] == 'x')
		{
			sel [cxl][y] = 's';
			cxl--;
		}
		if (cxl >= 0 && fg [cxl][y] != fg [x][y] && fg [cxl][y] != 'x')
		{
			sel [cxl][y] = 's';
		}
		//		down code
		int cxl1 = x+1;
		while (cxl1 <= 7 && fg [cxl1][y] == 'x')
		{
			sel [cxl1][y] = 's';
			cxl1++;
		}
		if (cxl1 <= 7 && fg [cxl1][y] != fg [x][y] && fg [cxl1][y] != 'x')
		{
			sel [cxl1][y] = 's';
		}
		//		right code (across)
		int cyl = y+1;
		while (cyl <= 7 && fg [x][cyl] == 'x')
		{
			sel [x][cyl] = 's';
			cyl++;
		}
		if (cyl <= 7 && fg [x][cyl] != fg [x][y] && fg [x][cyl] != 'x')
		{
			sel [x][cyl] = 's';
		}
		//		left code (across)
		int cyl1 = y-1;
		while (cyl1 >= 0 && fg [x][cyl1] == 'x')
		{
			sel [x][cyl1] = 's';
			cyl1--;
		}
		if (cyl1 >= 0 && fg [x][cyl1] != fg [x][y] && fg [x][cyl1] != 'x')
		{
			sel [x][cyl1] = 's';
		}
		//		code from the bishop
		//		Moving up and to the right corner
		int cxl2 = x-1;
		int cyl2 = y+1;
		while (cxl2 >= 0 && cyl2 <= 7 && fg [cxl2][cyl2] == 'x')
		{
			sel [cxl2][cyl2] = 's';
			cxl2--;
			cyl2++;
		}
		if (cxl2 >= 0 && cyl2 <= 7 && fg [cxl2][cyl2] != fg [x][y] && fg [cxl2][cyl2] != 'x')
		{
			sel [cxl2][cyl2] = 's';
		}
		//		Moving up and to the left corner
		int cxl3 = x-1;
		int cyl3 = y-1;
		while (cxl3 >= 0 && cyl3 >= 0 && fg [cxl3][cyl3] == 'x')
		{
			sel [cxl3][cyl3] = 's';
			cxl3--;
			cyl3--;
		}
		if (cxl3 >= 0 && cyl3 >= 0 && fg [cxl3][cyl3] != fg[x][y] && fg [cxl3][cyl3] != 'x' )
		{
			sel [cxl3][cyl3] = 's';
		}
		//		Moving down and to the right corner
		int cxl4 = x+1;
		int cyl4 = y+1;
		while (cxl4 <=7 && cyl4 <= 7 && fg [cxl4][cyl4] == 'x')
		{
			sel [cxl4][cyl4] = 's';
			cxl4++;
			cyl4++;
		}
		if (cxl4 <=7 && cyl4 <= 7 && fg [cxl4][cyl4] != fg [x][y] && fg [cxl4][cyl4] != 'x' )
		{
			sel [cxl4][cyl4] = 's';
		}
		//		Moving down and to the let corner
		int cxl5 = x+1;
		int cyl5 = y-1;
		while (cxl5 <= 7 && cyl5 >= 0 && fg [cxl5][cyl5] == 'x')
		{
			sel [cxl5][cyl5] = 's';
			cxl5++;
			cyl5--;
		}
		if (cxl5 <= 7 && cyl5 >= 0 && fg [cxl5][cyl5] != fg [x][y] && fg [cxl5][cyl5] != 'x')
		{
			sel [cxl5][cyl5] = 's';
		}
	}
	public void selectKing (int x, int y)
	{
		//		Move king from anywhere
		if (x-1 >= 0 && fg [x-1][y] == 'x')
		{
			sel [x-1][y] = 's';
		}
		if (x+1 <= 7 && fg [x+1][y] == 'x')
		{
			sel [x+1][y] = 's';
		}
		if (y-1 >= 0 && fg [x][y-1] == 'x')
		{
			sel [x][y-1] = 's';
		}
		if (y+1 <= 7 && fg [x][y+1] == 'x')
		{
			sel [x][y+1] = 's';
		}
		if (x-1 >= 0 && y-1 >= 0 && fg [x-1][y-1] == 'x')
		{
			sel [x-1][y-1] = 's';
		}
		if (x-1 >= 0 && y+1 <= 7 && fg [x-1][y+1] == 'x')
		{
			sel [x-1][y+1] = 's';
		}
		if (x+1 <= 7 && y-1 >= 0 && fg [x+1][y-1] == 'x')
		{
			sel [x+1][y-1] = 's';
		}
		if (x+1 <= 7 && y+1 <= 7 && fg [x+1][y+1] == 'x')
		{
			sel [x+1][y+1] = 's';
		}
		//		Kill condition for the king
		if (x-1 >= 0 && fg [x-1][y] != fg [x][y] && fg [x-1][y] != 'x')
		{
			sel [x-1][y] = 's';
		}
		if (x-1 >= 0 && y+1 <= 7 && fg [x-1][y+1] != fg [x][y] && fg [x-1][y+1] != 'x')
		{
			sel [x-1][y+1] = 's';
		}
		if (y+1 <= 7 && fg [x][y+1] != fg [x][y] && fg [x][y+1] != 'x')
		{
			sel [x][y+1] = 's';
		}
		if (x+1 <= 7 && y+1 <= 7 && fg [x+1][y+1] != fg [x][y] && fg [x+1][y+1] != 'x')
		{
			sel [x+1][y+1] = 's';
		}
		if (x+1 <= 7 && fg [x+1][y] != fg [x][y] && fg [x+1][y] != 'x')
		{
			sel [x+1][y] = 's';
		}
		if (x+1 <= 7 && y-1 >= 0 && fg [x+1][y-1] != fg [x][y] && fg [x+1][y-1] != 'x')
		{
			sel [x+1][y-1] = 's';
		}
		if (y-1 >= 0 && fg [x][y-1] != fg [x][y] && fg [x][y-1] != 'x')
		{
			sel [x][y-1] = 's';
		}
		if (x-1 >= 0 && y-1 >= 0 && fg [x-1][y-1] != fg [x][y] && fg [x-1][y-1] != 'x')
		{
			sel [x-1][y-1] = 's';
		}

	}
	public void selectKnight (int x, int y)
	{
		//		Moving knight from anywhere on the board
		if (x-2 >= 0 && y-1 >= 0 && fg [x-2][y-1] == 'x')
		{	
			sel [x-2][y-1] = 's';
		}
		if (x-2 >= 0 && y+1 <= 7 && fg [x-2][y+1] == 'x')
		{
			sel [x-2][y+1] = 's';
		}
		if (x+2 <= 7 && y-1 >= 0 && fg [x+2][y-1] == 'x')
		{
			sel [x+2][y-1] = 's';
		}
		if (x+2 <= 7 && y+1 <= 7 && fg [x+2][y+1] == 'x')
		{
			sel [x+2][y+1] = 's';
		}
		if (x-1 >= 0 && y-2 >= 0 && fg [x-1][y-2] == 'x')
		{
			sel [x-1][y-2] = 's';
		}
		if (x-1 >= 0 && y+2 <= 7 && fg [x-1][y+2] == 'x')
		{
			sel [x-1][y+2] = 's';
		}
		if (x+1 <= 7 && y-2 >= 0 && fg [x+1][y-2] == 'x')
		{
			sel [x+1][y-2] = 's';
		}
		if (x+1 <= 7 && y+2 <= 7 && fg [x+1][y+2] == 'x')
		{
			sel [x+1][y+2] = 's';
		}
		//			Moving knight with kill condition added
		if (x-2 >= 0 && y-1 >= 0 && fg [x-2][y-1] != fg [x][y] && fg [x-2][y-1] != 'x')
		{
			sel [x-2][y-1] = 's';
		}
		if (x-2 >= 0 && y+1 <= 7 && fg [x-2][y+1] != fg [x][y] && fg [x-2][y+1] != 'x')
		{
			sel [x-2][y+1] = 's';
		}
		if (x+2 <= 7 && y-1 >= 0 && fg [x+2][y-1] != fg [x][y] && fg [x+2][y-1] != 'x')
		{
			sel [x+2][y-1] = 's';
		}
		if (x+2 <= 7 && y+1 <= 7 && fg [x+2][y+1] != fg [x][y] && fg [x+2][y+1] != 'x')
		{
			sel [x+2][y+1] = 's';
		}
		if (x-1 >= 0 && y-2 >= 0 && fg [x-1][y-2] != fg [x][y] && fg [x-1][y-2] !=  'x')
		{
			sel [x-1][y-2] = 's';
		}
		if (x-1 >= 0 && y+2 <= 7 && fg [x-1][y+2] != fg [x][y] && fg [x-1][y+2] != 'x')
		{
			sel [x-1][y+2] = 's';
		}
		if (x+1 <= 7 && y-2 >= 0 && fg [x+1][y-2] != fg [x][y] && fg [x+1][y-2] != 'x')
		{
			sel [x+1][y-2] = 's';
		}
		if (x+1 <= 7 && y+2 <= 7 && fg [x+1][y+2] != fg [x][y] && fg [x+1][y+2] != 'x')
		{
			sel [x+1][y+2] = 's';
		}
	}
	public void actionPerformed (ActionEvent e)
	{ //moves between the screens
		if (e.getActionCommand().equals("save"))
			save("file.txt");
		else if (e.getActionCommand().equals("open"))
			open("file.txt");
		else if (e.getActionCommand ().equals ("s1"))
			cdLayout.show (p_card, "1");
		else if (e.getActionCommand ().equals ("s2"))
			cdLayout.show (p_card, "2");
		else if (e.getActionCommand ().equals ("s3"))
			cdLayout.show (p_card, "3");
		else if (e.getActionCommand ().equals ("s4"))
			cdLayout.show (p_card, "4");
		else if (e.getActionCommand ().equals ("s5"))
			cdLayout.show (p_card, "5");
		else if (e.getActionCommand ().equals ("s6"))
			System.exit (0);
		else if (e.getActionCommand ().equals ("reset"))
			reset();
		else
		{ //code to handle the game
			int n = Integer.parseInt (e.getActionCommand ());
			int x = n / col;
			int y = n % col;
			showStatus ("(" + x + ", " + y + ")");
			//			b [x][y] = turn;
			//					redraw();

			if (turn != fg[x][y] && last == -1)
			{
				JOptionPane.showMessageDialog (null, "It's not your turn!", "Wrong",
						JOptionPane.INFORMATION_MESSAGE);
			}
			else if (last == -1 && turn == fg [x][y])
			{
				if (pcs [x][y] == 'p') {
					selectPawn (x,y);
				}
				else if (pcs [x][y] == 'r') {
					selectRook (x,y);				
				}
				else if (pcs [x][y] == 'n') {
					selectKnight (x,y);				
				}
				else if (pcs [x][y] == 'b') {
					selectBishop (x,y);				
				}
				else if (pcs [x][y] == 'q') {
					selectQueen (x,y);				
				}
				else if (pcs [x][y] == 'k') {
					selectKing (x,y);				
				}
				last = n;
			}
			else 
			{
				int lastx = last/col;
				int lasty = last % col;
				if (sel [x][y] == 's') 
				{
					pcs [x][y] = pcs [lastx][lasty];
					pcs [lastx][lasty] = 'x';
					fg [x][y] = fg [lastx][lasty];
					fg [lastx][lasty] = 'x';
					if (turn == 'b')
					{
						turnpic.setIcon(createImageIcon ("GTurn.png"));
						turn = 'w';
					}
					else 
					{
						turnpic.setIcon(createImageIcon ("STurn.png"));
						turn = 'b';
					}
				}
				for (int i = 0; i < row; i++)
				{
					for (int j = 0; j < col; j++)
					{
						sel [i][j] = 'u';
					}
				}
				last = -1;
			}
			redraw();

		}
	}
}
