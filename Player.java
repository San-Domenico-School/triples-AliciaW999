import greenfoot.*;
import java.util.ArrayList;

/**
 * Player for Triple
 * 
 * @author alicia 
 * @version Jan 26
 */
public class Player extends Actor
{
    private Dealer dealer;
    private Card[] cardsSelected;
    private ArrayList<Card> cardsOnBoard;
    private ArrayList<Integer> selectedCardsIndex;

    public Player(Dealer dealer)
    {
        this.dealer = dealer;
        cardsOnBoard = new ArrayList<Card>();
        cardsSelected = new Card[3];
        selectedCardsIndex = new ArrayList<Integer>();
    }

    public void act()
    {
        selectCards();
        boolean threeCardsHaveBeenSelected = setCardsSelected();
        if (threeCardsHaveBeenSelected)
        {
            dealer.setCardsSelected(cardsOnBoard, cardsSelected, selectedCardsIndex);
            dealer.checkIfTriple();
            resetCardsSelected(); 
        }
    }
    
    public void addedToWorld(World world)
    {
        cardsOnBoard = (ArrayList) getWorld().getObjects(Card.class);
    }
    
    private void selectCards()
    {
        for (int i = 0; i < cardsOnBoard.size(); i++)
        {           
            if(Greenfoot.mouseClicked(cardsOnBoard.get(i)))
            {
                if(cardsOnBoard.get(i).getIsSelected())
                {
                    cardsOnBoard.get(i).setIsSelected(false);
                    cardsOnBoard.get(i).setImage(cardsOnBoard.get(i).getCardImage());
                    selectedCardsIndex.remove(Integer.valueOf(i));
                }
                
                else
                {
                    cardsOnBoard.get(i).setIsSelected(true);
                    cardsOnBoard.get(i).setImage(cardsOnBoard.get(i).getSelectedCardImage());
                    selectedCardsIndex.add(i);
                }
            }
        }
    }
    
    private void resetCardsSelected()
    {
        for (int i = 0; i < cardsOnBoard.size(); i++)
        {
            cardsOnBoard.get(i).setIsSelected(false);
            cardsOnBoard.get(i).setImage(cardsOnBoard.get(i).getCardImage());
        }
        selectedCardsIndex.clear();
    }
    
    private boolean setCardsSelected()
    {
        return selectedCardsIndex.size() == 3;
    }
}
