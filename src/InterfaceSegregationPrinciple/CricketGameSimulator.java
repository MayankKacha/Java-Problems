package InterfaceSegregationPrinciple;

import java.util.ArrayList;
import java.util.List;

public class CricketGameSimulator
{
    public List<AllRounder> allRounders;
    public List<PureBatsman> pureBatsmen;

    public CricketGameSimulator(List<AllRounder> allRounders, List<PureBatsman> pureBatsmen){
        this.allRounders = allRounders;
        this.pureBatsmen = pureBatsmen;
    }

    public static void main(String[] args){
        List<AllRounder> allRounders = new ArrayList<>();
        allRounders.add(new AllRounder());
        allRounders.add(new AllRounder());
        List<PureBatsman> pureBatsmen = new ArrayList<>();
        pureBatsmen.add(new PureBatsman());
        pureBatsmen.add(new PureBatsman());
        CricketGameSimulator cricketGameSimulator = new CricketGameSimulator(allRounders,pureBatsmen);
        cricketGameSimulator.Simulate();
    }

    public void Simulate(){
        startBatting();
        startFielding();
    }

    void startBatting(){
        for (int i=0;i<pureBatsmen.size();i++){
            pureBatsmen.get(i).bat();
        }
    }

    public void startFielding(){
        for (int i=0;i<allRounders.size();i++){
            allRounders.get(i).Fielding();
        }
    }
}
