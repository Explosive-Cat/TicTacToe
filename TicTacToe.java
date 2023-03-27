import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.io.*;
import javax.swing.*;
//import java.applet.*;

public class TicTacToe extends JComponent/*implements ActionListener*/{
        public static final int FIELD_EMPTY = 0;
        public static final int FIELD_X = 1;
        public static final int FIELD_O = -1;
        public static final int size = 5;
        int[][] field;
        boolean isXturn;
        public TicTacToe(){
                enableEvents(AWTEvent.MOUSE_EVENT_MASK);
                field = new int[size][size];
                initGame();
        }

        public void initGame(){
                for(int i=0; i<size; i++){
                        for(int j=0; j<size; j++){
                                field[i][j]= FIELD_EMPTY;
                        }
                }
                isXturn = true;
        }

        @Override
        protected void processMouseEvent(MouseEvent mouseEvent){
                super.processMouseEvent(mouseEvent);
                int x;
                int y;
                if(mouseEvent.getButton() == MouseEvent.BUTTON1){
                        x = mouseEvent.getX();
                        y = mouseEvent.getY();
                
                int i = (int)((float)x/getWidth()*size);
                int j = ((int)((float)y/getHeight()*size));
                if(field[i][j] == FIELD_EMPTY){
                        field[i][j] = isXturn?FIELD_X:FIELD_O;
                        isXturn = !isXturn;
                        repaint();
                }
                }
        }

        void drawX(int x, int y, Graphics graph){
                graph.setColor(Color.RED);
                int w = getWidth();
                int h = getHeight();
                int f = h/6;
                int space = ((h>w)?w:h)/30;
                //graph.imageUpdate(null, y, x, y, x, y)
                graph.drawLine(x*w/size+space, y*h/size+f+space, (x+1)*w/size-space, (y+1)*h/size+f-space);
                graph.drawLine(x*w/size+space, (y+1)*h/size+f-space, (x+1)*w/size-space, y*h/size+f+space);
        }

        void drawO(int x, int y, Graphics graph){
                graph.setColor(Color.BLUE);
                int w = getWidth();
                int h = getHeight();
                int f = h/6;
                int space = ((h>w)?w:h)/30;
                graph.drawOval((int)(x+0.5)*w/size, (int)(y+0.5)*h/size+f, w/size-space, h/size-space);
        }

        void drawXO(Graphics graph){
                for(int i=0; i<size; i++){
                        for(int j=0; j<size; j++){
                                if(field[i][j] == FIELD_X){
                                        drawX(i, j, graph);
                                }else if(field[i][j] == FIELD_O){
                                        drawO(i, j, graph);
                                }
                        }
                }
        }

        @Override
        protected void paintComponent(Graphics graph){
                super.paintComponent(graph);
                graph.clearRect(0, 0, getWidth(), getHeight());
                drawGrid(graph);
                drawXO(graph);
        }

        void drawGrid(Graphics graph){
                int w = getWidth();
                int h = getHeight();
                int f = h/6;
                int space = ((h>w)?w:h)/30;
                int x = w/size;
                int y = (h-f)/size;
                for(int i=1; i<size; i++){
                        graph.drawLine(x*i, f+space, x*i, h-space);
                        graph.drawLine(space, f+y*i, w-space, f+y*i);
                }
                System.out.println("x="+x);
                System.out.println("y="+y);
                System.out.println("w="+w);
                System.out.println("h="+h);
                System.out.println("f="+f);
                System.out.println("space="+space);
        }
} 

      