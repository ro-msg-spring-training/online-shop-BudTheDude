CREATE TABLE IF NOT EXISTS `productCategory` (

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
                                          `streetAddress` varchar(20)


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

                                       `product` int,
                                       `location` int,
                                       `quantity` int,
                                       primary key (`product`,`location`)


);

CREATE TABLE IF NOT EXISTS `orderDetail` (

                                       `order` int,
                                       `product` int,
                                       `quantity` int,
                                       primary key (`order`,`product`)


);

ALTER TABLE `revenue`
    ADD FOREIGN KEY (`location`) REFERENCES `location`(`id`);

ALTER TABLE `order`
    ADD FOREIGN KEY (`shippedFrom`) REFERENCES `location`(`id`);

ALTER TABLE `order`
    ADD FOREIGN KEY (`customer`) REFERENCES `customer`(`id`);

ALTER TABLE `product`
    ADD FOREIGN KEY (`category`) REFERENCES `productCategory`(`id`);

ALTER TABLE `product`
    ADD FOREIGN KEY (`supplier`) REFERENCES `supplier`(`id`);




