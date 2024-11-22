DROP TABLE IF EXISTS "books";
DROP TABLE IF EXISTS "authors";

DROP SEQUENCE IF EXISTS author_id_seq;
CREATE SEQUENCE author_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "authors" (
                           "id" bigint DEFAULT nextval('author_id_seq') NOT NULL,
                           "name" text,
                           "age" int,
                           CONSTRAINT "authors_pkey" PRIMARY KEY ("id")
);

CREATE TABLE "books" (
    "isbn" text NOT NULL,
    "title" text,
    "author_id" bigint,
    CONSTRAINT "books_pkey" PRIMARY KEY ("isbn"),
    CONSTRAINT "books_fkey" FOREIGN KEY ("author_id")
                     REFERENCES authors("id")
);