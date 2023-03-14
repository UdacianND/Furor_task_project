package management;

import factories.FishFactory;
import models.Fish;
import models.Gender;
import repository.contract.FishRepository;
import repository.impl.FishRepositoryImp;
import service.contract.FishService;
import service.impl.FishServiceImp;

import java.util.Random;

public class ThreadManager {
    private static final ThreadGroup threadGroup = new ThreadGroup("ThreadGroup");
    private static final Random randomGenerator = new Random();
    private static final FishRepository fishRepository = new FishRepositoryImp();
    private static final FishService fishService = new FishServiceImp(fishRepository, randomGenerator);
    private static final FishFactory fishFactory = new FishFactory(randomGenerator);
    public static void initData(){
        int males = randomGenerator.nextInt(10)+5;
        int females = randomGenerator.nextInt(10)+5;
        for (int i = 0; i < males; i++) {
            Fish fish = fishFactory.createFish(Gender.MALE);
            addNewFish(fish);
            long id = fish.getId();
        }
        for (int i = 0; i < females; i++) {
            Fish fish = fishFactory.createFish(Gender.FEMALE);
            addNewFish(fish);
        }
    }

    public static void addBabyFish(){
        Fish babyFish = fishFactory.createFish();
        System.out.println("Baby was born");
        addNewFish(babyFish);
    }

    public static void addNewFish(Fish fish){
        fishService.addNewFish(fish);
        FishLifeThread fishLifeThread = new FishLifeThread(fishService, fish,randomGenerator);
        Thread thread = new Thread(threadGroup, fishLifeThread);
        thread.start();
    }
}
