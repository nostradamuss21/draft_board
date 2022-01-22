package draft_board;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class draft_board extends timer implements ActionListener {

// Initial Proclamation of Variables; for Both Inputs & Outputs

// Find a Way to Separate the Topics into Separate Classes
    // Try to Identify Characters Using Object Templates That Produce Instances
    public JFrame frame;
    public JPanel panel;
    // General Layout of Information
    public JLabel onTheClock_label, round_label, overallPick_label, draftConclusion_label, team1label, team2label,
            team3label, team4label, team5label, team6label, team7label, team8label, team9label, team10label, team1label_header,
            team2label_header, team3label_header, team4label_header, team5label_header, team6label_header, team7label_header,
            team8label_header, team9label_header, team10label_header;
    private JButton confirmPick_button;
    private int count = 0;
    private int team = 0;
    private int round = 1;
    private int pick = 0;
    private int year = 2022;
    private String champ = "NostradaMuss";
    private String team1 = "NostradaMuss";
    private String team2 = "DaltonSucksBigDongs";
    private String team3 = "Can\'t Guard Big Mike";
    private String team4 = "Hangin\' with Mahomies";
    private String team5 = "Jackson 5";
    private String team6 = "Momma Mac";
    private String team7 = "Evan Al-Fragile";
    private String team8 = "School of Kunard Knocks";
    private String team9 = "Generic Team";
    private String team10 = "One Child Left Behind";

// Display Settings for Buttons, Labels, Lists, etc

    public draft_board() {

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(2000, 1050);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        frame.add(panel);


        confirmPick_button = new JButton("Begin Draft");
        confirmPick_button.setBounds(20, 180,320,105);
        confirmPick_button.setBackground(Color.GREEN);
        confirmPick_button.setFont(new Font("Verdana", Font.BOLD, 30));
        confirmPick_button.setBorder(BorderFactory.createBevelBorder(0));
        confirmPick_button.setOpaque(true);
        confirmPick_button.setHorizontalAlignment(JTextField.CENTER);
        confirmPick_button.addActionListener(this);
        panel.add(confirmPick_button);

        onTheClock_label = new JLabel("Team: " + (team+1) + " Has the First Overall Pick");
        onTheClock_label.setBounds(355, 5, 500, 65);
        onTheClock_label.setBackground(Color.LIGHT_GRAY);
        onTheClock_label.setFont(new Font("Verdana", Font.BOLD, 20));
        onTheClock_label.setBorder(BorderFactory.createBevelBorder(0));
        onTheClock_label.setOpaque(true);
        onTheClock_label.setHorizontalAlignment(JTextField.CENTER);
        panel.add(onTheClock_label);

        round_label = new JLabel("Reigning Champ: Team " + champ);
        round_label.setBounds(855, 5, 500, 65);
        round_label.setBackground(Color.LIGHT_GRAY);
        round_label.setFont(new Font("Verdana", Font.BOLD, 20));
        round_label.setBorder(BorderFactory.createBevelBorder(0));
        round_label.setOpaque(true);
        round_label.setHorizontalAlignment(JTextField.CENTER);
        panel.add(round_label);

        overallPick_label = new JLabel(year + " Tinker Time League Fantasy Draft");
        overallPick_label.setBounds(1355, 5, 500, 65);
        overallPick_label.setBackground(Color.LIGHT_GRAY);
        overallPick_label.setFont(new Font("Verdana", Font.BOLD, 20));
        overallPick_label.setBorder(BorderFactory.createBevelBorder(0));
        overallPick_label.setOpaque(true);
        overallPick_label.setHorizontalAlignment(JTextField.CENTER);
        panel.add(overallPick_label);

        team1label = new JLabel(team1);
        team1label.setBounds(355, 115, 150, 60);
        team1label.setBackground(Color.WHITE);
        team1label.setFont(new Font("Verdana", Font.PLAIN, 12));
        team1label.setBorder(BorderFactory.createBevelBorder(1));
        team1label.setOpaque(true);
        team1label.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team1label);

        team1label_header = new JLabel("Team 1");
        team1label_header.setBounds(355, 70, 150, 45);
        team1label_header.setBackground(Color.WHITE);
        team1label_header.setFont(new Font("Verdana", Font.PLAIN, 12));
        team1label_header.setBorder(BorderFactory.createBevelBorder(1));
        team1label_header.setOpaque(true);
        team1label_header.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team1label_header);

        team2label = new JLabel(team2);
        team2label.setBounds(505, 115, 150, 60);
        team2label.setBackground(Color.WHITE);
        team2label.setFont(new Font("Verdana", Font.PLAIN, 12));
        team2label.setBorder(BorderFactory.createBevelBorder(1));
        team2label.setOpaque(true);
        team2label.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team2label);

        team2label_header = new JLabel("Team 2");
        team2label_header.setBounds(505, 70, 150, 45);
        team2label_header.setBackground(Color.WHITE);
        team2label_header.setFont(new Font("Verdana", Font.PLAIN, 12));
        team2label_header.setBorder(BorderFactory.createBevelBorder(1));
        team2label_header.setOpaque(true);
        team2label_header.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team2label_header);

        team3label = new JLabel(team3);
        team3label.setBounds(655, 115, 150, 60);
        team3label.setBackground(Color.WHITE);
        team3label.setFont(new Font("Verdana", Font.PLAIN, 12));
        team3label.setBorder(BorderFactory.createBevelBorder(1));
        team3label.setOpaque(true);
        team3label.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team3label);

        team3label_header = new JLabel("Team 3");
        team3label_header.setBounds(655, 70, 150, 45);
        team3label_header.setBackground(Color.WHITE);
        team3label_header.setFont(new Font("Verdana", Font.PLAIN, 12));
        team3label_header.setBorder(BorderFactory.createBevelBorder(1));
        team3label_header.setOpaque(true);
        team3label_header.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team3label_header);

        team4label = new JLabel(team4);
        team4label.setBounds(805, 115, 150, 60);
        team4label.setBackground(Color.WHITE);
        team4label.setFont(new Font("Verdana", Font.PLAIN, 12));
        team4label.setBorder(BorderFactory.createBevelBorder(1));
        team4label.setOpaque(true);
        team4label.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team4label);

        team4label_header = new JLabel("Team 4");
        team4label_header.setBounds(805, 70, 150, 45);
        team4label_header.setBackground(Color.WHITE);
        team4label_header.setFont(new Font("Verdana", Font.PLAIN, 12));
        team4label_header.setBorder(BorderFactory.createBevelBorder(1));
        team4label_header.setOpaque(true);
        team4label_header.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team4label_header);

        team5label = new JLabel(team5);
        team5label.setBounds(955, 115, 150, 60);
        team5label.setBackground(Color.WHITE);
        team5label.setFont(new Font("Verdana", Font.PLAIN, 12));
        team5label.setBorder(BorderFactory.createBevelBorder(1));
        team5label.setOpaque(true);
        team5label.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team5label);

        team5label_header = new JLabel("Team 5");
        team5label_header.setBounds(955, 70, 150, 45);
        team5label_header.setBackground(Color.WHITE);
        team5label_header.setFont(new Font("Verdana", Font.PLAIN, 12));
        team5label_header.setBorder(BorderFactory.createBevelBorder(1));
        team5label_header.setOpaque(true);
        team5label_header.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team5label_header);

        team6label = new JLabel(team6);
        team6label.setBounds(1105, 115, 150, 60);
        team6label.setBackground(Color.WHITE);
        team6label.setFont(new Font("Verdana", Font.PLAIN, 12));
        team6label.setBorder(BorderFactory.createBevelBorder(1));
        team6label.setOpaque(true);
        team6label.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team6label);

        team6label_header = new JLabel("Team 6");
        team6label_header.setBounds(1105, 70, 150, 45);
        team6label_header.setBackground(Color.WHITE);
        team6label_header.setFont(new Font("Verdana", Font.PLAIN, 12));
        team6label_header.setBorder(BorderFactory.createBevelBorder(1));
        team6label_header.setOpaque(true);
        team6label_header.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team6label_header);

        team7label = new JLabel(team7);
        team7label.setBounds(1255, 115, 150, 60);
        team7label.setBackground(Color.WHITE);
        team7label.setFont(new Font("Verdana", Font.PLAIN, 12));
        team7label.setBorder(BorderFactory.createBevelBorder(1));
        team7label.setOpaque(true);
        team7label.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team7label);

        team7label_header = new JLabel("Team 7");
        team7label_header.setBounds(1255, 70, 150, 45);
        team7label_header.setBackground(Color.WHITE);
        team7label_header.setFont(new Font("Verdana", Font.PLAIN, 12));
        team7label_header.setBorder(BorderFactory.createBevelBorder(1));
        team7label_header.setOpaque(true);
        team7label_header.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team7label_header);

        team8label = new JLabel(team8);
        team8label.setBounds(1405, 115, 150, 60);
        team8label.setBackground(Color.WHITE);
        team8label.setFont(new Font("Verdana", Font.PLAIN, 12));
        team8label.setBorder(BorderFactory.createBevelBorder(1));
        team8label.setOpaque(true);
        team8label.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team8label);

        team8label_header = new JLabel("Team 8");
        team8label_header.setBounds(1405, 70, 150, 45);
        team8label_header.setBackground(Color.WHITE);
        team8label_header.setFont(new Font("Verdana", Font.PLAIN, 12));
        team8label_header.setBorder(BorderFactory.createBevelBorder(1));
        team8label_header.setOpaque(true);
        team8label_header.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team8label_header);

        team9label = new JLabel(team9);
        team9label.setBounds(1555, 115, 150, 60);
        team9label.setBackground(Color.WHITE);
        team9label.setFont(new Font("Verdana", Font.PLAIN, 12));
        team9label.setBorder(BorderFactory.createBevelBorder(1));
        team9label.setOpaque(true);
        team9label.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team9label);

        team9label_header = new JLabel("Team 9");
        team9label_header.setBounds(1555, 70, 150, 45);
        team9label_header.setBackground(Color.WHITE);
        team9label_header.setFont(new Font("Verdana", Font.PLAIN, 12));
        team9label_header.setBorder(BorderFactory.createBevelBorder(1));
        team9label_header.setOpaque(true);
        team9label_header.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team9label_header);

        team10label = new JLabel(team10);
        team10label.setBounds(1705, 115, 150, 60);
        team10label.setBackground(Color.WHITE);
        team10label.setFont(new Font("Verdana", Font.PLAIN, 12));
        team10label.setBorder(BorderFactory.createBevelBorder(1));
        team10label.setOpaque(true);
        team10label.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team10label);

        team10label_header = new JLabel("Team 10");
        team10label_header.setBounds(1705, 70, 150, 45);
        team10label_header.setBackground(Color.WHITE);
        team10label_header.setFont(new Font("Verdana", Font.PLAIN, 12));
        team10label_header.setBorder(BorderFactory.createBevelBorder(1));
        team10label_header.setOpaque(true);
        team10label_header.setHorizontalAlignment(JTextField.CENTER);
        panel.add(team10label_header);

        draftConclusion_label = new JLabel("Welcome to the " + year + " Tinker Time League Annual Fantasy Football Draft. Good Luck!!");
        draftConclusion_label.setBounds(355, 175, 1500, 800);
        draftConclusion_label.setBackground(Color.LIGHT_GRAY);
        draftConclusion_label.setFont(new Font("Ink Free", Font.PLAIN, 40));
        draftConclusion_label.setBorder(BorderFactory.createBevelBorder(1));
        draftConclusion_label.setOpaque(true);
        draftConclusion_label.setHorizontalAlignment(JTextField.CENTER);
        panel.add(draftConclusion_label);
    }

// Snake Loop Functionality Logic to Determine Team That's On the Clock

// To Return Name of Team Currently on the Clock Use One of the Following Logical Structures
    // string value is the return value of variable count
    // add count to string to create searchable string value
    // search for identifiable string variable associated with team's name
    // if statement asking for a true/false value
    // do/while statement that thru loops team names
    // function checks team name input against source to determine
    // valueChanged is method.... ListSelectionEvent is object

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmPick_button) {
            if (count == 10 || count == 20 || count == 30 || count == 40 || count == 50 || count == 60 || count == 70 || count == 80 || count == 90 ||
                    count == 100 || count == 110 || count == 120 || count == 130 || count == 140 || count == 150) {
                team += 0;
                pick++;
                round++;
                onTheClock_label.setText("On the Clock: Team " + team);
                round_label.setText("Round: " + round);
                overallPick_label.setText("Overall Draft Pick: " + pick);
            } else if (count < 10 || (count > 20 && count < 30) || (count > 40 && count < 50) || (count > 60 && count < 70) || (count > 80 && count < 90) ||
                    (count > 100 && count < 110) || (count > 120 && count < 130) || (count > 140 && count < 150)) {
                team++;
                pick++;
                confirmPick_button.setText("Confirm Selection");
                onTheClock_label.setText("On the Clock: Team " + team);
                round_label.setText("Round: " + round);
                overallPick_label.setText("Overall Draft Pick: " + pick);
                draftConclusion_label.setText("");
            } else if (count < 20 || (count > 30 && count < 40) || (count > 50 && count < 60) || (count > 70 && count < 80) || (count > 90 && count < 100) ||
                    (count > 110 && count < 120) || (count > 130 && count < 140)) {
                team--;
                pick++;
                onTheClock_label.setText("On the Clock: Team " + team);
                round_label.setText("Round: " + round);
                overallPick_label.setText("Overall Draft Pick: " + pick);
            }
            select();
        }
    }
// Method ActionEvents for Value Determining Team that's Currently On the Clock
    void select() {
        count++;
    }
}
