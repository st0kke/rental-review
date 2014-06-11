select * from rentals.property;


select column_name, data_type, character_maximum_length, is_nullable
from INFORMATION_SCHEMA.COLUMNS where table_name = 'property';

select * from INFORMATION_SCHEMA.COLUMNS where table_name = 'property';

alter table rentals.property 
alter column property_type drop NOT NULL

select * from INFORMATION_SCHEMA.COLUMNS where table_name = 'review'
alter table rentals.review
alter column rented_to_date drop NOT NULL


alter table rentals.review
alter column rented_from_date drop NOT NULL;
alter table rentals.review
alter column date_created drop NOT NULL;