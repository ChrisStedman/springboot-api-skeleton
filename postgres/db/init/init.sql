CREATE SCHEMA music;

CREATE TABLE music.artist
(
    id numeric PRIMARY KEY,
    name character varying(255) NOT NULL UNIQUE,
    genre varchar NOT NULL,
    creation_date timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE SEQUENCE music.artist_sequence
    AS INTEGER
    INCREMENT BY 1
    START WITH 1
    OWNED BY music.artist.id
;

INSERT INTO music.artist (id, name, genre)VALUES
    (nextVal('music.artist_sequence'), 'Nirvana', 'GRUNGE'),
    (nextVal('music.artist_sequence'), '1000mods', 'ROCK'),
    (nextVal('music.artist_sequence'), 'Days N Daze', 'PUNK');



CREATE TABLE music.album
(
    id numeric PRIMARY KEY,
    name character varying(255) NOT NULL UNIQUE,
    genre varchar NOT NULL,
    artist_id numeric NOT NULL,
    release_date date,
    creation_date timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT fk_artist
        FOREIGN KEY(artist_id)
            REFERENCES music.artist(id)
);

CREATE SEQUENCE music.album_sequence
    AS INTEGER
    INCREMENT BY 1
    START WITH 1
    OWNED BY music.album.id
;

INSERT INTO music.album (id, name, genre, artist_id, release_date)VALUES
    (nextVal('music.album_sequence'), 'Bleach', 'GRUNGE', 1, '1989-06-15'),
    (nextVal('music.album_sequence'), 'Nevermind', 'GRUNGE', 1, '1991-09-24'),
    (nextVal('music.album_sequence'), 'Super Van Vacation', 'ROCK', 2, '2011-09-29'),
    (nextVal('music.album_sequence'), 'Show Me The Blueprints', 'PUNK', 3, '2020-05-01');
