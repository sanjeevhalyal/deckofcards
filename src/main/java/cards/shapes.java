package cards;

public  enum shapes {
    S,
    D,
    C,
    H;

    private String value;

    static {
        S.value="shape";
        D.value="diamond";
        C.value="club";
        H.value="heart";
    }
    public String getvalue()
    {
        return value;
    };

}
