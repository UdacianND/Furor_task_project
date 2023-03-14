package factories;

import models.Fish;
import models.Gender;

import java.time.LocalDateTime;
import java.util.Random;

import static utils.AppConstants.FISH_MAX_LIFE_EXPECTANCY;

public class FishFactory {
    private final Random randomGenerator;

    public FishFactory(Random randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public Fish createFish(){
        int lifeExpectancy = randomGenerator.nextInt(FISH_MAX_LIFE_EXPECTANCY) + 10;
        LocalDateTime birthday = LocalDateTime.now();
        Gender gender = Gender.values()[randomGenerator.nextInt(2)];
        return new Fish(lifeExpectancy, birthday, gender);
    }

    public Fish createFish(Gender gender){
        int lifeExpectancy = randomGenerator.nextInt(FISH_MAX_LIFE_EXPECTANCY) + 10;
        LocalDateTime birthday = LocalDateTime.now();
        return new Fish(lifeExpectancy, birthday, gender);
    }
}
