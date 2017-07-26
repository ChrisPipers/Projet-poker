package view.handPokerPlayer;

import view.cardComponent.CardComponent;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.Player;
import model.cards.Card;

/**
 *
 * @author Mitch
 */
public class handPokerPlayer extends HBox {
    
//    public handPokerPlayer(List <Card> listCard ){
//         
//        String sCard;
//        int i = 0;
//        System.out.println(listCard.size()+"********************");
//        for (Card card : listCard) {
//            CardComponent cardC = new CardComponent(card);
//            if ( i == 0){
//                cardC.setRotate(-10);
//            }else{
//                cardC.setRotate(10);
//            }
//            i++;
//            
//            getChildren().add(cardC);
//        }
//        this.setSpacing(-20);
//    }
//    
    
    private String sCard;
    private CardComponent cardCL;
    private CardComponent cardCR;
    
    public handPokerPlayer(List <Card> listCard ){
        System.out.println(listCard.size());
        if(listCard.size()!=0){
        cardCL = new CardComponent(listCard.get(0));
        cardCR = new CardComponent(listCard.get(1));
        
        cardCL.setRotate(-10);
       
        cardCR.setRotate(10);
            
        getChildren().addAll(cardCL, cardCR);
        }
        this.setSpacing(-20);
    }
    
    public void setHandPokerPlayer(List <Card> listCard){
        cardCL = new CardComponent(listCard.get(0));
        cardCR = new CardComponent(listCard.get(1));
        
    }
    
    public void setVissibleHand(){
    }
    
}


