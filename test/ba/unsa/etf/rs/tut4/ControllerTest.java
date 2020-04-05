package ba.unsa.etf.rs.tut4;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.awt.*;

@ExtendWith(ApplicationExtension.class)
class ControllerTest {
    @Start
    public void start (Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Main.class.getResource("/main.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Test
    void DaLiJeUreduButton(FxRobot robot) {
        Button btn = robot.lookup("#dodaj").queryAs(Button.class);
        assertNotNull(btn);
    }

    @Test
    void DaLiSuUreduTextArea(FxRobot robot) {
        TextArea txa1 = robot.lookup("#input").queryAs(TextArea.class);
        TextArea txa2 = robot.lookup("#output").queryAs(TextArea.class);
        assertNotNull(txa1);
        assertNotNull(txa2);
    }

    @Test
    void IspravnostTextArea(FxRobot robot) {
        Button btn = robot.lookup("#dodaj").queryAs(Button.class);
        TextArea txa1 = robot.lookup("#input").queryAs(TextArea.class);
        TextArea txa2 = robot.lookup("#output").queryAs(TextArea.class);
        robot.clickOn(txa1);
        robot.write("Pro1,Proizvod1,50");
        robot.clickOn(btn);
        // dodato .0 na cijenu posto je cijena tipa double
        // i dodato '\n' zato sto smo u metodi naveli da ide u novi red
        assertEquals("Pro1,Proizvod1,50.0\n",txa2.getText().toString());
    }
}