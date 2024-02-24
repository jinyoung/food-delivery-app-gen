<?php

require_once 'vendor/autoload.php';

use RestaurantManagement\Domain\Command\CreateRestaurantCommand;
use RestaurantManagement\Domain\Command\UpdateRestaurantCommand;
use RestaurantManagement\Domain\CommandHandler\CommandHandler;
use RestaurantManagement\Domain\Event\EventPublisher;
use RestaurantManagement\Domain\Model\Restaurant\RestaurantRepository;
use RestaurantManagement\Infrastructure\Persistence\InMemoryRestaurantRepository;

// Initialize repositories
$restaurantRepository = new InMemoryRestaurantRepository();

// Initialize command handler and event publisher
$commandHandler = new CommandHandler($restaurantRepository);
$eventPublisher = new EventPublisher();

// Example usage
$createRestaurantCommand = new CreateRestaurantCommand('My Restaurant', []);
$commandHandler->handleCreateRestaurant($createRestaurantCommand);

$updateRestaurantCommand = new UpdateRestaurantCommand('restaurant-id-123', 'Updated Restaurant Name', []);
$commandHandler->handleUpdateRestaurant($updateRestaurantCommand);

// Output the events that were published
foreach ($eventPublisher->getEvents() as $event) {
    echo $event->getName() . " event published with data: " . json_encode($event->getData()) . PHP_EOL;
}