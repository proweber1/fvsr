CREATE TABLE categories
(
  id         SERIAL PRIMARY KEY NOT NULL,
  name       CHAR(200),
  name_short CHAR(10)
);
CREATE TABLE competitions
(
  id            SERIAL PRIMARY KEY NOT NULL,
  name          CHAR(300)          NOT NULL,
  id_rf_subject INTEGER,
  place         CHAR(300),
  date_begin    DATE,
  date_end      DATE,
  id_country    INTEGER DEFAULT 643,
  id_vid        INTEGER
);
CREATE TABLE continents
(
  id         SERIAL PRIMARY KEY NOT NULL,
  name       CHAR(10)           NOT NULL,
  name_short CHAR(3)            NOT NULL
);
CREATE TABLE countries
(
  id           SERIAL PRIMARY KEY NOT NULL,
  name_eng     CHAR(100)          NOT NULL,
  name         CHAR(100)          NOT NULL,
  alpha2       CHAR(2),
  name_short   CHAR(3),
  continent_id INTEGER
);
CREATE TABLE participant
(
  id         SERIAL PRIMARY KEY NOT NULL,
  name       CHAR(50)           NOT NULL,
  name_short CHAR(10)
);
CREATE TABLE people
(
  uci                BIGINT,
  federation_num     INTEGER,
  lastname_eng       CHAR(100),
  firstname_eng      CHAR(100),
  gender             BOOLEAN,
  birthdate          DATE,
  address1           CHAR(300),
  address2           CHAR(300),
  zip                CHAR(20),
  town               CHAR(100),
  country            CHAR(100),
  phone              CHAR(50),
  mobile             CHAR(50),
  email              CHAR(200),
  rider              BOOLEAN DEFAULT FALSE,
  commissaire        BOOLEAN DEFAULT FALSE,
  classifier         BOOLEAN DEFAULT FALSE,
  technical_delegate BOOLEAN DEFAULT FALSE,
  federation         BOOLEAN DEFAULT FALSE,
  team_member        BOOLEAN DEFAULT FALSE,
  other_role         BOOLEAN,
  lastname           CHAR(100),
  firstname          CHAR(100),
  patronymic         CHAR(100),
  subjects_id        SMALLINT,
  teams_id           SMALLINT,
  road               BOOLEAN,
  track              BOOLEAN,
  mb                 BOOLEAN,
  bmx                BOOLEAN,
  titles_id          SMALLINT,
  id                 BIGSERIAL PRIMARY KEY NOT NULL
);
COMMENT ON COLUMN people.gender IS '0 - мужики';
CREATE TABLE race_type
(
  id     SERIAL PRIMARY KEY NOT NULL,
  name   CHAR(50)           NOT NULL,
  id_vid INTEGER
);
CREATE TABLE races
(
  id             SERIAL PRIMARY KEY NOT NULL,
  id_race_type   INTEGER,
  id_category    INTEGER,
  place          CHAR(200),
  date_time      TIMESTAMP          NOT NULL,
  id_competition INTEGER            NOT NULL,
  coments        CHAR(300),
  distance       REAL
);
CREATE TABLE result_status
(
  id         SERIAL PRIMARY KEY NOT NULL,
  name_short CHAR(10)           NOT NULL,
  name       CHAR(50)
);
CREATE TABLE results
(
  id               SERIAL PRIMARY KEY NOT NULL,
  id_race          INTEGER            NOT NULL,
  bib              INTEGER,
  rank             INTEGER,
  id_people        BIGINT,
  fio              CHAR(100),
  id_subject       INTEGER,
  id_team          INTEGER,
  result           TIMESTAMP,
  id_result_status INTEGER,
  irm              CHAR(100),
  points           INTEGER
);
CREATE TABLE rf_fo
(
  id         SERIAL PRIMARY KEY NOT NULL,
  name_short CHAR(10)           NOT NULL,
  name       CHAR(100)
);
CREATE TABLE rf_subjects
(
  id       SERIAL PRIMARY KEY NOT NULL,
  name     CHAR(100)          NOT NULL,
  rf_fo_id SMALLINT
);
CREATE TABLE teams
(
  id           SERIAL PRIMARY KEY NOT NULL,
  name         CHAR(100)          NOT NULL,
  name_short   CHAR(10),
  countries_id INTEGER,
  format       CHAR(50)
);
CREATE TABLE teams_uci
(
  team_id INTEGER NOT NULL,
  uci_id  INTEGER NOT NULL,
  CONSTRAINT teams_uci_pkey PRIMARY KEY (uci_id, team_id)
);
CREATE TABLE titles
(
  id         SERIAL PRIMARY KEY NOT NULL,
  name_short CHAR(50)           NOT NULL,
  name       CHAR(100)
);
CREATE TABLE uci
(
  id         SERIAL PRIMARY KEY NOT NULL,
  name       CHAR(50)           NOT NULL,
  name_short CHAR(5),
  vid_id     INTEGER
);
CREATE TABLE vid
(
  id   SERIAL PRIMARY KEY NOT NULL,
  name CHAR(50)           NOT NULL
);