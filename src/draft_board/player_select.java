package draft_board;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class player_select {
    private JFrame frame;
    private JList<String> players_list;
    private JLabel players_label;
    private JScrollPane scroll;
    private String path;
    private String line;
    private String[] players;


    public player_select() {
        path = "C:\\Users\\jordan\\workspace\\draft_board\\src\\draft_board\\fantasyPlayers.csv";
        line = "";
        {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(path));
                while (true) {
                    try {
                        if (!((line = br.readLine()) != null)) break;
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    String[] values = line.split(",");

                    players = new String[] {values[2] + " | " + values[3] + " | " + values[4]};
                    //System.out.println(Arrays.stream(players).toList());
                    System.out.println(players);


                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        frame = new JFrame("Players");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(335, 695);

        players_label = new JLabel("Choose Player");
        players_list = new JList<String>(players);
        players_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scroll = new JScrollPane(players_list);
        scroll.setPreferredSize(new Dimension(300, 600));



        String[] finalValues = players;
        players_list.addListSelectionListener(le -> {           // valueChanged is method.... ListSelectionEvent is object

            int index = players_list.getSelectedIndex();

            if (index != -1)
                players_label.setText("Team 1 Selects " + finalValues[index]);

        });

        frame.add(scroll);
        frame.add(players_label);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                new player_select();

            }
        });
    }
}
