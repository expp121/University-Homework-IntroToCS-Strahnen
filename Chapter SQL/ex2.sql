 --Write these queries in SQL
 --(a)List of cars
 select * from CAR

 --(b)List of chauffeurs
 select Unique PERSON.PNo, PERSON.FirstName, PERSON.Name, Plate, Make, Type from CAR, PERSON