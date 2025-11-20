package atd_limud.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;

import java.io.IOException;
import java.net.URL;

public class VideoCheckController {

    @FXML
    private Pane videoContainer;

    // שדה ברמת המחלקה – חשוב!
    private MediaPlayer mediaPlayer;

    public void initialize() {

        File dir = new File("src/main/resources/videos");

// מחפש ספציפית את nike_video.mp4
        File videoFile = new File(dir, "nike_video.mp4");

        System.out.println("DEBUG: looking for: " + videoFile.getAbsolutePath());
        if (!videoFile.exists()) {
            System.out.println("DEBUG: VIDEO FILE NOT FOUND!");
            return;
        }

        String videoUri = videoFile.toURI().toString();
        System.out.println("DEBUG: USING VIDEO URI: " + videoUri);

        Media media = new Media(videoUri);
        mediaPlayer = new MediaPlayer(media);

        mediaPlayer.setOnError(() ->
                System.out.println("MEDIA ERROR: " + mediaPlayer.getError())
        );
        mediaPlayer.setOnEndOfMedia(() ->
                System.out.println("DEBUG: END OF MEDIA reached")
        );

        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.fitWidthProperty().bind(videoContainer.widthProperty());
        mediaView.fitHeightProperty().bind(videoContainer.heightProperty());

        videoContainer.getChildren().add(mediaView);
        mediaPlayer.play();
    }
}
