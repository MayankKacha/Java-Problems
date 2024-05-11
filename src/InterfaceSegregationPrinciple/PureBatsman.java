package InterfaceSegregationPrinciple;

public class PureBatsman implements Player , Fielder
{
    @Override
    public void bat() {
        System.out.println("Pure Batsman bating!");
    }

    @Override
    public void Fielding(){
        System.out.println("Pure Batsman fielding!");
    }
}
