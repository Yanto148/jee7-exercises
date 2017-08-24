insert into person(id, firstName, lastName, birthDate, email, street, number, postalCode, city, version) values(1, 'John', 'Doe', '1970-01-01', 'john@example.com', 'Brighton Road', '27', '1000', 'Brussels', 1);
insert into person(id, firstName, lastName, birthDate, email, street, number, postalCode, city, version) values(2, 'Jane', 'Doe', '1970-01-02', 'jane@example.com', 'Harper Lane', '8', '2845', 'London', 1);
insert into person(id, firstName, lastName, birthDate, email, street, number, postalCode, city, version) values(3, 'Tyler', 'Turner', '1983-07-15', 'tyler@example.com', 'Masonstreet', '72B', '5874', 'Winterfell', 1);
insert into person(id, firstName, lastName, birthDate, email, street, number, postalCode, city, version) values(4, 'Marcia', 'Jackson', '1975-03-28', 'marcia@example.com', 'Factory Lane', '100/7', '1578', 'Glasgow', 1);
insert into person(id, firstName, lastName, birthDate, email, street, number, postalCode, city, version) values(5, 'Allan', 'Wilson', '1964-12-28', 'allan@example.com', 'Turingstreet', '1', '2547', 'Newcastle', 1);

insert into order_client(id, price, person_id) values(1, 10, 3)
insert into order_client(id, price, person_id) values(2, 15, 2)
insert into order_client(id, price, person_id) values(3, 20, 3)
insert into order_client(id, price, person_id) values(4, 25, 4)