create schema rentals

CREATE TABLE property (id numeric NOT NULL, property_type character varying(10) NOT NULL,address_line1 character varying(50),address_line2 character varying(50),address_line3 character varying(50),address_line4 character varying(50),postcode character varying(10) NOT NULL,date_created timestamp,active boolean NOT NULL,CONSTRAINT property_pkey PRIMARY KEY (id))

CREATE TABLE review (id integer NOT NULL, property_id numeric NOT NULL, rented_from_date date, rented_to_date date, rating smallint NOT NULL, comment character varying(1000) NOT NULL,date_created timestamp, active boolean NOT NULL,CONSTRAINT pk_review PRIMARY KEY (id),CONSTRAINT fk_property_id FOREIGN KEY (property_id) REFERENCES property (id) ON UPDATE NO ACTION ON DELETE NO ACTION)

CREATE SEQUENCE property_seq AS BIGINT INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1

CREATE SEQUENCE review_seq AS BIGINT INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1
  