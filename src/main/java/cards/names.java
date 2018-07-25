package cards;

public enum names {

    a,b,c,d,e,f,g,h,i,j,k,l,m;

    private String value;

    static {
        a.value="A";
        b.value="2";
        c.value="3";
        d.value="4";
        e.value="5";
        f.value="6";
        g.value="7";
        h.value="8";
        i.value="9";
        j.value="10";
        k.value="J";
        l.value="Q";
        m.value="K";
    }
    public String getvalue()
    {
        return value;
    };
}
