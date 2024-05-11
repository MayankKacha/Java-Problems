package OpenClosedPrinciple;

import java.util.ArrayList;
import java.util.List;

public class SuperHeroSimulator
{
    public static void main(String[] args) {
        List<SuperHero> superHeroes = new ArrayList<>();
        superHeroes.add(new BatMan());
        superHeroes.add(new CaptainAmerica());
        superHeroes.add(new SuperMan());
        superHeroes.add(new SpiderMan());
        Attacker attacker = new Attacker();
        attacker.attackWithHeroes(superHeroes);
    }
}
