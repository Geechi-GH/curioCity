BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS landmarks;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE landmarks (
	landmark_id SERIAL PRIMARY KEY,
	name varchar(64) NOT NULL,
	description varchar(500) DEFAULT 'No Description Provided',
	weekday_open time DEFAULT '00:00:00',
	weekday_close time DEFAULT '00:00:00',
	weekend_open time DEFAULT '00:00:00',
	weekend_close time DEFAULT '00:00:00',
	category varchar(35) NOT NULL,
	city_id int DEFAULT 1,
	like_count int,
	dislike_count int
);


COMMIT TRANSACTION;
