DROP TABLE IF EXISTS vessel;
CREATE SEQUENCE vessel_seq;
CREATE TABLE vessel (
  id int NOT NULL DEFAULT NEXTVAL ('vessel_seq'),
  name varchar(64) UNIQUE NOT NULL,
  vessel_type varchar(64) DEFAULT NULL,
  engine_type varchar(45) DEFAULT NULL,
  engine_power varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS position;
CREATE SEQUENCE position_seq;
CREATE TABLE position (
  id int NOT NULL DEFAULT NEXTVAL ('position_seq'),
  name varchar(128) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS vacancy;

CREATE SEQUENCE vacancy_seq;
CREATE TABLE vacancy (
  id int NOT NULL DEFAULT NEXTVAL ('vacancy_seq'),
  status boolean DEFAULT false,
  position_id int DEFAULT NULL,
  vessel_id int DEFAULT NULL,
  duration_of_contract int DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_VESSEL
  FOREIGN KEY (vessel_id) 
  REFERENCES vessel (id) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT FK_POSITION 
  FOREIGN KEY (position_id)
  REFERENCES position (id)
	
  ON DELETE NO ACTION ON UPDATE NO ACTION
);

ALTER SEQUENCE vacancy_seq RESTART WITH 5;
ALTER SEQUENCE vessel_seq RESTART WITH 6;
ALTER SEQUENCE position_seq RESTART WITH 15;

CREATE INDEX FK_VESSEL_idx ON vacancy (vessel_id);
CREATE INDEX FK_POSITION_idx ON vacancy (position_id);

INSERT INTO vessel VALUES 
	(1,'SantaMaria','Cruiser','diesel', '1000HP'),
	(2,'Laperamida','Yacht','wind', '10HP'),
	(3,'CrazyHorse','Boat','coal', '20HP'),
	(4,'Just for fun','kayak','oars', '5HP'),
	(5,'SantaLucia','Cruiser','diesel', '1500HP');


INSERT INTO position VALUES 
	(11,'sailor'),
	(12,'mechanic'),
	(13,'locman'),
	(14,'cook');

INSERT INTO vacancy VALUES 
	(1, false, 12, 3, 365),
	(2, true, 11, 1, 365),
	(3, false, 14, 4, 60);



 