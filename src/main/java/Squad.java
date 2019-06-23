import java.util.ArrayList;

public class Squad {
    private String name;
    private int squadSize;
    private String cause;
    private static ArrayList<Squad> instances = new ArrayList<>();

    private Hero newMember;

    private ArrayList<Hero> squadMembers = new ArrayList<>();

    private static ArrayList<Hero> testSquadMembers = new ArrayList<>();

    public Squad(String name, int squadSize, String cause, ArrayList<Hero> squadMembers) {
        this.name = name;
        this.squadSize = squadSize;
        this.cause = cause;
        this.squadMembers = squadMembers;
        instances.add(this);

    }

    public static ArrayList<Squad> getInstances() {
        return instances;
    }

    public ArrayList<Hero> getSquadMembers() {
        return squadMembers;
    }

    public static ArrayList<Hero> getTestSquadMembers() {
        return testSquadMembers;
    }

    public ArrayList<Hero> setSquadMembers(ArrayList<Hero> newMember) {
        return squadMembers = newMember;
    }
}

