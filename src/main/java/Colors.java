public enum Colors {

    TRON(125, 253, 254),
    SUNSET(255, 54, 0),
    AMBER(255,191, 0),
    CRIMSON(220, 20, 60),
    CHAMPAGNE_SILVER(210, 200, 190);


    private int R;
    private int G;
    private int B;

    Colors(int R, int G, int B) {
        this.R = R;
        this.G = G;
        this.B = B;
    }


    public String printWithColor(String text) {
        return "\u001B[38;2;" + R + ";" + G + ";" + B + "m" + text + "\u001b[0m";
    }
}
