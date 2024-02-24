<?php

namespace RestaurantManagement\Domain\Model\Restaurant;

interface RestaurantRepository
{
    public function save(Restaurant $restaurant): void;
    public function findById(string $restaurantId): ?Restaurant;
}