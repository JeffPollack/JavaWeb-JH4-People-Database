package people;

/**
 *
 * @author Jeff
 */
public class Person {
    
    private String name;
    private String eyeColor;
    private String hairColor;
    private String height;
    private String weight;
    private String wepOfChoice;
    
    public Person (String name, String eyeColor, String hairColor, String height, String weight, String wepOfChoice){
        this.name=name;
        this.eyeColor=eyeColor;
        this.hairColor=hairColor;
        this.height=height;
        this.weight=weight;
        this.wepOfChoice=wepOfChoice;
    }
    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    
    public void setEyeColor(String e){
        eyeColor = e;
    }
    public String getEyeColor(){
        return eyeColor;
    }
    
    public void setHairColor(String h){
        hairColor = h;
    }
    public String getHairColor(){
        return hairColor;
    }
    
    public void setHeight(String he){
        height = he;
    }
    public String getHeight(){
        return height;
    }
    
    public void setWeight(String w){
        weight = w;
    }
    public String getWeight(){
        return weight;
    }
    
    public void setWepOfChoice(String wep){
        wepOfChoice = wep;
    }
    public String getWepOfChoice(){
        return wepOfChoice;
    }
    
    @Override
    public boolean equals(Object other){
        // check to make sure the class is not empty or a different class
        if(other == null || other.getClass() != getClass()) return false; 
        // check if the entry already exists
        Person peeps = (Person)other;
        if(name.equals(peeps.name) && eyeColor.equals(peeps.eyeColor) &&
                hairColor.equals(peeps.hairColor) && height.equals(peeps.height) &&
                weight.equals(peeps.weight) && wepOfChoice.equals(peeps.wepOfChoice))
            return true;
        else
            return false;
    }
}
