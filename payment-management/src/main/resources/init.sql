CREATE TABLE IF NOT EXISTS payments (
    payment_id VARCHAR(255) PRIMARY KEY,
    method VARCHAR(255),
    amount DECIMAL
);