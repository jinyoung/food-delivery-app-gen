<?php

namespace RestaurantManagement\Infrastructure\Persistence;

use RestaurantManagement\Domain\Model\Restaurant\Restaurant;
use RestaurantManagement\Domain\Model\Restaurant\RestaurantRepository;

class InMemoryRestaurantRepository implements RestaurantRepository
{
    private array $restaurants = [];

    public function save(Restaurant $restaurant): void
    {
        $this->restaurants[$restaurant->getRestaurantId()] = $restaurant;
    }

    public function findById(string $restaurantId): ?Restaurant
    {
        return $this->restaurants[$restaurantId] ?? null;
    }
}