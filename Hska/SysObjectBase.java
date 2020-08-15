package blatt10;

public abstract class SysObjectBase {

    /**
     * name -  Namen der Ressource
     * owner - Besitzer der Ressource
     */
    private String name;
    private String owner; //Könnte static sein ?

    /**
     * Getter für name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter für name
     * @param name new value to assign
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter für owner
     * @return owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Setter für Owner
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;

    }

    /**
     * Konstruktor
     * @param name
     */
    public SysObjectBase(String name) {
        this.name = name;
        this.owner = System.getenv("USERNAME");
    }

    @Override
    public String toString(){
         return String.format("Class=%s, Name=%s, User=%s.", this.getClass().getSimpleName(), name, owner);
    }

    public static void main(String[] args) {

    }

}
