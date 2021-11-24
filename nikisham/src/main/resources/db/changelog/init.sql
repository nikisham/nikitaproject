CREATE SEQUENCE if not exists buy_id_seq;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE IF NOT EXISTS public.buy
(
    id_      uuid PRIMARY KEY NOT NULL ,
    name_    VARCHAR NOT NULL,
    price    VARCHAR,
    date_    VARCHAR,
    lot      VARCHAR,
    number_  INTEGER,
    volume   VARCHAR
);

;;
