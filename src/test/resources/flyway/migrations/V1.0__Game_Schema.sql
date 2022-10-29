DROP TABLE IF EXISTS game_genre;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS game;

CREATE TABLE game (
    game_id INT AUTO_INCREMENT NOT NULL,
    game_name VARCHAR (128) NOT NULL,
    estimated_completion_time DECIMAL (5,2),
    game_overview TEXT,
    esrb_rating enum('EVERYONE', 'EVERYONE_10PLUS', 'TEEN', 'MATURE_17PLUS', 'ADULTS_ONLY_18PLUS', 'RATING_PENDING') NOT NULL,
    difficulty enum('EASY', 'NORMAL', 'CHALLENGING', 'HARD', 'EXPERT') NOT NULL,
    average_rating DECIMAL (3,1),
    release_date DATE,
    price DECIMAL (5,2),
    PRIMARY KEY (game_id)
    );
    
CREATE TABLE review (
    review_id INT AUTO_INCREMENT NOT NULL,
    game_id INT NOT NULL,
    reviewer_name VARCHAR (128) NOT NULL,
    reviewer_timestamp DATE,
    review_rating enum('ONE_STAR', 'TWO_STARS', 'THREE_STARS', 'FOUR_STARS', 'FIVE_STARS') NOT NULL,
    review_text TEXT,
    PRIMARY KEY (review_id),
    FOREIGN KEY (game_id) REFERENCES game (game_id) ON DELETE CASCADE
);

CREATE TABLE genre (
    genre_id INT AUTO_INCREMENT NOT NULL,
    genre_name VARCHAR (128) NOT NULL,
    PRIMARY KEY (genre_id)
);

CREATE TABLE game_genre (
    game_id INT NOT NULL,
    genre_id INT NOT NULL,
    FOREIGN KEY (game_id) REFERENCES game (game_id) ON DELETE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES genre (genre_id) ON DELETE CASCADE,
    UNIQUE KEY (game_id, genre_id)
);