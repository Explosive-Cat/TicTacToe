import javax.swing.*;
import java.awt.*;

public class Main{
    public static void main(String[] args){
        JFrame window = new JFrame();
        Image icon= new ImageIcon("TTTicon.png").getImage();
        window.setSize(300, 360);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setIconImage(icon);
        window.setResizable(true);
        TicTacToe game = new TicTacToe();
        window.add(game);
        window.setVisible(true);
    }
}