-- Table: property

-- DROP TABLE property;

CREATE TABLE property
(
  id numeric NOT NULL,
  property_type character varying(10) NOT NULL,
  address_line1 character varying(50),
  address_line2 character varying(50),
  address_line3 character varying(50),
  address_line4 character varying(50),
  postcode character varying(10) NOT NULL,
  date_created timestamp without time zone,
  active boolean NOT NULL,
  CONSTRAINT property_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE property
  OWNER TO rentals;
