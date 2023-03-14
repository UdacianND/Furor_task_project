package repository.contract;

import models.Fish;

import java.util.List;

public interface FishRepository {
    boolean save(Fish fish);
    boolean deleteById(long id);
    Fish getByIndex(int index);
    int getFishCount();
}
