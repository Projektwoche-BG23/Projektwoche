import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sounds {

    private Clip backgroundMusic1;
    private Clip backgroundMusic2;
    private Clip backgroundMusic3;
    private Clip backgroundMusic4;
    private Clip fightMusic1;
    private Clip fightMusic2;
    private Clip bossFightMusic;

    public Sounds() {

        try {
            File background1File = new File("Musics/backgroundMusic1.wav");
            AudioInputStream background1Stream = AudioSystem.getAudioInputStream(background1File);
            backgroundMusic1 = AudioSystem.getClip();
            backgroundMusic1.open(background1Stream);

            //--------------

            File background2File = new File("Musics/backgroundMusic2.wav");
            AudioInputStream background2Stream = AudioSystem.getAudioInputStream(background2File);
            backgroundMusic2 = AudioSystem.getClip();
            backgroundMusic2.open(background2Stream);

            //--------------

            File background3File = new File("Musics/backgroundMusic3.wav");
            AudioInputStream background3Stream = AudioSystem.getAudioInputStream(background3File);
            backgroundMusic3 = AudioSystem.getClip();
            backgroundMusic3.open(background3Stream);

            //--------------

            File background4File = new File("Musics/backgroundMusic4.wav");
            AudioInputStream background4Stream = AudioSystem.getAudioInputStream(background4File);
            backgroundMusic4 = AudioSystem.getClip();
            backgroundMusic4.open(background4Stream);

            //--------------

            File fightMusic1File = new File("Musics/fightMusic1.wav");
            AudioInputStream fightMusic1Stream = AudioSystem.getAudioInputStream(fightMusic1File);
            fightMusic1 = AudioSystem.getClip();
            fightMusic1.open(fightMusic1Stream);

            //--------------

            File fightMusic2File = new File("Musics/fightMusic2.wav");
            AudioInputStream fightMusic2Stream = AudioSystem.getAudioInputStream(fightMusic2File);
            fightMusic2 = AudioSystem.getClip();
            fightMusic2.open(fightMusic2Stream);

            //--------------

            File bossFightFile = new File("Musics/bossFight.wav");
            AudioInputStream bossFightStream = AudioSystem.getAudioInputStream(bossFightFile);
            bossFightMusic = AudioSystem.getClip();
            bossFightMusic.open(bossFightStream);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void stopAll()
    {
        backgroundMusic1.stop();
        backgroundMusic2.stop();
        backgroundMusic3.stop();
        backgroundMusic4.stop();
        fightMusic1.stop();
        fightMusic2.stop();
        bossFightMusic.stop();
    }

    public void playBackground1() {
        stopAll();
        backgroundMusic1.start();
    }

    public void playBackground2() {
        stopAll();
        backgroundMusic2.start();
    }

    public void playBackground3() {
        stopAll();
        backgroundMusic3.start();
    }

    public void playBackground4() {
        stopAll();
        backgroundMusic4.start();
    }

    public void playBossFight() {
        stopAll();
        bossFightMusic.start();
    }

    public void playFight1() {
        stopAll();
        fightMusic1.start();
    }

    public void playFight2() {
        stopAll();
        fightMusic2.start();
    }


}
