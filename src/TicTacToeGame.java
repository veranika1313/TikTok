import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame extends JFrame {
   private char currentPlayer = 'X';
    private JButton[][] buttons = new JButton[10][10];

    public TicTacToeGame() {
        setTitle("Крестики- нолики");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 10));
        initializeButtons();
        setVisible(true);
    }

    private void initializeButtons() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j] = new JButton(" ");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(new ButtonClickListener());
                add(buttons[i][j]);
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            if (clickedButton.getText().equals(" ")) {
                clickedButton.setText(String.valueOf(currentPlayer));
                if (checkForWin()) {
                    JOptionPane.showMessageDialog(null, "Игрок " +
                            currentPlayer + " выиграл!");
                             resertGame();
                } else if (isBoardFull()) {
                    JOptionPane.showMessageDialog(null, "Ничья!");
                    resertGame();
                } else {
                    switchPlayer();
                }
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? '0' : 'X';
    }

    private boolean checkForWin() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRows() {
        for (int i = 0; i < 10; i++) {
            if (checkRowCol(
                    buttons[i][0].getText(),
                    buttons[i][1].getText(),
                    buttons[i][2].getText(),
                    buttons[i][3].getText(),
                    buttons[i][4].getText(),
                    buttons[i][5].getText(),
                    buttons[i][6].getText(),
                    buttons[i][7].getText(),
                    buttons[i][8].getText(),
                    buttons[i][9].getText())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 10; i++) {
            if (checkRowCol(
                    buttons[0][i].getText(),
                    buttons[1][i].getText(),
                    buttons[2][i].getText(),
                    buttons[3][i].getText(),
                    buttons[4][i].getText(),
                    buttons[5][i].getText(),
                    buttons[6][i].getText(),
                    buttons[7][i].getText(),
                    buttons[8][i].getText(),
                    buttons[9][i].getText())) {
                return true;
            }
        }
        return false;
    }
    private boolean checkDiagonals() {
        return checkRowCol(
                buttons[0][0].getText(),
                buttons[1][1].getText(),
                buttons[2][2].getText(),
                buttons[3][3].getText(),
                buttons[4][4].getText(),
                buttons[5][5].getText(),
                buttons[6][6].getText(),
                buttons[7][7].getText(),
                buttons[8][8].getText(),
                buttons[9][9].getText()) ||
                checkRowCol(
                        buttons[0][9].getText(),
                        buttons[1][8].getText(),
                        buttons[2][7].getText(),
                        buttons[3][6].getText(),
                        buttons[4][5].getText(),
                        buttons[5][4].getText(),
                        buttons[6][3].getText(),
                        buttons[7][2].getText(),
                        buttons[8][1].getText(),
                        buttons[9][0].getText());
            }
            private boolean checkRowCol(String val1,String val2,String val3,
                                        String val4, String val5,String val6,
                                        String val7,String val8,String val9, String val10) {
                return !val1.equals(" ") && val1.equals(val2) && val2.equals(val3 ) &&
                        val3.equals(val4) && val4.equals(val5)  && val5.equals(val6) &&
                        val6.equals(val7) && val7.equals(val8) && val8.equals(val9) &&
                        val9.equals(val10);
            }
                private boolean isBoardFull() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (buttons[i][j].getText().equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
    private void resertGame(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j].setText(" ");
            }
        }
        currentPlayer = 'X';
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToeGame());
    }
}






