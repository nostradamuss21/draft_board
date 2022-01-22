package draft_board;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class timer implements ActionListener {

    // Countdown Timer Variables

    public JFrame frame;
    public JPanel panel;
    public JLabel timeLabel, countdown_label;
    public JButton startButton;
    public JButton resetButton;
    int timeLeft = 90000;
    int seconds = 30;
    int minutes = 1;
    int hours = 0;
    int milliseconds = 0;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);
    String milliseconds_string = String.format("%03d", milliseconds);
    boolean started = false;

    Timer timer = new Timer(0, new ActionListener() {
        private ListSelectionEvent le;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (timeLeft > 20000) {
                timeLeft = timeLeft - 15;
                hours = (timeLeft / 3600000);
                minutes = (timeLeft / 60000)%60;
                seconds = (timeLeft / 1000)%60;
                milliseconds = (timeLeft)%1000;
                String seconds_string = String.format("%02d", seconds);
                String minutes_string = String.format("%02d", minutes);
                String hours_string = String.format("%02d", hours);
                String milliseconds_string = String.format("%03d", milliseconds);
                timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milliseconds_string);
            } else if (timeLeft > 10000) {
                timeLeft = timeLeft - 15;
                hours = (timeLeft / 3600000);
                minutes = (timeLeft / 60000)%60;
                seconds = (timeLeft / 1000)%60;
                milliseconds = (timeLeft)%1000;
                String seconds_string = String.format("%02d", seconds);
                String minutes_string = String.format("%02d", minutes);
                String hours_string = String.format("%02d", hours);
                String milliseconds_string = String.format("%03d", milliseconds);
                timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milliseconds_string);
                timeLabel.setBackground(Color.ORANGE);
                startButton.setBackground(Color.ORANGE);
                resetButton.setBackground(Color.ORANGE);
                countdown_label.setBackground(Color.ORANGE);
                panel.setBackground(Color.ORANGE);
            } else if (timeLeft > 5000) {
                timeLeft = timeLeft - 15;
                hours = (timeLeft / 3600000);
                minutes = (timeLeft / 60000) % 60;
                seconds = (timeLeft / 1000) % 60;
                milliseconds = (timeLeft) % 1000;
                String seconds_string = String.format("%02d", seconds);
                String minutes_string = String.format("%02d", minutes);
                String hours_string = String.format("%02d", hours);
                String milliseconds_string = String.format("%03d", milliseconds);
                timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milliseconds_string);
                timeLabel.setBackground(Color.RED);
                startButton.setBackground(Color.RED);
                resetButton.setBackground(Color.RED);
                countdown_label.setBackground(Color.RED);
                panel.setBackground(Color.RED);
            } else {
                timeLeft = 0;
                hours = 0;
                minutes = 0;
                seconds = 0;
                milliseconds = 0;
                String seconds_string = String.format("%02d", seconds);
                String minutes_string = String.format("%02d", minutes);
                String hours_string = String.format("%02d", hours);
                String milliseconds_string = String.format("%03d", milliseconds);
                timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milliseconds_string);
            }
        }
    });

    public timer(){

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(2000, 1050);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        frame.add(panel);

        timeLabel = new JLabel();
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milliseconds_string);
        timeLabel.setBounds(20,50,320, 75);
        timeLabel.setBackground(Color.CYAN);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(0));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        panel.add(timeLabel);

        startButton = new JButton("Start");
        startButton.setBounds(20,125,160, 50);
        startButton.setBackground(Color.LIGHT_GRAY);
        startButton.setFont(new Font("Ink Free", Font.BOLD, 20));
        startButton.setBorder(BorderFactory.createBevelBorder(0));
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        panel.add(startButton);

        resetButton = new JButton("Reset");
        resetButton.setBounds(180,125,160, 50);
        resetButton.setBackground(Color.LIGHT_GRAY);
        resetButton.setFont(new Font("Ink Free", Font.BOLD, 20));
        resetButton.setBorder(BorderFactory.createBevelBorder(0));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        panel.add(resetButton);

        countdown_label = new JLabel("Time on the Clock");
        countdown_label.setBounds(20,5,320, 45);
        countdown_label.setBackground(Color.BLUE);
        countdown_label.setFont(new Font("Ink Free", Font.BOLD, 30));
        countdown_label.setBorder(BorderFactory.createBevelBorder(0));
        countdown_label.setOpaque(true);
        countdown_label.setHorizontalAlignment(JTextField.CENTER);
        panel.add(countdown_label);
    }
    // Countdown Timer Logic
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if (started == false) {
                started = true;
                startButton.setText("STOP");
                startButton.setBackground(Color.GRAY);
                start();
            } else {
                started = false;
                startButton.setText("START");
                startButton.setBackground(Color.LIGHT_GRAY);
                stop();
            }
        } else if (e.getSource() == resetButton) {
            started = true;
            resetButton.setText("RESET");
            reset();
        }
    }
    // Method ActionEvents Attributed to Timer Buttons
    void start() {
        timer.start();}
    void stop() {
        timer.stop();
    }
    void reset() {
        timer.stop();
        timeLeft = 90000;
        milliseconds = 0;
        seconds = 30;
        minutes = 1;
        hours = 0;
        String seconds_string = String.format("%02d", seconds);
        String minutes_string = String.format("%02d", minutes);
        String hours_string = String.format("%02d", hours);
        String milliseconds_string = String.format("%03d", milliseconds);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milliseconds_string);
        timeLabel.setBackground(Color.CYAN);
        startButton.setBackground(Color.LIGHT_GRAY);
        resetButton.setBackground(Color.LIGHT_GRAY);
        countdown_label.setBackground(Color.BLUE);
    }
}
