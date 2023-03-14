package service.impl;

import models.Fish;
import repository.contract.FishRepository;
import service.contract.FishService;

public class FishServiceImp implements FishService {
    private final FishRepository fishRepository;

    public FishServiceImp(FishRepository fishRepository) {
        this.fishRepository = fishRepository;
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

    private boolean isValid(Fish fish){
        if(fish == null)
            throw new NullPointerException("Fish is null");

        return fish.getLifeExpectancy() > 0 &&
                fish.getGender() != null &&
                fish.getBirthday() != null;
    }
}
