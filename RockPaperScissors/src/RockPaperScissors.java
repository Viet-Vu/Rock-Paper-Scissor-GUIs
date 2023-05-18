import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissors extends JFrame implements ActionListener {

    private Container window;

    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;

    private JButton nextButton;
    private JButton resetButton;
    private JButton closeButton;
    private JButton restartButton;

    private JLabel mainForeground;

    private JLabel userChoice;
    private JLabel cpuChoice;
    private JLabel dwayneHead;
    private JLabel userCharacter;
    private JLabel cpuCharacter;

    private JLabel pScoreboard1;
    private JLabel pScoreboard2;
    private JLabel pScoreboard3;
    private JLabel pScoreboard4;
    private JLabel pScoreboard5;
    private JLabel cScoreboard1;
    private JLabel cScoreboard2;
    private JLabel cScoreboard3;
    private JLabel cScoreboard4;
    private JLabel cScoreboard5;
    private JLabel tieLabel;

    private ImageIcon foreground;

    private ImageIcon playerImage;
    private ImageIcon opponentImage;

    private ImageIcon rockImage;
    private ImageIcon paperImage;
    private ImageIcon scissorsImage;
    private ImageIcon theRockImage;

    private ImageIcon playerCounter;
    private ImageIcon cpuCounter;

    int random = 0; //Used to give the CPU a random choice

    int userScore = 0;
    int cpuScore = 0;
    int tieCount = 0;

    Color buttonBackground = new Color(77, 44, 33);
    Color mainBackground = new Color(45, 35, 33);

    Font buttonFont = new Font("Ariel", Font.BOLD, 24);
    Font labelFont = new Font("Ariel", Font.BOLD, 12);
    Font endButtonFont = new Font("Ariel", Font.BOLD, 28);

    /**
     * CONSTRUCTOR
     * In this program the constructor is run in the main().
     * Calls methods imageSetUp and setUpWindow.
     */
    public RockPaperScissors() {

        imageSetUp();
        setUpWindow();
    }

    /**
     * Used to create the main window.
     * Calls methods createTieLabel and decorateWindow.
     * Called in the main method.
     */
    public void setUpWindow() {

        //This creates a window with the standard setup format.
        window = getContentPane();
        window.setLayout(null);
        window.setBackground(mainBackground);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Just Another Amazing Game Brought to the Virtual World by Digital Means");
        setSize(1200, 700);
        setLocation(325,150);
        setResizable(false);

        createTieLabel(); //Isolated from the others due to conflicts.
        decorateWindow();
    }

    /**
     * Used to associate ImageIcons with .png files.
     * Called in the main method.
     */
    public void imageSetUp() {

        foreground = new ImageIcon("resources/foreground.png");

        playerImage = new ImageIcon("resources/character.png");
        opponentImage = new ImageIcon("resources/opponent.png");

        rockImage = new ImageIcon("resources/choice_rock.png");
        paperImage = new ImageIcon("resources/choice_paper.png");
        scissorsImage = new ImageIcon("resources/choice_scissors.png");
        theRockImage = new ImageIcon("resources/dwayne.png");

        playerCounter = new ImageIcon("resources/player_counter.png");
        cpuCounter = new ImageIcon("resources/opponent_counter.png");
    }

    /**
     * Used to add depth to the main window.
     * Sets up the main foreground decoration.
     * Calls methods setUpScoreSlots, setUpChoiceSlots, setUpChoiceButtons, setUpResetButton, and placeCharacters.
     * Called in setUpWindow and when the restartButton is clicked.
     */
    public void decorateWindow() {

        mainForeground = new JLabel();
        mainForeground.setBounds(0,0,1200,700);
        window.add(mainForeground);
        mainForeground.setIcon(foreground);

        setUpScoreSlots();
        setUpChoiceSlots();
        setUpChoiceButtons();
        setUpResetButton();
        placeCharacters();
    }

    /**
     * Used to set up slots for the players' options for where they would appear.
     * Called in decorateWindow, resetProtocol, and when the nextButton or restartButton is clicked.
     */
    public void setUpChoiceSlots() {

        userChoice = new JLabel();
        userChoice.setBounds(480, 280,75, 50);
        window.add(userChoice);

        cpuChoice = new JLabel();
        cpuChoice.setBounds(645, 280, 75, 50);
        window.add(cpuChoice);

        dwayneHead = new JLabel();
        dwayneHead.setBounds(830, 160, 100, 100);
        window.add(dwayneHead);
    }

    /**
     * Used to create slots and respective images for each player's character.
     * Called in decorateWindow and when restartButton is clicked.
     */
    public void placeCharacters() {

        userCharacter = new JLabel();
        userCharacter.setBounds(150, 125, 400, 375);
        window.add(userCharacter);
        userCharacter.setIcon(playerImage);

        cpuCharacter = new JLabel();
        cpuCharacter.setBounds(650, 125, 400, 375);
        window.add(cpuCharacter);
        cpuCharacter.setIcon(opponentImage);
    }

    /**
     * Used to create a JLabel for the tie counter with default text.
     * Called in setUpWindow.
     */
    public void createTieLabel() {

        tieLabel = new JLabel("TIES: 0");
        tieLabel.setBounds(16, 170, 120, 20);
        tieLabel.setForeground(Color.BLACK);
        tieLabel.setBackground(Color.LIGHT_GRAY);
        tieLabel.setOpaque(true);
        tieLabel.setFont(labelFont);
        window.add(tieLabel);
    }

    /**
     * Used to create the scoreboard.
     * Sets up each individual slot for each player.
     * Called in decorateWindow, resetProtocol, and when restartButton is clicked.
     */
    public void setUpScoreSlots() {

        pScoreboard1 = new JLabel();
        pScoreboard1.setBounds(150,45,50,65);
        window.add(pScoreboard1);

        pScoreboard2 = new JLabel();
        pScoreboard2.setBounds(215, 45, 50, 65);
        window.add(pScoreboard2);

        pScoreboard3 = new JLabel();
        pScoreboard3.setBounds(280, 45, 50, 65);
        window.add(pScoreboard3);

        pScoreboard4 = new JLabel();
        pScoreboard4.setBounds(345, 45, 50 ,65);
        window.add(pScoreboard4);

        pScoreboard5 = new JLabel();
        pScoreboard5.setBounds(410, 45, 50 ,65);
        window.add(pScoreboard5);

        cScoreboard1 = new JLabel();
        cScoreboard1.setBounds(1000, 45, 50, 65);
        window.add(cScoreboard1);

        cScoreboard2 = new JLabel();
        cScoreboard2.setBounds(935, 45, 50, 65);
        window.add(cScoreboard2);

        cScoreboard3 = new JLabel();
        cScoreboard3.setBounds(870, 45, 50, 65);
        window.add(cScoreboard3);

        cScoreboard4 = new JLabel();
        cScoreboard4.setBounds(805, 45, 50, 65);
        window.add(cScoreboard4);

        cScoreboard5 = new JLabel();
        cScoreboard5.setBounds(740, 45, 50,65);
        window.add(cScoreboard5);
    }

    /**
     * Used to create the player's "choice" buttons of rock, paper, or scissors.
     * Called in decorateWindow and when nextButton is clicked.
     */
    public void setUpChoiceButtons() {

        rockButton = new JButton("Rock");
        rockButton.setBounds(50, 560, 140, 70);
        rockButton.setFocusPainted(false);
        rockButton.setBackground(buttonBackground);
        rockButton.setForeground(Color.BLACK);
        rockButton.setFont(buttonFont);
        rockButton.addActionListener(this);
        window.add(rockButton);

        paperButton = new JButton("Paper");
        paperButton.setBounds(205, 560, 140, 70);
        paperButton.setFocusPainted(false);
        paperButton.setBackground(buttonBackground);
        paperButton.setForeground(Color.BLACK);
        paperButton.setFont(buttonFont);
        paperButton.addActionListener(this);
        window.add(paperButton);

        scissorsButton = new JButton("Scissors");
        scissorsButton.setBounds(360, 560, 140, 70);
        scissorsButton.setFocusPainted(false);
        scissorsButton.setFont(buttonFont);
        scissorsButton.setBackground(buttonBackground);
        scissorsButton.setForeground(Color.BLACK);
        scissorsButton.addActionListener(this);
        window.add(scissorsButton);
    }

    /**
     * Used to create the reset button that would allow the player a clean slate.
     * Called in decorateWindow and when restartButton is clicked.
     */
    public void setUpResetButton() {

        resetButton = new JButton("Reset");
        resetButton.setBounds(1010, 560, 140, 70);
        resetButton.setFocusPainted(false);
        resetButton.setFont(buttonFont);
        resetButton.setBackground(buttonBackground);
        resetButton.setForeground(Color.BLACK);
        resetButton.addActionListener(this);
        window.add(resetButton);
    }

    /**
     * Used to create the end game buttons with the choice of restarting or closing the program.
     * Called in produceEndGame.
     */
    public void setUpRestartButtons() {

        closeButton = new JButton("Close");
        closeButton.setBounds(440,180,150,100);
        closeButton.setFocusPainted(false);
        closeButton.setFont(endButtonFont);
        closeButton.setBackground(Color.WHITE);
        closeButton.setForeground(Color.BLACK);
        closeButton.addActionListener(this);
        window.add(closeButton);

        restartButton = new JButton("Restart");
        restartButton.setBounds(610,180,150,100);
        restartButton.setFocusPainted(false);
        restartButton.setFont(endButtonFont);
        restartButton.setBackground(Color.WHITE);
        restartButton.setForeground(Color.BLACK);
        restartButton.addActionListener(this);
        window.add(restartButton);

        repaint();
    }

    /**
     * Used to create the player's next button.
     * Allows a protection from miss clicking and time to react appropriately.
     * Called when any choice buttons are clicked.
     */
    public void setUpNextButton() {

        nextButton = new JButton("Next");
        nextButton.setBounds(855, 560, 140, 70);
        nextButton.setFocusPainted(false);
        nextButton.setFont(buttonFont);
        nextButton.setBackground(buttonBackground);
        nextButton.setForeground(Color.BLACK);
        nextButton.addActionListener(this);
        window.add(nextButton);
    }

    /**
     * Used to remove the player's "choice" buttons.
     * Prevents any attempts to break the code from spamming a choice.
     * Called in endGameClear and when any choice button is clicked.
     */
    public void clearChoices() {

        window.remove(rockButton);
        window.remove(paperButton);
        window.remove(scissorsButton);
    }

    /**
     * Used to reset absolutely everything.
     * Calls methods resetProtocol and clearChoices.
     * Called in produceEndGame.
     */
    public void endGameClear() {

        resetProtocol();
        clearChoices();
        window.remove(nextButton);
        window.remove(resetButton);
    }

    /**
     * Used to offer the player choices when finished with a round.
     * Calls methods endGameClear and setUpRestartButtons.
     * Called in testForEndGame.
     */
    public void produceEndGame() {

        endGameClear();

        setUpRestartButtons();
    }

    /**
     * Used to update the player and cpu counters as well as the tie counter.
     * Calls methods updatePlayer and updateCpu.
     * Called in resetProtocol and when any choice button is clicked.
     */
    public void updateScoreboard() {

        updatePlayer();
        updateCpu();
        tieLabel.setText("TIES: " + tieCount);
    }

    /**
     * Used to update the player's score on the scoreboard.
     * Applies icons as the player scores.
     * Called in updateScoreboard.
     */
    public void updatePlayer() {

        if (userScore >= 1) {

            pScoreboard1.setIcon(playerCounter);
        }

        if (userScore >= 2) {

            pScoreboard2.setIcon(playerCounter);
        }

        if (userScore >= 3) {

            pScoreboard3.setIcon(playerCounter);
        }

        if (userScore >= 4) {

            pScoreboard4.setIcon(playerCounter);
        }

        if (userScore == 5) {

            pScoreboard5.setIcon(playerCounter);
        }
    }

    /**
     * Used to update the cpu's score on the scoreboard.
     * Applies icons as the cpu scores.
     * Called in updateScoreboard.
     */
    public void updateCpu() {

        if (cpuScore >= 1) {

            cScoreboard1.setIcon(cpuCounter);
        }

        if (cpuScore >= 2) {

            cScoreboard2.setIcon(cpuCounter);
        }

        if (cpuScore >= 3) {

            cScoreboard3.setIcon(cpuCounter);
        }

        if (cpuScore >= 4) {

            cScoreboard4.setIcon(cpuCounter);
        }

        if (cpuScore == 5) {

            cScoreboard5.setIcon(cpuCounter);
        }
    }

    /**
     * Used to give the cpu a random choice.
     * Assigns int random a number.
     * Called when any choice buttons are clicked.
     */
    public void randomizeCpu() {

        double d = Math.random() * 100;

        if ((d -= 33) < 0) {

            random = 1;
            cpuChoice.setIcon(rockImage);
        }

        else if ((d -= 33) < 0) {

            random = 2;
            cpuChoice.setIcon(paperImage);
        }

        else if ((d -= 33) < 0) {

            random = 3;
            cpuChoice.setIcon(scissorsImage);
        }

        else {

            random = 4;
            dwayneHead.setIcon(theRockImage);
        }
    }

    /**
     * Used to clear the scoreboard.
     * Called in resetProtocol
     */
    public void clearScoreboard() {

        window.remove(pScoreboard1);
        window.remove(pScoreboard2);
        window.remove(pScoreboard3);
        window.remove(pScoreboard4);
        window.remove(pScoreboard5);
        window.remove(cScoreboard1);
        window.remove(cScoreboard2);
        window.remove(cScoreboard3);
        window.remove(cScoreboard4);
        window.remove(cScoreboard5);
    }

    /**
     * Used to give a soft restart.
     * Calls methods clearChoiceSlots, setUpChoiceSlots, clearScoreboard, setUpScoreSlots, and updateScoreboard.
     * Called in endGameClear and when resetButton is clicked.
     */
    public void resetProtocol() {

        userScore = 0;
        cpuScore = 0;
        tieCount = 0;

        clearChoiceSlots();
        setUpChoiceSlots();

        clearScoreboard();
        setUpScoreSlots();
        updateScoreboard();

        repaint();
    }

    /**
     * Used to clear each players' choice slots.
     * Called in clearNextSlots and resetProtocol.
     */
    public void clearChoiceSlots() {

        window.remove(userChoice);
        window.remove(cpuChoice);
        window.remove(dwayneHead);
    }

    /**
     * Used to check who wins when the player picks rock and gives the score appropriately.
     * Called when rockButton is clicked.
     */
    public void checkForRock() {

        if (random == 1) {

            tieCount++;
        }

        else if (random == 3) {

            userScore++;
        }

        else {

            cpuScore++;
        }
    }

    /**
     * Used to check who wins when the player picks paper and gives the score appropriately.
     * Called when PaperButton is clicked.
     */
    public void checkForPaper() {

        if (random == 1) {

            userScore++;
        }

        else if (random == 2) {

            tieCount++;
        }

        else {

            cpuScore++;
        }
    }

    /**
     * Used to check who wins when the player picks scissors and gives the score appropriately.
     * Called when scissorsButton is clicked.
     */
    public void checkForScissors() {

        if(random == 2) {

            userScore++;
        }

        else if (random == 3) {

            tieCount++;
        }

        else {

            cpuScore++;
        }
    }

    /**
     * Used to clear each player's choice along with nextButton.
     * Calls the method clearChoiceSlots.
     * Called when nextButton is clicked.
     */
    public void clearNextSlots() {

        clearChoiceSlots();
        window.remove(nextButton);
    }

    /**
     * Used to check to see if someone wins.
     * Calls the method produceEndGame.
     * Called when nextButton is clicked.
     */
    public void testForEndGame() {

        if (userScore == 5 || cpuScore == 5) {

            produceEndGame();
        }
    }

    @Override

    /**
     * Used to listen for appropriate buttons.
     * Checks for resetButton, rockButton, paperButton, scissorsButton, nextButton, restartButton, and closeButton.
     * @param e : Information about the event that occurred.
     */
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resetButton) {

            resetProtocol();
        }

        if (e.getSource() == rockButton) {

            randomizeCpu();

            userChoice.setIcon(rockImage);

            setUpNextButton();
            clearChoices();
            repaint();

            checkForRock();
            updateScoreboard();
        }

        if (e.getSource() == paperButton) {

            randomizeCpu();

            userChoice.setIcon(paperImage);

            setUpNextButton();
            clearChoices();
            repaint();

            checkForPaper();
            updateScoreboard();
        }

        if (e.getSource() == scissorsButton) {

            randomizeCpu();

            userChoice.setIcon(scissorsImage);

            setUpNextButton();
            clearChoices();
            repaint();

            checkForScissors();
            updateScoreboard();
        }

        if (e.getSource() == nextButton) {

            clearNextSlots();

            setUpChoiceButtons();
            setUpChoiceSlots();
            repaint();

            testForEndGame();
        }

        if (e.getSource() == restartButton) {

            window.remove(closeButton);
            window.remove(restartButton);
            decorateWindow();
            setUpChoiceSlots();
            placeCharacters();
            setUpScoreSlots();
            window.add(rockButton);
            window.add(paperButton);
            window.add(scissorsButton);
            setUpResetButton();
        }

        if (e.getSource() == closeButton) {

            System.exit(0);
        }
    }

    /**
     * This the the main method.
     */
    public static void main(String[] args) {

        RockPaperScissors game = new RockPaperScissors();
        game.setVisible(true);
    }
}
