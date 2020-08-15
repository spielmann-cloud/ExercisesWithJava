package blatt10;

public class SysTextFile extends SysObjectBase{

    /**
     * type, der Dateityp wie z.B. java oder txt
     * text, der Inhalt der Datei
     */
    private String type;
    private String text;


    /**
     * Kostruktor mit Parameter
     * @param name
     * @param type of Datei
     */
    public SysTextFile(String name, String type) {
         super(name);
         this.type = type;
         text = "";
    }

    /**
     * Setter for text
     * @param text - für Zuweisung
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Getter for text
     */
    public String getText() {
        return text;
    }

    /**
     * Overriden toString() method
     * @return formatted toString emthods
     */
    @Override
    public String toString(){
        return super.toString().substring(0, super.toString().length() - 1) + String.format(", Type=%s, Length=%s",type, text.length());
    }


    /**
     * main Methode für Tests
     * @param args
     */
    public static void main(String[] args) {

        SysTextFile stf = new SysTextFile("Hello", "java");
        stf.setText("public class HelloWorld{/*...*/}");
        System.out.printf("%s:\n %s\n\n", stf, stf.getText() );
        System.out.println(stf);

    }
}
