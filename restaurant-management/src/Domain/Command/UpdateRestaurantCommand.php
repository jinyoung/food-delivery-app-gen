<?php

namespace RestaurantManagement\Domain\Command;

class UpdateRestaurantCommand
{
    private string $restaurantId;
    private string $name;
    private array $menu;

    public function __construct(string $restaurantId, string $name, array $menu)
    {
        $this->restaurantId = $restaurantId;
        $this->name = $name;
        $this->menu = $menu;
    }

    // Getters...
}