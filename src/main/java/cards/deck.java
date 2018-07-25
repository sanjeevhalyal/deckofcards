package cards;

import generator.idgenerator;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class deck {
   private LinkedList<card> deck;
   private String deck_id;
   private int weekstamp;
   private int year;
   private Boolean shuffle;



    public int getCount() {

        return count;
    }

    private int count;

    public deck(boolean shuffle,int count)
    {
        LinkedList<card> cardslist=new LinkedList<>();


        intializedeck(count);

        for(int i=0;i<count;i++)
        for(shapes sh : shapes.values())
            for(names na : names.values()) {
                cardslist.add(new card(na,sh));
            }

        addcards(cardslist);


        this.shuffle=shuffle;
        if(shuffle)
        {
            shuffleDeck(deck,count);
        }
    }

    public deck(boolean shuffle,int count,LinkedList<card> cardslist)
    {


        intializedeck(count);


        addcards(cardslist);

        if(shuffle)
        {
            shuffleDeck(deck,count);
        }
    }


    private void intializedeck(int count)
    {
        deck=new LinkedList<>();
        deck_id=idgenerator.randomString(12);
        this.count=count;

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        weekstamp= cal.get(Calendar.WEEK_OF_YEAR);
        year= cal.get(Calendar.YEAR);

        this.count=count;
    }

    private void addcards(LinkedList<card> cardslist)
    {
        for(card cd : cardslist)
            {
                deck.add(cd);
            }
    }

    public String shuffleDeck(LinkedList<card> deck,int count) {
        for(int i=0; i<52*count; i++) {
            int card = (int) (Math.random() * (52*count-i));
            deck.addLast(deck.remove(card));
        }
        return "true";
    }

    public LinkedList<card> getDeck() {
        return deck;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public int getWeekstamp() {
        return weekstamp;
    }

    public int getYearstamp() {
        return year;
    }

    public boolean getShuffle() {
        return shuffle;
    }

    public void setShuffle(boolean shuffle) {
        this.shuffle = shuffle;
    }
}
