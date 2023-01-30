BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE profile (
   profile_id SERIAL,
   user_id INTEGER NOT NULL,
   email varchar(100) NOT NULL,
   age INTEGER NOT NULL,
   height_feet INTEGER NOT NULL,
   height_inches INTEGER NOT NULL,
   current_weight NUMERIC(5,2) NOT NULL,
   desired_weight NUMERIC(5,2) NOT NULL,
   CONSTRAINT PK_profile PRIMARY KEY (profile_id),
   CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id)
 );

 CREATE TABLE meal(
 meal_id SERIAL,
 user_id INTEGER NOT NULL,
 meal_type varchar(100),
 CONSTRAINT PK_meal PRIMARY KEY (meal_id),
 CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id)
 );

 CREATE TABLE food(
 food_id SERIAL,
 food_name VARCHAR(100) NOT NULL,
 calories NUMERIC(10,2) NOT NULL,
 CONSTRAINT PK_food PRIMARY KEY (food_id)
 );

 CREATE TABLE meal_food(
 meal_id INTEGER NOT NULL,
 food_id INTEGER NOT NULL,
 CONSTRAINT PK_meal_food PRIMARY KEY (meal_id, food_id),
 CONSTRAINT FK_meal_id FOREIGN KEY (meal_id) REFERENCES meal(meal_id),
 CONSTRAINT FK_food_id FOREIGN KEY (food_id) REFERENCES food(food_id)
 );

COMMIT TRANSACTION;
