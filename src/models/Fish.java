package models;

import java.time.LocalDateTime;

public class Fish {

    long id;
    int lifeExpectancyInSeconds;
    LocalDateTime birthday;

    Gender gender;

    public Fish(int lifeExpectancyInSeconds, LocalDateTime birthday, Gender gender) {
        this.lifeExpectancyInSeconds = lifeExpectancyInSeconds;
        this.birthday = birthday;
        this.gender = gender;
    }

    public int getLifeExpectancy() {
        return lifeExpectancyInSeconds;
    }

    public void setLifeExpectancy(int lifeExpectancyInSeconds) {
        this.lifeExpectancyInSeconds = lifeExpectancyInSeconds;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }
}
