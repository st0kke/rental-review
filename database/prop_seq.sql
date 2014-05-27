-- Sequence: property_seq

-- DROP SEQUENCE property_seq;

CREATE SEQUENCE property_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 4
  CACHE 1;
ALTER TABLE property_seq
  OWNER TO rentals;
