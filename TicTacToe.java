import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.io.*;
import javax.swing.*;
//import java.applet.*;

public class TicTacToe extends JComponent/*implements ActionListener*/{
        @Override
        protected void paintComponent(Graphics graph){
                int size = 3;
                int w = getWidth();
                int h = getHeight();
                
                int f = h/6;
                int x = w/size;
                int y = (h-f)/size;
                int space = 10;
                super.paintComponent(graph);
                graph.setColor(Color.BLUE);
                for(int i=1; i<size; i++){
                        graph.drawLine(x*i, f+space, x*i, h-space);
                        graph.drawLine(space, f+y*i, w-space, f+y*i);
                }
                /*System.out.println("x="+x);
                System.out.println("y="+y);
                System.out.println("w="+w);
                System.out.println("h="+h);
                System.out.println("f="+f);
                */
                //Image icon= new ImageIcon("Zero.png").getImage();
               // graph.drawImage(icon, 20, 20, null, icon);
        }
       
} 

      