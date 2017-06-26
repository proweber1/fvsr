CREATE TABLE groups
(
  id SMALLINT PRIMARY KEY NOT NULL,
  name CHAR(10) NOT NULL
);

CREATE TABLE people
(
  id BIGINT PRIMARY KEY NOT NULL,
  federation_num INTEGER,
  lastname CHAR(100),
  firstname CHAR(100),
  gender BOOLEAN,
  birthdate DATE,
  address1 CHAR(300),
  address2 CHAR(300),
  zip CHAR(20),
  town CHAR(100),
  country CHAR(100),
  phone CHAR(50),
  mobile CHAR(50),
  email CHAR(200),
  rider BOOLEAN DEFAULT false,
  commissaire BOOLEAN DEFAULT false,
  classifier BOOLEAN DEFAULT false,
  technical_delegate BOOLEAN DEFAULT false,
  federation BOOLEAN DEFAULT false,
  team_member BOOLEAN DEFAULT false,
  other_role BOOLEAN,
  old_id CHAR(20),
  lastname_rus CHAR(100),
  firstname_rus CHAR(100),
  patronymic_rus CHAR(100),
  groups_id SMALLINT,
  subjects_id SMALLINT,
  teams_id SMALLINT,
  road BOOLEAN,
  track BOOLEAN,
  mb BOOLEAN,
  bmx BOOLEAN,
  titles_id SMALLINT
);
COMMENT ON COLUMN people.gender IS '0 - мужики';

CREATE TABLE rf_fo
(
  id SMALLINT PRIMARY KEY NOT NULL,
  name CHAR(10) NOT NULL
);

CREATE TABLE rf_subjects
(
  id SMALLINT PRIMARY KEY NOT NULL,
  name CHAR(100) NOT NULL,
  rf_fo_id SMALLINT
);

CREATE TABLE teams
(
  id SMALLINT PRIMARY KEY NOT NULL,
  name CHAR(100) NOT NULL
);

CREATE TABLE titles
(
  id SMALLINT PRIMARY KEY NOT NULL,
  name CHAR(100) NOT NULL
);