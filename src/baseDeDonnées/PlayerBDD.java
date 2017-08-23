package baseDeDonnées;

/**
 *
 * @author Mitch
 */
public class PlayerBDD {

    private int IDPlayer;
    private String name;
    private int money;
    private double bounty;

    public PlayerBDD(int IDPlayer, String name, int money, double bounty) {
        this.IDPlayer = IDPlayer;
        this.name = name;
        this.money = money;
        this.bounty = bounty;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setBounty(double bounty) {
        this.bounty = bounty;
    }

    public int getIDPlayer() {
        return IDPlayer;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }
    
    public double getBounty(){
        return bounty;
    }


}
