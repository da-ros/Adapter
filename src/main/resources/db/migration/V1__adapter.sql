CREATE SCHEMA IF NOT EXISTS adapter
    AUTHORIZATION pds;

CREATE TABLE IF NOT EXISTS adapter.dispositivo_celsius
(
 id smallserial PRIMARY KEY,
 valor smallint,
 localidad character varying(20) COLLATE pg_catalog."default"
);

CREATE TABLE IF NOT EXISTS adapter.dispositivo_fahrenheit
(
 id smallserial PRIMARY KEY,
 temperatura smallint,
 bloque character varying(20) COLLATE pg_catalog."default"
);