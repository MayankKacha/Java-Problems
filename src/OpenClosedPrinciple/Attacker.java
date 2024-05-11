package OpenClosedPrinciple;

import java.util.List;

public class Attacker
{
    public void attackWithHeroes(List<SuperHero> superHeroes){
        for (int i=0;i<superHeroes.size();i++){
            superHeroes.get(i).attack();
        }
    }
}
