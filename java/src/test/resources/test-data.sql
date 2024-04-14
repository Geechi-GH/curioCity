BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO landmarks (landmark_id, name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, city_id, like_count, dislike_count, imagePath)
VALUES (1, 'Test Landmark 1', 'Test Description 1', '09:00:00', '17:00:00', '10:00:00', '16:00:00', 'Test Category 1', 1, 0, 0, '../assets/CurioCity.png'),
(2, 'Test Landmark 2', 'Test Description 2', '09:00:00', '17:00:00', '10:00:00', '16:00:00', 'Test Category 1', 1, 0, 0, '../assets/CurioCity.png'),
(3, 'Test Landmark 3', 'Test Description 3', '10:30:00', '18:30:00', '12:00:00', '17:00:00', 'Test Category 2', 1, 0, 0, '../assets/CurioCity.png');

INSERT INTO itinerarys (itinerary_id, title, city_id, user_id, date_of_travel, date_created)
VALUES (1, 'Test 1', 1, 1, '2024-05-15', '2024-04-10'),
(2, 'Test 2', 1, 1, '2024-06-20', '2024-04-10'),
(3, 'Test 3', 1, 2, '2024-05-15', '2024-04-10');

COMMIT TRANSACTION;