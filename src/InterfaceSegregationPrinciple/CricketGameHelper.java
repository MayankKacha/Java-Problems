package InterfaceSegregationPrinciple;

public class CricketGameHelper
{
    public void Batting(PureBatsman p){
        p.bat();
    }

    public void Keeping(AllRounder allRounder){
        allRounder.wicketKeeping();
    }


}
