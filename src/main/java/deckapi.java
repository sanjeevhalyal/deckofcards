import static spark.Spark.*;

public class deckapi {

    static String newshuffledeck="/api/deck/new/:shuffle/";
    static String drawfrom="/api/deck/:deck_id/draw/";
    static String resuffle="/api/deck/:deck_id/shuffle/";
    static String newdeck="/api/deck/new/";


    static decks.decks apidecks=new decks.decks();

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        get(newshuffledeck, (req, res) -> {
          String countstring = req.queryParams("deck_count")==null?"1":req.queryParams("deck_count");
          int count=Integer.parseInt(countstring);


          String shuf=req.params("shuffle"),response;
          Boolean shuffled=shuf.compareTo("shuffle")==0;



          if(shuffled)
              response=apidecks.addnew(true,count);
          else
              response=apidecks.addnew(false,count);

          return response;
        });

        get(resuffle, (req, res) -> {
            String deck_id = req.params(":deck_id");

            String response=apidecks.shuffle(deck_id);

            return response;
        });

        get(newdeck, (req, res) -> {
            String countstring = req.queryParams("deck_count")==null?"1":req.queryParams("deck_count");
            System.out.println(countstring);
            String deck_id;
            int count=Integer.parseInt(countstring),remaining=count*52;

            apidecks.refresholddeck();

            deck_id=apidecks.addnew(false,count);

            return deck_id;
        });


        get(drawfrom, (req, res) -> {
            String deck_id = req.params(":deck_id");
            String countstring= req.queryParams("count")==null?"1":req.queryParams("count");
            int count=Integer.parseInt(countstring);
            String response=apidecks.draw(count,deck_id);

            return response;

        });





    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}
