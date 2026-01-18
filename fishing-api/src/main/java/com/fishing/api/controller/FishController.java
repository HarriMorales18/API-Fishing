package com.fishing.api.controller;
import com.fishing.api.model.Fish;
import com.fishing.api.service.FishService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/fish")
@Tag(name = "Fish", description = "API for managing fish")
public class FishController {

    private final FishService fishService;

    public FishController(FishService fishService) {
        this.fishService = fishService;
    }

    @Operation(summary = "Create a new fish")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fish createFish(@Valid@RequestBody Fish fish) {
        return fishService.createFish(fish);
    }

    @Operation(summary = "Get all fishes")
    @GetMapping
    public List<Fish> getAllFishes() {
        return fishService.getAllFishes();
    }

    @Operation(summary = "Get a fish by ID")
    @GetMapping("/{id}")
    public Fish getFishById(@PathVariable Long id) {
        return fishService.getFishById(id);
    }

    @Operation(summary = "Update a fish by ID")
    @PutMapping("/{id}")
    public Fish updateFish(
            @PathVariable Long id,
            @Valid @RequestBody Fish fish
    ) {
        return fishService.updateFish(id, fish);
    }


    @Operation(summary = "Delete a fish by ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFish(@PathVariable Long id) {
        fishService.deleteFish(id);
    }

    @GetMapping("/test")
public String test() {
    return "API funcionando";
}

}
