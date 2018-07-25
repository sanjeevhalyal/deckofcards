package cards;

public class card {

    private names name = null;

    private shapes shapes = null;

    public names getName() {
        return name;
    }

    public void setName(names name) {
        this.name = name;
    }

    public cards.shapes getShapes() {
        return shapes;
    }

    public void setShapes(cards.shapes shapes) {
        this.shapes = shapes;
    }

    public card(names name, cards.shapes shapes) {
        this.name = name;
        this.shapes = shapes;
    }
}
