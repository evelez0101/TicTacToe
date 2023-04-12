import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener
{
    // Instance Variables
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    private final int SIZE = 9;
    JButton [] buttons = new JButton[SIZE];
    private boolean player1_turn;

    //Constructor 
    public TicTacToe()
    {
        // Creating Instance of a Frame 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Frame size
        frame.setSize(800,800);
        
        // Background Color (R, G, B) Values
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // Creating Instance of a Text Field 
        textfield.setBackground(new Color(117,156,174));
        textfield.setForeground(new Color(0,0,0));
        
        // Font
        textfield.setFont(new Font(Font.SERIF, Font.PLAIN,  100));
        
        // Border Layout 
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);

        // Title Panel
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        // Buttons 
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150,150,150));

        for (int i = 0; i < buttons.length; i++)
        {
            // Create button and add to array 
            buttons[i] = new JButton();

            // add button to panel 
            button_panel.add(buttons[i]);

            // Set up Button
            buttons[i].setFont(new Font(Font.SANS_SERIF,Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        // Connects the title panel to the text field 
        title_panel.add(textfield);

        // Connects title panel to the frame
        frame.add(title_panel,BorderLayout.NORTH);

        // Connects button panel to the frame
        frame.add(button_panel);

        // Game Begins
        firstTurn();


    }

    // Action Listner Interface 
    public void actionPerformed (ActionEvent e)
    {
        for (int i = 0; i < buttons.length; i++)
        {
            // Check whose turn it is at each button
            if (e.getSource() == buttons[i])
            {
                // Player 1 move
                if (player1_turn)
                {
                    // If the button is un occupied
                    if (buttons[i].getText() == "")
                    {
                        // Color for Symbol
                        buttons[i].setForeground(new Color(36,132,244));
                        
                        // Symbol 
                        buttons[i].setText("X");
                        
                        // End turn 
                        player1_turn = false;

                        // Change Text Field 
                        textfield.setText("O turn");
                        
                        // Checks for a win
                        checkWin();
                    }
                }
                // Player 2 move
                else 
                {
                    // If the button is un occupied
                    if (buttons[i].getText() == "")
                    {
                        // Color for Symbol
                        buttons[i].setForeground(new Color(209,63,61));
                            
                        // Symbol 
                        buttons[i].setText("O");
                        
                        // End turn 
                        player1_turn = true;

                        // Change Text Field 
                        textfield.setText("X turn");

                        // Checks for a win
                        checkWin();
                    }
                }
            }
        }
    }

    public void firstTurn()
    {
        // Menu could come here before hand
        
        // Wait before changing text
        try
        {
            Thread.sleep(2000);
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }

        // determine whose turn it is
        if (random.nextInt(2) == 0)
        {
            // Player 1 Turn
            player1_turn = true;
            textfield.setText("X turn");
        }
        else 
        {
            // Player 2 Turn
            player1_turn = false;
            textfield.setText("O turn");
        }
        
    }

    public void checkWin()
    {
        // Row 1
        if (buttons[0].getText() == buttons[1].getText() 
            && buttons[1].getText() == buttons[2].getText() 
            && buttons[0].getText() != "")
        {
            if (buttons[0].getText() == "X")
            {
                xWins(0,1,2);
            }
            else
            {
                oWins(0,1,2);
            }
        }

        // Row 2
        if (buttons[3].getText() == buttons[4].getText() 
            && buttons[4].getText() == buttons[5].getText()
            && buttons[3].getText() != "")
        {
            if (buttons[3].getText() == "X")
            {
                xWins(3,4,5);
            }
            else
            {
                oWins(3,4,5);
            }
        }

        // Row 3
        else if (buttons[6].getText() == buttons[7].getText() 
                && buttons[7].getText() == buttons[8].getText()
                && buttons[6].getText() != "")
        {
            if (buttons[6].getText() == "X")
            {
                xWins(6,7,8);
            }
            else
            {
                oWins(6,7,8);
            }
        }

        // Colomn 1
        else if (buttons[0].getText() == buttons[3].getText() 
                && buttons[3].getText() == buttons[6].getText()
                && buttons[0].getText() != "")
        {
            if (buttons[0].getText() == "X")
            {
                xWins(0,3,6);
            }
            else
            {
                oWins(0,3,6);
            }
        }

        // Colomn 2
        else if (buttons[1].getText() == buttons[4].getText() 
                && buttons[4].getText() == buttons[7].getText()
                && buttons[1].getText() != "")
        {
            if (buttons[1].getText() == "X")
            {
                xWins(1,4,7);
            }
            else
            {
                oWins(1,4,7);
            }
        }

        // Colomn 3
        else if (buttons[2].getText() == buttons[5].getText() 
                && buttons[5].getText() == buttons[8].getText()
                && buttons[2].getText() != "")
        {
            if (buttons[2].getText() == "X")
            {
                xWins(2,5,8);
            }
            else
            {
                oWins(2,5,8);
            }
        }
        
        // Diagnal 1
        else if (buttons[0].getText() == buttons[4].getText() 
                && buttons[4].getText() == buttons[8].getText()
                && buttons[0].getText() != "")
        {
            if (buttons[0].getText() == "X")
            {
                xWins(0,4,8);
            }
            else
            {
                oWins(0,4,8);
            }
        }

        // Diagnal 2
        else if (buttons[2].getText() == buttons[4].getText() 
                && buttons[4].getText() == buttons[6].getText()
                && buttons[2].getText() != "")
        {
            if (buttons[2].getText() == "X")
            {
                xWins(2,4,6);
            }
            else
            {
                oWins(2,4,6);
            }
        }
        // Check for Draw 
        else 
        {
            // if there are any empty buttons then we keep going 
            for (int i = 0; i < buttons.length; i++)
            {
                if (buttons[i].getText() == "")
                {
                    // leave function
                    return;
                }
            }

            // Disable all Buttons
            for (int i = 0; i < buttons.length; i++)
            {
              buttons[i].setEnabled(false);
            }

            // Display message to text field
            textfield.setText("Draw!");   
        }

    }

    public void xWins(int a, int b, int c)
    {
        // Change Button Color for wining combo
        buttons[a].setBackground(new Color(26,173,114));
        buttons[b].setBackground(new Color(26,173,114));
        buttons[c].setBackground(new Color(26,173,114));

        // Disable all Buttons
        for (int i = 0; i < buttons.length; i++)
        {
            if (i == a || i == b || i == c)
            {
                continue;
            }
            else
            {
                buttons[i].setEnabled(false);
            }
        }

        // Display message to text field
        textfield.setText("X Wins!");
    }

    public void oWins(int a, int b, int c)
    {
        // Change Button Color for wining combo
        buttons[a].setBackground(new Color(26,173,114));
        buttons[b].setBackground(new Color(26,173,114));
        buttons[c].setBackground(new Color(26,173,114));

        // Disable all Buttons
        for (int i = 0; i < buttons.length; i++)
        {
            if (i == a || i == b || i == c)
            {
                continue;
            }
            else
            {
                buttons[i].setEnabled(false);
            }
        }

        // Display message to text field
        textfield.setText("O Wins!");
    }
}
