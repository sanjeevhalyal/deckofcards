package decks;

import static org.junit.jupiter.api.Assertions.*;

class decksTest {
    decks dck;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        dck=new decks();
        System.out.println(dck.addnew(true,1));
    }

    @org.junit.jupiter.api.Test
    void refresholddeck() {
        dck.refresholddeck();
    }

    @org.junit.jupiter.api.Test
    void addnew() {

        System.out.println(dck.addnew(true,1));
        System.out.println(dck.addnew(false,1));
        System.out.println(dck.addnew(true,2));
        System.out.println(dck.addnew(false,2));
    }

    @org.junit.jupiter.api.Test
    void shuffle() {
        System.out.println(dck.shuffle("aasas"));
        System.out.println(dck.shuffle(dck.list.get(0).getDeck_id()));
    }

    @org.junit.jupiter.api.Test
    void draw() {

        System.out.println(dck.draw(1,dck.list.get(0).getDeck_id()));
        System.out.println(dck.draw(1,dck.list.get(0).getDeck_id()));
        System.out.println(dck.draw(2,dck.list.get(0).getDeck_id()));

    }
}