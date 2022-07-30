DROP TABLE IF EXISTS `table_bookings`;
create table bookings
(
   show_id bigint NOT NULL,
  `a1` int NOT NULL,
  `a2` int NOT NULL,
  `a3` int NOT NULL,
  `a4` int NOT NULL,
  `a5` int NOT NULL,
  `b1` int NOT NULL,
  `b2` int NOT NULL,
  `b3` int NOT NULL,
  `b4` int NOT NULL,
  `b5` int NOT NULL,
  `c1` int NOT NULL,
  `c2` int NOT NULL,
  `c3` int NOT NULL,
  `c4` int NOT NULL,
  `c5` int NOT NULL,
   PRIMARY KEY(show_id)
);

DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `city_id` bigint NOT NULL,
  `city_name` varchar(255) NOT NULL,
  `city_pincode` varchar(255) NOT NULL,
  `city_state` varchar(255) NOT NULL,
  PRIMARY KEY (`city_id`)
);

DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `movie_id` bigint NOT NULL,
  `movie_description` varchar(255) DEFAULT NULL,
  `movie_director` varchar(255) NOT NULL,
  `movie_name` varchar(255) NOT NULL,
  PRIMARY KEY (`movie_id`)
);

DROP TABLE IF EXISTS `theater`;
CREATE TABLE `theater` (
  `theater_id` bigint NOT NULL,
  `theater_area` varchar(255) NOT NULL,
  `theater_name` varchar(255) NOT NULL,
  `city_c_id` bigint DEFAULT NULL,
  PRIMARY KEY (`theater_id`),
  CONSTRAINT `FKtflvxj66v6b9kicc9kwh3js3g` FOREIGN KEY (`city_c_id`) REFERENCES `city` (`city_id`)
);


DROP TABLE IF EXISTS `show`;
CREATE TABLE `show` (
  `show_id` bigint NOT NULL,
  `show_time` varchar(255) NOT NULL,
  `the_movie_m_id` bigint DEFAULT NULL,
  `the_theater_t_id` bigint DEFAULT NULL,
  PRIMARY KEY (`show_id`),
  CONSTRAINT `FKeg2ca18ko9iie9lo3h6ay2ury` FOREIGN KEY (`the_theater_t_id`) REFERENCES `theater` (`theater_id`),
  CONSTRAINT `FKsayo2xxw82i3o8h7twmmps3um` FOREIGN KEY (`the_movie_m_id`) REFERENCES `movie` (`movie_id`)
);



