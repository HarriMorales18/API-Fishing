package com.fishing.api.service.impl;

import com.fishing.api.model.Fish;
import com.fishing.api.repository.FishRepository;
import com.fishing.api.service.FishService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishServiceImpl implements FishService {

    private final FishRepository fishRepository;

    public FishServiceImpl(FishRepository fishRepository) {
        this.fishRepository = fishRepository;
    }

    @Override
    public Fish createFish(Fish fish) {
        fish.setId(null);
        return fishRepository.save(fish);
    }

    @Override
    public List<Fish> getAllFishes() {
        return fishRepository.findAll();
    }

    @Override
    public Fish updateFish(Long id, Fish fish) {
        Fish existingFish = fishRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fish not found"));

        existingFish.setName(fish.getName());
        existingFish.setWeight(fish.getWeight());
        existingFish.setZone(fish.getZone());

        return fishRepository.save(existingFish);
    }


    @Override
    public Fish getFishById(Long id) {
        return fishRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fish not found with id " + id));
    }

    @Override
    public void deleteFish(Long id) {
        fishRepository.deleteById(id);
    }
}
