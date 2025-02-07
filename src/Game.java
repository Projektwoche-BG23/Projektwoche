
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    public JFrame frame;
    JPanel potionScreenButtonPanel, enemyHealtbartextpanel, titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, healtbartextpanel, waffentextpanel, playerPositionPanel, playerPositionPanel2, waffentextpanel2;
    JLabel enemyHealtbartext, titleNameLabel, healtbartext, waffentext, playerPositiontext, playerPositiontext2, waffentext2, playerHealthTExt;
    public JButton strengthPotionButton, manaPotionButton, healthPotionButton, startButton, ladenButton, einstellungenButton, verlassenButton, attackButton, magicButton,itemButton;
    public JButton choiceButton1, choiceButton2, choiceButton3, choiceButton4;
    JPanel ImagePanel,fightScreenButtonPanel;
    public JTextArea mainTextArea;
    public TitleScreenHandler tsHandler = new TitleScreenHandler();
    public ChoiceHandler choiceHandler = new ChoiceHandler();
    Player c = new Player();
    RechnerKampf rk = new RechnerKampf();


    private Clip clip;
    private FloatControl volumeControl;
    private boolean isMuted = false;
    /**
     * Dies sind die Schriftarten. Nach belieben ändern.
     */

    public Font titleFont = new Font("Times New Roman", Font.PLAIN, 170);
    public Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    public Font startButtonFont = new Font("Times New Roman", Font.PLAIN, 50);

    /**
     * Dies gibt die Position in der Story ein. Wichtig für ChoiceHandler.
     */

    String position;

    /**
     * Die Variable waffe ist für die ausgewählte Waffe verantwortlich.
     */

    String waffe = "Fists";

    /**
     * Die Variable health ist für die Leben die der Spieler hat verantwortlich,.
     */

    int health = c.getHealth();

    /**
     * Die Variable playerPosition ist für den Standort verantwortlich wo der Spiler sich gerade im Spiel befindet.
     */
    String playerPosition = "Intro";

    /**
     * @Game Titelbildschirm des Spieles
     */


    public Game(int playerID) {
        //  initializeMusic();
        //initializeMusic();
        System.out.println(playerID);
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
        titleNameLabel.setForeground(new Color(222, 158, 65));
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        /**
         * Dies Panel bietet Platz für die Buttons des Titelscreens
         */

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 450, 1000, 350);
        startButtonPanel.setBackground(new Color(23, 32, 56));
        startButtonPanel.setLayout(new GridLayout(4, 1));

        /**
         * Dies ist für das Anzeigen des Start-Buttons us
         */

        startButton = new JButton("Start");
        startButton.setBackground(new Color(23, 32, 56));
        startButton.setForeground(new Color(222, 158, 65));
        startButton.setFont(startButtonFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);
        startButtonPanel.add(startButton);

        ladenButton = new JButton("Laden");
        ladenButton.setBackground(new Color(23, 32, 56));
        ladenButton.setForeground(new Color(222, 158, 65));
        ladenButton.setFont(startButtonFont);
        //Action Listener hinzufügen für Funktion
        startButtonPanel.add(ladenButton);

        einstellungenButton = new JButton("Einstellungen");
        einstellungenButton.setBackground(new Color(23, 32, 56));
        einstellungenButton.setForeground(new Color(222, 158, 65));
        einstellungenButton.setFont(startButtonFont);
        //Action Listener hinzufügen für Funktion
        startButtonPanel.add(einstellungenButton);

        einstellungenButton.addActionListener(new ActionListener() {
            //Action Listener hinzufügen für Funktion
            @Override
            public void actionPerformed(ActionEvent e) {
                showSettings();
            }
        });

        verlassenButton = new JButton("Verlassen");
        verlassenButton.setBackground(new Color(23, 32, 56));
        verlassenButton.setForeground(new Color(222, 158, 65));
        verlassenButton.setFont(startButtonFont);
        //Action Listener hinzufügen für Funktion
        startButtonPanel.add(verlassenButton);


        verlassenButton.addActionListener(new ActionListener() {
            //Action Listener hinzufügen für Funktion
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });



        /**
         * Dies ist die Healtbar
         */

        healtbartextpanel = new JPanel();
        healtbartextpanel.setBackground(new Color(23, 32, 56));
        healtbartextpanel.setBounds(0, 10, 250, 100);
        frame.add(healtbartextpanel);

        healtbartext = new JLabel("Player Health: " + health, SwingConstants.CENTER);
        healtbartext.setForeground(new Color(222, 158, 65));
        healtbartext.setFont(normalFont);
        healtbartextpanel.add(healtbartext);
        healtbartext.setVisible(false);

        enemyHealtbartextpanel = new JPanel();
        enemyHealtbartextpanel.setBackground(new Color(23, 32, 56));
        enemyHealtbartextpanel.setBounds(0, 20, 250, 100);
        frame.add(enemyHealtbartextpanel);

        enemyHealtbartext = new JLabel("Enemy Health: " + health, SwingConstants.CENTER);
        enemyHealtbartext.setForeground(new Color(222, 158, 65));
        enemyHealtbartext.setFont(normalFont);
        enemyHealtbartextpanel.add(enemyHealtbartext);
        enemyHealtbartext.setVisible(false);

        /**
         * Dies ist die Waffenanzeige
         */

        waffentextpanel = new JPanel();
        waffentextpanel.setBackground(new Color(23, 32, 56));
        waffentextpanel.setBounds(433, 10, 300, 100);
        frame.add(waffentextpanel);

        waffentext = new JLabel("Current Weapon: ", SwingConstants.CENTER);
        waffentext.setForeground(new Color(222, 158, 65));
        waffentext.setFont(normalFont);
        waffentextpanel.add(waffentext);
        waffentext.setVisible(false);

        waffentextpanel2 = new JPanel();
        waffentextpanel2.setBackground(new Color(23, 32, 56));
        waffentextpanel2.setBounds(633, 10, 300, 80);
        frame.add(waffentextpanel2);

        waffentext2 = new JLabel(waffe, SwingConstants.CENTER);
        waffentext2.setForeground(new Color(222, 158, 65));
        waffentext2.setFont(normalFont);
        waffentextpanel2.add(waffentext2);
        waffentext2.setVisible(false);

        /**
         * Dies ist die Position des Spielers
         */

        playerPositionPanel = new JPanel();
        playerPositionPanel.setBackground(new Color(23, 32, 56));
        playerPositionPanel.setBounds(933, 10, 360, 100);
        frame.add(playerPositionPanel);

        playerPositiontext = new JLabel("Current Player Position: ", SwingConstants.CENTER);
        playerPositiontext.setForeground(new Color(222, 158, 65));
        playerPositiontext.setFont(normalFont);
        playerPositionPanel.add(playerPositiontext);
        playerPositiontext.setVisible(false);

        playerPositionPanel2 = new JPanel();
        playerPositionPanel2.setBackground(new Color(23, 32, 56));
        playerPositionPanel2.setBounds(1259, 10, 316, 100);
        frame.add(playerPositionPanel2);

        playerPositiontext2 = new JLabel(playerPosition, SwingConstants.CENTER);
        playerPositiontext2.setForeground(new Color(222, 158, 65));
        playerPositiontext2.setFont(normalFont);
        playerPositionPanel2.add(playerPositiontext2);
        playerPositiontext2.setVisible(false);

        frame.add(titleNamePanel);
        frame.add(startButtonPanel);
        frame.setVisible(true);
    }

    // Musik initialisieren
    private void InitialisierenMusic() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("to-adventure-193760.mp3"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            volumeControl = (FloatControl) clip.getControl(FloatControl.Type.VOLUME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Musik abspielen
    // public void playMusic() {
    //  if (!clip.isRunning()) {
    //     clip.loop(Clip.LOOP_CONTINUOUSLY);    // <---- Braucht man Eigentlich aber ich bekomms nicht geschissen gerade
    // }
    //  }

    // Lautstärke anpassen
    public void setVolume(float volume) {
        volumeControl.setValue(volume);
    }

    // Stummschalten umschalten
    public void toggleMute() {
        if (isMuted) {
            volumeControl.setValue(0.5f); // Standardlautstärke
            isMuted = false;
        } else {
            volumeControl.setValue(-80.0f); // Stumm
            isMuted = true;
        }
    }

    private void showSettings() {
        // Titelname ausblenden wenn auf Einstellungen geklickt wird
        titleNamePanel.setVisible(false); // Setzt das Titel-Panel unsichtbar

        // Panel für Einstellungen erstellen
        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new GridBagLayout());
        settingsPanel.setBackground(new Color(23, 32, 56));

        // GridBagConstraints <--- Zentriete Positionen fpr die einzelnen buttons
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0);  // Abstand nach oben und unten

        // Lautstärkeregler
        JSlider volumeSlider = new JSlider(0, 100, 50);
        volumeSlider.setMajorTickSpacing(25);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);
        volumeSlider.addChangeListener(e -> setVolume(volumeSlider.getValue() / 100.0f));
        volumeSlider.setPreferredSize(new Dimension(400, 50));  // Gleiche Größe wie Buttons

        // Lautstärkeregler oben hinzufügen
        settingsPanel.add(volumeSlider, gbc);

        // Stummschalt-Button
        JButton muteButton = new JButton("Ton Ein/Aus");
        muteButton.setFont(startButtonFont);
        muteButton.setBackground(new Color(23, 32, 56));
        muteButton.setForeground(new Color(222, 158, 65));
        muteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleMute(); // Schaltet den Ton ein oder aus
            }
        });
        muteButton.setPreferredSize(new Dimension(400, 50));  // Gleiche Größe wie der Zurück-Button

        // Button unter dem Lautstärkeregler
        gbc.gridy++;
        settingsPanel.add(muteButton, gbc);

        // Zurück-Button zum Startbildschirm
        JButton backButton = new JButton("Zurück zum Startbildschirm");
        backButton.setFont(startButtonFont);
        backButton.setBackground(new Color(23, 32, 56));
        backButton.setForeground(new Color(222, 158, 65));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Startbildschirm wieder anzeigen
                startButtonPanel.setVisible(true);
                settingsPanel.setVisible(false); // Einstellungen ausblenden
                titleNamePanel.setVisible(true); // Titel wieder sichtbar machen
            }
        });
        backButton.setSize(new Dimension(600, 50));

        // Zurück-Button unter dem "Ton Ein/Aus"-Button
        gbc.gridy++;
        settingsPanel.add(backButton, gbc);

        // Panel im gleichen Fenster einfügen
        startButtonPanel.setVisible(false);  // Versteckt den Startbildschirm
        frame.add(settingsPanel);  // Fügt das Einstellungs-Panel hinzu
        settingsPanel.setBounds(0, 100, 1600, 800);  // Positionieren des Panels
        settingsPanel.setVisible(true);
    }


    /**
     * @createGameScreen Hauptbildschirm des Spieles, wo der Spieler seine Optionen auswählt
     */

    public void createGameScreen() {
        /**
         * Löscht den Vorherigen Inhalt von der GUI also es macht es unsichbar
         */
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        waffentext.setVisible(true);
        healtbartext.setVisible(true);
        playerPositiontext.setVisible(true);
        playerPositiontext2.setVisible(true);
        waffentext2.setVisible(true);


        ImagePanel = new JPanel();
        ImagePanel.setBounds(300, 300, 1200, 550);
        frame.add(ImagePanel);

        ImageIcon imageIcon = new ImageIcon("Images/KerkerHintergrund.png");
        JLabel label = new JLabel(imageIcon);
        ImagePanel.add(label);


        /**
         * Dies Panel beinhaltet das Dialog Feld
         */

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(0, 100, 1600, 200);
        mainTextPanel.setBackground(new Color(23, 32, 56));
        frame.add(mainTextPanel);

        /**
         * Hier wird der Dialog angezeigt
         */

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(0, 0, 1600, 200);
        mainTextArea.setBackground(new Color(23, 32, 56));
        mainTextArea.setForeground(new Color(222, 158, 65));
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
        choiceButtonPanel.setBounds(50, 300, 200, 550);
        choiceButtonPanel.setBackground(new Color(23, 32, 56));
        choiceButtonPanel.setLayout(new GridLayout(4, 1, 10, 10));
        frame.add(choiceButtonPanel);

        choiceButton1 = new JButton();
        choiceButton1.setBackground(new Color(23, 32, 56));
        choiceButton1.setForeground(new Color(222, 158, 65));
        choiceButton1.setFont(normalFont);
        choiceButton1.setActionCommand("c1");
        choiceButton1.addActionListener(choiceHandler);
        choiceButton1.setFocusPainted(false);
        choiceButtonPanel.add(choiceButton1);

        choiceButton2 = new JButton();
        choiceButton2.setBackground(new Color(23, 32, 56));
        choiceButton2.setForeground(new Color(222, 158, 65));
        choiceButton2.setFont(normalFont);
        choiceButton2.setActionCommand("c2");
        choiceButton2.addActionListener(choiceHandler);
        choiceButton2.setFocusPainted(false);
        choiceButtonPanel.add(choiceButton2);

        choiceButton3 = new JButton();
        choiceButton3.setBackground(new Color(23, 32, 56));
        choiceButton3.setForeground(new Color(222, 158, 65));
        choiceButton3.setFont(normalFont);
        choiceButton3.setActionCommand("c3");
        choiceButton3.addActionListener(choiceHandler);
        choiceButton3.setFocusPainted(false);
        choiceButtonPanel.add(choiceButton3);

        choiceButton4 = new JButton();
        choiceButton4.setBackground(new Color(23, 32, 56));
        choiceButton4.setForeground(new Color(222, 158, 65));
        choiceButton4.setFont(normalFont);
        choiceButton4.setActionCommand("c4");
        choiceButton4.addActionListener(choiceHandler);
        choiceButton4.setFocusPainted(false);
        choiceButtonPanel.add(choiceButton4);

        startGame();
    }

    public void healthAktualisieren(int health) {
        healtbartext.setText("Player Health: " + health);
    }

    public void createFightScreen(Enemy enemy){
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        ImagePanel.setBounds(500,300,900,500);

        fightScreenButtonPanel = new JPanel();
        fightScreenButtonPanel.setBounds(100,300,380,550);
        fightScreenButtonPanel.setBackground(new Color(23, 32, 56));
        fightScreenButtonPanel.setLayout(new GridLayout(3, 1));
        frame.add(fightScreenButtonPanel);



        attackButton = new JButton();
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rk.fight(c,"normal",enemy);
                System.out.println("Leben: " + enemy.getHealth());
                System.out.println("Leben1: " +c.getHealth());
                if(enemy.getHealth() == 0)
                {
                    figthSceneManager();
                }
                if(c.getHealth() == 0)
                {
                    fightScreenButtonPanel.setVisible(false);
                    createGameScreen();
                }
            }
        });
        attackButton.setBackground(new Color(23, 32, 56));
        attackButton.setForeground(new Color(222, 158,65));
        attackButton.setText("Attack");
        fightScreenButtonPanel.add(attackButton);

        magicButton = new JButton();
        magicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rk.fight(c,"magic",enemy);
                System.out.println("Leben: " + enemy.getHealth());
                System.out.println("Leben1: " +c.getHealth());
                if(enemy.getHealth() == 0)
                {
                    figthSceneManager();
                }
                if(c.getHealth() == 0)
                {
                    fightScreenButtonPanel.setVisible(false);
                    createGameScreen();
                }

            }
        });
        magicButton.setBackground(new Color(23, 32, 56));
        magicButton.setForeground(new Color(222, 158,65));
        magicButton.setText("Magic");
        fightScreenButtonPanel.add(magicButton);

        itemButton = new JButton();
        itemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPotionSceene();
            }
        });
        itemButton.setBackground(new Color(23, 32, 56));
        itemButton.setForeground(new Color(222, 158,65));
        itemButton.setText("Item");
        fightScreenButtonPanel.add(itemButton);



    }
   public void createPotionSceene()
   {
       fightScreenButtonPanel.setVisible(false);
       mainTextPanel.setVisible(false);
       choiceButtonPanel.setVisible(false);
       ImagePanel.setBounds(500,300,900,500);

       potionScreenButtonPanel = new JPanel();
       potionScreenButtonPanel.setBounds(100,300,380,550);
       potionScreenButtonPanel.setBackground(new Color(23, 32, 56));
       potionScreenButtonPanel.setLayout(new GridLayout(3, 1));
       frame.add(potionScreenButtonPanel);

       healthPotionButton = new JButton();
       healthPotionButton.setText("Health Potion");
       healthPotionButton.setBackground(new Color(23,32,56));
       healthPotionButton.setForeground(new Color(222, 158,65));
       potionScreenButtonPanel.add(healthPotionButton);

       manaPotionButton = new JButton();
       manaPotionButton.setText("Mana Potion");
       manaPotionButton.setBackground(new Color(23, 32, 56));
       manaPotionButton.setForeground(new Color(222, 158,65));
       potionScreenButtonPanel.add(manaPotionButton);

       strengthPotionButton = new JButton();
       strengthPotionButton.setText("Strength Potion");
       strengthPotionButton.setBackground(new Color(23, 32, 56));
       strengthPotionButton.setForeground(new Color(222, 158,65));
       potionScreenButtonPanel.add(strengthPotionButton);

   }


    /**
     * Cheapter 1
     */

    public void startGame() {
        position = "anfangsSzene1";
        playerPosition = "Intro";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("The year 384 of the 534 cycle in the kingdom of Possehl.\n" +
                "The great royal family Seidler has ruled the land for 13 cycles.\n" +
                "For years the country has been struggling with the brutal rule of the 13th King Heuer.\n");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");


    }

    public void anfangsSzene() {
        position = "anfangsSzene2";
        playerPosition = "Intro";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("But there is hope the only person who can save the KING's city\n" +
                "and the country can save is the one true blood heir to the throne princess Seidler\n" +
                "but she was driven out some time ago by the corrupt powers of the land.\n" +
                "Seidler’s location is unknown find and bring her back to save the country.\n");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");

    }

    public void tavernSzene(){
        position = "tavernCenter";
        playerPosition = "Tavern Center";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*A drunken knight steps forward*\n" +
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
        position = "tavernCenter2";
        playerPosition = "Tavern Center";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Drunken knight: Wrong answer");
        choiceButton1.setText("FIGHT");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");

    }


    public void tavernFight() {
        position = "tavernFight";
        Enemy enemy = new Enemy("DRUNKENKNIGHT");
        createFightScreen(enemy);


    }

    public void afterFight() {
        position = "afterFight";
        playerPosition = "Tavern Center";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("You defeated the Drunken knight!\n" +
                "You receive a sword, a piece of armor, and 2 potions.\n" +
                "Suddenly, town guards appear!");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");

    }

    public void prisonScene() {
        position = "prison";
        playerPosition = "Prison";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Town guards appear*\n" +
                "Guards: HEY STOP YOU’RE NOT GETTING OUT!! \n" +
                "YOU ARE UNDER ARREST!!" +
                "*You are taken to prison.*\n" +
                "*Time passes...*\n");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");

    }

    public void queenOffer() {
        position = "queenOffer";
        playerPosition = "Prison";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*A woman appears hidden in the shadows by your cell.* \n" +
                "Unknown woman: You surely want to get out of here, don't you?\n" +
                "Do something for me, and I'll waive your sentence. " +
                "*player realizes its the Queen*\n" +
                "Once you protected our country, now I ask you...\n" +
                "Do you want to serve the country again and free it from the Evil King?");
        choiceButton1.setText("Yes");
        choiceButton2.setText("No");
        choiceButton3.setText("");
        choiceButton4.setText("");

    }

    public void queenYes() {
        position = "queenYes";
        playerPosition = "Prison - Secret Chamber";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("\nQueen: Follow me.\n" +
                "*She unlocks the door and leads you to a secret weapon chamber.*\n" +
                "Queen: You will help me, so now I will help you.\n" +
                "Please choose a weapon.");
        choiceButton1.setText("Sword");
        choiceButton2.setText("Axe");
        choiceButton3.setText("");
        choiceButton4.setText("");

    }

    public void queenNo() {
        position = "queenNo";
        playerPosition = "Prison";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("\nQueen: ...\n" +
                "*She leaves the prison.*\n" +
                "You die after a few years. (Game Over)");
        choiceButton1.setText("Restart");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");

    }

    public void weaponChamber() {
        position = "weaponsSelect";
        playerPosition = "Secret Weapon Chamber";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("\nQueen: Good choice.\n" +
                "*You leave the chamber and go to the streets of the King's Realm to gather information.*");
        choiceButton1.setText("Go to Tavern");
        choiceButton2.setText("Go to Marketplace");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void tavernRevisited() {
        position = "tavernRevisited";
        playerPosition = "Tavern";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("\n*Two guards stand in front of the door.*\n" +
                "Guard: Get out, you are not welcome here!");
        choiceButton1.setText("... Go to Marketplce");
        choiceButton2.setText("I'm looking for the princess.");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void goToMarketplace() {
        position = "tavernRevisited1";
        playerPosition = "Tavern";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Guards:.....\n" +
                "*A person who had heard the conversation comes by*\n" +
                "Stranger: Try the market, these guards won't help you.");
        choiceButton1.setText("Go to Marketplace");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void marketplace() {
        position = "marketplace";
        playerPosition = "Marketplace";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*You arrive at the marketplace.*\n" +
                "Apple Seller: FRESH APPLES!! COME BY!! BEST PRICES!!\n" +
                "Blacksmith: GET HERE!! YOUR NEXT WEAPON IS WAITING!! BUY FROM ME AND SAVE YOUR GOLD!!");
        choiceButton1.setText("Talk to Apple Seller");
        choiceButton2.setText("Talk to Blacksmith");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void appleSeller() {
        position = "appleSeller";
        playerPosition = "Marketplace - Apple Seller";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("...");
        choiceButton1.setText("I'm looking for the princess.");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");

    }

    public void appleSellerAwnser() {
        position = "appleSeller1";
        playerPosition = "Marketplace - Apple Seller";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Buy something and I'll see what I can   do.\n");
        choiceButton1.setText("Buy");
        choiceButton2.setText("Refuse");
        choiceButton3.setText("");
        choiceButton4.setText("");

    }
    public void appleSellerABuy() {
        position = "appleSeller2";
        playerPosition = "Marketplace - Apple Seller";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Player: An apple please. \n" +
                "Owner: Here choose one, and then ask your question");
        choiceButton1.setText("Take an Apple");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");

    }

    public void appleSellerABuy1() {
        position = "appleSeller3";
        playerPosition = "Marketplace - Apple Seller";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Player: I'm looking for the outcast princess. \n" +
                "Owner: Very well, I will help you. \n" +
                "Find an Old Man in the alley outside the city gate. \n" +
                "Maybe he can help you.\n");
        choiceButton1.setText("Search for the Old Man");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");

    }

    public void appleSellerAReject() {
        position = "appleSellerReject";
        playerPosition = "Marketplace - Apple Seller";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Player: No, I don't want an apple.\n" +
                "Owner: Then get lost, you're scaring my customers away! \n");
        choiceButton1.setText("Go Away");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void appleSellerAReject1() {
        position = "appleSellerReject1";
        playerPosition = "Alley";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Player walks and is approached by an old man in an alley*\n");
        choiceButton1.setText("Talk to the Old man");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }




    public void blacksmith() {
        position = "blacksmith";
        playerPosition = "Marketplace - Blacksmith";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("...");
        choiceButton1.setText("I'm looking for the princess.\n");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");

    }

    public void blacksmith1() {
        position = "blacksmith1";
        playerPosition = "Marketplace - Blacksmith";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("...");
        choiceButton1.setText("I'm looking for the outcast princess!");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");

    }

    public void blacksmith2() {
        position = "blacksmith2";
        playerPosition = "Marketplace - Blacksmith";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Very well, I will try to help you. \n" +
                " Find the old man in the alley outside the city gate. \n" +
                " Maybe he can help you.\n");
        choiceButton1.setText("Search for the Old Man");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void blacksmith3() {
        position = "blacksmith3";
        playerPosition = "Marketplace - Blacksmith";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Player searches the alley and finds an old man\n" +
                "The old man speaks to the player");
        choiceButton1.setText("...");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void oldManAlley() {
        position = "oldManAlley";
        playerPosition = "Alley";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText(
                "Old Man: I knew I would meet you one day.\n" +
                        "That's what the spirits told me years ago.\n" +
                        "I've been waiting, and finally, you're here.\n");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");

    }

    public void oldManAlley1() {
        position = "oldManAlley1";
        playerPosition = "Alley";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Player: I'm looking for the princess. \n" +
                " Where can I find her?\n"+
                "Old man: Take this and you will find her! \n");
        choiceButton1.setText("Take");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");

    }

    public void oldManAlley2() {
        position = "oldManAlley2";
        playerPosition = "Alley";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Player receives map from the old man\n" +
                "And sets off on the journey*");
        choiceButton1.setText("Start the journey");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");

    }


    /**
     *  Cheapter 2
     */

    public void ch2followMap() {
        position = "ch2followMap";
        playerPosition = "CP2 - Intro";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player follows the instructions.* \n" +
                "*This leads him out of the city, through dark forests, and to a ruined castle. Loud noises emanate from the\n" +
                "undergrowth. Suddenly, a pack of wolves leaps out of the bushes.*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void ch2fwolves() {
        position = "ch2wolves1";
        playerPosition = "CP2 - Ruined Castle";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Three hungry wolves circle the player* \n" +
                "*Their teeth flashing in the moonlight.*");
        choiceButton1.setText("Fight");
        choiceButton2.setText("Flee");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void ch2fwolvescp2afterwolvesScene() {
        position = "ch2fwolvescp2afterwolvesScene";
        Enemy enemy = new Enemy("Wolves");
        createFightScreen(enemy);
    }

    public void cp2afterwolvesFight() {
        position = "ch2afterwolvesFight";
        playerPosition = "CP2 - Ruined Castle";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*After the fight, the Player looks at his map and discovers a secret entrance.*\n" +
                "*A stone staircase that leads deep into the earth.* \n" +
                "*The player carefully steps down.*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2afterwolvesFlee() {
        position = "ch2afterwolvesFlee";
        playerPosition = "CP2 - Ruined Castle";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The Player fleed and looks at his map and discovers a secret entrance.*\n" +
                "*A stone staircase that leads deep into the earth.* \n" +
                "*The player carefully steps down.*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2dungeon1() {
        position = "cp2dungeon1";
        playerPosition = "CP2 - Dungeon";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player reaches the bottom of the stairs, \n" +
                "realizing that he is in an old, labyrinthine dungeon.*\n" +
                "*Cobwebs hang from the ceiling and torches cast light on the stone walls.\n" +
                " The first room seems to be empty*\n");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2dungeonFight() {
        position = "cp2dungeonFight";
        playerPosition = "CP2 - Dungeon Fight";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Two armored skeletons rise from the dust, their rusty swords drawn.*\n");
        choiceButton1.setText("Fight");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2dungeonFightScene() {
        position = "cp2dungeonFightScene";
        Enemy enemy = new Enemy("SKELLETGUARD");
        createFightScreen(enemy);
    }

    public void cp2dungeonAfterFight() {
        position = "cp2dungeonAfterFight";
        playerPosition = "CP2 - Dungeon Room";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*After the victory, the player searches the room and finds an old chest. \n" +
                "Inside lies a magic spell you found a random spell)*\n" +
                "*And an old key, the player continues deeper into the dungeon.*\n");
        choiceButton1.setText("Collect Key");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2dungeonlabyrinth() {
        position = "cp2dungeonlabyrinth";
        playerPosition = "CP2 - Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player enters a long corridor that splits into many directions after a few meters.*\n");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2dungeonlabyrinthChoose() {
        position = "cp2dungeonlabyrinthChoose";
        playerPosition = "CP2 - Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player sees Three paths*\n");
        choiceButton1.setText("Left path *hears subtle noises.*");
        choiceButton2.setText("The middle path *A seemingly safe path*");
        choiceButton3.setText("The right-hand path *A wide open area with corpses of past adventurers.*");
        choiceButton4.setText("");
    }

    public void cp2LeftPath() {
        position = "cp2dungeonlabyrinthleft";
        playerPosition = "CP2 - Dungeon Labyrinth Left";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player encounters a trap*\n");
        choiceButton1.setText("*Continue*");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2TheMiddlePath() {
        position = "cp2dungeonlabyrinthmiddle";
        playerPosition = "CP2 - Dungeon Labyrinth Middle";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player briefly loses his orientation(room switch?) \n" +
                "but can discovera secret weapon. *\n");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2TheRightHandPath() {
        position = "cp2dungeonlabyrinthright";
        playerPosition = "CP2 - Dungeon Labyrinth Right";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Here lurks a powerful spirit warrior guarding a rare weapon*\n");
        choiceButton1.setText("Fight");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2TheRightHandPathScene() {
        position = "cp2dungeonlabyrinthrightScene";
        Enemy enemy = new Enemy("SHADOWGUARDS");
        createFightScreen(enemy);
    }

    public void cp2TheRightHandPathFight() {
        position = "cp2dungeonlabyrinthrighFightt";
        playerPosition = "CP2 - Dungeon Labyrinth Right";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Spirit warrior guarding a rare weapon*\n");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2EncounterInLabyrinth() {
        position = "cp2EncounterInLabyrinth";
        playerPosition = "CP2 - Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*As the player moves through the dark corridor*\n" +
                "*He notices a figure in the shadows appears.*\n" +
                "*A confused old man steps forward*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2EncounterOldMen() {
        position = "cp2EncounterOldMen";
        playerPosition = "CP2 - Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Old Man: Ah, a traveler... traveler... Are you looking for the Princess?\n");
        choiceButton1.setText("Yes, where is she?");
        choiceButton2.setText("Ignore the Men");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2EncounterOldMenYes() {
        position = "cp2EncounterOldMenYes";
        playerPosition = "CP2 - Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Old Man: Stick to the right and use the first door u see\n");
        choiceButton1.setText("Thanks, the player moves on");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2EncounterOldMenNo() {
        position = "cp2EncounterOldMenNo";
        playerPosition = "CP2 - Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The Player Continues*");
        choiceButton1.setText("...");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2EncounterAdventurer() {
        position = "cp2EncounterAdventurer";
        playerPosition = "CP2 - Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Player found a captured adventurer in a cell\n" +
                "Adventurer: Please, save me!\n" +
                "I can help you! \n" +
                "*Player found a captured adventurer in a cell*\n");
        choiceButton1.setText("Free him");
        choiceButton2.setText("Leave him behinde");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2EncounterAdventurerFree() {
        position = "cp2EncounterAdventurerFree";
        playerPosition = "CP2 - Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player opens the cage and gives the adventurer a healing potion*" +
                "*Adventurer gives Player 2+ Strength potions*\n");
        choiceButton1.setText("Move on");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2EncounterAdventurerMoveOn() {
        position = "cp2EncounterAdventurerFree1";
        playerPosition = "CP2 - Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The Player moves on*\n" +
                "*The player hears a quiet voice as he goes nearer a \n" +
                "shadowy silhouette and speaks in riddles*\n");
        choiceButton1.setText("...");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2Encountershadowysilhouette() {
        position = "cp2Encountershadowysilhouette";
        playerPosition = "CP2 - Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("A shadowy silhouette: I can speak without having a mouth.\n" +
                " I can hear without having ears. \n" +
                " I have no body parts, but I can understand you.\n" +
                " What am I?\n");
        choiceButton1.setText("An echo");
        choiceButton2.setText("A shadow");
        choiceButton3.setText("A thought");
        choiceButton4.setText("");
    }

    public void cp2Encountershadowysilhouetteture() {
        position = "cp2Encountershadowysilhouettetrue";
        playerPosition = "CP2 - Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Shadowy Silhouette: You are right its the echo you can now go\n");
        choiceButton1.setText("Move on");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2Encountershadowysilhouetteturefalse() {
        position = "cp2Encountershadowysilhouettefalse";
        playerPosition = "CP2 - Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("shadowy silhouette: Wrong Awnser! ");
        choiceButton1.setText("Try again");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2EncountershadowysilhouetteMoveOn() {
        position = "cp2EncountershadowysilhouetteMoveOn";
        playerPosition = "CP2 - Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*After the Player discovers a door decorated with runes.*\n" +
                "*The player uses the key he has found and enters*\n" +
                "*After a few more long corridors the player reaches a huge\n" +
                "chamber where The lord of the dungeon is waiting.*\n");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2miniboss() {
        position = "cp2miniboss1";
        playerPosition = "CP2 - Huge Chamber";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*In burning torches stands a creature*\n" +
                "Its... the Dark Titan, Azroth!.");
        choiceButton1.setText("...");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2miniboss1() {
        position = "cp2miniboss2";
        playerPosition = "CP2 - Huge Chamber";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Azroth: Mortal, you have desecrated my halls.\n" +
                "Your life ends here!");
        choiceButton1.setText("Direct combat");
        choiceButton2.setText("Use the environment");
        choiceButton3.setText("Negotiate with Azroth");
        choiceButton4.setText("");
    }

    public void cp2miniboss1fight() {
        position = "cp2miniboss2fight";
        Enemy enemy = new Enemy("DARKTITANAZROTH");
        createFightScreen(enemy);
    }

    public void cp2miniboss1Win() {
        position = "cp2miniboss2fightWin";
        playerPosition = "CP2 - Huge Chamber Won";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Azroth falls to the ground.*\n" +
                "*The path to the Princess is now free*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2miniboss1Rescue() {
        position = "cp2miniboss1Rescue";
        playerPosition = "CP2 - Tower";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player moves up the stairs to the tower.* \n" +
                "Right before the princess’s door, two Guardians appear.*\n" +
                "*Two elite knights in black armor confront the player.*");
        choiceButton1.setText("Fight");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2miniboss1TowerFightScene() {
        position = "cp2miniboss1RescueWonScene";
        Enemy enemy = new Enemy("ELITEKNIGHTS");
        createFightScreen(enemy);
    }

    public void cp2miniboss1TowerFight() {
        position = "cp2miniboss1RescueWon";
        playerPosition = "CP2 - Tower";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*You defeated the Elite Knights* \n" +
                "*You got a Royal Key*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp2miniboss1TowerFightWon() {
        position = "cp2miniboss1RescueWon1";
        playerPosition = "CP2 - Tower Princess";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player uses the key to open the Princess's room.*\n" +
                "Princess: “Finally! You've come... We must leave quickly before Cerberus\n" +
                "appears!”\n" +
                "*A loud growl shakes the room.*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }
    public void cp2miniboss1TowerUnknown() {
        position = "cp2miniboss1TowerUnknown";
        playerPosition = "CP2 - Tower Princess";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Unknown: Grrr!!!\n" +
                "*A huge 3-headed dog appears behind the player and attacks him.*");
        choiceButton1.setText("....");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    /**
     * Cheapter 3
     */

    public void cp3TheEscape() {
        position = "cp3TheEscape";
        playerPosition = "CP3 - Tower Princess";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("The three-headed dog bares its teeth, \n" +
                "its deep growl echoes through the tower.\n" +
                "The princess crouches behind the Player.");
        choiceButton1.setText("Direct combat");
        choiceButton2.setText("Distraction");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp3TheEscapeOption1() {
        position = "cp3TheEscapeOption1";
        Enemy enemy = new Enemy("THREEHEADDOG");
        createFightScreen(enemy);
    }

    public void cp3TheEscapeOption2() {
        position = "cp3TheEscapeOption2";
        playerPosition = "CP3 - Tower Princess Distraction";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player uses a stone that has fallen out of a crumbling wall*\n" +
                "*and throws it at a chandelier behind the dog to distract him.*\n" +
                "*The player tries to escape with the princess.*");
        choiceButton1.setText("...");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp3TheEscapeFightWon() {
        position = "cp3TheEscapeFightWon";
        playerPosition = "CP3 - Tower Princess Fight";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Player has won the Fight against the three-headed dog*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp3TheEscapeFightDistraction() {
        position = "cp3TheEscapeFightDistraction";
        playerPosition = "CP3 - Tower Princess Distraction";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Player has successful distracted the the three-headed dog*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp3TheEscapeAfterFight() {
        position = "cp3TheEscapeAfterFight";
        playerPosition = "CP3 - Tower Princess Fight";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*After the fight, the player moves through \n" +
                "the dark corridors of the dungeon with the princess following.*\n" +
                "*The Player hears Footsteps*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp3TheEscapeAfterDistraction() {
        position = "cp3TheEscapeAfterDistraction";
        playerPosition = "CP3 - Tower Princess Fight";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player moves through the dark corridors of the dungeon\n" +
                "with the princess following.\n" +
                "The Player hears Footsteps*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp3Guard() {
        position = "cp3Guard";
        playerPosition = "CP3 - Dark Corridors";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Guard: Stop right there!");
        choiceButton1.setText("Ignore");
        choiceButton2.setText("Attack");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp3GuardIgnore() {
        position = "cp3GuardIgnore";
        playerPosition = "CP3 - Dark Corridors";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Player Ignores the Guard and Flees with the princess*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp3GuardAttack() {
        position = "cp3GuardAttack";
        Enemy enemy = new Enemy("ELITEGUARDS");
        createFightScreen(enemy);
    }

    public void cp3GuardAfter() {
        position = "cp3GuardAfter";
        playerPosition = "CP3 - Surface";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The escape continues as the player leads the \n" +
                "princess through the labyrinthine corridors back to the surface. *");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp3surface() {
        position = "cp3surface";
        playerPosition = "CP3 - Surface";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Princess: We are out!\n" +
                " I am finally free! \n" +
                " I was trapped for so long. \n" +
                " Thank you, Adventurer!?");
        choiceButton1.setText("No Problem");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp3Goblins() {
        position = "cp3Goblins";
        playerPosition = "CP3 - Surface";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*As The Player and Princess wanted to head in the Castles direction.*\n" +
                "*they get interrupted by a group of goblins.*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp3GoblinsFight() {
        position = "cp3GoblinsFight";
        playerPosition = "CP3 - Surface Fight";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Three goblins block the dirt road.* \n" +
                "*The player has no choice but to defend the princess* \n" +
                "Goblins: Give me the princess!");
        choiceButton1.setText("No way!");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp3GoblinsFightScene() {
        position = "cp3GoblinsFightScene";
        Enemy enemy =new Enemy("Goblins");
        createFightScreen(enemy);
    }

    public void cp3Night() {
        position = "cp3Night";
        playerPosition = "CP3 - Surface Night";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player and Princess continue their journey.\n" +
                "Night arises.*'");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp3NightQuest() {
        position = "cp3NightQuest";
        playerPosition = "CP3 - Surface Night Quest";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Suddenly they hear a loud cry for help from the road ahead.*\n" +
                "*A trader is being attacked by Skeletons.*");
        choiceButton1.setText("Help the merchant");
        choiceButton2.setText("Ignore the merchant");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp3NightQuestFight() {
        position = "cp3NightQuestFight";
        Enemy enemy = new Enemy("Bandit");
        createFightScreen(enemy);
    }

    public void cp3NightQuestAfterFight() {
        position = "cp3NightQuestAfterFight";
        playerPosition = "CP3 - Surface Night Quest";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player defends the trader by attacking the monsters*\n" +
                "*Trader gives him information about a secret tunnel into the city.*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp3ArriveAtCity() {
        position = "cp3ArriveAtCity";
        playerPosition = "CP3 - City";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Arrival at the city*\n" +
                "*The city lies before them, but the city gates are heavily\n" +
                "guarded by Two elite guards.*");
        choiceButton1.setText("Direct combat");
        choiceButton2.setText("Alternative route");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp3ArriveAtCityFight() {
        position = "cp3ArriveAtCityFight";
        Enemy enemy = new Enemy("EliteGuards");
        createFightScreen(enemy);
    }

    public void cp3ArriveAtCityFightScene() {
        position = "cp3ArriveAtCityFightScene";
        playerPosition = "CP3 - City Fight ";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player must defeat the guards to get through the gate. *");
        choiceButton1.setText("Fight");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");


    }

    public void cp3ArriveAtCityOtherRoute() {
        position = "cp3ArriveAtCityOtherRoute";
        playerPosition = "CP3 - City Tunnel ";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player uses the information from the trader about \n" +
                "the tunnel that leads into the city*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    /**
     * Cheapter 4
     */


    public void cp4towardsCastle() {
        position = "cp4towardsCastle";
        playerPosition = "CP4 - Towards Castle";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Inside the city, Princess Seidler and the Player continue\n" +
                " towards the Castle located in the middle of Possehl.*\n" +
                "*The player and Princess standing right before the castle´s door*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");

    }

    public void cp4InsideCastle() {
        position = "cp4InsideCastle";
        playerPosition = "CP4 - Inside Castle";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Princess: How do you think we get in?\n" +
                "Player: Just thru the main door. Princess, you will wait outside.\n" +
                "Princess: Good luck Hero.");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp4InsideCastleSkeletons() {
        position = "cp4InsideCastleSkeletons";
        playerPosition = "CP4 - Inside Castle Skeletons";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player enters the Castle undetected.*\n" +
                "*Before the Player reaches the throne room 3 Skeleton Guards stand in his way*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp4InsideCastleSkeletonsFight() {
        position = "cp4InsideCastleSkeletonsFight";
        playerPosition = "CP4 - Inside Castle Fight";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Skeleton/Guards: Stop u have no right to enter this room! \n" +
                "If you don’t stop we will attack you! \n" +
                "Player: Try to stop me!");
        choiceButton1.setText("Fight");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp4InsideCastleSkeletonsFightScene() {
        position = "cp4InsideCastleSkeletonsFightScene";
        Enemy enemy = new Enemy("SKELLETGUARD");
        createFightScreen(enemy);
    }

    public void cp4AfterFight() {
        position = "cp4AfterFight";
        playerPosition = "CP4 - Inside Castle";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("King Heuer: How did u come in?! Guards!! Guards!! \n" +
                "Player: Give up the throne! u have no right to be a King. \n" +
                "I will free this land!\n" +
                "King Heuer: YOU WILL NEVER WIN!? ");
        choiceButton1.setText("FIGHT KING HEUER");
        choiceButton2.setText("Shit in Pants");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp4BossFight() {
        position = "cp4BossFight";
        Enemy enemy = new Enemy("KING");
        createFightScreen(enemy);
    }

    public void cp4AfterBossFight() {
        position = "cp4AfterBossFight";
        playerPosition = "CP4 - After Boss Fight";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("King Heuer : How did I… How did u… \n" +
                " HOW CAN I LOOSE!!!! \n" +
                " …\n" +
                "Player: Now the real one will rule the land.");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp4AfterBossFight1() {
        position = "cp4AfterBossFight1";
        playerPosition = "CP4 - After Boss Fight";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Princess gets into the throne room*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }
    public void cp4AfterBossFight2() {
        position = "cp4AfterBossFight2";
        playerPosition = "CP4 - After Boss Fight";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Princess: Guards throw him into a cell.\n" +
                "Princess: Thank you adventurer u freed the land of Possehl. \n" +
                "I have one last question, Adventurer. \n" +
                "Will u be the King on my side?");
        choiceButton1.setText("Become the new King");
        choiceButton2.setText("Decline");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void cp4AfterBossFightOption1() {
        position = "cp4AfterBossFightOption1";
        playerPosition = "CP4 - Become King";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Player: I will stand at ur side as long as I live.\n" +
                "*The end* *You married the princess and became the king of Possehl \n" +
                "u ruled over the Land for 58years*\n");
        choiceButton1.setVisible(false);
        choiceButton2.setVisible(false);
        choiceButton3.setVisible(false);
        choiceButton4.setVisible(false);
    }

    public void cp4AfterBossFightOption2() {
        position = "cp4AfterBossFightOption2";
        playerPosition = "CP4 - Decline";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Player: I can´t there are more kingdoms to be rescued.\n" +
                "*The end* *you rescued two more princesses and got more adventures\n" +
                "than u thought would ever get. After 58years you get into retirement*");
        choiceButton1.setVisible(false);
        choiceButton2.setVisible(false);
        choiceButton3.setVisible(false);
        choiceButton4.setVisible(false);
    }





    public void SecretEnding() {
        position = "SecretEnding";
        playerPosition = "";
        waffentext2.setText("");
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Player Shits in Pants and Leaves the Castel!*");
        choiceButton1.setVisible(false);;
        choiceButton2.setVisible(false);
        choiceButton3.setVisible(false);
        choiceButton4.setVisible(false);
    }

    private class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            switch (position) {
                case "anfangsSzene1":
                    if (yourChoice.equals("c1")) {
                        anfangsSzene(); // Move to the next scene
                    }
                    break;

                case "anfangsSzene2":
                    if (yourChoice.equals("c1")) {
                        tavernSzene(); // Move to the tavern scene
                    }
                    break;

                case "tavernCenter":
                    if (yourChoice.equals("c1")) {
                        tavernSzene2(); // Start the tavern fight
                    }
                    break;

                case "tavernCenter2":
                    if (yourChoice.equals("c1")) {
                        tavernFight();
                    }
                    break;



                case "afterFight":
                    if (yourChoice.equals("c1")) {
                        prisonScene();
                    }
                    break;

                case "prison":
                    if (yourChoice.equals("c1")) {
                        queenOffer();
                    }

                    break;

                case "queenOffer":
                    if(yourChoice.equals("c1")){
                        queenYes();
                    }
                    else if(yourChoice.equals("c2")){
                        queenNo();
                    }
                    break;

                case "queenYes":
                    if (yourChoice.equals("c1")) {
                        waffentext2.setText("Sword");
                        waffe = "Sword";
                        weaponChamber();
                    } else if (yourChoice.equals("c2")) {
                        waffentext2.setText("Axe");
                        waffe = "Axe";
                        weaponChamber();
                    }
                    break;

                case "queenNo":
                    if (yourChoice.equals("c1")) {
                        queenOffer();
                    }
                    break;

                case "weaponsSelect":
                    if (yourChoice.equals("c1")) {
                        tavernRevisited();
                    } else if (yourChoice.equals("c2")) {
                        marketplace();
                    }
                    break;

                case "tavernRevisited":
                    if (yourChoice.equals("c1"))
                    {
                        marketplace();
                    }
                    else if (yourChoice.equals("c2")) {
                        goToMarketplace();
                    }
                    break;

                case "tavernRevisited1":
                    if (yourChoice.equals("c1"))
                    {
                        marketplace();
                    }
                    break;

                case "marketplace":
                    if (yourChoice.equals("c1")) {
                        appleSeller();
                    }
                    else if (yourChoice.equals("c2")) {
                        blacksmith();
                    }

                    break;

                case "appleSeller":
                    if (yourChoice.equals("c1")) {
                        appleSellerAwnser();
                    }

                    break;

                case "appleSeller1":
                    if (yourChoice.equals("c1")) {
                        appleSellerABuy();
                    }
                    else if (yourChoice.equals("c2")) {
                        appleSellerAReject();
                    }
                    break;

                case "appleSeller2":
                    if (yourChoice.equals("c1")) {
                        appleSellerABuy1();
                    }
                    break;

                case "appleSeller3":
                    if (yourChoice.equals("c1")) {
                        oldManAlley();
                    }
                    break;

                case "oldManAlley":
                    if (yourChoice.equals("c1")) {
                        oldManAlley1();
                    }
                    break;

                case "oldManAlley1":
                    if (yourChoice.equals("c1")) {
                        oldManAlley2();
                    }
                    break;

                case "appleSellerReject":
                    if (yourChoice.equals("c1")) {
                        appleSellerAReject1();
                    }
                    break;

                case "blacksmith":
                    if (yourChoice.equals("c1")) {
                        blacksmith1();
                    }
                    break;


                case "blacksmith1":
                    if (yourChoice.equals("c1")) {
                        blacksmith2();
                    }
                    break;

                case "blacksmith2":
                    if (yourChoice.equals("c1")) {
                        blacksmith3();
                    }
                    break;

                case "blacksmith3":
                    if (yourChoice.equals("c1")) {
                        oldManAlley();
                    }
                    break;

                case "appleSellerReject1":
                    if (yourChoice.equals("c1")) {
                        oldManAlley();
                    }
                    break;

                case "oldManAlley2":
                    if (yourChoice.equals("c1")) {
                        ch2followMap();
                    }
                    break;

                case "ch2followMap":
                    if(yourChoice.equals("c1")){
                        ch2fwolves();
                    }
                    break;

                case "ch2wolves1":
                    if(yourChoice.equals("c1")){
                        ch2fwolvescp2afterwolvesScene(); // Hier muss die Kampf Methode gegen den die Wölfe eingefügt werden.
                    }
                    else if(yourChoice.equals("c2")){
                        cp2afterwolvesFlee();
                    }
                    break;

                case "ch2fwolvescp2afterwolvesScene":
                    if(yourChoice.equals("c1")){
                        cp2afterwolvesFight();
                    }
                    break;

                case "ch2afterwolvesFlee":
                    if(yourChoice.equals("c1")){
                        cp2dungeon1();
                    }
                    break;

                case "ch2afterwolvesFight":
                    if(yourChoice.equals("c1")){
                        cp2dungeon1();
                    }
                    break;

                case "cp2dungeon1":
                    if(yourChoice.equals("c1")){
                        cp2dungeonFight();
                    }
                    break;

                case "cp2dungeonFight":
                    if(yourChoice.equals("c1")){
                        cp2dungeonFightScene();
                    }
                    break;

                case "cp2dungeonFightScene":
                    if(yourChoice.equals("c1")){
                        cp2dungeonAfterFight();
                    }
                    break;

                case "cp2dungeonAfterFight":
                    if(yourChoice.equals("c1")){
                        cp2dungeonlabyrinth();
                    }
                    break;

                case "cp2dungeonlabyrinth":
                    if(yourChoice.equals("c1")){
                        cp2dungeonlabyrinthChoose();
                    }
                    break;

                case "cp2dungeonlabyrinthChoose":
                    if(yourChoice.equals("c1")){
                        cp2LeftPath();
                    }
                    else if(yourChoice.equals("c2")){
                        cp2TheMiddlePath();
                    }
                    else if(yourChoice.equals("c3")){
                        cp2TheRightHandPath(); // Hier ist der Kampf gegen den Spirit warrior guardian Kampfmethode hier einfügen
                    }
                    break;


                case "cp2dungeonlabyrinthleft":
                    if(yourChoice.equals("c1")){
                        cp2EncounterInLabyrinth();
                    }
                    break;

                case "cp2dungeonlabyrinthmiddle":
                    if(yourChoice.equals("c1")){
                        cp2EncounterInLabyrinth();
                    }
                    break;

                case "cp2dungeonlabyrinthright":
                    if(yourChoice.equals("c1")){
                        cp2TheRightHandPathScene();
                    }
                    break;

                case "cp2dungeonlabyrinthrightScene":
                    if(yourChoice.equals("c1")){
                        cp2TheRightHandPathFight();
                    }
                    break;

                case "cp2dungeonlabyrinthrighFightt":
                    if(yourChoice.equals("c1")){
                        cp2EncounterInLabyrinth();
                    }
                    break;

                case "cp2EncounterInLabyrinth":
                    if(yourChoice.equals("c1")){
                        cp2EncounterOldMen();
                    }
                    break;

                case "cp2EncounterOldMen":
                    if(yourChoice.equals("c1")){
                        cp2EncounterOldMenYes();
                    }
                    else if(yourChoice.equals("c2")){
                        cp2EncounterOldMenNo();
                    }
                    break;

                case "cp2EncounterOldMenYes":
                    if(yourChoice.equals("c1")){
                        cp2EncounterAdventurer();
                    }
                    break;

                case "cp2EncounterOldMenNo":
                    if(yourChoice.equals("c1")){
                        cp2EncounterAdventurer();
                    }
                    break;


                case "cp2EncounterAdventurer":
                    if(yourChoice.equals("c1")){
                        cp2EncounterAdventurerFree();
                    }
                    else if(yourChoice.equals("c2")){
                        cp2EncounterAdventurerMoveOn();
                    }
                    break;


                case "cp2EncounterAdventurerFree":
                    if(yourChoice.equals("c1")){
                        cp2EncounterAdventurerMoveOn();
                    }
                    break;


                case "cp2EncounterAdventurerFree1":
                    if(yourChoice.equals("c1")){
                        cp2Encountershadowysilhouette();
                    }
                    break;


                case "cp2Encountershadowysilhouette":
                    if(yourChoice.equals("c1")){
                        cp2Encountershadowysilhouetteture();
                    }
                    else if(yourChoice.equals("c2")){
                        cp2Encountershadowysilhouetteturefalse();
                    }
                    else if(yourChoice.equals("c3")){
                        cp2Encountershadowysilhouetteturefalse();
                    }
                    break;


                case "cp2Encountershadowysilhouettetrue":
                    if(yourChoice.equals("c1")){
                        cp2EncountershadowysilhouetteMoveOn();
                    }
                    break;


                case "cp2Encountershadowysilhouettefalse":
                    if(yourChoice.equals("c1")){
                        cp2Encountershadowysilhouette();
                    }
                    break;


                case "cp2EncountershadowysilhouetteMoveOn":
                    if(yourChoice.equals("c1")){
                        cp2miniboss();
                    }
                    break;


                case "cp2miniboss1":
                    if(yourChoice.equals("c1")){
                        cp2miniboss1();
                    }
                    break;


                case "cp2miniboss2":
                    if(yourChoice.equals("c1")){
                        cp2miniboss1fight();
                    }
                    else if(yourChoice.equals("c2")){
                        cp2miniboss1fight();
                    }
                    else if(yourChoice.equals("c3")){
                        cp2miniboss1fight();
                    }
                    break;


                case "cp2miniboss2fight":
                    if(yourChoice.equals("c1")){
                        cp2miniboss1Win();
                    }
                    break;


                case "cp2miniboss2fightWin":
                    if(yourChoice.equals("c1")){
                        cp2miniboss1Rescue();
                    }
                    break;


                case "cp2miniboss1Rescue":
                    if(yourChoice.equals("c1")){
                        cp2miniboss1TowerFightScene();
                    }
                    break;

                case "cp2miniboss1RescueWonScene":
                    if(yourChoice.equals("c1")){
                        cp2miniboss1TowerFight();
                    }
                    break;



                case "cp2miniboss1RescueWon":
                    if(yourChoice.equals("c1")){
                        cp2miniboss1TowerFightWon();
                    }
                    break;

                case "cp2miniboss1RescueWon1":
                    if(yourChoice.equals("c1")){
                        cp2miniboss1TowerUnknown();
                    }
                    break;

                case "cp2miniboss1TowerUnknown":
                    if(yourChoice.equals("c1")){
                        cp3TheEscape();
                    }
                    break;

                case "cp3TheEscape":
                    if(yourChoice.equals("c1")){
                        cp3TheEscapeOption1();
                    }
                    else if(yourChoice.equals("c2")){
                        cp3TheEscapeOption2();
                    }
                    break;

                case "cp3TheEscapeOption1":
                    if(yourChoice.equals("c1")){
                        cp3TheEscapeFightWon(); // Hier soll die Kampfmethode gegen den Hund eingefüght werdem
                    }
                    break;

                case "cp3TheEscapeOption2":
                    if(yourChoice.equals("c1")){
                        cp3TheEscapeFightDistraction();
                    }
                    break;

                case "cp3TheEscapeFightWon":
                    if(yourChoice.equals("c1")){
                        cp3TheEscapeAfterFight();
                    }
                    break;

                case "cp3TheEscapeFightDistraction":
                    if(yourChoice.equals("c1")){
                        cp3TheEscapeAfterDistraction();
                    }
                    break;

                case "cp3TheEscapeAfterFight":
                    if(yourChoice.equals("c1")){
                        cp3Guard();
                    }
                    break;

                case "cp3TheEscapeAfterDistraction":
                    if(yourChoice.equals("c1")){
                        cp3Guard();
                    }
                    break;

                case "cp3Guard":
                    if(yourChoice.equals("c1")){
                        cp3GuardIgnore();
                    }
                    else if(yourChoice.equals("c2")){
                        cp3GuardAttack(); // Hier muss die Methode für den Kampf gegen den Wächter eingfügt werden
                    }
                    break;

                case "cp3GuardAfter":
                    if(yourChoice.equals("c1")){
                        cp3surface();
                    }
                    break;


                case "cp3GuardIgnore":
                    if(yourChoice.equals("c1")){
                        cp3GuardAfter();
                    }
                    break;

                case "cp3GuardAttack":
                    if(yourChoice.equals("c1")){
                        cp3GuardAfter();
                    }
                    break;

                case "cp3surface":
                    if(yourChoice.equals("c1")){
                        cp3Goblins();
                    }
                    break;

                case "cp3Goblins":
                    if(yourChoice.equals("c1")){
                        cp3GoblinsFight();
                    }
                    break;

                case "cp3GoblinsFight":
                    if(yourChoice.equals("c1")){
                        cp3GoblinsFightScene(); //Hier Muss die Methode für den Kampf gegen die Goblins eingefügt werden
                    }
                    break;

                case "cp3GoblinsFightScene":
                    if(yourChoice.equals("c1")){
                        cp3Night();
                    }
                    break;

                case "cp3Night":
                    if(yourChoice.equals("c1")){
                        cp3NightQuest();
                    }
                    break;

                case "cp3NightQuest":
                    if(yourChoice.equals("c1")){
                        cp3NightQuestFight(); //Hier muss die Methode für den Kampf gegen die Skelete eingefügt werden
                    }
                    else if(yourChoice.equals("c2")){
                        cp3ArriveAtCity();
                    }
                    break;

                case "cp3NightQuestFight":
                    if(yourChoice.equals("c1")){
                        cp3NightQuestAfterFight();
                    }
                    break;

                case "cp3NightQuestAfterFight":
                    if(yourChoice.equals("c1")){
                        cp3ArriveAtCity();
                    }
                    break;

                case "cp3ArriveAtCity":
                    if(yourChoice.equals("c1")){
                        cp3ArriveAtCityFight();
                    }
                    else if(yourChoice.equals("c2")){
                        cp3ArriveAtCityOtherRoute();
                    }
                    break;

                case "cp3ArriveAtCityFightScene":
                    if(yourChoice.equals("c1")){
                        cp3ArriveAtCityFightScene(); //Hier muss die Methode für den Kampf gegen die Zwei Elite Guards eingefügt werden
                    }
                    break;

                case "cp3ArriveAtCityFight":
                    if(yourChoice.equals("c1")){
                        cp4towardsCastle();
                    }
                    break;


                case "cp3ArriveAtCityOtherRoute":
                    if(yourChoice.equals("c1")){
                        cp4towardsCastle();
                    }
                    break;

                case "cp4towardsCastle":
                    if(yourChoice.equals("c1")){
                        cp4InsideCastle();
                    }
                    break;

                case "cp4InsideCastle":
                    if(yourChoice.equals("c1")){
                        cp4InsideCastleSkeletons();
                    }
                    break;

                case "cp4InsideCastleSkeletons":
                    if(yourChoice.equals("c1")){
                        cp4InsideCastleSkeletonsFight();
                    }
                    break;

                case "cp4InsideCastleSkeletonsFight":
                    if(yourChoice.equals("c1")){
                        cp4InsideCastleSkeletonsFightScene(); //Hier muss die Methodde für den Kampf gegen die Skelete eingefügt werden
                    }
                    break;

                case "cp4InsideCastleSkeletonsFightScene":
                    if(yourChoice.equals("c1")){
                        cp4AfterFight();
                    }
                    break;

                case "cp4AfterFight":
                    if(yourChoice.equals("c1")){
                        cp4BossFight(); //Hier muss die Methode für den BossKampf eingefügt werden
                    }
                    else if(yourChoice.equals("c2")){
                        SecretEnding();
                    }
                    break;

                case "cp4BossFight":
                    if(yourChoice.equals("c1")){
                        cp4AfterBossFight();
                    }
                    break;

                case "cp4AfterBossFight":
                    if(yourChoice.equals("c1")){
                        cp4AfterBossFight1();
                    }
                    break;

                case "cp4AfterBossFight1":
                    if(yourChoice.equals("c1")){
                        cp4AfterBossFight2();
                    }
                    break;

                case "cp4AfterBossFight2":
                    if(yourChoice.equals("c1")){
                        cp4AfterBossFightOption1();
                    }
                    else if(yourChoice.equals("c2")){
                        cp4AfterBossFightOption2();
                    }
                    break;

                default:
                    System.out.println("Unknown position: " + position);
                    break;

            }
        }
    }
    private void figthSceneManager()
    {
        fightScreenButtonPanel.setVisible(false);
        switch (position)
        {
            case "tavernFight":
                createGameScreen();
                afterFight();
                break;
            case "ch2fwolvescp2afterwolvesScene":
                createGameScreen();
                cp2afterwolvesFight();
                break;
            case "cp2dungeonFightScene":
                createGameScreen();
                cp2dungeonAfterFight();
                break;
            case "cp2dungeonlabyrinthrightScene":
                createGameScreen();
                cp2EncounterInLabyrinth();
                break;
            case "cp2miniboss2fight":
                createGameScreen();
                cp2miniboss1Win();
                break;
            case "cp2miniboss1RescueWonScene":
                createGameScreen();
                cp2miniboss1TowerFight();
                break;
            case "cp3TheEscapeOption1":
                createGameScreen();
                cp3TheEscapeFightWon();
                break;
            case "cp3GuardAttack":
                createGameScreen();
                cp3GuardAfter();
                break;
            case "cp3GoblinsFightScene":
                createGameScreen();
                cp3Night();
                break;
            case "cp3NightQuestFight":
                createGameScreen();
                cp3NightQuestAfterFight();
                break;
            case "cp4InsideCastleSkeletonsFightScene":
                createGameScreen();
                cp4AfterFight();
                break;
            case "cp4BossFight":
                createGameScreen();
                cp4AfterBossFight();
                break;

        }
    }
    private class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }
}