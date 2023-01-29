CREATE TABLE movie (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    release_date DATE NOT NULL,
    unique (name)
);
CREATE TABLE actor
(
    id    bigserial primary key,
    name  TEXT NOT NULL,
    movie bigint REFERENCES movie (id),
    unique (name, movie)
);