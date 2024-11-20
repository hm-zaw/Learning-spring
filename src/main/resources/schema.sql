DROP TABLE IF EXISTS "books"
DROP TABLE IF EXISTS "author"

CREATE TABLE "books" (
    'isbn' text NOT NULL
    'author_id' bigint
    'title' text
    CONSTRAINT 'books_pkey' PRIMARY KEY('isbn')
    CONSTRAINT 'books_fkey' FOREIGN KEY('author_id')
    REFERENCES authors('id')
)

CREATE TABLE "authors" (
    'id' bigint DEFAULT nextval('authors_id_seq') NOT NULL
    'age' integer
    'name' text
    CONSTRAINT 'authors_pkey' PRIMARY KEY('id')
)