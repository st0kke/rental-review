-- Table: review

-- DROP TABLE review;

CREATE TABLE review
(
  id integer NOT NULL,
  property_id numeric NOT NULL,
  rented_from_date date NOT NULL,
  rented_to_date date,
  rating smallint NOT NULL,
  comment character varying(1000) NOT NULL,
  date_created timestamp without time zone NOT NULL,
  active boolean NOT NULL,
  CONSTRAINT pk_review PRIMARY KEY (id),
  CONSTRAINT fk_property_id FOREIGN KEY (property_id)
      REFERENCES property (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE review
  OWNER TO rentals;

-- Index: fki_property_id

-- DROP INDEX fki_property_id;

CREATE INDEX fki_property_id
  ON review
  USING btree
  (property_id);

