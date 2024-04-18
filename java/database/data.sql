BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

------------------------------------------------------------------------------------------------------------------------

-- Fountain Square
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Fountain Square', 'Fountain Square in Cincinnati is a vibrant and iconic urban space that serves as the heart of the citys downtown area. At its center stands the Tyler Davidson Fountain, a stunning bronze monument often referred to as the "Genius of Water." The fountain is surrounded by a meticulously landscaped plaza with ample seating, making it a popular gathering spot for locals and visitors alike.', '00:00:00', '24:00:00', '00:00:00', '24:00:00', 'Public Space', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Fountain Square.jpg', 'https://myfountainsquare.com/');

-- Cincinnati Zoo & Botanical Garden
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Cincinnati Zoo & Botanical Garden', 'The Cincinnati Zoo & Botanical Garden is a fantastic destination known for its rich history, diverse wildlife, and beautiful botanical displays. Founded in 1873, its one of the oldest zoos in the United States and has a strong commitment to conservation, education, and animal welfare.', '09:00:00', '17:00:00', '09:00:00', '18:00:00', 'Attraction', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Updated photos/cincinnati zoo.png', 'https://cincinnatizoo.org/');

-- Cincinnati Museum Center at Union Terminal
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Cincinnati Museum Center at Union Terminal', 'The Cincinnati Museum Center is a cultural gem nestled within the historic Union Terminal building, a magnificent Art Deco structure that is itself a work of art. Located in the heart of Cincinnati, Ohio, the Museum Center is a hub of exploration and learning, offering a diverse range of exhibits and activities for visitors of all ages.', '10:00:00', '17:00:00', '10:00:00', '17:00:00', 'Museum', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/CMC.jpg', 'https://www.cincymuseum.org/');

-- Roebling Suspension Bridge
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Roebling Suspension Bridge', 'The Ohio Roebling Suspension Bridge, spanning the Ohio River and connecting Cincinnati, Ohio, with Covington, Kentucky, is a masterpiece of engineering and a historic landmark. Designed by John A. Roebling, the same engineer behind the Brooklyn Bridge, this suspension bridge is a testament to ingenuity and craftsmanship.', '00:00:00', '24:00:00', '00:00:00', '24:00:00', 'Public Space', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Roebling Bridge.jpg', 'https://roeblingbridge.org/');

-- Krohn Conservatory
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Krohn Conservatory', 'Krohn Conservatory is a botanical paradise nestled within Cincinnati, Ohio, offering visitors a lush and vibrant escape into the world of plants and flowers. Located in Eden Park, the conservatory is housed in a stunning Art Deco building that adds to its charm and allure.', '10:00:00', '17:00:00', '10:00:00', '17:00:00', 'Attraction', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Updated Photos/kron.png', 'https://www.cincinnati-oh.gov/cincyparks/visit-a-park/find-a-parkfacility/krohn-conservatory/');

-- Music Hall
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Cincinnati Music Hall', 'Cincinnati Music Hall is a magnificent architectural masterpiece and a cultural icon nestled in the heart of Cincinnatis Over-the-Rhine neighborhood. Built in the late 19th century, this historic venue is renowned for its stunning Gothic Revival style and its rich history of hosting world-class performances.','00:00:00', '24:00:00', '00:00:00', '24:00:00', 'Attraction', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Music Hall LRG.jpg', 'https://www.cincinnatiarts.org/music-hall-home?gad_source=1&gclid=CjwKCAjw_e2wBhAEEiwAyFFFo3iCJtH3WcWaRPBIzL7cMqhLj8SWT7g26dFUgjaDwSD9L0sFhtRcMxoCdP4QAvD_BwE');

-- Eden Park
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Eden Park', 'Eden Park is a picturesque urban oasis located in Cincinnati, Ohio, offering visitors a serene retreat amidst lush greenery, scenic overlooks, and a variety of recreational amenities. Situated on the edge of the city overlooking the Ohio River, the park is renowned for its natural beauty, historic landmarks, and cultural attractions.', '06:00:00', '22:00:00', '06:00:00', '22:00:00', 'Park', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Eden Park.jpg', 'https://www.cincinnati-oh.gov/cincyparks/visit-a-park/find-a-parkfacility/eden-park/');

-- Cincinnati Art Museum
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Cincinnati Art Museum', 'The Cincinnati Art Museum is a cultural treasure nestled within the scenic Eden Park in Cincinnati, Ohio. Housed in a majestic building that blends classical and modern architectural elements, the museum offers a rich tapestry of artistic masterpieces spanning thousands of years and representing diverse cultures from around the world.', '11:00:00', '17:00:00', '11:00:00', '17:00:00', 'Museum', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Cincy Art Museum.jpg', 'https://cincinnatiartmuseum.org/');

-- Taft Museum of Art
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Taft Museum of Art', 'The Taft Museum of Art in Ohio is a hidden gem nestled in Cincinnatis historic district, offering visitors a captivating journey through art, history, and culture. Housed in a stunning National Historic Landmark building that was once the home of prominent industrialist Charles Phelps Taft and his family, the museum combines a rich collection of artworks with a beautifully preserved historic setting.', '11:00:00', '16:00:00', '11:00:00', '16:00:00', 'Museum', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Taft.jpg', 'https://www.taftmuseum.org/');

-- Cincinnati Observatory
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website)
VALUES ('Cincinnati Observatory', 'The Cincinnati Observatory is a historic and iconic landmark that has been observing the wonders of the night sky for over two centuries. Located in Cincinnati, Ohio, the observatory is known for its rich astronomical heritage, stunning telescopes, and commitment to public education and outreach.', '19:00:00', '22:00:00', '19:00:00', '22:00:00', 'Attraction', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Observatory.jpg', 'https://www.cincinnatiobservatory.org/');

-- Chats new addition

INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website) VALUES
('Carew Tower', 'A historic skyscraper in downtown Cincinnati, offering observation decks with panoramic views of the city and surrounding areas.', '09:00:00', '17:00:00', '09:00:00', '18:00:00', 'Public Space', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Updated photos/carew tower.png', 'https://www.cincydeco.com/buildings/carew-tower'),
('Paychor Stadium', 'Home to the Cincinnati Bengals NFL team, this stadium features modern architecture and hosts football games and other events.', '09:00:00', '17:00:00', '09:00:00', '18:00:00', 'Stadium', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Updated photos/football stadium.png', 'https://www.bengals.com/stadium/'),
('Great American Tower at Queen City Square', 'A distinctive skyscraper in downtown Cincinnati, known for its modern design and observation deck offering stunning views of the city.', '09:00:00', '17:00:00', '09:00:00', '18:00:00', 'Public Space', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Updated photos/great american tower.png', 'https://www.queencitysquare.com/great-american-tower'),
('Fifth Third Arena', 'The home of the University of Cincinnati Bearcats basketball teams, featuring modern architecture and state-of-the-art facilities.', '09:00:00', '17:00:00', '09:00:00', '18:00:00', 'Stadium', ROUND(RANDOM() * 100), ROUND(RANDOM() * 500), '../assets/Updated photos/fifth third arena.png', 'https://gobearcats.com/facilities/fifth-third-arena/1003')
-- Add more landmarks here as needed
;
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website) VALUES
('Eden Park', 'A scenic park offering gardens, lakes, walking trails, playgrounds, and beautiful views of the Ohio River.', '06:00:00', '22:00:00', '06:00:00', '22:00:00', 'Park', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Updated photos/eden park.png', 'https://www.cincinnati-oh.gov/cincyparks/visit-a-park/find-a-parkfacility/eden-park/'),
('Devou Park', 'A large park in Covington, Kentucky, featuring hiking trails, golf courses, playgrounds, and panoramic views of the Cincinnati skyline.', '07:00:00', '21:00:00', '07:00:00', '22:00:00', 'Park', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Updated photos/devou park.png', 'https://www.exploredevoupark.org/'),
('Spring Grove Cemetery and Arboretum', 'One of the largest nonprofit cemeteries in the US, known for its beautiful gardens, sculptures, and historic gravesites.', '08:00:00', '17:00:00', '08:00:00', '18:00:00', 'Park', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Updated photos/spring grove.png', 'https://www.springgrove.org/'),
('Smale Riverfront Park', 'A riverfront park offering interactive fountains, playgrounds, gardens, and walking paths along the Ohio River.', '06:00:00', '22:00:00', '06:00:00', '23:00:00', 'Park', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Updated photos/smale riverfront.png', 'https://www.cincinnati-oh.gov/cincyparks/visit-a-park/find-a-parkfacility/smale-riverfront-park/'),
('Graeter''s Ice Cream', 'A Cincinnati institution known for its handcrafted ice cream flavors and famous French Pot process.', '11:00:00', '22:00:00', '11:00:00', '23:00:00', 'Restaurant', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Updated photos/graeters.jpg', 'https://www.graeters.com/'),
('Loveland Bike Trail', 'A scenic bike trail stretching over 70 miles from Cincinnati to Springfield, passing through parks, historic landmarks, and natural landscapes.', '06:00:00', '22:00:00', '06:00:00', '22:00:00', 'Park', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Updated photos/loveland biketrail.png', 'https://www.lovelandbiketrail.com/'),
('Findlay Market', 'Ohio''s oldest continuously operated public market, offering a wide variety of fresh produce, meats, baked goods, and artisanal products.', '08:00:00', '18:00:00', '08:00:00', '18:00:00', 'Public Space', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Updated photos/findlay.png', 'http://www.findlaymarket.org/'),
('Coney Island', 'A family-friendly amusement park with rides, water attractions, and a classic wooden roller coaster.', '10:00:00', '20:00:00', '10:00:00', '21:00:00', 'Attraction', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Updated photos/coney island.png', 'https://coneyislandpark.com/')
-- Add more landmarks here as needed
;
INSERT INTO landmarks (name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, like_count, dislike_count, imagePath, website) VALUES
('Skyline Chili', 'A Cincinnati classic, known for its unique chili served over spaghetti, hot dogs, or coneys.', '10:00:00', '22:00:00', '10:00:00', '23:00:00', 'Restaurant', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Updated photos/skyline chili.png', 'https://www.skylinechili.com/'),
('LaRosa''s Pizzeria', 'A popular local chain serving delicious pizza, pasta, and other Italian-American dishes.', '11:00:00', '22:00:00', '11:00:00', '23:00:00', 'Restaurant', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Updated photos/larosas.png', 'https://www.larosas.com/'),
('Montgomery Inn', 'Famous for its ribs and BBQ sauce, Montgomery Inn offers a casual dining experience with river views.', '11:30:00', '22:00:00', '11:30:00', '23:00:00', 'Restaurant', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Updated Photos/montgomery inn.png', 'https://www.montgomeryinn.com/'),
('King''s Island', 'A large amusement park with roller coasters, water rides, and family-friendly attractions.', '10:00:00', '22:00:00', '10:00:00', '23:00:00', 'Attraction', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Updated photos/kings island.png', 'https://www.visitkingsisland.com/'),
('Great Wolf Lodge', 'A family-friendly resort featuring indoor water parks, activities, and themed suites.', '08:00:00', '22:00:00', '08:00:00', '23:00:00', 'Attraction', ROUND(RANDOM() * 1000), ROUND(RANDOM() * 500), '../assets/Updated photos/great wolf lodge.png', 'https://www.greatwolf.com/mason');
-- Add more landmarks here as needed

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

INSERT INTO reviews (user_id, landmark_id, title, review, name) VALUES
(1, 1, 'Breathtaking View', 'The scenic beauty of this place is absolutely stunning and well worth a visit. The atmosphere is serene and peaceful.', 'John Doe');

INSERT INTO reviews (user_id, landmark_id, title, review, name) VALUES
(2, 1, 'Historic Marvel', 'A deep dive into the history and architectural brilliance of this landmark. Highly recommended for history buffs!', 'Jane Smith');

INSERT INTO reviews (user_id, landmark_id, title, review, name) VALUES
(1, 2, 'Just OK', 'It was alright but quite crowded and a bit overrated. Could be better managed.', 'Mike Johnson');

INSERT INTO reviews (user_id, landmark_id, title, review, name) VALUES
(2, 2, 'Must Visit', 'An incredible experience, the guided tours are informative and the view is spectacular. Make sure to bring your camera for some stunning photos!', 'Alice Martin');

INSERT INTO reviews (user_id, landmark_id, title, review) VALUES
(1, 3, 'Lovely Spot', 'The park surrounding the landmark is perfect for a family day out. Lots of space and very clean.');

COMMIT TRANSACTION;
