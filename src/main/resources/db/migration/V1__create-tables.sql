CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE students (
    id          UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    email       VARCHAR(255) NOT NULL UNIQUE,
    created_at  TIMESTAMP DEFAULT NOW(),
    updated_at  TIMESTAMP DEFAULT NOW()
);

CREATE TABLE certifications (
    id          UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    student_id  UUID,
    technology  VARCHAR(50) NOT NULL,
    grade       INTEGER,
    created_at  TIMESTAMP DEFAULT NOW(),
    updated_at  TIMESTAMP DEFAULT NOW(),

    CONSTRAINT fk_student FOREIGN KEY(student_id) REFERENCES students(id) ON DELETE CASCADE
);

CREATE TABLE questions (
    id          UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    description VARCHAR NOT NULL,
    technology  VARCHAR(50) NOT NULL,
    created_at  TIMESTAMP DEFAULT NOW(),
    updated_at  TIMESTAMP DEFAULT NOW()
);

CREATE TABLE alternatives (
    id          UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    description VARCHAR NOT NULL,
    question_id UUID,
    is_correct  BOOLEAN NOT NULL,
    created_at  TIMESTAMP DEFAULT NOW(),
    updated_at  TIMESTAMP DEFAULT NOW(),

    CONSTRAINT fk_question FOREIGN KEY(question_id) REFERENCES questions(id) ON DELETE CASCADE
);

CREATE TABLE certification_answers (
    id                  UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    certification_id    UUID,
    question_id         UUID,
    answer_id           UUID,
    is_correct          BOOLEAN NOT NULL,
    created_at          TIMESTAMP DEFAULT NOW(),
    updated_at          TIMESTAMP DEFAULT NOW(),

    CONSTRAINT fk_certification FOREIGN KEY(certification_id) REFERENCES certifications(id) ON DELETE CASCADE,
    CONSTRAINT fk_question FOREIGN KEY(question_id) REFERENCES questions(id) ON DELETE CASCADE,
    CONSTRAINT fk_alternative FOREIGN KEY(answer_id) REFERENCES alternatives(id) ON DELETE CASCADE
);