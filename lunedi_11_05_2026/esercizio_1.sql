-- 1
select
  *
from
  clienti
where
  email like "%google%";

-- 2
select
  *
from
  clienti
where
  email like "%shinystat.com"
order by
  nome asc;

-- 3
select
  *
from
  clienti
where
  nome like "A%";

-- 4
SELECT
  *
FROM
  Clienti
WHERE
  CHAR_LENGTH(cognome) = 5;
-- oppure solo LENGHT il quale conta i byte

-- 4 bis
SELECT
  *
FROM
  Clienti
WHERE
  cognome like "_____%";

-- 5 
select
  *
from
  clienti
where
  eta between 30 and 40;

-- 6
select
  *
from
  clienti
where
  citta like "%pertunmaa%";