
CREATE SEQUENCE public.person_seq;

CREATE TABLE IF NOT EXISTS public.person (
    id int NOT NULL DEFAULT NEXTVAL ('person_seq'),
    first_name character varying(80) NOT NULL,
    last_name character varying(80) NOT NULL,
    address character varying(100) NOT NULL,
    gender character varying(6) NOT NULL,
    PRIMARY KEY(id)
);
