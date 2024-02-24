<?php

namespace RestaurantManagement\Domain\Event;

class EventPublisher
{
    private array $events = [];

    public function publish($event): void
    {
        $this->events[] = $event;
    }

    public function getEvents(): array
    {
        return $this->events;
    }
}