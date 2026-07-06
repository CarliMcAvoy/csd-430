USE CSD430;

CREATE TABLE IF NOT EXISTS carli_movies_data(
movie_title varchar(50) PRIMARY KEY,
movie_year varchar(4),
movie_rating varchar(4),
movie_director varchar(50),
movie_producer varchar(50)
);

INSERT IGNORE INTO carli_movies_data(movie_title, movie_year, movie_rating, movie_director, movie_producer)
VALUES
('Spirited Away', 2001, 8.6, 'Hayao Miyazaki', 'Studio Ghibli'),
('Princess Mononoke', 1997, 8.3, 'Hayao Miyazaki', 'Studio Ghibli'),
('Ponyo', 2008, 7.6, 'Hayao Miyazaki', 'Studio Ghibli'),
('Howls Moving Castle', 2004, 8.2, 'Hayao Miyazaki', 'Studio Ghibli'),
('The Cat Returns', 2002, 7.1, 'Hayao Miyazaki', 'Studio Ghibli'),
('Porco Rosso', 1992, 7.7, 'Hayao Miyazaki', 'Studio Ghibli'),
('Castle in the Sky', 1986, 8, 'Hayao Miyazaki', 'Studio Ghibli'),
('The Wind Rises', 2013, 7.8, 'Hayao Miyazaki', 'Studio Ghibli'),
('When Marnie Was There', 2014, 7.6, 'Hayao Miyazaki', 'Studio Ghibli'),
('Arrietty', 2010, 7.6, 'Hayao Miyazaki', 'Studio Ghibli');

