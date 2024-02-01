import greenfoot.*; 
import java.util.ArrayList;

/**
 * dealer for Triples
 * 
 * @Alicia  
 * @Jan 18
 */

public class Dealer extends Actor  
{
    private Deck deck;
    private ArrayList<Card> cardsOnBoard;
    private ArrayList<Integer> selectedCardsIndex;
    private Card[] cardsSelected;
    private int numCardsInDeck;
    private int triplesRemaining;

    public Dealer(int numCardsInDeck)
    {
        this.numCardsInDeck = numCardsInDeck;
        this.triplesRemaining = numCardsInDeck/3;
        this.deck = new Deck(numCardsInDeck);
        this.cardsSelected = new Card[3];
    }
    
    public void addedToWorld(World world) 
    {
        dealBoard();
        setUI();
    }

    public void dealBoard() 
    {
        Greenfoot.playSound("shuffle.wav");
        
        for (int y = 45; y <= 450; y += 72) 
        {
            for (int x = 80; x <= 400; x += 135) 
            {
                getWorld().addObject(deck.getTopCard(), x, y);       
            }
        }
    }

    public void setUI() 
    {
        Integer score = Scorekeeper.getScore();
        Integer numCardsRemaining = numCardsInDeck;
        getWorld().showText(score.toString(), 312, 506);
        getWorld().showText(numCardsRemaining.toString(), 312, 471);
    }

    public void endGame() 
    {
        
    }

    public void checkIfTriple() 
    {
        
    }

    public void actionIfTriple() 
    {
        
    }

    public void setCardsSelected(ArrayList<Card> cardsOnBoard, Card[] cardsSelected, ArrayList<Integer> selectedCardsIndex)
    {
        
    }
}
