DROP TABLE IF EXISTS user_quiz_statistic;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE user_quiz_statistic
(
    id                          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    user_id                     INTEGER                     NOT NULL,
    correct_answers             INTEGER                     NOT NULL,
    incorrect_answers           INTEGER                     NOT NULL,
    last_quiz_date              TIMESTAMP     DEFAULT now() NOT NULL
)

INSERT INTO user_quiz_statistic(id, user_id, correct_answers, incorrect_answers, last_quiz_date)
values (100000, 1, 0, 0, '17.12.2024');

DROP TABLE IF EXISTS questions;

CREATE TABLE questions(
    id                          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    text_question               VARCHAR
)

CREATE TABLE answers(
    id                          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    answer                      VARCHAR,
    isCorrect                   BOOLEAN             DEFAULT false,
    question_id                 INTEGER             NOT NULL,
    FOREIGN KEY (question_id)   REFERENCES questions (id) ON DELETE CASCADE
)

INSERT INTO questions(id, text_question)
values (100001, 'Вопрос');

INSERT INTO answers(id, answer, isCorrect)
values (100002, 'Ответ1', false, 100001);
INSERT INTO answers(id, answer, isCorrect)
values (100003, 'Ответ2', false, 100001);
INSERT INTO answers(id, answer, isCorrect)
values (100004, 'Ответ3', true, 100001);
INSERT INTO answers(id, answer, isCorrect)
values (100005, 'Ответ4', false, 100001);