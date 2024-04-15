BEGIN TRANSACTION;

DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS ratings;
DROP TABLE IF EXISTS land_itin_helper;
DROP TABLE IF EXISTS landmarks;
DROP TABLE IF EXISTS itinerarys;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE itinerarys (
	itinerary_id SERIAL PRIMARY KEY,
	title varchar(50) DEFAULT 'untitled',
	city_id int DEFAULT 1,
	user_id int,
	date_of_travel date NOT NULL,
	date_created date DEFAULT CURRENT_DATE,
	FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE landmarks (
	landmark_id SERIAL PRIMARY KEY,
	name varchar(64) NOT NULL,
	description varchar(550) DEFAULT 'No Description Provided',
	weekday_open time DEFAULT '00:00:00',
	weekday_close time DEFAULT '00:00:00',
	weekend_open time DEFAULT '00:00:00',
	weekend_close time DEFAULT '00:00:00',
	category varchar(35) NOT NULL,
	city_id int DEFAULT 1,
	like_count int,
	dislike_count int,
	imagePath varchar(100),
    website varchar(250)
);

CREATE TABLE land_itin_helper (
	itinerary_id int,
	landmark_id int,
	sequence int,
	PRIMARY KEY (itinerary_id, landmark_id),
	FOREIGN KEY (itinerary_id) REFERENCES itinerarys(itinerary_id),
	FOREIGN KEY (landmark_id) REFERENCES landmarks(landmark_id)
);

CREATE TABLE ratings (
	user_id int,
	landmark_id int,
	like_status int DEFAULT 0,
	PRIMARY KEY (user_id, landmark_id),
	FOREIGN KEY (user_id) REFERENCES users(user_id),
	FOREIGN KEY (landmark_id) REFERENCES landmarks(landmark_id)
);

CREATE TABLE reviews (
	user_id int,
	landmark_id int,
	title varchar(30),
	review varchar(750),
	name varchar(20) DEFAULT 'anonymous',
	PRIMARY KEY (user_id, landmark_id),
	FOREIGN KEY (user_id) REFERENCES users(user_id),
	FOREIGN KEY (landmark_id) REFERENCES landmarks(landmark_id)
);

COMMIT TRANSACTION;