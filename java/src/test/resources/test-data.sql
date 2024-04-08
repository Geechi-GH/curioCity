BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO landmarks (landmark_id, name, description, weekday_open, weekday_close, weekend_open, weekend_close, category, city_id, like_count, dislike_count)
VALUES
(1, 'Test Landmark 1', 'Test Description 1', '09:00:00', '17:00:00', '10:00:00', '16:00:00', 'Test Category 1', 1, 0, 0),
(2, 'Test Landmark 2', 'Test Description 2', '09:00:00', '17:00:00', '10:00:00', '16:00:00', 'Test Category 1', 1, 0, 0),
(3, 'Test Landmark 3', 'Test Description 3', '10:30:00', '18:30:00', '12:00:00', '17:00:00', 'Test Category 2', 1, 0, 0);


COMMIT TRANSACTION;
