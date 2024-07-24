CREATE TABLE IF NOT EXISTS `customer` (
    `customer_id` int AUTO_INCREMENT PRIMARY KEY,
    `name` Varchar(100) NOT NULL,
    `email` Varchar(100) NOT NULL,
    `created_at` date NOT NULL,
    `created_by` Varchar(20) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` Varchar(20) DEFAULT NULL
);