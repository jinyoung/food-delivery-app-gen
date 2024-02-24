<?php

namespace RestaurantManagement\Domain\Event;

class RestaurantCreatedEvent
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

    public function getName(): string
    {
        return 'RestaurantCreated';
    }

    public function getData(): array
    {
        return [
            'restaurantId' => $this->restaurantId,
            'name' => $this->name,
            'menu' => $this->menu,
        ];
    }
}