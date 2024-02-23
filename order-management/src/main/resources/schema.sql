CREATE TABLE orders (
    order_id VARCHAR(255) PRIMARY KEY,
    menu TEXT,
    delivery_address TEXT,
    payment_method VARCHAR(255),
    status VARCHAR(255)
);