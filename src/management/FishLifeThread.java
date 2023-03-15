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
                Thread.sleep(3000);
                isAlive = deathTime.isAfter(LocalDateTime.now());
                if(!isAlive) {
                    fishService.deleteById(fish.getId());
                    System.out.println("Oh poor! Fish died (!");
                }else {
                    Fish friend = fishService.getRandomFish();
                    if(friend.getGender() != fish.getGender()){
                        ThreadManager.addBabyFish();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
