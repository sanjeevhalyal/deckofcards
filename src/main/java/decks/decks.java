package decks;

import cards.card;
import cards.deck;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import static java.lang.System.out;

public class decks {

    LinkedList<cards.deck> list;


    public decks(){
        list=new LinkedList<cards.deck>();
    }

    public boolean refresholddeck() {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int weekstamp= cal.get(Calendar.WEEK_OF_YEAR);
        int year= cal.get(Calendar.YEAR);

        list.removeIf(d -> d.getYearstamp() < year);
        list.removeIf(d -> d.getWeekstamp() <= weekstamp-2);

        out.println(year);
        out.println(weekstamp);

        return true;
    }

    public String addnew(boolean b, int count) {

        cards.deck newdeck= new cards.deck(b,count);

        String response="{\n" +
                "    \"success\": true,\n" +
                "    \"deck_id\": \""+newdeck.getDeck_id()+"\",\n" +
                "    \"shuffled\": "+newdeck.getShuffle()+",\n" +
                "    \"remaining\": "+newdeck.getDeck().size()+"\n" +
                "}";

        list.add(newdeck);

        return response;


    }

    public String shuffle(String deck_id) {

        String response;
        cards.deck newdeck=getdeck(deck_id);

        if(newdeck==null)
            response="{\"success\": false}";
        else
            response="{\n" +
                "    \"success\": true,\n" +
                "    \"deck_id\": \""+newdeck.getDeck_id()+"\",\n" +
                "    \"shuffled\": "+newdeck.getShuffle()+",\n" +
                "    \"remaining\": "+newdeck.getDeck().size()+"\n" +
                "}";

        return response;

    }

    private cards.deck getdeck(String deck_id)
    {
        cards.deck newdeck=null;
        for(cards.deck lst : list)
        {
            if(lst.getDeck_id().compareTo(deck_id)==0) {
                lst.shuffleDeck(lst.getDeck(), lst.getCount());
                newdeck=lst;
                break;
            }
        }
        return newdeck;
    }

    public String draw(int count,String deck_id) {

        cards.deck deck=getdeck(deck_id);
        String out="{\n" +
                "    \"success\": true,\n" +
                "    \"cards\": [\n" +
                "        ";

        for(int i=0;i<count-1;i++)
        {
            out=out+drawformatted(deck)+",";
        }
        out=out+drawformatted(deck)+"],\n" +
                "    \"deck_id\":\""+deck.getDeck_id()+"\",\n" +
                "    \"remaining\": "+deck.getDeck().size()+"\n" +
                "}";

        return out;
    }

    private String drawformatted(cards.deck deck)
    {
        card first = deck.getDeck().getFirst();
        deck.getDeck().remove(0);

         String out="{\n" +
                 "            \"name\": \""+first.getName().getvalue()+"\",\n" +
                 "            \"shape\": \""+first.getShapes().getvalue()+"\",\n" +
                 "            \"code\": \""+first.getShapes()+first.getName().getvalue()+"\"\n" +
                 "        }";


        return out;
    }
}
