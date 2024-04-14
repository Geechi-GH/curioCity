BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

------------------------------------------------------------------------------------------------------------------------

-- Fountain Square
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Fountain Square', 'Fountain Square in Cincinnati is a vibrant and iconic urban space that serves as the heart of the citys downtown area. At its center stands the Tyler Davidson Fountain, a stunning bronze monument often referred to as the "Genius of Water." The fountain is surrounded by a meticulously landscaped plaza with ample seating, making it a popular gathering spot for locals and visitors alike.', '00:00:00', '24:00:00', '00:00:00', '24:00:00', 'Public Space', 0, 0, '../assets/Fountain Square.jpg', 'https://myfountainsquare.com/');

-- Cincinnati Zoo & Botanical Garden
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Cincinnati Zoo & Botanical Garden', 'The Cincinnati Zoo & Botanical Garden is a fantastic destination known for its rich history, diverse wildlife, and beautiful botanical displays. Founded in 1873, its one of the oldest zoos in the United States and has a strong commitment to conservation, education, and animal welfare.', '09:00:00', '17:00:00', '09:00:00', '18:00:00', 'Attraction', 0, 0, '../assets/Cincy Zoo.jpg', 'https://cincinnatizoo.org/');

-- Cincinnati Museum Center at Union Terminal
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Cincinnati Museum Center at Union Terminal', 'The Cincinnati Museum Center is a cultural gem nestled within the historic Union Terminal building, a magnificent Art Deco structure that is itself a work of art. Located in the heart of Cincinnati, Ohio, the Museum Center is a hub of exploration and learning, offering a diverse range of exhibits and activities for visitors of all ages.', '10:00:00', '17:00:00', '10:00:00', '17:00:00', 'Museum', 0, 0, '../assets/CMC.jpg', 'https://www.cincymuseum.org/');

-- Roebling Suspension Bridge
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Roebling Suspension Bridge', 'The Ohio Roebling Suspension Bridge, spanning the Ohio River and connecting Cincinnati, Ohio, with Covington, Kentucky, is a masterpiece of engineering and a historic landmark. Designed by John A. Roebling, the same engineer behind the Brooklyn Bridge, this suspension bridge is a testament to ingenuity and craftsmanship.', '00:00:00', '24:00:00', '00:00:00', '24:00:00', 'Landmark', 0, 0, '../assets/Roebling Bridge.jpg', 'https://roeblingbridge.org/');

-- Krohn Conservatory
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Krohn Conservatory', 'Krohn Conservatory is a botanical paradise nestled within Cincinnati, Ohio, offering visitors a lush and vibrant escape into the world of plants and flowers. Located in Eden Park, the conservatory is housed in a stunning Art Deco building that adds to its charm and allure.', '10:00:00', '17:00:00', '10:00:00', '17:00:00', 'Botanical Garden', 0, 0, '../assets/Krohn.jpg', 'https://www.cincinnati-oh.gov/cincyparks/visit-a-park/find-a-parkfacility/krohn-conservatory/');

-- Music Hall
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Music Hall', 'Cincinnati Music Hall is a magnificent architectural masterpiece and a cultural icon nestled in the heart of Cincinnatis Over-the-Rhine neighborhood. Built in the late 19th century, this historic venue is renowned for its stunning Gothic Revival style and its rich history of hosting world-class performances.','00:00:00', '24:00:00', '00:00:00', '24:00:00', 'Entertainment', 0, 0, '../assets/Music Hall LRG.jpg', 'https://www.cincinnatiarts.org/music-hall-home?gad_source=1&gclid=CjwKCAjw_e2wBhAEEiwAyFFFo3iCJtH3WcWaRPBIzL7cMqhLj8SWT7g26dFUgjaDwSD9L0sFhtRcMxoCdP4QAvD_BwE');

-- Eden Park
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Eden Park', 'Eden Park is a picturesque urban oasis located in Cincinnati, Ohio, offering visitors a serene retreat amidst lush greenery, scenic overlooks, and a variety of recreational amenities. Situated on the edge of the city overlooking the Ohio River, the park is renowned for its natural beauty, historic landmarks, and cultural attractions.', '06:00:00', '22:00:00', '06:00:00', '22:00:00', 'Park', 0, 0, '../assets/Eden Park.jpg', 'https://www.cincinnati-oh.gov/cincyparks/visit-a-park/find-a-parkfacility/eden-park/');

-- Cincinnati Art Museum
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Cincinnati Art Museum', 'The Cincinnati Art Museum is a cultural treasure nestled within the scenic Eden Park in Cincinnati, Ohio. Housed in a majestic building that blends classical and modern architectural elements, the museum offers a rich tapestry of artistic masterpieces spanning thousands of years and representing diverse cultures from around the world.', '11:00:00', '17:00:00', '11:00:00', '17:00:00', 'Museum', 0, 0, '../assets/Cincy Art Museum.jpg', 'https://cincinnatiartmuseum.org/');

-- Taft Museum of Art
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Taft Museum of Art', 'The Taft Museum of Art in Ohio is a hidden gem nestled in Cincinnatis historic district, offering visitors a captivating journey through art, history, and culture. Housed in a stunning National Historic Landmark building that was once the home of prominent industrialist Charles Phelps Taft and his family, the museum combines a rich collection of artworks with a beautifully preserved historic setting.', '11:00:00', '16:00:00', '11:00:00', '16:00:00', 'Museum', 0, 0, '../assets/Taft.jpg', 'https://www.taftmuseum.org/');

-- Cincinnati Observatory
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Cincinnati Observatory', 'The Cincinnati Observatory is a historic and iconic landmark that has been observing the wonders of the night sky for over two centuries. Located in Cincinnati, Ohio, the observatory is known for its rich astronomical heritage, stunning telescopes, and commitment to public education and outreach.', '19:00:00', '22:00:00', '19:00:00', '22:00:00', 'Observatory', 0, 0, '../assets/Observatory.jpg', 'https://www.cincinnatiobservatory.org/');

------------------------------------------------------------------------------------------------------------------------

INSERT INTO itinerarys (title, city_id, user_id, date_of_travel) VALUES ('Trip to Cincinnati', 1, 1, '2024-05-15');
INSERT INTO itinerarys (title, city_id, user_id, date_of_travel) VALUES ('Weekend Getaway', 1, 1, '2024-06-20');
INSERT INTO itinerarys (title, city_id, user_id, date_of_travel) VALUES ('Family Vacation', 1, 1, '2024-07-10');
INSERT INTO itinerarys (title, city_id, user_id, date_of_travel) VALUES ('Business Trip', 1, 1, '2024-08-05');
INSERT INTO itinerarys (title, city_id, user_id, date_of_travel) VALUES ('Honeymoon', 1, 1, '2024-09-12');
INSERT INTO itinerarys (title, city_id, user_id, date_of_travel) VALUES ('Adventure in the City', 1, 1, '2024-10-25');
INSERT INTO itinerarys (title, city_id, user_id, date_of_travel) VALUES ('Water Park Vacation', 1, 1, '2024-11-08');
INSERT INTO itinerarys (title, city_id, user_id, date_of_travel) VALUES ('Sightseeing Tour', 1, 1, '2024-12-17');
INSERT INTO itinerarys (title, city_id, user_id, date_of_travel) VALUES ('Exploring Historical Sites', 1, 1, '2025-01-05');
INSERT INTO itinerarys (title, city_id, user_id, date_of_travel) VALUES ('Cultural Exchange Program', 1, 1, '2025-02-20');

COMMIT TRANSACTION;
