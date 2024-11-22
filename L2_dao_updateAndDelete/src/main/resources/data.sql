INSERT INTO authors (id, age, name)
VALUES (nextval('authors_id_seq'), 45, 'J.K. Rowling');

INSERT INTO books (isbn, author_id, title)
VALUES ('9780747532743', currval('authors_id_seq'), 'Harry Potter');