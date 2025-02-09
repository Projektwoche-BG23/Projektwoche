import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sounds {

    private Clip storyMusic;
    private Clip battleMusic;

    public Sounds() {

        try {
            // Load the audio file (replace the path with your actual file path)
            File storyFile = new File("Musics/Story.wav");

            // Create an AudioInputStream from the file
            AudioInputStream storyStream = AudioSystem.getAudioInputStream(storyFile);

            // Get a Clip to play the audio
            storyMusic = AudioSystem.getClip();
            storyMusic.open(storyStream);



            // Load the audio file (replace the path with your actual file path)
            File battleFile = new File("Musics/Battle.wav");

            // Create an AudioInputStream from the file
            AudioInputStream battleStream = AudioSystem.getAudioInputStream(battleFile);

            // Get a Clip to play the audio
            battleMusic = AudioSystem.getClip();
            battleMusic.open(battleStream);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void playStory() {
        battleMusic.stop();
        storyMusic.start();
    }

    public void playBattle() {
        storyMusic.stop();
        battleMusic.start();
    }

}
