import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;


public class guess_word extends JFrame
{
	private static final int WIDTH = 200;
	private static final int HEIGHT = 300;
	
	private JLabel your_choice, you_chose, guess,promptL,promptL2,promptL3,promptL4,promptL5,promptL6,promptL7,promptL8;
	private JTextField your_choiceTF, you_choseTF, guessTF,blahTF,promptTF3,promptTF4,promptTF5,promptTF6,promptTF7,promptTF8;
	private JButton checkB, exitB,startB;
	
	//Button handlers:
	public CheckButtonHandler cbHandler;
	public StartButtonHandler stHandler;
	public ExitButtonHandler ebHandler;
	String s;
	StringBuilder s2 = new StringBuilder();
	StringBuilder s3 = new StringBuilder();

	public guess_word	()
	{
		your_choice =new JLabel("Your Choice", SwingConstants.RIGHT);
		you_chose  =new JLabel("You chose: ", SwingConstants.RIGHT);
		guess   =new JLabel("Enter ur guess : ", SwingConstants.RIGHT);
		promptL =new JLabel("1 for fruits ", SwingConstants.RIGHT);
		promptL2=new JLabel("2 for games", SwingConstants.RIGHT);
		promptL3=new JLabel("we got", SwingConstants.RIGHT);
		promptL4=new JLabel("result", SwingConstants.RIGHT);
		promptL5=new JLabel("correct so far", SwingConstants.RIGHT);

		promptL6=new JLabel("correct", SwingConstants.RIGHT);
		promptL7=new JLabel("wrong", SwingConstants.RIGHT);
		promptL8=new JLabel("Score", SwingConstants.RIGHT);
		
		your_choiceTF = new JTextField(10);
		you_choseTF = new JTextField(10);
		guessTF = new JTextField(10);
		blahTF=new JTextField(10);
		//promptTF2 = new JTextField(10);
		promptTF3 = new JTextField(10);
		promptTF4 = new JTextField(10);
		promptTF5 = new JTextField(10);

		promptTF6 = new JTextField(10);
		promptTF7 = new JTextField(10);
		promptTF8 = new JTextField(10);

		
		checkB = new JButton("Check");
		cbHandler = new CheckButtonHandler();
		checkB.addActionListener(cbHandler);

		exitB = new JButton("Exit");
		ebHandler = new ExitButtonHandler();
		exitB.addActionListener(ebHandler);

		startB= new JButton("Start");
		stHandler=new StartButtonHandler();
		startB.addActionListener(stHandler);
		
		setTitle("Word guessing game");

		
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(12, 2));
		
		pane.add(promptL);
		pane.add(promptL2);

		pane.add(your_choice);
		pane.add(your_choiceTF);

		pane.add(startB);
		pane.add(blahTF);

		pane.add(you_chose);
		pane.add(you_choseTF);

		pane.add(guess);
		pane.add(guessTF);

		pane.add(promptL3);
		pane.add(promptTF3);

		pane.add(promptL4);
		pane.add(promptTF4);

		pane.add(promptL5);
		pane.add(promptTF5);

		pane.add(promptL6);
		pane.add(promptTF6);

		pane.add(promptL7);
		pane.add(promptTF7);

		pane.add(promptL8);
		pane.add(promptTF8);

		pane.add(checkB);
		pane.add(exitB);
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public class  StartButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			int width, length1, area;
			
			length1 = Integer.parseInt(your_choiceTF.getText());
        ArrayList<String> fruits = new ArrayList<String>(3);
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("mango");
        
        ArrayList<String> games;
        games = new ArrayList<String>(3);
        games.add("cricket");
        games.add("football");
        games.add("tennis");
         double x;
        int y;
      


			if (length1==1) {
				you_choseTF.setText("u chose fruits");
				 x=  Math.random();
                y=(int) (x*(fruits.size()));
                //System.out.println(y);
               
				 s=fruits.get(y);
				 

				
			}
			else if (length1==2) {
				you_choseTF.setText("u chose games");
				 x=  Math.random();
                y=(int) (x*(games.size()));
                //System.out.println(y);
                
                s=games.get(y);
                //guessTF.setText(s);
				
			}
			else
			{
				you_choseTF.setText("Invalid");
			}
			int l=s.length(),count=0;

			int l2=s.length();
				 int c1=0;
				 while(c1<l2)
				 {
				 	s2.insert(c1, s.charAt(c1));
				 	c1++;
				 }
			
		}
		
	}

	int right=0,wrong=0,score=0;  
	public class CheckButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
                    //System.out.println(ch);
                    int n=-1; 

                    while(right < s.length())
                   { 	
                   	String a=guessTF.getText();
            		char ch=a.charAt(0);
                    promptTF3.setText(ch+" ");
                   // int n=-1;
                    //System.out.println(s2.length());

                    for(int i=0;i<s2.length();i++)
                    {
                        if(s2.charAt(i)==ch)
                        {
                            n=i;
                            promptTF4.setText("Correct");
                          //  System.out.println("U r Correct");
                         // System.out.println("right is "+ right);
                            break;
                        }
                        
                    
                    }

                    if(n!= -1 && n < s2.length())
                    {
                    s2.deleteCharAt(n);
                    s2.insert(n, "z");

                    right++;
//                    System.out.println(s2);
//                    System.out.println(n);


                    //clear s3


                       // System.out.println("");
                    }

                    else
                    {
                    wrong++;
                    promptTF4.setText("Incorrect");
                    
                    //clear s3
                       // System.out.println("U made a mistake");
                        //System.out.println("wrong is " +wrong);
                    }
                    int j=0;
                    while(j<s2.length())
                    {
                    if(s2.charAt(j)=='z')
                    {
                        s3.insert(j,s.charAt(j));
                    }
                    else
                    {
                       s3.insert(j,"_");
                    }
                    j++;
                    }
                     promptTF5.setText(s3+"");
                     s3.delete(0,s2.length());
                      your_choiceTF.setText("");
                      guessTF.setText("");
                      promptTF3.setText("");
                      promptTF6.setText(right+"");
                      promptTF7.setText(wrong+"");
                    }
                    score=right*5;
                
                	score=score-(wrong*2);
                	promptTF8.setText(score+"");
		}	
	}
	
	public class ExitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
	public static void main(String[] args)
	{
		guess_word g= new guess_word();
	}
}
