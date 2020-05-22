public class Person {
    private String name;
    private int pideCount;
    private boolean wearedMask;
    

    public Person(String name, boolean mask) {
        super();
        this.name=name;
        this.pideCount=0;;
        wearedMask=mask;
    }

    public String getName(){return name;}

    public int getPideCount(){return pideCount;}
    
    public void setPideCount(int quantity){
        this.pideCount+=quantity;
    }

    public void takeMask(){wearedMask=true;}
    
    public boolean checkMask(){return wearedMask;}
}   
            
        