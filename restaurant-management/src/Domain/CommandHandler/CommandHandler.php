<?php

namespace RestaurantManagement\Domain\CommandHandler;

use RestaurantManagement\Domain\Command\CreateRestaurantCommand;
use RestaurantManagement\Domain\Command\UpdateRestaurantCommand;
use RestaurantManagement\Domain\Event\RestaurantCreatedEvent;
use RestaurantManagement\Domain\Model\Restaurant\RestaurantRepository;
use RestaurantManagement\Domain\Event\EventPublisher;

class CommandHandler
{
    private RestaurantRepository $restaurantRepository;
    private EventPublisher $eventPublisher;

    public function __construct(RestaurantRepository $restaurantRepository, EventPublisher $eventPublisher)
    {
        $this->restaurantRepository = $restaurantRepository;
        $this->eventPublisher = $eventPublisher;
    }

    public function handleCreateRestaurant(CreateRestaurantCommand $command): void
    {
        // Logic to create a restaurant...
        $restaurantId = uniqid(); // Generate a unique ID for the restaurant
        $restaurant = new Restaurant($restaurantId, $command->getName(), $command->getMenu());
        $this->restaurantRepository->save($restaurant);

        // Publish an event
        $event = new RestaurantCreatedEvent($restaurantId, $command->getName(), $command->getMenu());
        $this->eventPublisher->publish($event);
    }

    public function handleUpdateRestaurant(UpdateRestaurantCommand $command): void
    {
        // Logic to update a restaurant...
        $restaurant = $this->restaurantRepository->findById($command->getRestaurantId());
        if ($restaurant) {
            $restaurant->updateRestaurant($command->getName(), $command->getMenu());
            $this->restaurantRepository->save($restaurant);
        }

        // No event is defined for update in the model, but you could publish one if needed
    }
}