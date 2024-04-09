BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');




-- Fountain Square
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath)
VALUES ('Fountain Square', 'A bustling public space in the heart of downtown.', '00:00:00', '24:00:00', '00:00:00', '24:00:00', 'Public Space', 0, 0, '../assets/Fountain Square.jpg');

-- Cincinnati Zoo & Botanical Garden
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath)
VALUES ('Cincinnati Zoo & Botanical Garden', 'A renowned zoo with diverse animal exhibits and beautiful gardens.', '09:00:00', '17:00:00', '09:00:00', '18:00:00', 'Attraction', 0, 0, '../assets/Cincy Zoo.jpg');

-- Cincinnati Museum Center at Union Terminal
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath)
VALUES ('Cincinnati Museum Center at Union Terminal', 'An iconic Art Deco train station turned museum complex.', '10:00:00', '17:00:00', '10:00:00', '17:00:00', 'Museum', 0, 0, '../assets/CMC.jpg');

-- Roebling Suspension Bridge
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath)
VALUES ('Roebling Suspension Bridge', 'A historic bridge connecting Cincinnati with Covington, Kentucky.', '00:00:00', '24:00:00', '00:00:00', '24:00:00', 'Landmark', 0, 0, '../assets/Roebling Bridge.jpg');

-- Krohn Conservatory
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath)
VALUES ('Krohn Conservatory', 'A botanical garden showcasing a wide variety of plants and flowers.', '10:00:00', '17:00:00', '10:00:00', '17:00:00', 'Botanical Garden', 0, 0, '../assets/Krohn.jpg');

-- Music Hall
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath)
VALUES ('Music Hall', 'A stunning concert venue hosting performances by the Cincinnati Symphony Orchestra and more.','00:00:00', '24:00:00', '00:00:00', '24:00:00', 'Entertainment', 0, 0, '../assets/Music Hall LRG.jpg');

-- Eden Park
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath)
VALUES ('Eden Park', 'A picturesque park offering scenic views of the Ohio River and numerous recreational activities.', '06:00:00', '22:00:00', '06:00:00', '22:00:00', 'Park', 0, 0, '../assets/Eden Park.jpg');

-- Cincinnati Art Museum
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath)
VALUES ('Cincinnati Art Museum', 'Featuring a vast collection of artworks spanning thousands of years.', '11:00:00', '17:00:00', '11:00:00', '17:00:00', 'Museum', 0, 0, '../assets/Cincy Art Museum.jpg');

-- Taft Museum of Art
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath)
VALUES ('Taft Museum of Art', 'A historic house museum showcasing fine art collections in a beautifully preserved mansion.', '11:00:00', '16:00:00', '11:00:00', '16:00:00', 'Museum', 0, 0, '../assets/Taft.jpg');

-- Cincinnati Observatory
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath)
VALUES ('Cincinnati Observatory', 'An historic observatory offering stargazing opportunities and educational programs.', '19:00:00', '22:00:00', '19:00:00', '22:00:00', 'Observatory', 0, 0, '../assets/Observatory.jpg');

COMMIT TRANSACTION;
