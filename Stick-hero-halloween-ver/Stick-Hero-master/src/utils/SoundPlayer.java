package utils;
//README for this code is given below
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {

    public static void playSound(String soundFilePath) {
        try {
            File soundFile = new File(soundFilePath);

            // Get AudioInputStream
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

            // Get Clip
            Clip clip = AudioSystem.getClip();

            // Open AudioInputStream to the clip
            clip.open(audioInputStream);

            // Start the clip
            clip.start();

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
}
//MORE ON THE CODE ABOVE :
//The SoundPlayer class facilitates the playing of sound files in the Java application. It contains a static method playSound that accepts a file path to an audio file as a parameter. This method handles various exceptions that may occur during the sound-playing process, such as UnsupportedAudioFileException, LineUnavailableException, and IOException.
// Inside the playSound method:
// It creates a File object representing the sound file from the provided file path.
// Obtains an AudioInputStream from the sound file.
// Retrieves a Clip from the AudioSystem.
// Opens the AudioInputStream to the Clip.
// Starts playing the sound using the clip.start() method.
// In case any exceptions occur during the process of playing the sound, they are caught and their stack traces are printed, providing information about the error encountered.