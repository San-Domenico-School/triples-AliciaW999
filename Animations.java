import greenfoot.*; 

/**
 * Animation for Triples
 * 
 * @Alicia  
 * @Jan 11
 */

public class Animations  
{
    public static void wobble(Card[] cards)
    {
        Greenfoot.playSound("wobble.wav");
    }
    
    public static void slideAndTurn(Card[] cards)
    {
        Greenfoot.playSound("swoosh.wav");
        for(int i = 0; i < cards.length; i++)
        {
            cards[i].move(-500);
        }
    }
    
    public static void shuffle(Card[] cards)
    {
        Greenfoot.playSound("shuffle.wav");
    }
}
