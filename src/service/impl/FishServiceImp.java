package service.impl;

import models.Fish;
import repository.contract.FishRepository;
import service.contract.FishService;

import java.util.Random;

public class FishServiceImp implements FishService {
    private final FishRepository fishRepository;
    private final Random randomGenerator;

    public FishServiceImp(FishRepository fishRepository, Random randomGenerator) {
        this.fishRepository = fishRepository;
        this.randomGenerator = randomGenerator;
    }

    @Override
    public boolean addNewFish(Fish fish) {
        if(fish == null)
            throw new NullPointerException("Fish is null");
        if(!isValid(fish))
            return false;
        fishRepository.save(fish);
        return true;
    }

    @Override
    public boolean deleteById(long id) {
        if(id < 1)
            throw new IllegalArgumentException("Invalid fish id");
        return fishRepository.deleteById(id);
    }

    @Override
    public Fish getRandomFish() {
        int fishCount = fishRepository.getFishCount();
        int index = randomGenerator.nextInt(fishCount);
        return fishRepository.getByIndex(index);
    }

    private boolean isValid(Fish fish){
        if(fish == null)
            throw new NullPointerException("Fish is null");

        return fish.getLifeExpectancy() > 0 &&
                fish.getGender() != null &&
                fish.getBirthday() != null;
    }
}
