/*
* The Abstract Player class displays specific methods that must be implemented by a Sport Player as well as setting
* and accessing the player name through the constructor.
*/

public abstract class Player {
    private String name;
    public Player(){
        name = "Bob";
    }
    public Player(String name){
        this.name = name;
    }
    public void setname(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public abstract void setPosition(String position);
}
