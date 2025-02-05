import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;


public class Game {
    JFrame frame;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, healtbartextpanel, waffentextpanel;
    JLabel titleNameLabel, healtbartext, waffentext;
    JButton startButton, ladenButton, einstellungenButton, verlassenButton;
    JButton choiceButton1, choiceButton2, choiceButton3, choiceButton4;
    JTextArea mainTextArea;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    /**
     * Dies sind die Leben.
     */
    int healt;

    /**
     * Dies ist die aktuelle Waffe die von dem Spieler verwendet wird.
     */
    String waffe = "Fists";

    /**
     * Dies ist die Position des Spielers
     */

    String position;


    /**
     * Dies sind die Schriftarten. Nach belieben ändern
     */

    Font titleFont = new Font("Times New Roman", Font.PLAIN, 170);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font startButtonFont = new Font("Times New Roman", Font.PLAIN, 50);

    /**
     * Dies gibt die Position in der Story ein. Wichtig für ChoiceHandler
     */
    String playerPosition = "Intro";

    /**
     * @Game Titelbildschirm des Spieles
     */

    public Game() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * Dies ist der Hauptframe, auf dem alle anderen Frames hinzugefügt werden.
         */

        frame = new JFrame();
        frame.setSize(1600, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(23, 32, 56));
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        /**
         * Dieses Panel ist für das anzeigen des Titels
         */

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(0, 100, 1600, 300);
        titleNamePanel.setBackground(new Color(23, 32, 56));
        frame.add(titleNamePanel);

        /**
         * Dieses Label ist der Titel
         */

        titleNameLabel = new JLabel("(Spiel Name)", SwingConstants.CENTER);
        titleNameLabel.setForeground(new Color(222, 158,65));
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        /**
         * Healtbar Anzeige.
         */

        healtbartextpanel = new JPanel();
        healtbartextpanel.setBackground(new Color(23, 32, 56));
        healtbartextpanel.setBounds(0, 10, 800, 100);
        frame.add(healtbartextpanel);

        healtbartext = new JLabel("Player Health: "+healt, SwingConstants.CENTER);
        healtbartext.setForeground(new Color(222, 158,65));
        healtbartext.setFont(normalFont);
        healtbartext.setBackground(new Color(23, 32, 56));
        healtbartext.setBounds(0, 10, 100, 100);
        healtbartextpanel.add(healtbartext);
        healtbartext.setVisible(false);

        /**
         * Waffen anzeige.
         */

        waffentextpanel = new JPanel();
        waffentextpanel.setBackground(new Color(23, 32, 56));
        waffentextpanel.setBounds(800, 10, 800, 100);
        frame.add(waffentextpanel);

        waffentext = new JLabel("Current Weapon: "+waffe, SwingConstants.CENTER);
        waffentext.setForeground(new Color(222, 158,65));
        waffentext.setFont(normalFont);
        waffentext.setBackground(new Color(23, 32, 56));
        waffentext.setBounds(0, 10, 100, 100);
        waffentextpanel.add(waffentext);
        waffentext.setVisible(false);


        /**
         * Dies Panel bietet Platz für die Buttons des Titelscreens
         */

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 450, 1000, 350);
        startButtonPanel.setBackground(new Color(23, 32, 56));
        startButtonPanel.setLayout(new GridLayout(4,1));

        /**
         * Dies ist für das Anzeigen des Start-Buttons
         */

        startButton = new JButton("Start");
        startButton.setBackground(new Color(23, 32, 56));
        startButton.setForeground(new Color(222, 158,65));
        startButton.setFont(startButtonFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);
        startButtonPanel.add(startButton);

        ladenButton = new JButton("Laden");
        ladenButton.setBackground(new Color(23, 32, 56));
        ladenButton.setForeground(new Color(222, 158,65));
        ladenButton.setFont(startButtonFont);
        //Action Listener hinzufügen für Funktion
        startButtonPanel.add(ladenButton);

        einstellungenButton = new JButton("Einstellungen");
        einstellungenButton.setBackground(new Color(23, 32, 56));
        einstellungenButton.setForeground(new Color(222, 158,65));
        einstellungenButton.setFont(startButtonFont);
        //Action Listener hinzufügen für Funktion
        startButtonPanel.add(einstellungenButton);

        verlassenButton = new JButton("Verlassen");
        verlassenButton.setBackground(new Color(23, 32, 56));
        verlassenButton.setForeground(new Color(222, 158,65));
        verlassenButton.setFont(startButtonFont);
        //Action Listener hinzufügen für Funktion
        startButtonPanel.add(verlassenButton);


        frame.add(titleNamePanel);
        frame.add(startButtonPanel);
        frame.setVisible(true);
    }

    /**
     * @createGameScreen Hauptbildschirm des Spieles, wo der Spieler seine Optionen auswählt
     */
    public void createGameScreen() {
        /**
         * Löscht den Vorherigen Inhalt
         */
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        waffentext.setVisible(true);
        healtbartext.setVisible(true);

        /**
         * Dies Panel beinhaltet das Dialog Feld
         */
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,1400, 200);
        mainTextPanel.setBackground(new Color(23, 32, 56));
        frame.add(mainTextPanel);

        /**
         * Hier wird der Dialog angezeigt
         */

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(0, 0, 1400, 200);
        mainTextArea.setBackground(new Color(23, 32, 56));
        mainTextArea.setForeground(new Color(222, 158,65));
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(false);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextArea.setOpaque(false);
        mainTextPanel.add(mainTextArea);

        /**
         * Dies Feld beinhaltet die Buttons
         */

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(90, 630, 1400, 200);
        choiceButtonPanel.setBackground(new Color(23, 32, 56));
        choiceButtonPanel.setLayout(new GridLayout(2, 2, 10, 10));
        frame.add(choiceButtonPanel);

        choiceButton1 = new JButton();
        choiceButton1.setBackground(new Color(23, 32, 56));
        choiceButton1.setForeground(new Color(222, 158,65));
        choiceButton1.setFont(normalFont);
        choiceButton1.addActionListener(new ChoiceHandler());
        choiceButton1.setFocusPainted(false);
        choiceButton1.setActionCommand("c1");
        choiceButton1.addActionListener(choiceHandler);
        choiceButtonPanel.add(choiceButton1);

        choiceButton2 = new JButton();
        choiceButton2.setBackground(new Color(23, 32, 56));
        choiceButton2.setForeground(new Color(222, 158,65));
        choiceButton2.setFont(normalFont);
        choiceButton2.addActionListener(new ChoiceHandler());
        choiceButton2.setFocusPainted(false);
        choiceButton2.setActionCommand("c2");
        choiceButton2.addActionListener(choiceHandler);
        choiceButtonPanel.add(choiceButton2);

        choiceButton3 = new JButton();
        choiceButton3.setBackground(new Color(23, 32, 56));
        choiceButton3.setForeground(new Color(222, 158,65));
        choiceButton3.setFont(normalFont);
        choiceButton3.addActionListener(new ChoiceHandler());
        choiceButton3.setFocusPainted(false);
        choiceButton3.setActionCommand("c3");
        choiceButton3.addActionListener(choiceHandler);
        choiceButtonPanel.add(choiceButton3);

        choiceButton4 = new JButton();
        choiceButton4.setBackground(new Color(23, 32, 56));
        choiceButton4.setForeground(new Color(222, 158,65));
        choiceButton4.setFont(normalFont);
        choiceButton4.addActionListener(new ChoiceHandler());
        choiceButton4.setFocusPainted(false);
        choiceButton4.setActionCommand("c4");
        choiceButton4.addActionListener(choiceHandler);
        choiceButtonPanel.add(choiceButton4);



        /**
         * Dies Panel beinaltet die Stats des Spielers
         */

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(new Color(23, 32, 56));
        playerPanel.setLayout(new GridLayout(1, 4));
        frame.add(playerPanel);
        anfangsSzene1();
    }

    public void anfangsSzene1() {
        position = "AnfangsSzene";
        mainTextArea.setText("The year 384 of the (.) cycle in the kingdom of (placeholder). The great royal family Seidler has\n" +
                "ruled the land for 13 cycles. For years the country has been struggling with the brutal rule of the\n" +
                "13th King Thomas von Seidler. But there is hope the only person who can save the KING's city\n");
        choiceButton1.setText("Weiter");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void anfangsSzene2(){
        position = "AnfangsSzene2";
        mainTextArea.setText("and the country .... can save is the one true blood heir to the throne (name of princess) but she\n" +
                "was driven out some time ago by the corrupt powers of the land. (name of princess)s location is\n" +
                "unknown nd and bring her back to save the country. \n");
        choiceButton1.setText("Weiter");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cheapterOneCenter(){
        position = "Stadtmitte";
        mainTextArea.setText("Player is in a tavern in the center of the kingdom (name of the kingdom)");
        choiceButton1.setText("Weiter");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }


    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            /**
             * Der erste Switch erfasst den Ort/ die Szene in der, der Spieler gerade ist. Für jede Szene gibt
             * es mehrere Antworten die mit einem weiteren Switch Statement erfasst werden
             * Pro asgewählter Option gibt es verschieden Methoden die dann aufgerufen werden.
             */

            switch (position) {
                case "AnfangsSzene":
                    switch (yourChoice) {
                        case "c1":
                            anfangsSzene2();
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "AnfangsSzene2":
                    switch (yourChoice) {
                        case "c1":
                            cheapterOneCenter();
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;

                    }
                    break;

                case "CityCenter":
                    switch (yourChoice) {
                        case "c1":
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;
            }
        }
    }
}