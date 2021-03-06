CREATE TABLE IF NOT EXISTS `product_Category` (

                                          `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                          `name` varchar(20),
                                          `description` varchar(50)


);

CREATE TABLE IF NOT EXISTS `supplier` (

                                                 `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                                 `name` varchar(20)


);

CREATE TABLE IF NOT EXISTS `customer` (

                                          `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                          `first_Name` varchar(20),
                                          `last_Name` varchar(20),
                                          `user_Name` varchar(20),
                                          `password` varchar(20),
                                          `email_Address` varchar(20)


);

CREATE TABLE IF NOT EXISTS `location` (

                                          `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                          `name` varchar(20),
                                          `country` varchar(20),
                                          `city` varchar(20),
                                          `county` varchar(20),
                                          `street_Address` varchar(20)


);

CREATE TABLE IF NOT EXISTS `product` (

                                          `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                          `name` varchar(20),
                                          `description` varchar(50),
                                          `price` long,
                                          `weight` double,
                                          `category` int,
                                          `supplier` int,
                                          `imageUrl` varchar(50)

);

CREATE TABLE IF NOT EXISTS `revenue` (

                                         `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                         `location` int,
                                         `date` date,
                                         `sum` long

);

CREATE TABLE IF NOT EXISTS `order1` (

                                         `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                         `shipped_From_id` int,
                                         `customer_id` int,
                                         `created_At` varchar(20),
                                         `country` varchar(20),
                                         `city` varchar(20),
                                         `county` varchar(20),
                                         `street_Address` varchar(20)

);

CREATE TABLE IF NOT EXISTS `stock` (

                                       `product_id` int,
                                       `location_id` int,
                                       `quantity` int,
                                       primary key (`product_id`,`location_id`)


);

CREATE TABLE IF NOT EXISTS `order_detail` (

                                       `order_id` int,
                                       `product_id` int,
                                       `quantity` int,
                                       primary key (`order_id`,`product_id`)


);

ALTER TABLE `stock`
    ADD FOREIGN KEY (`product_id`) REFERENCES `product`(`id`);

ALTER TABLE `stock`
    ADD FOREIGN KEY (`location_id`) REFERENCES `location`(`id`);

ALTER TABLE `order_detail`
    ADD FOREIGN KEY (`order_id`) REFERENCES `order1`(`id`);

ALTER TABLE `order_detail`
    ADD FOREIGN KEY (`product_id`) REFERENCES `product`(`id`);

ALTER TABLE `revenue`
    ADD FOREIGN KEY (`location`) REFERENCES `location`(`id`);

ALTER TABLE `order1`
    ADD FOREIGN KEY (`shipped_From_id`) REFERENCES `location`(`id`);

ALTER TABLE `order1`
    ADD FOREIGN KEY (`customer_id`) REFERENCES `customer`(`id`);

ALTER TABLE `product`
    ADD FOREIGN KEY (`category`) REFERENCES `product_Category`(`id`);

ALTER TABLE `product`
    ADD FOREIGN KEY (`supplier`) REFERENCES `supplier`(`id`);






