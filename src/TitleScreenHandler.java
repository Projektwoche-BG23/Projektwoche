import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Game game = new Game();
            game.createGameScreen();
        }
    }


}
