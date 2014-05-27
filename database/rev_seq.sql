-- Sequence: review_seq

-- DROP SEQUENCE review_seq;

CREATE SEQUENCE review_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE review_seq
  OWNER TO rentals;
