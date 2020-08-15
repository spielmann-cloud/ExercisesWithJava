package blatt10;

public class SysDirectory extends SysObjectBase {
    private SysObjectBase[] sysObjects;

    /**
     * Konstruktor
     * @param name
     * @param sysObjects
     */
    public SysDirectory(String name, SysObjectBase... sysObjects) {
        super(name);
        this.sysObjects = sysObjects;
    }

    /**
     * Setter für Owner
     * @param owner
     */
/*
    public void setOwner(String owner) {
        super.setOwner(owner);
        for(SysObjectBase obj : sysObjects) {
            obj.setOwner(owner);
        }
    }
*/



    /** Struktur des Verzeichnisses ermitteln
     *
     * @param indent Einrückung links (wird durch Rekursion verbreitert)
     * @return Struktur des Verzeichnisses als String
     */


    /**
     *
     * public String dirStructure(String indent) {
     * String s = "";
     * indent += "| - ";
     * for (SysObjectBase obj : sysObjects) {
     * if (obj instanceof SysDirectory) {
     * s += indent + obj.toString() + "\n";
     * SysDirectory objj = (SysDirectory) obj;
     * s += objj.dirStructure(indent);
     * } else {
     * s += indent + obj.toString() + "\n";
     * }
     * }
     *
     * return s;
     * }
     *
     */
    public String dirStructure(String indent) {
        String res = "";

        String choice = (indent.trim().length() == 0 ?("|" + (indent + " ") + "-" + (indent + " ")) : indent);
        String next =  (indent.indexOf("|", 1) != -1 ? indent.substring(0, indent.indexOf("|", 1) ) : ("|" + (indent + " ") + "-" + (indent + " ")));
        for (SysObjectBase obj : sysObjects) {
                 res += choice + obj + "\n";
                 if (obj instanceof SysDirectory) {
                     res +=  ((SysDirectory) obj).dirStructure((next.length() != 0 ? choice + next : choice + choice ));
                 }
             }
        return res;
    }


    @Override
    public String toString() {
        return super.toString().substring(0, super.toString().length() - 1) + ", NumberOfObjects=" + sysObjects.length;
    }

    public void findName(String searchFor) {
        for(SysObjectBase obj : sysObjects) {
            if(obj.getName().indexOf(searchFor) != -1) {
                System.out.println(obj.getName());
            }
            if(obj instanceof SysDirectory) {
                ((SysDirectory) obj).findName(searchFor);
            }
        }
    }
    /**
     * Main methode für Test
     * @param args
     */
    public static void main(String[] args) {
        SysTextFile hello = new SysTextFile("Hello", "java");
        hello.setText("public class HelloWorld{/*...*/}");
        SysTextFile test = new SysTextFile("Test", "java");
        SysTextFile prt = new SysTextFile("PrintClass", "java");

        SysDirectory srcDir = new SysDirectory("SRC", hello, test, prt);


        SysTextFile todo = new SysTextFile("Todos", "txt");
        SysTextFile toget = new SysTextFile("Eggs", "rtm");

        SysDirectory txtDir = new SysDirectory("txt", todo, toget, srcDir);


        SysDirectory home = new SysDirectory("home", srcDir, txtDir);
        srcDir.setName("SRC");
        toget.setName("Einkaufsliste");

        home.setName("HOME");
        home.setOwner("brul0001");


        System.out.printf("%s\n", home);

        System.out.printf("%s\n", home.dirStructure("     "));

        String find = "e";
        System.out.println("\nFind '" + find + "':");
        home.findName(find);
    }
}
