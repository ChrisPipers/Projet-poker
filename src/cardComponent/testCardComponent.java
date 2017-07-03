/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardComponent;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.cards.Card;
import model.cards.Color;
import model.cards.Value;

/**
 *
 * @author Mitch
 */
public class testCardComponent extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        Card card = new Card(Color.CLUB, Value.ACE);
        CardComponent cardC = new CardComponent(card);
        
        Scene scene = new Scene(cardC, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
