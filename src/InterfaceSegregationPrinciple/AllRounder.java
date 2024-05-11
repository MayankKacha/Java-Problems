package InterfaceSegregationPrinciple;

public class AllRounder implements Player,Keeper,Fielder
{
    @Override
    public void wicketKeeping() {
        System.out.println("AllRounder wicket keeping");
    }

    @Override
    public void bat() {
        System.out.println("AllRounder bating!");
    }

    @Override
    public void Fielding(){
        System.out.println("AllRounder fielding!");
    }
}
