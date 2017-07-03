create table people
(
  id_uci bigint not null
    constraint pk_people
    primary key,
  federation_num integer,
  lastname char(100),
  firstname char(100),
  gender boolean,
  birthdate date,
  address1 char(300),
  address2 char(300),
  zip char(20),
  town char(100),
  country char(100),
  phone char(50),
  mobile char(50),
  email char(200),
  rider boolean default false,
  commissaire boolean default false,
  classifier boolean default false,
  technical_delegate boolean default false,
  federation boolean default false,
  team_member boolean default false,
  other_role boolean,
  old_id_uci char(20),
  lastname_rus char(100),
  firstname_rus char(100),
  patronymic_rus char(100),
  groups_id smallint,
  subjects_id smallint,
  teams_id smallint,
  road boolean,
  track boolean,
  mb boolean,
  bmx boolean,
  titles_id smallint,
  id serial not null
)
;

comment on column people.gender is '0 - мужики'
;

create table rf_subjects
(
  id smallint not null
    constraint rf_subjects_pkey
    primary key,
  name char(100) not null,
  rf_fo_id smallint
)
;

create table rf_fo
(
  id smallint not null
    constraint rf_fo_pkey
    primary key,
  name char(10) not null
)
;

create table teams
(
  id smallint not null
    constraint teams_pkey
    primary key,
  name char(100) not null
)
;

create table groups
(
  id smallint not null
    constraint groups_pkey
    primary key,
  name char(10) not null
)
;

create table titles
(
  id smallint not null
    constraint titles_pkey
    primary key,
  name char(100) not null
)
;

create table vid
(
  id serial not null
    constraint vid_pkey
    primary key,
  name char(50) not null
)
;

create table competitions
(
  id serial not null
    constraint competitions_pkey
    primary key,
  name char(300) not null,
  id_rf_subject integer,
  place char(300),
  date_begin date,
  date_end date,
  id_country integer default 643,
  id_vid integer
)
;

create table participant
(
  id serial not null
    constraint participant_pkey
    primary key,
  name char(50) not null
)
;

create table countrys
(
  id integer not null
    constraint countrys_pkey
    primary key,
  name char(100) not null,
  name_rus char(100) not null,
  alpha2 char(2),
  alpha3 char(3)
)
;

create table categories
(
  id serial not null
    constraint categories_pkey
    primary key,
  name char(200)
)
;

create table races
(
  id serial not null
    constraint races_pkey
    primary key,
  id_race_type integer,
  id_category integer,
  place char(200),
  date_time timestamp not null,
  distance char(200),
  id_competition integer not null
)
;

create table race_type
(
  id serial not null
    constraint race_type_pkey
    primary key,
  name char(50) not null
)
;

create table results
(
  id serial not null
    constraint results_pkey
    primary key,
  id_race integer not null,
  num integer,
  place integer,
  id_people bigint,
  fio char(100),
  id_subject integer,
  id_team integer,
  id_people_old bigint,
  time_result timestamp,
  id_result_status integer
)
;

create table result_status
(
  id serial not null
    constraint result_status_pkey
    primary key,
  name char(50) not null
)
;

