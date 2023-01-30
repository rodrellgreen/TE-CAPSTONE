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

COMMIT TRANSACTION;
