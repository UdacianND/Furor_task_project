package repository.impl;

import models.Fish;
import repository.contract.FishRepository;

import java.util.ArrayList;
import java.util.List;

public class FishRepositoryImp implements FishRepository {
    static final List<Fish> fishList = new ArrayList<>();
    static long counter = 1;

    @Override
    public boolean save(Fish fish) {
        if(fish == null)
            throw new NullPointerException("Fish is null");
        fish.setId(counter++);
        fishList.add(fish);
        return true;
    }

    @Override
    public boolean deleteById(long id) {
        if(id < 1)
            throw new IllegalArgumentException("Invalid fish id");
        for (int i = 0; i < fishList.size(); i++) {
            if(fishList.get(i).getId() == id) {
                fishList.remove(i);
                return true;
            }
        }
        return false;
    }
}
