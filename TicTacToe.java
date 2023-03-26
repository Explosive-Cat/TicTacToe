import javax.swing.*;

public class TicTacToe{
        public static void main(String[] args){
        JFrame window = new JFrame("TicTacToe");
        ImageIcon icon = new ImageIcon("TTTicon.png");
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 300);
        window.setIconImage(icon.getImage());
        }
}       