package com.galactichitchhiker.spacetrader.models;

public enum TradeGoods {
    WATER(0	, 0, 2, 30, 3, 4, "DROUGHT", "LOTSOFWATER",	"DESERT", 30,50),
    FURS(0, 0, 0, 250, 10, 10, "COLD", "RICHFAUNA",	"LIFELESS", 230, 280),
    FOOD(1, 0, 1, 100, 5, 5, "CROPFAIL",	"RICHSOIL", "POORSOIL", 90, 160),
    ORE(2, 2, 3, 350, 20, 10, "WAR",	"MINERALRICH",	"MINERALPOOR", 350, 420),
    GAMES(3, 1, 6, 250,	-10, 5, "BOREDOM",	"ARTISTIC", "Never",	160, 270),
    FIREARMS(3, 1, 5, 1250, -75, 100, "WAR",	"WARLIKE",	"Never", 600, 1100),
    MEDICINES(4, 1, 6, 650, -20, 10, "PLAGUE", "LOTSOFHERBS", "Never", 400, 700),
    MACHINES(4, 3, 5, 900,	-30, 5, "LACKOFWORKERS",	"Never", "Never",	600, 800),
    NARCOTICS(5, 0, 5,	3500, -125,	150, "BOREDOM", "WEIRDMUSHROOMS", "Never", 2000, 3000),
    ROBOTS(6, 4, 7, 5000, -150, 100, "LACKOFWORKERS", "Never",	"Never", 3500, 5000);


    private int MTLP;
    private int MTLU;
    private int TTP;
    private int basePrice;
    private int IPL;
    private int Var;
    private String IE;
    private String CR;
    private String ER;
    private int MTL;
    private int MTH;

    TradeGoods(int MTLP, int MTLU, int TTP, int basePrice	, int IPL,
               int	Var, String IE, String CR, String ER, int MTL, int MTH) {

        this.MTLP = MTLP;
        this.MTLU = MTLU;
        this.TTP = TTP;
        this.basePrice = basePrice;
        this.IPL = IPL;
        this.Var = Var;
        this.IE = IE;
        this.CR = CR;
        this.ER = ER;
        this.MTL = MTL;
        this.MTH = MTH;
    }

    public boolean canBuyAt(int techLevel) {
        return MTLP > techLevel;

    }

    public boolean canSellAt(int techLevel) {
        return MTLU > techLevel;
    }

    public int getPrice(int TechLevel) {
        return basePrice + (IPL * (TechLevel - MTLP)) + ((int)Math.random() * 4);

    }
}
