<?php

namespace RestaurantManagement\Domain\Command;

class CreateRestaurantCommand
{
    private string $name;
    private array $menu;

    public function __construct(string $name, array $menu)
    {
        $this->name = $name;
        $this->menu = $menu;
    }

    // Getters...
}