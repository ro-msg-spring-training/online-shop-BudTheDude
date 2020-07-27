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
                                          `firstName` varchar(20),
                                          `lastName` varchar(20),
                                          `userName` varchar(20),
                                          `password` varchar(20),
                                          `emailAddress` varchar(20)


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

CREATE TABLE IF NOT EXISTS `order` (

                                         `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                         `shippedFrom` int,
                                         `customer` int,
                                         `createdAt` datetime,
                                         `country` varchar(20),
                                         `city` varchar(20),
                                         `county` varchar(20),
                                         `streetAddress` varchar(20)

);

CREATE TABLE IF NOT EXISTS `stock` (

                                       `product_id` int,
                                       `location_id` int,
                                       `quantity` int,
                                       primary key (`product_id`,`location_id`)


);

CREATE TABLE IF NOT EXISTS `orderDetail` (

                                       `order` int,
                                       `product` int,
                                       `quantity` int,
                                       primary key (`order`,`product`)


);

ALTER TABLE `stock`
    ADD FOREIGN KEY (`product_id`) REFERENCES `product`(`id`);

ALTER TABLE `stock`
    ADD FOREIGN KEY (`location_id`) REFERENCES `location`(`id`);

ALTER TABLE `orderDetail`
    ADD FOREIGN KEY (`order`) REFERENCES `order`(`id`);

ALTER TABLE `orderDetail`
    ADD FOREIGN KEY (`product`) REFERENCES `product`(`id`);

ALTER TABLE `revenue`
    ADD FOREIGN KEY (`location`) REFERENCES `location`(`id`);

ALTER TABLE `order`
    ADD FOREIGN KEY (`shippedFrom`) REFERENCES `location`(`id`);

ALTER TABLE `order`
    ADD FOREIGN KEY (`customer`) REFERENCES `customer`(`id`);

ALTER TABLE `product`
    ADD FOREIGN KEY (`category`) REFERENCES `product_Category`(`id`);

ALTER TABLE `product`
    ADD FOREIGN KEY (`supplier`) REFERENCES `supplier`(`id`);





