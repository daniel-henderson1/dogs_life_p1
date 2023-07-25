CREATE table owners
    (ownerID int auto_increment PRIMARY KEY, ownerName varchar(50))
;

CREATE table dogs
    (dogID int auto_increment PRIMARY KEY, dogName varchar(50), dogAge int, ownerID int, FOREIGN KEY(ownerID) references owners(ownerID))
;