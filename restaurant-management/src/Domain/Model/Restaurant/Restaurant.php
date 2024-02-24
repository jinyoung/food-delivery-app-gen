<?php

namespace RestaurantManagement\Domain\Model\Restaurant;

use RestaurantManagement\Domain\Model\Menu\Menu;

class Restaurant
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

    public function updateRestaurant(string $name, array $menu): void
    {
        $this->name = $name;
        $this->menu = $menu;
    }

    // Getters and setters...
}