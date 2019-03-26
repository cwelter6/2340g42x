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


    private int MTLP; //Minimum Tech Level to produce
    private int MTLU; //Minimum Tech Level to use
    private int TTP; //Tech Level which produces most of this item
    private int basePrice;
    private int IPL; //Price increase per tech level
    private int Var; //Maximum percentage that the price can vary above or below the base
    private String IE; //Radical price increase event
    private String CR; //Cheap price condition
    private String ER; //Expensive price condition
    private int MTL; //Minimum price offered in space trade with random trader
    private int MTH; //Maximum price offered in space trade with random trader

    TradeGoods(int MTLP, int MTLU, int TTP, int basePrice, int IPL,
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

    /**
     * Determine whether a given planet can buy a resource
     *
     * @param techLevel - Tech level of planet
     * @returns boolean - whether planet can buy this good
     */
    public boolean canBuyAt(int techLevel) {
        return MTLP > techLevel;

    }


    /**
     * Determine whether a given planet can sell a resource
     *
     * @param techLevel - Tech level of planet
     * @returns boolean - whether planet can sell this good
     */
    public boolean canSellAt(int techLevel) {
        return MTLU < techLevel;
    }


    /**
     *  Calculate price of resource using plane's techlevel
     *
     * @param techLevel - Tech level of planet
     * @returns int - price of good
     */
    public int getPrice(int techLevel) {
        return basePrice + (IPL * (techLevel - MTLP)) + (basePrice* ((int)Math.random() * Var));
    }
}
