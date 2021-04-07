 --Write these queries in SQL
 --(a)List of cars
 select * from CAR

 --(b)List of chauffeurs
 select distinct * from PERSON
 
 --(c)List of segments with distance
 select *, (KmFinish-KmStart)'Distance(km)' from SEGMENT

 --(d)List of segments with distance in miles (1mile = 1.609 km) 
  select *, ((KmFinish-KmStart)/1.609)'Distance(mile)' from SEGMENT

--(e)List of administrators not living in „Böblingen
select * from PERSON where PERSON.Role = 'A' and PERSON.Residence != 'Böblingen'

--(f)List of cars licensed in Stuttgart
select * from CAR where CAR.Plate like 'S_%'

--(g)List of segments with a distance between 1000 and 2000 km
select *, (KmFinish-KmStart)'Distance(km)' from SEGMENT where (KmFinish - KmStart) >= 1000 and (KmFinish - KmStart) <= 2000	

--(h)List of segments traversed by Mercecdes-Benz cars
select distinct SEGMENT.*, CAR.Make from SEGMENT, CAR where CAR.Make = 'Mercedes-Benz'


--(i)Which person (PNo) has never used a car?
select distinct PERSON.PNo, (RTRIM(FirstName) + ' ' + RTRIM(Name))Name, Role from PERSON where PERSON.PNo not in (select PNo from SEGMENTPERSON)

--(j) List of residences in descending order
select Residence from PERSON ORDER BY Residence desc
