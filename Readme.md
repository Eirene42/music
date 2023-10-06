Album
album_id PK Serial
title TEXT
year INTEGER
rating INTEGER
artist_id INTEGER
record_company_id INTEGER

Artist
artist_id PK Serial
name Text
number_of_members INTEGER
still_performing BOOLEAN

RecordCompany
record_company_id PK Serial
name TEXT
location TEXT
email TEXT