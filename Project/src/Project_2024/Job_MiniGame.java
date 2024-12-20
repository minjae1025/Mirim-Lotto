package Project_2024;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.concurrent.CountDownLatch;

class Job_MiniGame {
    private JFrame frame = new JFrame("버튼을 순서대로 눌러보세요!");
    private JButton[] buttons = new JButton[10];
    private int nextNum = 1;
    private boolean gameWon = false;
    private CountDownLatch latch;
    ArrayList<Integer> numbers = new ArrayList<>();

    Job_MiniGame() {
        this.latch = new CountDownLatch(1);;
        initializeUI();
    }

    void initializeUI() {
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 5)); // 2 rows, 5 columns
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        for (int i = 0; i < 10; i++) {
            int number = numbers.get(i);
            buttons[i] = new JButton(String.valueOf(number));
            buttons[i].setFont(new Font("Arial", Font.BOLD, 20));

            // ActionListener 추가
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ButtonClick(number, (JButton) e.getSource());
                }
            });

            panel.add(buttons[i]);
        }

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(400, 200);
    }

    void ButtonClick(int buttonNum, JButton button) {
        if (buttonNum == nextNum) {
            button.setEnabled(false); // 버튼 비활성화
            nextNum++;
            if (nextNum > 10) {
                gameWon = true;
                JOptionPane.showMessageDialog(frame, "알바를 성공적으로 완수하셨습니다! 10000원이 지급되었습니다!");
                frame.dispose(); // 창 닫기
                latch.countDown(); // 게임 종료 신호
            }
        } else {
            gameWon = false;
            JOptionPane.showMessageDialog(frame, "알바도중 실수를 하셔서 손해배상금 10000원이 지불되었습니다.");
            frame.dispose(); // 창 닫기
            latch.countDown(); // 게임 종료 신호
        }
    }

    public void show() {
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.requestFocus();
        frame.setState(Frame.NORMAL);
        JOptionPane.showMessageDialog(frame, "버튼을 1부터 순서대로 누르시면 알바비가 지급됩니다.");
    }

    public boolean isGameWon() {
        return gameWon;
    }
    
    public void awaitGameEnd() throws InterruptedException {
        latch.await(); // 게임이 끝날 때까지 대기
    }
}
