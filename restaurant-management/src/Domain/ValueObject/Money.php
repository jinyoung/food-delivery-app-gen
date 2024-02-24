<?php

namespace RestaurantManagement\Domain\ValueObject;

class Money
{
    private float $amount;
    private string $currency;

    public function __construct(float $amount, string $currency = 'USD')
    {
        $this->amount = $amount;
        $this->currency = $currency;
    }

    // Getters and setters...
}