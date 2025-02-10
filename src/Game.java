import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Game {
    public JFrame frame;
    JPanel potionScreenButtonPanel,enemyHealtbartextpanel, titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, healtbartextpanel, waffentextpanel, playerPositionPanel, playerPositionPanel2, waffentextpanel2, imagePanelFightScreenGegner,imagePanelFightScreenPlayer;
    JLabel enemyHealtbartext, titleNameLabel, healtbartext, waffentext, playerPositiontext, playerPositiontext2, waffentext2, playerHealthTExt;
    public JButton exitButton,strengthPotionButton ,manaPotionButton, healthPotionButton, startButton, ladenButton, einstellungenButton, verlassenButton, attackButton, magicButton,itemButton;
    public JButton choiceButton1, choiceButton2, choiceButton3, choiceButton4;
    JPanel ImagePanel,fightScreenButtonPanel;
    public JLabel imageLabel, imageLabelGegner , imageLabelPlayer;
    public JTextArea mainTextArea;
    public TitleScreenHandler tsHandler = new TitleScreenHandler();
    public ChoiceHandler choiceHandler = new ChoiceHandler();
    int playerIDD;
    String playerPositionDB;
    public String ch3Help = "nothelp";

    Sounds msc = new Sounds();

    boolean ch1 = false;
    boolean ch2 = false;
    boolean ch3 = false;


    Player c = new Player();
    RechnerKampf rk = new RechnerKampf();
    Inventory inf = new Inventory();


    /**
     * Fonts for all text seen in game
     */

    public Font titleFont = new Font("Times New Roman", Font.PLAIN, 170);
    public Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    public Font startButtonFont = new Font("Times New Roman", Font.PLAIN, 50);

    /**
     * This gives the position of the story. Imoportant for ChoiceHandler.
     */

    String position;

    /**
     * Variable "waffe" is importnat for the current weapon equipped.
     */

    String waffe = "Fists";

    /**
     * Variable "health" is responsible for Players health.
     */

    int health = c.getHealth();

    /**
     * Variable "playerPosition" is responsible for player's position in game .
     */
    String playerPosition = "Intro";

    /**
     * @Game Titlescreen
     */


    public Game(int playerID) {
        playerIDD = playerID;
        inf.setUserID(playerID);
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * Primary screen where all oher screens are displayed
         */

        frame = new JFrame();
        frame.setSize(1600, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(23, 32, 56));
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        /**
         * displays the title
         */

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(0, 100, 1600, 300);
        titleNamePanel.setBackground(new Color(23, 32, 56));
        frame.add(titleNamePanel);

        /**
         * The title itself
         */

        titleNameLabel = new JLabel("Seidler's Legacy", SwingConstants.CENTER);
        titleNameLabel.setForeground(new Color(222, 158, 65));
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        /**
         * This panel creates place for all buttons
         */

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 450, 1000, 350);
        startButtonPanel.setBackground(new Color(23, 32, 56));
        startButtonPanel.setLayout(new GridLayout(4, 1));

        /**
         * Displays the start button
         */

        startButton = new JButton("Start");
        startButton.setBackground(new Color(23, 32, 56));
        startButton.setForeground(new Color(222, 158, 65));
        startButton.setFont(startButtonFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);
        startButtonPanel.add(startButton);

        /**
         * Displays the load button
         */

        ladenButton = new JButton("Load");
        ladenButton.setBackground(new Color(23, 32, 56));
        ladenButton.setForeground(new Color(222, 158, 65));
        ladenButton.setFont(startButtonFont);
        //Action Listener hinzufügen für Funktion
        startButtonPanel.add(ladenButton);

        /**
         * Displays the settings button
         */

        einstellungenButton = new JButton("Settings");
        einstellungenButton.setBackground(new Color(23, 32, 56));
        einstellungenButton.setForeground(new Color(222, 158, 65));
        einstellungenButton.setFont(startButtonFont);
        //Action Listener hinzufügen für Funktion
        startButtonPanel.add(einstellungenButton);

        /**
         * Displays the exit button
         */

        verlassenButton = new JButton("Exit");
        verlassenButton.setBackground(new Color(23, 32, 56));
        verlassenButton.setForeground(new Color(222, 158, 65));
        verlassenButton.setFont(startButtonFont);
        //Action Listener hinzufügen für Funktion
        startButtonPanel.add(verlassenButton);

        /**
         * Dislpays the healthbar
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
         * Displays the current weapon
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
         * Displays the current position of the player
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


        ImageIcon imageIcon = new ImageIcon("Images/KerkerHintergrund.png");
        imageLabel = new JLabel(imageIcon);

        ImagePanel = new JPanel();
        ImagePanel.setBounds(300, 300, 988, 550);
        ImagePanel.add(imageLabel);
        frame.add(ImagePanel);
        ImagePanel.setVisible(false);


        ImageIcon imageIconGegner = new ImageIcon("Images/Characters/Gegner/Rahmen/3KopfHund 2.png");
        imageLabelGegner = new JLabel(imageIconGegner);

        imagePanelFightScreenGegner = new JPanel();
        imagePanelFightScreenGegner.setBounds(1160,300,340,590);
        imagePanelFightScreenGegner.add(imageLabelGegner);
        frame.add(imagePanelFightScreenGegner);
        imagePanelFightScreenGegner.setVisible(false);
        imageLabelGegner.setVisible(true);


        ImageIcon imageIconPlayer = new ImageIcon("Images/Characters/Gegner/Rahmen/3KopfHund 2.png");
        imageLabelPlayer = new JLabel(imageIconPlayer);

        imagePanelFightScreenPlayer = new JPanel();
        imagePanelFightScreenPlayer.setBounds(480,300,340,590);
        imagePanelFightScreenPlayer.add(imageLabelPlayer);
        imagePanelFightScreenPlayer.setVisible(false);
        imageLabelPlayer.setVisible(false);
        frame.add(imagePanelFightScreenPlayer);


        frame.add(titleNamePanel);
        frame.add(startButtonPanel);
        frame.setVisible(true);

    }

    /**
     * @createGameScreen Main-screen of the game between the fights
     */

    public void createGameScreen() throws SQLException {
        /**
         * All of the content from Title-screen will be removed and new is painted
         */
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        waffentext.setVisible(true);
        healtbartext.setVisible(true);
        playerPositiontext.setVisible(true);
        playerPositiontext2.setVisible(true);
        waffentext2.setVisible(true);


        frame.setLayout(null);
        frame.setVisible(true);


        /**
         * Dialog block
         */

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(0, 100, 1600, 200);
        mainTextPanel.setBackground(new Color(23, 32, 56));
        frame.add(mainTextPanel);

        /**
         * Dialog content
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

        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);
        imagePanelFightScreenGegner.setVisible(false);
        imagePanelFightScreenPlayer.setVisible(false);
        imageLabelGegner.setVisible(false);
        imageLabelPlayer.setVisible(false);


        String[] currentPosition = db.playerInfo(playerIDD);
        playerPositionDB = currentPosition[1];

        System.out.println(currentPosition[1]);


        /**
         * Ruft die Orte aus der DB auf und setzt den Spieler auf diesen Standort zurück wenn er das Spiel verlässt und in das Spiler wieder reingeht.
         */

        switch (playerPositionDB) {
            case "cp1Finish":
                ch2followMap();
                break;
            case "cp2Finish":
                cp3TheEscape();
                break;
            case "cp3Finish":
                cp4towardsCastle();
                break;
            case "cp4Finish":
                startGame();

            default:
                startGame();
                break;
        }

    }

    public void healthAktualisieren(int health) {
        healtbartext.setText("Player Health: " + health);
    }
    public void setFightPictures(int playerID,String enemyType) throws SQLException {
        DB db = new DB();
        Object[] equip = db.getEquipped(playerID);
        String weaponID = (String) equip[2];
        Object[] weaponInfo = db.itemInfo(Integer.parseInt(weaponID));
        String playerImmagePath = (String) weaponInfo[2];
        //Funktion zum Player bild in fight scene einfügen
        String enemyPicturePath="";
        switch (enemyType) {
            case "DRUNKENKNIGHT":
                enemyPicturePath = "Images/Characters/Gegner/Rahmen/BetrunkenerRitter.png";
                break;
            case "WOLVES":
                enemyPicturePath = "Images/Characters/Gegner/Rahmen/Wolfis.png";
                break;
            case "SHADOWGUARDS":
                enemyPicturePath = "Images/Characters/Gegner/Rahmen/SchattenWache.png";
                break;
            case "AZROTH":
                enemyPicturePath = "Images/Characters/Gegner/Rahmen/Azroth.png";
                break;
            case "ELITEKNIGHTS":
                enemyPicturePath = "Images/Characters/Gegner/Rahmen/3EliteGuards(Dungeon).png";
                break;
            case "CERBERUS":
                enemyPicturePath = "Images/Characters/Gegner/Rahmen/3KopfHund 2.png";
                break;
            case "GOBLIN":
                enemyPicturePath = "Images/Characters/Gegner/Rahmen/Goblin.png";
                break;
            case "SKELETON":
                enemyPicturePath = "Images/Characters/Gegner/Rahmen/ZweiSkelettGegner.png";
                break;
            case "SKELLETGUARD":
                enemyPicturePath = "Images/Characters/Gegner/Rahmen/2EliteGuards(Echt).png";
                break;
            case "KING":
                enemyPicturePath = "Images/Characters/Gegner/Rahmen/KönigGegner.png";
                break;
        }
        changeImagePlayer(playerImmagePath);
        changeImageGegner(enemyPicturePath);
    }



    public void createFightScreen(Enemy enemy,String enemyType) throws SQLException {
        msc.playFight1();
        ImagePanel.setVisible(false);
        imageLabel.setVisible(false);
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        imagePanelFightScreenGegner.setVisible(true);
        imagePanelFightScreenPlayer.setVisible(true);
        imageLabelGegner.setVisible(true);
        imageLabelPlayer.setVisible(true);
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
                healthAktualisieren(c.getHealth());
                if(enemy.getHealth() == 0)
                {
                    try {
                        figthSceneManager();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                if(c.getHealth() == 0)
                {
                    fightScreenButtonPanel.setVisible(false);
                    try {
                        createGameScreen();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
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
                healthAktualisieren(c.getHealth());
                if(enemy.getHealth() == 0)
                {
                    try {
                        figthSceneManager();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if(c.getHealth() == 0)
                {
                    fightScreenButtonPanel.setVisible(false);
                    try {
                        createGameScreen();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
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
        itemButton.setBackground(new Color(23,32,56));
        itemButton.setForeground(new Color(222,158,65));
        itemButton.setText("Item");
        fightScreenButtonPanel.add(itemButton);
        setFightPictures(playerIDD,enemyType);

        //Fixt vielleicht das Problem das die Bilder nicht richtig angeziegt werden
        frame.revalidate(); // Refresh the layout
        frame.repaint();
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
        potionScreenButtonPanel.setLayout(new GridLayout(3, 2));
        frame.add(potionScreenButtonPanel);

        healthPotionButton = new JButton();
        healthPotionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    c.usePotion("26");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        healthPotionButton.setText("Health Potion");
        healthPotionButton.setBackground(new Color(23,32,56));
        healthPotionButton.setForeground(new Color(222, 158,65));
        potionScreenButtonPanel.add(healthPotionButton);

        manaPotionButton = new JButton();
        manaPotionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    c.usePotion("27");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        manaPotionButton.setText("Mana Potion");
        manaPotionButton.setBackground(new Color(23, 32, 56));
        manaPotionButton.setForeground(new Color(222, 158,65));
        potionScreenButtonPanel.add(manaPotionButton);

        strengthPotionButton = new JButton();
        strengthPotionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    inf.consum("29",c);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        strengthPotionButton.setText("Strength Potion");
        strengthPotionButton.setBackground(new Color(23, 32, 56));
        strengthPotionButton.setForeground(new Color(222, 158,65));
        potionScreenButtonPanel.add(strengthPotionButton);

        exitButton = new JButton();
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fightScreenButtonPanel.setVisible(true);
                potionScreenButtonPanel.setVisible(false);

            }
        });
        exitButton.setText("Exit");
        exitButton.setBackground(new Color(23, 32, 56));
        exitButton.setForeground(new Color(222, 158,65));
        potionScreenButtonPanel.add(exitButton);

    }

    public void changeImage(String imagePath) {
        ImageIcon newIcon = new ImageIcon(imagePath);
        imageLabel.setIcon(newIcon);
        ImagePanel.revalidate(); // Refresh layout
        ImagePanel.repaint();    // Force UI redraw
    }
    public void changeImageGegner(String imagePath) {
        ImageIcon newIcon = new ImageIcon(imagePath);
        imageLabelGegner.setIcon(newIcon);
        imageLabelGegner.revalidate(); // Refresh layout
        imageLabelGegner.repaint();    // Force UI redraw
    }
    public void changeImagePlayer(String imagePath) {
        ImageIcon newIcon = new ImageIcon(imagePath);
        imageLabelPlayer.setIcon(newIcon);
        imageLabelPlayer.revalidate(); // Refresh layout
        imageLabelPlayer.repaint();    // Force UI redraw
    }

    /**
     * Cheapter 1
     */

    DB db = new DB();

    public void startGame() throws SQLException {
        msc.playBackground1();
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
        ImagePanel.setVisible(false);
        imageLabel.setVisible(false);
        changeImage("Images/Hintergründe/Dungeon1Hintergrund.png");

    }

    public void anfangsSzene() throws SQLException {
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
        ImagePanel.setVisible(false);
        imageLabel.setVisible(false);
        changeImage("Images/Hintergründe/Dungeon3GängeHintergrund.png");
    }

    public void tavernSzene() throws SQLException {
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
        changeImage("Images/Hintergründe/TaverneHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void tavernSzene2() throws SQLException {
        position = "tavernCenter2";
        playerPosition = "Tavern Center";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Drunken knight: Wrong answer");
        choiceButton1.setText("FIGHT");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/TaverneHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }


    public void tavernFight() throws SQLException {
        position = "tavernFight";
        Enemy enemy = new Enemy("DRUNKENKNIGHT");
        createFightScreen(enemy,"DRUNKENKNIGHT");
        
    }

    public void afterFight() throws SQLException {

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
        changeImage("Images/Hintergründe/TaverneHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void prisonScene() throws SQLException {
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
        changeImage("Images/Hintergründe/KerkerHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void queenOffer() throws SQLException {
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
        changeImage("Images/Hintergründe/KerkerHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void queenYes() throws SQLException {
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
        changeImage("Images/Hintergründe/WaffenkammerHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void queenNo() throws SQLException {
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
        changeImage("Images/Hintergründe/KerkerHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void weaponChamber() throws SQLException {
        position = "weaponsSelect";
        playerPosition = "Secret Weapon Chamber";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("\nQueen: Good choice.\n" +
                "*You leave the chamber and go to the streets of the King's Realm to gather information.*");
        choiceButton1.setText("Go to Tavern");
        choiceButton2.setText("Go to Marketplace");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/StraßeDesKönigreichsHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void tavernRevisited() throws SQLException {
        position = "tavernRevisited";
        playerPosition = "Tavern";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("\n*Two guards stand in front of the door.*\n" +
                "Guard: Get out, you are not welcome here!");
        choiceButton1.setText("... Go to \nMarketplce");
        choiceButton2.setText("I'm looking for the princess.");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/StraßeDesKönigreichsHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void goToMarketplace() throws SQLException {
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
        changeImage("Images/Hintergründe/TaverneHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void marketplace() throws SQLException {
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
        changeImage("Images/Hintergründe/MarktplatzHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void appleSeller()throws SQLException {
        position = "appleSeller";
        playerPosition = "Marketplace - Apple Seller";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("...");
        choiceButton1.setText("I'm looking for the princess.");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/MarktplatzHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);


    }

    public void appleSellerAwnser()throws SQLException {
        position = "appleSeller1";
        playerPosition = "Marketplace - Apple Seller";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Buy something and I'll see what I can   do.\n");
        choiceButton1.setText("Buy");
        choiceButton2.setText("Refuse");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/MarktplatzHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }
    public void appleSellerABuy()throws SQLException {
        position = "appleSeller2";
        playerPosition = "Marketplace - Apple Seller";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Player: An apple please. \n" +
                "Owner: Here choose one, and then ask your question");
        choiceButton1.setText("Take an Apple");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/MarktplatzHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void appleSellerABuy1()throws SQLException {
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
        changeImage("Images/Hintergründe/MarktplatzHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void appleSellerAReject()throws SQLException {
        position = "appleSellerReject";
        playerPosition = "Marketplace - Apple Seller";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Player: No, I don't want an apple.\n" +
                "Owner: Then get lost, you're scaring my customers away! \n");
        choiceButton1.setText("Go Away");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/MarktplatzHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void appleSellerAReject1()throws SQLException {
        position = "appleSellerReject1";
        playerPosition = "Alley";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Player walks and is approached by an old man in an alley*\n");
        choiceButton1.setText("Talk to the Old man");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/MarktplatzHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }




    public void blacksmith()throws SQLException {
        position = "blacksmith";
        playerPosition = "Marketplace - Blacksmith";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("...");
        choiceButton1.setText("I'm looking for the princess.\n");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/MarktplatzHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void blacksmith1()throws SQLException {
        position = "blacksmith1";
        playerPosition = "Marketplace - Blacksmith";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("...");
        choiceButton1.setText("I'm looking for the outcast princess!");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/MarktplatzHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void blacksmith2()throws SQLException {
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
        changeImage("Images/Hintergründe/MarktplatzHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void blacksmith3()throws SQLException {
        position = "blacksmith3";
        playerPosition = "Marketplace - Blacksmith";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Player searches the alley and finds an old man\n" +
                "The old man speaks to the player");
        choiceButton1.setText("...");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/GasseVorStadttorHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void oldManAlley()throws SQLException {
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
        changeImage("Images/Hintergründe/GasseVorStadttorHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void oldManAlley1()throws SQLException {
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
        changeImage("Images/Hintergründe/GasseVorStadttorHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void oldManAlley2()throws SQLException {
        position = "oldManAlley2";
        playerPosition = "Alley";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Player receives map from the old man\n" +
                "And sets off on the journey*");
        choiceButton1.setText("Start the journey");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/GasseVorStadttorHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }


    /**
     *  Cheapter 2
     */

    public void ch2followMap()throws SQLException {
        msc.playBackground2();
        position = "ch2followMap";
        playerPosition = "Intro";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player follows the instructions.* \n" +
                "*This leads him out of the city, through dark forests, and to a ruined castle. Loud noises emanate from the\n" +
                "undergrowth. Suddenly, a pack of wolves leaps out of the bushes.*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/WaldHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void ch2fwolves()throws SQLException {
        position = "ch2wolves1";
        playerPosition = "Ruined Castle";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Three hungry wolves circle the player* \n" +
                "*Their teeth flashing in the moonlight.*");
        choiceButton1.setText("Fight");
        choiceButton2.setText("Flee");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/WaldHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void ch2fwolvescp2afterwolvesScene()  throws SQLException  {
        position = "ch2fwolvescp2afterwolvesScene";
        Enemy enemy = new Enemy("WOLVES");
        createFightScreen(enemy,"WOLVES");
            }

    public void cp2afterwolvesFight()throws SQLException {
        position = "ch2afterwolvesFight";
        playerPosition = "Ruined Castle";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*After the fight, the Player looks at his map and discovers a secret entrance.*\n" +
                "*A stone staircase that leads deep into the earth.* \n" +
                "*The player carefully steps down.*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/WaldRuinenHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2afterwolvesFlee()throws SQLException {
        position = "ch2afterwolvesFlee";
        playerPosition = "Ruined Castle";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The Player fleed and looks at his map and discovers a secret entrance.*\n" +
                "*A stone staircase that leads deep into the earth.* \n" +
                "*The player carefully steps down.*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/WaldHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2dungeon1()throws SQLException {
        position = "cp2dungeon1";
        playerPosition = "Dungeon";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player reaches the bottom of the stairs, \n" +
                "realizing that he is in an old, labyrinthine dungeon.*\n" +
                "*Cobwebs hang from the ceiling and torches cast light on the stone walls.\n" +
                " The first room seems to be empty*\n");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/Dungeon1Hintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2dungeonFight()throws SQLException {
        position = "cp2dungeonFight";
        playerPosition = "Dungeon Fight";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Two armored skeletons rise from the dust, their rusty swords drawn.*\n");
        choiceButton1.setText("Fight");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/Dungeon1Hintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2dungeonFightScene()throws SQLException {
        position = "cp2dungeonFightScene";
        Enemy enemy = new Enemy("SKELLETGUARD");
        createFightScreen(enemy,"SKELLETGUARD");
    }

    public void cp2dungeonAfterFight()throws SQLException {
        position = "cp2dungeonAfterFight";
        playerPosition = "Dungeon Room";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*After the victory, the player searches the room and finds an old chest. \n" +
                "Inside lies a magic spell you found a random spell)*\n" +
                "*And an old key, the player continues deeper into the dungeon.*\n");
        choiceButton1.setText("Collect Key");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/Dungeon1Hintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2dungeonlabyrinth()throws SQLException {
        position = "cp2dungeonlabyrinth";
        playerPosition = "Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player enters a long corridor that splits into many directions after a few meters.*\n");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/Dungeon3GängeHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2dungeonlabyrinthChoose()throws SQLException {
        position = "cp2dungeonlabyrinthChoose";
        playerPosition = "Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player sees Three paths*\n");
        choiceButton1.setText("Left path *hears subtle noises.*");
        choiceButton2.setText("The middle path *A seemingly safe path*");
        choiceButton3.setText("The right-hand path *A wide open area with corpses of past adventurers.*");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/Dungeon3GängeHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2LeftPath()throws SQLException {
        position = "cp2dungeonlabyrinthleft";
        playerPosition = "Dungeon Labyrinth Left";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player encounters a trap*\n");
        choiceButton1.setText("*Continue*");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonLinkerPfadHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2TheMiddlePath()throws SQLException {
        position = "cp2dungeonlabyrinthmiddle";
        playerPosition = "Dungeon Labyrinth Middle";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player briefly loses his orientation(room switch?) \n" +
                "but can discovers three secret weapons. *\n");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonWaffenkammerHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2TheRightHandPath()throws SQLException {
        position = "cp2dungeonlabyrinthright";
        playerPosition = "Dungeon Labyrinth Right";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Here lurks a powerful spirit warrior guarding a rare weapon*\n");
        choiceButton1.setText("Fight");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonRechterGangHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2TheRightHandPathScene()throws SQLException {
        position = "cp2dungeonlabyrinthrightScene";
        Enemy enemy = new Enemy("SHADOWGUARDS");
        createFightScreen(enemy,"SHADOWGUARDS");
    }

    public void cp2TheRightHandPathFight()throws SQLException {
        position = "cp2dungeonlabyrinthrighFightt";
        playerPosition = "Dungeon Labyrinth Right";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Spirit warrior guarding a rare weapon*\n");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonRechterGangHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2EncounterInLabyrinth()throws SQLException {
        position = "cp2EncounterInLabyrinth";
        playerPosition = "Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*As the player moves through the dark corridor*\n" +
                "*He notices a figure in the shadows appears.*\n" +
                "*A confused old man steps forward*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonHintergrundDunkleKorridorHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2EncounterOldMen()throws SQLException {
        position = "cp2EncounterOldMen";
        playerPosition = "Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Old Man: Ah, a traveler... traveler... Are you looking for the Princess?\n");
        choiceButton1.setText("Yes, where is she?");
        choiceButton2.setText("Ignore the Men");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonHintergrundDunkleKorridorHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2EncounterOldMenYes()throws SQLException {
        position = "cp2EncounterOldMenYes";
        playerPosition = "Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Old Man: Stick to the right and use the first door u see\n");
        choiceButton1.setText("Thanks, the player moves on");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonHintergrundDunkleKorridorHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2EncounterOldMenNo()throws SQLException {
        position = "cp2EncounterOldMenNo";
        playerPosition = "Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The Player Continues*");
        choiceButton1.setText("...");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonHintergrundDunkleKorridorHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2EncounterAdventurer()throws SQLException {
        position = "cp2EncounterAdventurer";
        playerPosition = "Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Player found a captured adventurer in a cell\n" +
                "Adventurer: Please, save me!\n" +
                "I can help you! \n" +
                "*Player found a captured adventurer in a cell*\n");
        choiceButton1.setText("Free him");
        choiceButton2.setText("Leave him behind");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonZelleHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2EncounterAdventurerFree()throws SQLException {
        position = "cp2EncounterAdventurerFree";
        playerPosition = "Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player opens the cage and gives the adventurer a healing potion*" +
                "*Adventurer gives Player 2+ Strength potions*\n");
        choiceButton1.setText("Move on");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonZelleHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2EncounterAdventurerMoveOn()throws SQLException {
        position = "cp2EncounterAdventurerFree1";
        playerPosition = "Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The Player moves on*\n" +
                "*The player hears a quiet voice as he goes nearer a \n" +
                "shadowy silhouette and speaks in riddles*\n");
        choiceButton1.setText("...");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonZelleHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2Encountershadowysilhouette()throws SQLException {
        position = "cp2Encountershadowysilhouette";
        playerPosition = "Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("A shadowy silhouette: I can speak without having a mouth.\n" +
                " I can hear without having ears. \n" +
                " I have no body parts, but I can understand you.\n" +
                " What am I?\n");
        choiceButton1.setText("An echo");
        choiceButton2.setText("A shadow");
        choiceButton3.setText("A thought");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonMittlererPfadHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2Encountershadowysilhouetteture()throws SQLException {
        position = "cp2Encountershadowysilhouettetrue";
        playerPosition = "Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Shadowy Silhouette: You are right its the echo you can now go\n");
        choiceButton1.setText("Move on");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonMittlererPfadHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2Encountershadowysilhouetteturefalse()throws SQLException {
        position = "cp2Encountershadowysilhouettefalse";
        playerPosition = "Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("shadowy silhouette: Wrong Awnser! ");
        choiceButton1.setText("Try again");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonMittlererPfadHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2EncountershadowysilhouetteMoveOn()throws SQLException {
        position = "cp2EncountershadowysilhouetteMoveOn";
        playerPosition = "Dungeon Labyrinth";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*After the Player discovers a door decorated with runes.*\n" +
                "*The player uses the key he has found and enters*\n" +
                "*After a few more long corridors the player reaches a huge\n" +
                "chamber where The lord of the dungeon is waiting.*\n");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonRunentürHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2miniboss()throws SQLException {
        position = "cp2miniboss1";
        playerPosition = "Huge Chamber";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*In burning lava stands a creature*\n" +
                "Its... the Dark Titan, Azroth!.");
        choiceButton1.setText("...");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonMinibossKampfraumHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2miniboss1()throws SQLException {
        position = "cp2miniboss2";
        playerPosition = "Huge Chamber";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Azroth: Mortal, you have desecrated my halls.\n" +
                "Your life ends here!");
        choiceButton1.setText("Direct combat");
        choiceButton2.setText("Use the environment");
        choiceButton3.setText("Negotiate with Azroth");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonMinibossKampfraumHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2miniboss1fight()throws SQLException {
        position = "cp2miniboss2fight";
        Enemy enemy = new Enemy("AZROTH");
        createFightScreen(enemy,"AZROTH");
    }

    public void cp2miniboss1Win()throws SQLException {
        position = "cp2miniboss2fightWin";
        playerPosition = "Huge Chamber Won";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Azroth falls to the ground.*\n" +
                "*The path to the Princess is now free*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonTreppeRichtungTurmHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2miniboss1Rescue()throws SQLException {
        position = "cp2miniboss1Rescue";
        playerPosition = "Tower";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player moves up the stairs to the tower.* \n" +
                "Right before the princess’s door, two Guardians appear.*\n" +
                "*Two elite knights in black armor confront the player.*");
        choiceButton1.setText("Fight");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonTreppezumTurmHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2miniboss1TowerFightScene()throws SQLException {
        position = "cp2miniboss1RescueWonScene";
        Enemy enemy = new Enemy("ELITEKNIGHTS");
        createFightScreen(enemy,"ELITEKNIGHTS");
            }

    public void cp2miniboss1TowerFight()throws SQLException {
        position = "cp2miniboss1RescueWon";
        playerPosition = "Tower";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*You defeated the Elite Knights* \n" +
                "*You got a Royal Key*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonMassiveTürvorPrizessinRaumHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp2miniboss1TowerFightWon()throws SQLException {
        position = "cp2miniboss1RescueWon1";
        playerPosition = "Tower Princess";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player uses the key to open the Princess's room.*\n" +
                "Princess: “Finally! You've come... We must leave quickly before Cerberus\n" +
                "appears!”\n" +
                "*A loud growl shakes the room.*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonPrinzessinenTurmRaumHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }
    public void cp2miniboss1TowerUnknown()throws SQLException {
        position = "cp2miniboss1TowerUnknown";
        playerPosition = "Tower Princess";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Unknown: Grrr!!!\n" +
                "*A huge 3-headed dog appears behind the player and attacks him.*");
        choiceButton1.setText("....");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonPrinzessinenTurmRaumHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    /**
     * Cheapter 3
     */

    public void cp3TheEscape()throws SQLException {
        msc.playBackground3();
        position = "cp3TheEscape";
        playerPosition = "Tower Princess";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("The three-headed dog bares its teeth, \n" +
                "its deep growl echoes through the tower.\n" +
                "The princess crouches behind the Player.");
        choiceButton1.setText("Direct combat");
        choiceButton2.setText("Distraction");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonPrinzessinenTurmRaumHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp3TheEscapeOption1()throws SQLException {
        position = "cp3TheEscapeOption1";
        Enemy enemy = new Enemy("CERBERUS");
        createFightScreen(enemy,"CERBERUS");
    }

    public void cp3TheEscapeOption2()throws SQLException {
        position = "cp3TheEscapeOption2";
        playerPosition = "Tower Princess Distraction";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player uses a stone that has fallen out of a crumbling wall*\n" +
                "*and throws it at a chandelier behind the dog to distract him.*\n" +
                "*The player tries to escape with the princess.*");
        choiceButton1.setText("...");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonPrinzessinenTurmRaumHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp3TheEscapeFightWon()throws SQLException {
        position = "cp3TheEscapeFightWon";
        playerPosition = "Tower Princess Fight";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Player has won the Fight against the three-headed dog*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonPrinzessinenTurmRaumHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp3TheEscapeFightDistraction()throws SQLException {
        position = "cp3TheEscapeFightDistraction";
        playerPosition = "Tower Princess Distraction";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Player has successful distracted the the three-headed dog*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonPrinzessinenTurmRaumHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp3TheEscapeAfterFight()throws SQLException {
        position = "cp3TheEscapeAfterFight";
        playerPosition = "Tower Princess Fight";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*After the fight, the player moves through \n" +
                "the dark corridors of the dungeon with the princess following.*\n" +
                "*The Player hears Footsteps*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonPrinzessinenTurmRaumHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp3TheEscapeAfterDistraction()throws SQLException {
        position = "cp3TheEscapeAfterDistraction";
        playerPosition = "Tower Princess Fight";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player moves through the dark corridors of the dungeon\n" +
                "with the princess following.\n" +
                "The Player hears Footsteps*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonMassiveTürvorPrizessinRaumHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp3Guard()throws SQLException {
        position = "cp3Guard";
        playerPosition = "Dark Corridors";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Guard: Stop right there!");
        choiceButton1.setText("Ignore");
        choiceButton2.setText("Attack");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonTreppeRichtungTurmHintergrundverbarikadiert.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp3GuardIgnore()throws SQLException {
        position = "cp3GuardIgnore";
        playerPosition = "Dark Corridors";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Player Ignores the Guard and Flees with the princess*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/DungeonHintergrundDunkleKorridorHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp3GuardAttack()throws SQLException {
        position = "cp3GuardAttack";
        Enemy enemy = new Enemy("PRINCESSGUARD");
        createFightScreen(enemy,"PRINCESSGUARD");
    }

    public void cp3GuardAfter()throws SQLException {
        position = "cp3GuardAfter";
        playerPosition = "Surface";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The escape continues as the player leads the \n" +
                "princess through the labyrinthine corridors back to the surface. *");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/Dungeon1Hintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp3surface()throws SQLException {
        position = "cp3surface";
        playerPosition = "Surface";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Princess: We are out!\n" +
                " I am finally free! \n" +
                " I was trapped for so long. \n" +
                " Thank you, Adventurer!?");
        choiceButton1.setText("No Problem");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/WaldRuinenNachtHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp3Goblins()throws SQLException {
        position = "cp3Goblins";
        playerPosition = "Surface";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*As The Player and Princess wanted to head in the Castles direction.*\n" +
                "*they get interrupted by a group of goblins.*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/WaldNachtHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp3GoblinsFight()throws SQLException {
        position = "cp3GoblinsFight";
        playerPosition = "Surface Fight";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Three goblins block the dirt road.* \n" +
                "*The player has no choice but to defend the princess* \n" +
                "Goblins: Give me the princess!");
        choiceButton1.setText("No way!");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/WaldNachtHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp3GoblinsFightScene()throws SQLException {
        position = "cp3GoblinsFightScene";
        Enemy enemy =new Enemy("GOBLIN");        
        createFightScreen(enemy,"GOBLIN");
    }

    public void cp3Night()throws SQLException {
        position = "cp3Night";
        playerPosition = "Surface Night";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player and Princess continue their journey.\n" +
                "Night arises.*'");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/WaldNachtHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp3NightQuest()throws SQLException {
        position = "cp3NightQuest";
        playerPosition = "Surface Night Quest";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Suddenly they hear a loud cry for help from the road ahead.*\n" +
                "*A trader is being attacked by Skeletons.*");
        choiceButton1.setText("Help the merchant");
        choiceButton2.setText("Ignore the merchant");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/WaldNachtHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp3NightQuestFight()throws SQLException {
        position = "cp3NightQuestFight";
        Enemy enemy = new Enemy("SKELETON");
        createFightScreen(enemy,"SKELETON");
    }

    public void cp3NightQuestAfterFight()throws SQLException {
        position = "cp3NightQuestAfterFight";
        playerPosition = "Surface Night Quest";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player defends the trader by attacking the monsters*\n" +
                "*Trader gives him information about a secret tunnel into the city.*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/WaldNachtHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp3ArriveAtCity()throws SQLException {
        position = "cp3ArriveAtCity";
        playerPosition = "City";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Arrival at the city*\n" +
                "*The city lies before them, but the city gates are heavily\n" +
                "guarded by Two elite guards.*");
        choiceButton1.setText("Direct combat");
        choiceButton2.setText("Alternative route");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/WaldvorStadttorHintergrundNacht.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp3ArriveAtCityFight()throws SQLException {
        position = "cp3ArriveAtCityFight";
        Enemy enemy = new Enemy("EliteGuards");    
        createFightScreen(enemy,"SKELLETGUARD");
    }

    public void cp3ArriveAtCityFightScene()throws SQLException {
        position = "cp3ArriveAtCityFightScene";
        playerPosition = "City Fight ";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player must defeat the guards to get through the gate. *");
        choiceButton1.setText("Fight");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/WaldvorStadttorHintergrundNacht.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);


    }

    public void cp3ArriveAtCityOtherRoute()throws SQLException {
        position = "cp3ArriveAtCityOtherRoute";
        playerPosition = "City Tunnel ";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player uses the information from the trader about \n" +
                "the tunnel that leads into the city*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/GeheimgangHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    /**
     * Cheapter 4
     */


    public void cp4towardsCastle()throws SQLException {
        msc.playBackground4();
        position = "cp4towardsCastle";
        playerPosition = "Towards Castle";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Inside the city, Princess Seidler and the Player continue\n" +
                " towards the Castle located in the middle of Possehl.*\n" +
                "*The player and Princess standing right before the castle´s door*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/SchlossvonStraßeausHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp4InsideCastle()throws SQLException {
        position = "cp4InsideCastle";
        playerPosition = "Inside Castle";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Princess: How do you think we get in?\n" +
                "Player: Just thru the main door. Princess, you will wait outside.\n" +
                "Princess: Good luck Hero.");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/SchlosstorHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp4InsideCastleSkeletons()throws SQLException {
        position = "cp4InsideCastleSkeletons";
        playerPosition = "Inside Castle Skeletons";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The player enters the Castle undetected.*\n" +
                "*Before the Player reaches the throne room 3 Skeleton Guards stand in his way*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/RaumVorTrohnRaumHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp4InsideCastleSkeletonsFight()throws SQLException {
        position = "cp4InsideCastleSkeletonsFight";
        playerPosition = "Inside Castle Fight";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Skeleton/Guards: Stop u have no right to enter this room! \n" +
                "If you don’t stop we will attack you! \n" +
                "Player: Try to stop me!");
        choiceButton1.setText("Fight");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/RaumVorTrohnRaumHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp4InsideCastleSkeletonsFightScene()throws SQLException {
        position = "cp4InsideCastleSkeletonsFightScene";

        Enemy enemy = new Enemy("SKELLETGUARD");
        createFightScreen(enemy,"SKELLETGUARD");
    }

    public void cp4AfterFight()throws SQLException {
        position = "cp4AfterFight";
        playerPosition = "Inside Castle";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("King Heuer: How did u come in?! Guards!! Guards!! \n" +
                "Player: Give up the throne! u have no right to be a King. \n" +
                "I will free this land!\n" +
                "King Heuer: YOU WILL NEVER WIN!? ");
        choiceButton1.setText("FIGHT KING HEUER");
        choiceButton2.setText("Shit in Pants");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/TrohnRaumHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp4BossFight()throws SQLException {
        position = "cp4BossFight";
        Enemy enemy = new Enemy("KING");
        createFightScreen(enemy,"KING");
    }

    public void cp4AfterBossFight()throws SQLException {
        position = "cp4AfterBossFight";
        playerPosition = "After Boss Fight";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("King Heuer : How did I… How did u… \n" +
                " HOW CAN I LOOSE!!!! \n" +
                " …\n" +
                "Player: Now the real one will rule the land.");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/TrohnRaumHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp4AfterBossFight1()throws SQLException {
        position = "cp4AfterBossFight1";
        playerPosition = "After Boss Fight";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Princess gets into the throne room*");
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/TrohnRaumHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }
    public void cp4AfterBossFight2() throws SQLException{
        position = "cp4AfterBossFight2";
        playerPosition = "After Boss Fight";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Princess: Guards throw him into a cell.\n" +
                "Princess: Thank you adventurer u freed the land of Possehl. \n" +
                "I have one last question, Adventurer. \n" +
                "Will u be the King on my side?");
        choiceButton1.setText("Become the new King");
        choiceButton2.setText("Decline");
        choiceButton3.setText("");
        choiceButton4.setText("");
        changeImage("Images/Hintergründe/TrohnRaumHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp4AfterBossFightOption1()throws SQLException {
        position = "cp4AfterBossFightOption1";
        playerPosition = "Become King";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("Player: I will stand at ur side as long as I live.\n" +
                "*The end* *You married the princess and became the king of Possehl \n" +
                "u ruled over the Land for 58years*\n");
        choiceButton1.setVisible(false);
        choiceButton2.setVisible(false);
        choiceButton3.setVisible(false);
        choiceButton4.setVisible(false);
        changeImage("Images/Hintergründe/PlayerKönigGewordenHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    public void cp4AfterBossFightOption2()throws SQLException {
        position = "cp4AfterBossFightOption2";
        playerPosition = "Decline";
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*The End*\n You decline and ride off proudly\n" +
                "23 Minutes later: carriage 1 you 0\n The next princess? Has long saved " +
                "herself.Your epic legend?\n Nerver existed. Wow. Great movie, champion. ");
        choiceButton1.setVisible(false);
        choiceButton2.setVisible(false);
        choiceButton3.setVisible(false);
        choiceButton4.setVisible(false);
        changeImage("Images/Hintergründe/PlayerTotDurchKutscheHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }





    public void SecretEnding()throws SQLException {
        position = "SecretEnding";
        playerPosition = "";
        waffentext2.setText("");
        playerPositiontext2.setText(playerPosition);
        mainTextArea.setText("*Player Shits in Pants and Leaves the Castel!*");
        choiceButton1.setVisible(false);;
        choiceButton2.setVisible(false);
        choiceButton3.setVisible(false);
        choiceButton4.setVisible(false);
        changeImage("Images/Hintergründe/TrohnRaumHintergrund.png");
        ImagePanel.setVisible(true);
        imageLabel.setVisible(true);

    }

    private class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            switch (position) {
                case "anfangsSzene1":
                    if (yourChoice.equals("c1")) {
                        try {
                            anfangsSzene(); // Move to the next scene
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case "anfangsSzene2":
                    if (yourChoice.equals("c1")) {
                        try {
                            tavernSzene(); // Move to the tavern scene
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "tavernCenter":
                    if (yourChoice.equals("c1")) {
                        try {
                            tavernSzene2(); // Start the tavern fight
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "tavernCenter2":
                    if (yourChoice.equals("c1")) {
                        try {
                            tavernFight();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "afterFight":
                    if (yourChoice.equals("c1")) {
                        try {
                            prisonScene();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "prison":
                    if (yourChoice.equals("c1")) {
                        try {
                            queenOffer();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    break;

                case "queenOffer":
                    if(yourChoice.equals("c1")){
                        try {
                            queenYes();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if(yourChoice.equals("c2")){
                        try {
                            queenNo();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "queenYes":
                    if (yourChoice.equals("c1")) {
                        waffentext2.setText("Sword");
                        waffe = "Sword";
                        try {
                            weaponChamber();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (yourChoice.equals("c2")) {
                        waffentext2.setText("Axe");
                        waffe = "Axe";
                        try {
                            weaponChamber();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "queenNo":
                    if (yourChoice.equals("c1")) {
                        try {
                            queenOffer();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "weaponsSelect":
                    if (yourChoice.equals("c1")) {
                        try {
                            tavernRevisited();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (yourChoice.equals("c2")) {
                        try {
                            marketplace();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "tavernRevisited":
                    if (yourChoice.equals("c1"))
                    {
                        try {
                            marketplace();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if (yourChoice.equals("c2")) {
                        try {
                            goToMarketplace();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "tavernRevisited1":
                    if (yourChoice.equals("c1"))
                    {
                        try {
                            marketplace();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "marketplace":
                    if (yourChoice.equals("c1")) {
                        try {
                            appleSeller();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if (yourChoice.equals("c2")) {
                        try {
                            blacksmith();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    break;

                case "appleSeller":
                    if (yourChoice.equals("c1")) {
                        try {
                            appleSellerAwnser();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    break;

                case "appleSeller1":
                    if (yourChoice.equals("c1")) {
                        try {
                            appleSellerABuy();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if (yourChoice.equals("c2")) {
                        try {
                            appleSellerAReject();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "appleSeller2":
                    if (yourChoice.equals("c1")) {
                        try {
                            appleSellerABuy1();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "appleSeller3":
                    if (yourChoice.equals("c1")) {
                        try {
                            oldManAlley();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "oldManAlley":
                    if (yourChoice.equals("c1")) {
                        try {
                            oldManAlley1();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "oldManAlley1":
                    if (yourChoice.equals("c1")) {
                        try {
                            oldManAlley2();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "appleSellerReject":
                    if (yourChoice.equals("c1")) {
                        try {
                            appleSellerAReject1();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "blacksmith":
                    if (yourChoice.equals("c1")) {
                        try {
                            blacksmith1();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;


                case "blacksmith1":
                    if (yourChoice.equals("c1")) {
                        try {
                            blacksmith2();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "blacksmith2":
                    if (yourChoice.equals("c1")) {
                        try {
                            blacksmith3();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "blacksmith3":
                    if (yourChoice.equals("c1")) {
                        try {
                            oldManAlley();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "appleSellerReject1":
                    if (yourChoice.equals("c1")) {
                        try {
                            oldManAlley();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "oldManAlley2":
                    if (yourChoice.equals("c1")) {
                        try {
                            db.updateLocation(playerIDD, "cp1Finish"); // Updatet die Datenbank um den Speicherort in die DB zu speichern und das Spiel an diesen Ort wieder laden zukönnen
                            ch2followMap();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "ch2followMap":
                    if(yourChoice.equals("c1")){
                        try {
                            ch2fwolves();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "ch2wolves1":
                    if(yourChoice.equals("c1")){
                        try {
                            ch2fwolvescp2afterwolvesScene(); // Hier muss die Kampf Methode gegen den die Wölfe eingefügt werden.
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if(yourChoice.equals("c2")){
                        try {
                            cp2afterwolvesFlee();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "ch2fwolvescp2afterwolvesScene":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2afterwolvesFight();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "ch2afterwolvesFlee":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2dungeon1();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "ch2afterwolvesFight":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2dungeon1();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp2dungeon1":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2dungeonFight();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp2dungeonFight":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2dungeonFightScene();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp2dungeonFightScene":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2dungeonAfterFight();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp2dungeonAfterFight":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2dungeonlabyrinth();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp2dungeonlabyrinth":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2dungeonlabyrinthChoose();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp2dungeonlabyrinthChoose":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2LeftPath();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if(yourChoice.equals("c2")){
                        try {
                            cp2TheMiddlePath();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if(yourChoice.equals("c3")){
                        try {
                            cp2TheRightHandPath(); // Hier ist der Kampf gegen den Spirit warrior guardian Kampfmethode hier einfügen
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;


                case "cp2dungeonlabyrinthleft":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2EncounterInLabyrinth();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp2dungeonlabyrinthmiddle":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2EncounterInLabyrinth();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp2dungeonlabyrinthright":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2TheRightHandPathScene();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp2dungeonlabyrinthrightScene":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2TheRightHandPathFight();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp2dungeonlabyrinthrighFightt":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2EncounterInLabyrinth();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp2EncounterInLabyrinth":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2EncounterOldMen();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp2EncounterOldMen":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2EncounterOldMenYes();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if(yourChoice.equals("c2")){
                        try {
                            cp2EncounterOldMenNo();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp2EncounterOldMenYes":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2EncounterAdventurer();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp2EncounterOldMenNo":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2EncounterAdventurer();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;


                case "cp2EncounterAdventurer":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2EncounterAdventurerFree();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if(yourChoice.equals("c2")){
                        try {
                            cp2EncounterAdventurerMoveOn();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;


                case "cp2EncounterAdventurerFree":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2EncounterAdventurerMoveOn();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;


                case "cp2EncounterAdventurerFree1":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2Encountershadowysilhouette();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;


                case "cp2Encountershadowysilhouette":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2Encountershadowysilhouetteture();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if(yourChoice.equals("c2")){
                        try {
                            cp2Encountershadowysilhouetteturefalse();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if(yourChoice.equals("c3")){
                        try {
                            cp2Encountershadowysilhouetteturefalse();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;


                case "cp2Encountershadowysilhouettetrue":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2EncountershadowysilhouetteMoveOn();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;


                case "cp2Encountershadowysilhouettefalse":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2Encountershadowysilhouette();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;


                case "cp2EncountershadowysilhouetteMoveOn":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2miniboss();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;


                case "cp2miniboss1":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2miniboss1();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;


                case "cp2miniboss2":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2miniboss1fight();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if(yourChoice.equals("c2")){
                        try {
                            cp2miniboss1fight();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if(yourChoice.equals("c3")){
                        try {
                            cp2miniboss1fight();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;


                case "cp2miniboss2fight":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2miniboss1Win();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;


                case "cp2miniboss2fightWin":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2miniboss1Rescue();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;


                case "cp2miniboss1Rescue":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2miniboss1TowerFightScene();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp2miniboss1RescueWonScene":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2miniboss1TowerFight();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;



                case "cp2miniboss1RescueWon":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2miniboss1TowerFightWon();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp2miniboss1RescueWon1":
                    if(yourChoice.equals("c1")){
                        try {
                            cp2miniboss1TowerUnknown();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp2miniboss1TowerUnknown":
                    if(yourChoice.equals("c1")){
                        try {
                            db.updateLocation(playerIDD, "cp2Finish"); // Updatet die Datenbank um den Speicherort in die DB zu speichern und das Spiel an diesen Ort wieder laden zukönnen
                            cp3TheEscape();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3TheEscape":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3TheEscapeOption1();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if(yourChoice.equals("c2")){
                        try {
                            cp3TheEscapeOption2();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3TheEscapeOption1":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3TheEscapeFightWon(); // Hier soll die Kampfmethode gegen den Hund eingefüght werdem
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3TheEscapeOption2":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3TheEscapeFightDistraction();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3TheEscapeFightWon":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3TheEscapeAfterFight();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3TheEscapeFightDistraction":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3TheEscapeAfterDistraction();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3TheEscapeAfterFight":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3Guard();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3TheEscapeAfterDistraction":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3Guard();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3Guard":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3GuardIgnore();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if(yourChoice.equals("c2")){
                        try {
                            cp3GuardAttack(); // Hier muss die Methode für den Kampf gegen den Wächter eingfügt werden
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3GuardAfter":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3surface();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;


                case "cp3GuardIgnore":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3GuardAfter();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3GuardAttack":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3GuardAfter();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3surface":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3Goblins();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3Goblins":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3GoblinsFight();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3GoblinsFight":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3GoblinsFightScene(); //Hier Muss die Methode für den Kampf gegen die Goblins eingefügt werden
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3GoblinsFightScene":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3Night();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3Night":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3NightQuest();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;



                case "cp3NightQuest":
                    if(yourChoice.equals("c1")){
                        try {
                            ch3Help = "help";
                            cp3NightQuestFight(); //Hier muss die Methode für den Kampf gegen die Skelete eingefügt werden
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if(yourChoice.equals("c2")){
                        try {
                            cp3ArriveAtCity();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3NightQuestFight":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3NightQuestAfterFight();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3NightQuestAfterFight":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3ArriveAtCity();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3ArriveAtCity":
                    if(ch3Help.equals("nothelp")) {
                        choiceButton2.setVisible(false);
                        choiceButton3.setVisible(false);
                        choiceButton4.setVisible(false);
                        if(yourChoice.equals("c1")){
                            try {
                                cp3ArriveAtCityFight();
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    } else if (ch3Help.equals("help")) {
                        if(yourChoice.equals("c1")){
                            try {
                                cp3ArriveAtCityFight();
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                        } else if (yourChoice.equals("c2")) {
                            try {
                                cp3ArriveAtCityOtherRoute();
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    break;

                case "cp3ArriveAtCityFightScene":
                    if(yourChoice.equals("c1")){
                        try {
                            cp3ArriveAtCityFightScene(); //Hier muss die Methode für den Kampf gegen die Zwei Elite Guards eingefügt werden
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp3ArriveAtCityFight":
                    if(yourChoice.equals("c1")){
                        try {
                            cp4towardsCastle();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;


                case "cp3ArriveAtCityOtherRoute":
                    if(yourChoice.equals("c1")){
                        try {// Updatet die Datenbank um den Speicherort in die DB zu speichern und das Spiel an diesen Ort wieder laden zukönnen
                            cp4towardsCastle();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp4towardsCastle":
                    if(yourChoice.equals("c1")){
                        try {
                            db.updateLocation(playerIDD, "cp3Finish");
                            cp4InsideCastle();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp4InsideCastle":
                    if(yourChoice.equals("c1")){
                        try {
                            cp4InsideCastleSkeletons();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp4InsideCastleSkeletons":
                    if(yourChoice.equals("c1")){
                        try {
                            cp4InsideCastleSkeletonsFight();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp4InsideCastleSkeletonsFight":
                    if(yourChoice.equals("c1")){
                        try {
                            cp4InsideCastleSkeletonsFightScene(); //Hier muss die Methodde für den Kampf gegen die Skelete eingefügt werden
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp4InsideCastleSkeletonsFightScene":
                    if(yourChoice.equals("c1")){
                        try {
                            cp4AfterFight();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp4AfterFight":
                    if(yourChoice.equals("c1")){
                        try {
                            cp4BossFight(); //Hier muss die Methode für den BossKampf eingefügt werden
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if(yourChoice.equals("c2")){
                        try {
                            SecretEnding();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp4BossFight":
                    if(yourChoice.equals("c1")){
                        try {
                            cp4AfterBossFight();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp4AfterBossFight":
                    if(yourChoice.equals("c1")){
                        try {
                            cp4AfterBossFight1();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp4AfterBossFight1":
                    if(yourChoice.equals("c1")){
                        try {
                            cp4AfterBossFight2();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case "cp4AfterBossFight2":
                    if(yourChoice.equals("c1")){
                        try {
                            cp4AfterBossFightOption1();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if(yourChoice.equals("c2")){
                        try {
                            cp4AfterBossFightOption2();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                default:
                    System.out.println("Unknown position: " + position);
                    break;

            }
        }
    }
    private void figthSceneManager() throws SQLException {
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
            case "cp3ArriveAtCityFight":
                createGameScreen();
                cp4towardsCastle();
            case "cp4InsideCastleSkeletonsFightScene":
                createGameScreen();
                cp4AfterFight();
                break;
            case "cp4BossFight":
                msc.playBossFight();
                createGameScreen();
                cp4AfterBossFight();
                break;
        }
    }
    private class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                createGameScreen();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
