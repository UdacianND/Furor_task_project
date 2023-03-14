package repository.contract;

import models.Fish;

public interface FishRepository {
    boolean save(Fish fish);
    boolean deleteById(long id);
}
