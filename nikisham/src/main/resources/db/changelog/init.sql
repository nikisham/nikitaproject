CREATE SEQUENCE buy_id_seq;

CREATE TABLE IF NOT EXISTS public.buy
(
    id_      INTEGER PRIMARY KEY NOT NULL DEFAULT nextval('buy_id_seq'),
    name_    VARCHAR NOT NULL,
    price    VARCHAR,
    date_    VARCHAR,
    lot      VARCHAR,
    number_  INTEGER,
    volume   VARCHAR
);

;;
