package management;

import models.Fish;
import models.Gender;
import service.contract.FishService;

import java.time.LocalDateTime;
import java.util.Random;

public class FishLifeThread implements Runnable{
    private final FishService fishService;
    private final Fish fish;
    private final Random randomGenerator;

    public FishLifeThread(FishService fishService, Fish fish, Random randomGenerator) {
        this.fishService = fishService;
        this.fish = fish;
        this.randomGenerator = randomGenerator;
    }

    @Override
    public void run() {
        boolean isAlive = true;
        LocalDateTime deathTime = fish.getBirthday().plusSeconds(fish.getLifeExpectancy());
        while (isAlive){
            try {
                //System.out.println(fish.getId() + " : eating");
                Thread.sleep(3000);
                //System.out.println(fish.getId() + " : sleeping");
                Thread.sleep(3000);
                Fish friend = fishService.getRandomFish();
                if(friend.getGender() == Gender.FEMALE){
                    ThreadManager.addBabyFish();
                }
                isAlive = deathTime.isAfter(LocalDateTime.now());
                if(!isAlive) {
                    fishService.deleteById(fish.getId());
                    System.out.println("Oh poor! Fish died (!");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
