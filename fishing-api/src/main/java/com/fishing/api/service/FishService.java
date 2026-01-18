package com.fishing.api.service;

import java.util.List;

import com.fishing.api.model.Fish;

public interface FishService {
    Fish createFish(Fish fish);

    List<Fish> getAllFishes();

    Fish getFishById(Long id);

    Fish updateFish(Long id, Fish fish);

    void deleteFish(Long id);
}
