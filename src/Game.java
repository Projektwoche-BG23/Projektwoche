import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//version 1.0

public class Game {
    public JFrame frame;
    public JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    public JLabel titleNameLabel;
    public JButton startButton, ladenButton, einstellungenButton, verlassenButton;
    public JButton choiceButton1, choiceButton2, choiceButton3, choiceButton4;
    public JTextArea mainTextArea;
    public TitleScreenHandler tsHandler = new TitleScreenHandler();
    public ChoiceHandler choiceHandler = new ChoiceHandler();

    /**
     * Dies sind die Schriftarten. Nach belieben ändern
     */

    public Font titleFont = new Font("Times New Roman", Font.PLAIN, 170);
    public Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    public Font startButtonFont = new Font("Times New Roman", Font.PLAIN, 50);

    /**
     * Dies gibt die Position in der Story ein. Wichtig für ChoiceHandler
     */
    String position;

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

        startGame();


    }

    public void startGame() {
        position = "anfangsSzene";
        mainTextArea.setText("The year 384 of the 534 cycle in the kingdom of Possehl.\n" +
                             "The great royal family Seidler has ruled the land for 13 cycles.\n" +
                             "For years the country has been struggling with the brutal rule of the 13th King Heuer.\n");
        choiceButton1.setText("Weiter");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void anfangsSzene(){
        position = "anfangsSzene2";
        mainTextArea.setText("But there is hope the only person who can save the KING's city\n"+
                             "and the country can save is the one true blood heir to the throne princess Seidler\n" +
                             "but she was driven out some time ago by the corrupt powers of the land.\n" +
                             "Seidler’s location is unknown find and bring her back to save the country.\n");
        choiceButton1.setText("Weiter");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void tavernSzene(){
        position = "tavern";
        mainTextArea.setText("A drunken knight steps forward \n" +
                "Drunken knight:What are you doing here, you haven't been a knight for a long time\n" +
                "Drunken knight:Didn't I tell you never to show your face here again\n" +
                "Drunken knight:You left me behind\n" +
                "Drunken knight:GET OUT OF THIS TOWN NOW");
        choiceButton1.setText("...");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void tavernSzene2(){
        position = "tavern2";
        mainTextArea.setText("Drunken knight: Wrong answer");
        choiceButton1.setText("FIGHT");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }


    private class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }






//LEtssas
    private class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            /**
             * Der erste Switch erfasst den Ort/ die Szene in der, der Spieler gerade ist. Für jede Szene gibt
             * es mehrere Antworten die mit einem weiteren Switch Statement erfasst werden
             * Pro ausgewählter Option gibt es verschieden Methoden die dann aufgerufen werden.
             */

            switch (position) {
                case "anfangsSzene":
                    switch (yourChoice) {
                        case "c1":
                            anfangsSzene();
                            break;
                        case "c2": break;
                        case "c3": break;
                        case "c4": break;
                    }
                    break;

                case "anfangsSzene2":
                    switch (yourChoice) {
                        case "c1":
                            tavernSzene();
                            break;
                        case "c2": break;
                        case "c3": break;
                        case "c4": break;
                    }
                    break;
                case "tavern":
                    switch (yourChoice) {
                        case "c1":
                            tavernSzene2();
                            break;
                        case "c2": break;
                        case "c3": break;
                        case "c4": break;
                    }
                case "tavern2":
                    switch (yourChoice) {
                        case "c1":
                            //Füge Kampf Methode hier ein
                            break;
                        case "c2": break;
                        case "c3": break;
                        case "c4": break;
                    }
            }
        }
    }
    private class deathScreenHandler {
    }}

