public class Hero {
    private String name;
    private int age;
    private String specialPowers;
    private String weakness;
public Hero (String name, int age, String specialPowers, String weakness){
    this.name = name;
    this.age= age;
    this.specialPowers= specialPowers;
    this.weakness = weakness;

}

    public String getName() {
        return name;
    }
    public int getAge(){
    return age;
    }

    public String getSpecialPowers(){
    return specialPowers;
    }

    public String getWeakness(){
    return weakness;
    }
}
