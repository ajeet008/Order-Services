create table orders(
   order_id INT NOT NULL AUTO_INCREMENT,
   price double ,
   quantity double,
   user_id varchar(40),
   order_type VARCHAR(40),
   PRIMARY KEY ( order_id ),
  
);
