package sample;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;


public class Controller {

    // Foto
    @FXML
    private ChoiceBox dropDownMenuPhotos;
    @FXML
    private TextField nameOfPhoto;
    @FXML
    private ImageView photoSelected;

    // Lyd
    @FXML
    private ChoiceBox dropDownMenuSounds;
    @FXML
    private TextField nameOfSound;

    // Video
    @FXML
    private ChoiceBox dropDownMenuVideos;
    @FXML
    private TextField nameOfVideo;
    @FXML
    private MediaView videoSelected;

    // Bruger får mulighed for at vælge foto, se foto og handling skrives i loggen
    @FXML
    void choosePhoto(ActionEvent event) {

        String fotos = (String) dropDownMenuPhotos.getValue();

        if (!fotos.isEmpty() || !fotos.isBlank()) {
            String filnavn = fotos + ".jpg";
            nameOfPhoto.setText(filnavn);
            Image image = new Image("fotos/" + filnavn);
            photoSelected.setImage(image);
            System.out.println("" + new java.util.Date() + " - Viste foto " + filnavn);
        }

        try {
            FileWriter myWriter = new FileWriter("data/datalog.txt", true);

            myWriter.write("" + new java.util.Date() + " - Viste foto af " + dropDownMenuPhotos.getValue() + '\n');
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    // Bruger får mulighed for at vælge lyd, afspille lyd og handling skrives i loggen
    @FXML
    void chooseSound(ActionEvent event) {

        String lyde = (String) dropDownMenuSounds.getValue();

        if (!lyde.isEmpty() || !lyde.isBlank()) {
            String filnavn = lyde + ".mp3";
            nameOfSound.setText(filnavn);

            File l = new File("src/lyde/" + filnavn);
            Media media = new Media(l.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
            System.out.println("" + new java.util.Date() + " - Afspillede filen " + filnavn);
        }
        try {
            FileWriter myWriter = new FileWriter("data/datalog.txt", true);

            myWriter.write("" + new java.util.Date() + " - Afspillede lyd fra " + dropDownMenuSounds.getValue() + '\n');
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    // Bruger får mulighed for at vælge video, se og høre video og handling skrives i loggen
    @FXML
    void chooseVideo(ActionEvent event) {

        String videoer = (String) dropDownMenuVideos.getValue();

        if (!videoer.isEmpty() || !videoer.isBlank()) {
            String filnavn = videoer + ".mp4";
            nameOfVideo.setText(filnavn);

            MediaPlayer mediaPlayer;
            File v = new File("src/videoer/" + filnavn);
            Media media = new Media(v.toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);
            videoSelected.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();

            System.out.println("" + new java.util.Date() + " - Viste videoen " + filnavn);
        }
        try {
            FileWriter myWriter = new FileWriter("data/datalog.txt", true);

            myWriter.write("" + new java.util.Date() + " - Afspillede video af " + dropDownMenuVideos.getValue() + '\n');
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}