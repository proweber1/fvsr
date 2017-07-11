CREATE TABLE people
(
  uci                BIGINT NOT NULL
    CONSTRAINT pk_people
    PRIMARY KEY,
  federation_num     INTEGER,
  lastname_eng       VARCHAR(100),
  firstname_eng      VARCHAR(100),
  gender             BOOLEAN,
  birthdate          DATE,
  address1           VARCHAR(300),
  address2           VARCHAR(300),
  zip                VARCHAR(20),
  town               VARCHAR(100),
  country            VARCHAR(100),
  phone              VARCHAR(50),
  mobile             VARCHAR(50),
  email              VARCHAR(200),
  rider              BOOLEAN DEFAULT FALSE,
  commissaire        BOOLEAN DEFAULT FALSE,
  classifier         BOOLEAN DEFAULT FALSE,
  technical_delegate BOOLEAN DEFAULT FALSE,
  federation         BOOLEAN DEFAULT FALSE,
  team_member        BOOLEAN DEFAULT FALSE,
  other_role         BOOLEAN,
  lastname           VARCHAR(100),
  firstname          VARCHAR(100),
  patronymic         VARCHAR(100),
  subjects_id        SMALLINT,
  teams_id           SMALLINT,
  road               BOOLEAN,
  track              BOOLEAN,
  mb                 BOOLEAN,
  bmx                BOOLEAN,
  titles_id          SMALLINT,
  id                 BIGSERIAL NOT NULL
);

COMMENT ON COLUMN people.gender IS '0 - мужики';

CREATE TABLE rf_subjects
(
  id       SERIAL  NOT NULL
    CONSTRAINT rf_subjects_pkey
    PRIMARY KEY,
  name     VARCHAR(100) NOT NULL,
  rf_fo_id SMALLINT
);

CREATE TABLE rf_fo
(
  id         SERIAL NOT NULL
    CONSTRAINT rf_fo_pkey
    PRIMARY KEY,
  name_short VARCHAR(10) NOT NULL,
  name       VARCHAR(100)
);

CREATE TABLE teams
(
  id         SERIAL  NOT NULL
    CONSTRAINT teams_pkey
    PRIMARY KEY,
  name       VARCHAR(100) NOT NULL,
  name_short VARCHAR(10),
  format     VARCHAR(50),
  country3   VARCHAR(3)
);

CREATE TABLE titles
(
  id         SERIAL NOT NULL
    CONSTRAINT titles_pkey
    PRIMARY KEY,
  name_short VARCHAR(50) NOT NULL,
  name       VARCHAR(100)
);

CREATE TABLE vid
(
  id        SERIAL   NOT NULL
    CONSTRAINT vid_pkey
    PRIMARY KEY,
  name      VARCHAR(50) NOT NULL,
  parent_id INTEGER
);

CREATE TABLE competitions
(
  id        SERIAL NOT NULL
    CONSTRAINT competitions_pkey
    PRIMARY KEY,
  name      VARCHAR(300),
  startdate DATE,
  enddate   DATE,
  country3  VARCHAR(3),
  country2  VARCHAR(2),
  classcode VARCHAR(10),
  vid_id    INTEGER,
  name_eng  VARCHAR(300)
);

CREATE TABLE participant
(
  id             SERIAL NOT NULL
    CONSTRAINT participant_pkey
    PRIMARY KEY,
  name           CHAR(50),
  name_short_eng CHAR(10),
  name_eng       CHAR(50)
);

CREATE TABLE countries
(
  id           SERIAL   NOT NULL
    CONSTRAINT countrys_pkey
    PRIMARY KEY,
  name_eng     VARCHAR(100) NOT NULL,
  name         VARCHAR(100) NOT NULL,
  country2     VARCHAR(2),
  country3     VARCHAR(3),
  continent_id INTEGER
);

CREATE TABLE categories
(
  id             SERIAL NOT NULL
    CONSTRAINT categories_pkey
    PRIMARY KEY,
  name           VARCHAR(200),
  name_short     VARCHAR(10),
  name_eng       VARCHAR(200),
  name_short_eng VARCHAR(10)
);

CREATE TABLE races
(
  id              SERIAL NOT NULL
    CONSTRAINT races_pkey
    PRIMARY KEY,
  place           VARCHAR(200),
  date            DATE,
  competitions_id INTEGER,
  name            VARCHAR(300),
  mandatorydate   DATE,
  participant_id  INTEGER,
  categorycode    VARCHAR(50)
);

CREATE TABLE race_type
(
  id             SERIAL NOT NULL
    CONSTRAINT race_type_pkey
    PRIMARY KEY,
  name           VARCHAR(50),
  id_vid         INTEGER,
  name_eng       VARCHAR(100),
  name_short_eng VARCHAR(7)
);

CREATE TABLE results
(
  id               SERIAL  NOT NULL
    CONSTRAINT results_pkey
    PRIMARY KEY,
  id_race          INTEGER NOT NULL,
  bib              INTEGER,
  rank             INTEGER,
  id_people        BIGINT,
  fio              VARCHAR(100),
  id_subject       INTEGER,
  id_team          INTEGER,
  result           TIMESTAMP,
  id_result_status INTEGER,
  points           INTEGER
);

CREATE TABLE result_status
(
  id             SERIAL NOT NULL
    CONSTRAINT result_status_pkey
    PRIMARY KEY,
  name_short     VARCHAR(10),
  name           VARCHAR(50),
  name_short_eng VARCHAR(3),
  name_eng       VARCHAR(50)
);

CREATE TABLE continents
(
  id             SERIAL   NOT NULL
    CONSTRAINT continents_pkey
    PRIMARY KEY,
  name           VARCHAR(10) NOT NULL,
  name_short_eng VARCHAR(3)  NOT NULL,
  name_short     VARCHAR(3)
);

CREATE TABLE uci
(
  id         SERIAL   NOT NULL
    CONSTRAINT uci_pkey
    PRIMARY KEY,
  name       VARCHAR(50) NOT NULL,
  name_short VARCHAR(5),
  vid_id     INTEGER
);

CREATE TABLE teams_uci
(
  team_id INTEGER NOT NULL,
  uci_id  INTEGER NOT NULL,
  CONSTRAINT teams_uci_pkey
  PRIMARY KEY (uci_id, team_id)
);

