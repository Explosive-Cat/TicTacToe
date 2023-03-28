import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JComponent{
        public static final int FIELD_EMPTY = 0;
        public static final int FIELD_X = 1;
        public static final int FIELD_O = -1;
        int size = 4;
        public static final int IMAGE_SIZE = 128;
        int full;
        int[][] field;
        int[] whowin;
        boolean isXturn;

        public TicTacToe(){
                enableEvents(AWTEvent.MOUSE_EVENT_MASK);
                field = new int[size][size];
                whowin = new int[2*size+2];
                full = 0;
                initGame();
        }

        public void initGame(){
                for(int i=0; i<size; i++){
                        for(int j=0; j<size; j++){
                                field[i][j]= FIELD_EMPTY;
                        }
                }
                for(int i=0; i<2*size+2;i++){
                        whowin[i] = FIELD_EMPTY;
                }
                full = 0;
                isXturn = true;
        }

        @Override
        protected void processMouseEvent(MouseEvent mouseEvent){
                super.processMouseEvent(mouseEvent);
                if(mouseEvent.getButton() == MouseEvent.BUTTON1){
                        int x;
                        int y;
                        int win;   
                        x = mouseEvent.getX();
                        y = mouseEvent.getY()-getHeight()/6;
                
                        int i = (int)((float)x/getWidth()*size);
                        int j = ((int)((float)y/(getHeight()*5/6)*size));
                        if(field[i][j] == FIELD_EMPTY){
                                field[i][j] = isXturn?FIELD_X:FIELD_O; 
                                full++;  
                                whowin[i] += isXturn?FIELD_X:FIELD_O;
                                whowin[size+j] += isXturn?FIELD_X:FIELD_O;
                                if(i == j){
                                        whowin[2*size] += isXturn?FIELD_X:FIELD_O;
                                }
                                if(i+j== size-1){
                                        whowin[2*size+1] += isXturn?FIELD_X:FIELD_O;
                                }

                                isXturn = !isXturn;
                                repaint();

                                win = endGame();
                                if(win != 0){
                                        if(win == 3){
                                                JOptionPane.showMessageDialog(this, "X win!", "Win!", JOptionPane.INFORMATION_MESSAGE);
                                        }else if(win == -3){
                                                JOptionPane.showMessageDialog(this, "O win!", "Win!", JOptionPane.INFORMATION_MESSAGE);
                                        }else {
                                                JOptionPane.showMessageDialog(this, "draw", "Draw!", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                        initGame();
                                        repaint();
                                }
                                

                        }
                }
        }

        void drawX(int x, int y, Graphics graph){
                int w = getWidth();
                int h = getHeight()*5/6;
                int f = getHeight()/6;
                int space = ((h>w)?w:h)/30;
                Image icon= new ImageIcon("Cross.png").getImage();
                graph.drawImage(icon, x*w/size+space, y*h/size+f+space, (x+1)*w/size-space, (y+1)*h/size+f-space, 0, 0, IMAGE_SIZE, IMAGE_SIZE, null);
        }

        void drawO(int x, int y, Graphics graph){
                int w = getWidth();
                int h = getHeight()*5/6;
                int f = getHeight()/6;
                int space = ((h>w)?w:h)/30;
                Image icon= new ImageIcon("Zero.png").getImage();
                graph.drawImage(icon, x*w/size+space, y*h/size+f+space, (x+1)*w/size-space, (y+1)*h/size+f-space, 0, 0, IMAGE_SIZE, IMAGE_SIZE, null);
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

        void drawTurn(Graphics graph){
                int x = getWidth();
                int y = getHeight()/6;
                if(isXturn){
                        Image icon= new ImageIcon("Cross.png").getImage();
                        graph.drawImage(icon, x/2-y*4/10, y/10, x/2+y*4/10,  y*8/10, 0, 0, IMAGE_SIZE, IMAGE_SIZE, null);
                } else{
                        Image icon= new ImageIcon("Zero.png").getImage();
                        graph.drawImage(icon, x/2-y*4/10, y/10, x/2+y*4/10,  y*8/10, 0, 0, IMAGE_SIZE, IMAGE_SIZE, null);
                }
        }

        int endGame(){     
                for(int k=0; k<2*size+2; k++){
                        if(whowin[k] == 3 || whowin[k] == -3)
                        return whowin[k];
                }
                if(full == size*size){
                        return  1;
                }else return 0;  
        }

        int chackState(){
                int diag1 = 0;
                int diag2 = 0;
                for(int i =0; i<size; i++){
                        diag1 += field[i][i];
                        diag2 += field[i][size-1-i];
                }

                if(diag1 == FIELD_O*3 || diag1 == FIELD_X*3){return diag1;}
                if(diag2 == FIELD_O*3 || diag2 == FIELD_X*3){return diag2;}
                int check_i, check_j;
                boolean hasEmpty = false;
                for(int i=0; i<size; i++){
                        check_i = 0;
                        check_j = 0;
                        for(int j=0; j<size; j++){
                                if(field[i][j] == 0){
                                        hasEmpty = true;
                                }
                                check_i += field[i][j];
                                check_j += field[j][i];
                        }
                
                        if(check_i == FIELD_O*3 || check_i == FIELD_X*3){return check_i;}
                        if(check_j == FIELD_O*3 || check_j == FIELD_X*3){return check_j;}
                }
                if(hasEmpty) return 0; else return -1;
        }

        @Override
        protected void paintComponent(Graphics graph){
                super.paintComponent(graph);
                graph.clearRect(0, 0, getWidth(), getHeight());
                drawGrid(graph);
                drawXO(graph);
                drawTurn(graph);
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
        }
} 

      