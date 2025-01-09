-- Table: answers
CREATE TABLE answers (
    id SERIAL PRIMARY KEY,
    message TEXT NOT NULL,
    topic_id BIGINT,
    creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    author_id BIGINT,
    solution TEXT NOT NULL
);

-- Table: courses
CREATE TABLE courses (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL
);

-- Table: profiles
CREATE TABLE profiles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Table: topics
CREATE TABLE topics (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status BOOLEAN NOT NULL DEFAULT TRUE,
    author_id BIGINT,
    course_id BIGINT
);

-- Table: users
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Table: users_profiles
CREATE TABLE users_profiles (
    user_id BIGINT NOT NULL,
    profile_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, profile_id)
);


-- Relationship between `answers` and `topics` (topic_id)
ALTER TABLE answers
    ADD CONSTRAINT fk_answers_topic
        FOREIGN KEY (topic_id)
            REFERENCES topics (id)
            ON DELETE CASCADE;

-- Relationship between `answers` and `users` (author_id)
ALTER TABLE answers
    ADD CONSTRAINT fk_answers_author
        FOREIGN KEY (author_id)
            REFERENCES users (id)
            ON DELETE CASCADE;

-- Relationship between `topics` and `users` (author_id)
ALTER TABLE topics
    ADD CONSTRAINT fk_topics_author
        FOREIGN KEY (author_id)
            REFERENCES users (id)
            ON DELETE CASCADE;

-- Relationship between `topics` and `courses` (course_id)
ALTER TABLE topics
    ADD CONSTRAINT fk_topics_course
        FOREIGN KEY (course_id)
            REFERENCES courses (id)
            ON DELETE CASCADE;

-- Relationship between `users_profiles` and `users` (user_id)
ALTER TABLE users_profiles
    ADD CONSTRAINT fk_users_profiles_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON DELETE CASCADE;

-- Relationship between `users_profiles` and `profiles` (profile_id)
ALTER TABLE users_profiles
    ADD CONSTRAINT fk_users_profiles_profile
        FOREIGN KEY (profile_id)
            REFERENCES profiles (id)
            ON DELETE CASCADE;