CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE IF NOT EXISTS public.buy
(
    id_      UUID PRIMARY KEY,
    name_    VARCHAR NOT NULL,
    price    VARCHAR,
    date_    VARCHAR,
    lot      VARCHAR,
    number_  INTEGER,
    volume   VARCHAR
);
CREATE TABLE IF NOT EXISTS public.TGbot
(
    chatId   INTEGER PRIMARY KEY,
    active   BOOLEAN,
    tool     VARCHAR,
    price    VARCHAR,
    lot      VARCHAR,
    volume   VARCHAR
);

;;
