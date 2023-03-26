import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.applet.*;

public class TicTacToe /*implements ActionListener*/{
        final static boolean RIGHT_TO_LEFT = true;
        public static void createWindow(){
                JFrame window = new JFrame("TicTacToe");
                Image icon= new ImageIcon("TTTicon.png").getImage();
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setSize(450, 450);
                window.setIconImage(icon);
                //window.setResizable(false);
                addComponentPane(window.getContentPane());

                window.pack();
                window.setVisible(true);
        }

        public static void addComponentPane(Container pane){
          
                pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                pane.setLayout(new GridBagLayout());
                
                GridBagConstraints c = new GridBagConstraints();

                JButton cell = new JButton();
                c.fill = GridBagConstraints.BOTH;
                c.gridx=0;
                c.gridy=0;
                c.weightx = 1;
	        c.weighty = 1;
                c.gridwidth = 3;
                pane.add(cell, c);

                JButton cell1 = new JButton("1");
                c.gridx=0;
                c.gridy=1;
                c.gridwidth = 1;
                pane.add(cell1, c);

                JButton cell2 = new JButton("2");
                c.gridx=1;
                c.gridy=1;
                pane.add(cell2, c);

                JButton cell3 = new JButton("3");
                c.gridx=2;
                c.gridy=1;
                pane.add(cell3, c);

                JButton cell4 = new JButton("4");
                c.gridx=0;
                c.gridy=2;
                pane.add(cell4, c);

                JButton cell5 = new JButton("5");
                c.gridx=1;
                c.gridy=2;
                pane.add(cell5, c);

                JButton cell6 = new JButton("6");
                c.gridx=2;
                c.gridy=2;
                pane.add(cell6, c);

                JButton cell7 = new JButton("7");
                c.gridx=0;
                c.gridy=3;
                pane.add(cell7, c);

                JButton cell8 = new JButton("8");
                c.gridx=1;
                c.gridy=3;
                pane.add(cell8, c);

                JButton cell9 = new JButton("9");
                c.gridx=2;
                c.gridy=3;
                pane.add(cell9, c);
        }
      
        public static void main(String[] args){   
                SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                                createWindow();
                        }
                });
                
        }
} 

      