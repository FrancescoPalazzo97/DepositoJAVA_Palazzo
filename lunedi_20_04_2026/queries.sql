-- Esercizio 1
SELECT DISTINCT
  `Continent`,
  `Region`
FROM
  country
WHERE
  `Continent` = "Europe"
order by
  `Region` asc;

-- Esercizio 2
SELECT
  `Name`,
  `Population`,
  `CountryCode`
FROM
  city
WHERE
  `Name` like "p%"
  AND `CountryCode` = "USA"
  AND `Population` > 1000000
ORDER BY
  `Population` DESC;

-- Esercizio 3
SELECT
  `Continent`,
  count(*) AS tot_countries,
  sum(`Population`) AS tot_pop
FROM
  country
GROUP BY
  `Continent`
ORDER BY
  tot_pop DESC;

-- Esercizio 4
-- 1
select
  `categoria`,
  sum(`quantita`) as tot_quantita_vendute
from
  `Vendite`
group by
  `categoria`;

-- 2
select
  `categoria`,
  avg(`prezzo_unitario`)
from
  `Vendite`
group by
  `categoria`;

-- 3
select
  `categoria`,
  sum(`quantita`) as tot_quantita_venduta
from
  `Vendite`
group by
  `categoria`;

-- 4
select
  max(`prezzo_unitario`) as max_price,
  min(`prezzo_unitario`) as min_price
from
  `Vendite`;

-- 5
select
  count(*) as tot_rows
from
  `Vendite`;

-- 6
select
  `prodotto`,
  `prezzo_unitario`
from
  `Vendite`
order by
  `prezzo_unitario` desc
limit
  5;

-- 7 
select
  `prodotto`,
  sum(`quantita`) as tot_quantita
from
  `Vendite`
group by
  `prodotto`
order by
  tot_quantita asc
limit
  3;