//Name: Dhir Patel
//Date: December 14, 2018
//Purpose: To entertainment the players with this intell

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;

public class Chess extends Applet implements ActionListener
{
	JLabel turnpic;
	JButton reset;
	char turn ='b';
	int last = -1;
	Panel p_card;  //to hold all of the screens
	Panel card1, card2, card3, card4, card5; //the two screens
	CardLayout cdLayout = new CardLayout ();

	//grid
	int row = 8;
	int col = 8;
	JButton a[] = new JButton [row * col];
	char bg[] [] = {	
			{'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b',}, 
			{'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w',}, 
			{'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b',}, 
			{'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w',}, 
			{'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b',}, 
			{'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w',}, 
			{'w', 'b', 'w', 'b', 'w', 'b', 'w', 'b',}, 
			{'b', 'w', 'b', 'w', 'b', 'w', 'b', 'w',}};

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

	public void init ()
	{
		p_card = new Panel ();
		p_card.setLayout (cdLayout);
		//	screen1 ();
		//	screen2 ();
		screen3 ();
		screen4 ();
		screen5 ();
		resize (550, 650);
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
		//card3.setBackground (Color.green);
		JLabel title = new JLabel ("Game");
		JButton next = new JButton ("Next");
		next.setActionCommand ("s4");
		next.addActionListener (this);
		turnpic = new JLabel (createImageIcon ("bpbu.png"));
		reset = new JButton ("Reset");
		JLabel turn1 = new JLabel ("Player's Turn");
		//Set up grid
		Panel p = new Panel (new GridLayout (row, col));
		int move = 0;
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{ //take out when you've got pictures
				a [move] = new JButton ("");
				//add in when you have pictures
				a [move] = new JButton (createImageIcon (fg [i] [j] + ""+pcs [i] [j] + ""+bg [i] [j] +  "u.png"));
				a [move].setPreferredSize (new Dimension (65, 65));
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
		card3.add (title);
		card3.add (p);
		card3.add (next);
		card3.add(turn1);
		card3.add (turnpic);
		card3.add(reset);
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
	public void selectPawn(int x, int y) 
	{
		if (fg [x][y] == 'w' && x == 6)
		{
			if(fg[x-1][y]=='x')
			sel [x-1][y] = 's';
			if(fg[x-1][y]=='x')
			sel [x-2][y] = 's';
		}
		else if (fg [x][y] == 'b' && x == 1)
		{
			if(fg[x+1][y]=='x')
			sel [x+1][y] = 's';
			if(fg[x+1][y]=='x')
			sel [x+2][y] = 's';
		}
		else if (fg [x][y] == 'w')
		{
			if(fg[x-1][y]=='x')
			sel [x-1][y] = 's';
			if(fg[x-1][y-1]!='x')
			sel [x-1][y-1] = 's';
			if(fg[x-1][y+1]!='x')
			sel [x-1][y+1] = 's';
		}
		else if (fg [x][y] == 'b')
		{
			if(fg[x+1][y]=='x')
			sel [x+1][y] = 's';
			if(fg[x+1][y-1]!='x')
			sel [x+1][y-1] = 's';
			if(fg[x+1][y+1]!='x')
			sel [x+1][y+1] = 's';
		}
		
		//kill
		if (fg [x][y] == 'w' && fg[x][y] != fg [x][y] && fg [x][y] != 'x')
		{
			sel [x+1][y-1] = 's';
			sel [x+1][y+1] = 's';
		}

	}
	public void selectBishop (int x, int y)
	{
		if (fg [x][y] == 'w' && x == 7 && y == 2 )
		{
			sel [x-2][y-2] = 's';
			sel [x-5][y+5] = 's';
		}
		else if (fg [x][y] == 'w' && x == 7 && y == 5)
		{
			sel [x-5][y-5] = 's';
			sel [x-2][y+2] = 's';
		}
		else if (fg [x][y] == 'b' && x == 0 && y == 2)
		{
			sel [x+2][y-2] = 's';
			sel [x+5][y+5] = 's';
		}
		else if (fg [x][y] == 'b' && x == 0 && y == 5)
		{
			sel [x+5][y-5] = 's';
			sel [x+2][y+2] = 's';
		}
		else if (fg [x][y] == 'w')
		{
			BWanywhere (x,y);
		}
		else if (fg [x][y] == 'b')
		{
			BBanywhere (x,y);
		}
	}
	public void selectRook (int x, int y)
	{
		//		up code
		int cxl = x-1;
		//		A loop to control the up movement of the rook
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
		//		A loop to control the down movement of the rook
		while (cxl1 <= 7 && fg [cxl1][y] == 'x')
		{
			sel [cxl1][y] = 's';
			cxl1++;
		}
		if (cxl1 <= 7 && fg [cxl1][y] != fg [x][y] && fg [cxl1][y] != 'x')
		{
			sel [cxl1][y] = 's';
		}
	}
	public void BWanywhere (int x, int y)
	{
		//	Movement for the two white bishops when they are anywhere on the board
		//			if (fg [x][y] == 'w')
		{

			//		To go to bottom right corner
			sel [x+1][y+1] = 's';
			//		To go to top right corner
			sel [x-1][y+1] = 's';
			//		To go to bottom left corner
			sel [x+1][y-1] = 's';
			//		To go to top left corner
			sel [x-1][y-1] = 's';
		}
	}
	public void BBanywhere (int x, int y)
	{
		//	Movement for the two black bishops when they are anywhere on the board
		//	if (fg [x][y] == 'b')
		{
			//			To go to bottom right corner
			sel [x+1][y+1] = 's';
			//			To go to top right corner
			sel [x-1][y+1] = 's';
			//			To go to bottom left corner
			sel [x+1][y-1] = 's';
			//			To go to top left corner
			sel [x-1][y-1] = 's';
		}	
	}
	public void selectKing (int x, int y)
	{
		if (fg [x][y] == 'w' && x == 7 && y == 4)
		{
			sel [x-1][y] = 's';
			sel [x-1][y-1] = 's';
			sel [x+1][y+1] = 's';
			sel [x] [y-1] = 's';
			sel [x][y+1] = 's';
		}
		else if (fg [x][y] == 'b' && x == 0 && y == 4)
		{
			sel [x+1][y] = 's';
			sel [x+1][y-1] = 's';
			sel [x+1][y+1] = 's';
			sel [x][y-1] = 's';
			sel [x][y+1] = 's';
		}
	}
	public void selectKnight (int x, int y)
	{
		if (fg [x][y] == 'w' && x == 7 && y == 1)
		{
			sel [x-2][y-1] = 's';
			sel [x-2][y+1] = 's';
		}
	}

	/*	char pcs [] [] = {	
			{'r','n','b','q','k','b','n','r'},
			{'p','p','p','p','p','p','p','p'},
			{'x','x','x','x','x','x','x','x'},
			{'x','x','x','x','x','x','x','x'},
			{'x','x','x','x','x','x','x','x'},
			{'x','x','x','x','x','x','x','x'},
			{'p','p','p','p','p','p','p','p'},
			{'r','n','b','q','k','b','n','r'}};*/
	public void actionPerformed (ActionEvent e)
	{ //moves between the screens
		if (e.getActionCommand ().equals ("s1"))
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
					//					selectKnight (x,y);				
				}
				else if (pcs [x][y] == 'b') {
					selectBishop (x,y);				
				}
				else if (pcs [x][y] == 'q') {
					//					selectQueen (x,y);				
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
						turnpic.setIcon(createImageIcon ("wpwu.png"));
						turn = 'w';
					}
					else 
					{
						turnpic.setIcon(createImageIcon ("bpbu.png"));
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