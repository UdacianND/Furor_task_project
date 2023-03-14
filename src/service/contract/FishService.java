package service.contract;

import models.Fish;

public interface FishService {
    boolean addNewFish(Fish fish );
    boolean deleteById(long id);
}
