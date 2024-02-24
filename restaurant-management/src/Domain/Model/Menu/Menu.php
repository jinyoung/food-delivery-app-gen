<?php

namespace RestaurantManagement\Domain\Model\Menu;

use RestaurantManagement\Domain\ValueObject\Money;

class Menu
{
    private string $name;
    private Money $price;
    private string $description;
    private $image; // Assuming $image is a File object or a string path

    public function __construct(string $name, Money $price, string $description, $image)
    {
        $this->name = $name;
        $this->price = $price;
        $this->description = $description;
        $this->image = $image;
    }

    // Getters and setters...
}