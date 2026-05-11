-- 1 INNER JOIN + WHERE + LIKE
-- Visualizzare l’elenco dei libri venduti in almeno un negozio, mostrando: titolo del libro, autore, data_vendita, negozio.
-- Includere solo i libri il cui autore contiene la stringa “King” (indipendentemente da maiuscole/minuscole). 
select
  libri.titolo,
  libri.autore,
  vendite.data_vendita,
  vendite.negozio
from
  libri
  join vendite on vendite.id_libro = libri.id
where
  libri.titolo like "%king%"
order by
  libri.titolo;

-- 2  LEFT JOIN + WHERE + BETWEEN
-- Visualizzare tutti i libri, anche quelli che non hanno ancora vendite registrate, mostrando per ciascuno: titolo, anno_pubblicazione, prezzo, data_vendita (se presente).
-- Filtrare i risultati per anno_pubblicazione compreso tra 2000 e 2010.
select
  libri.titolo,
  libri.anno_pubblicazione,
  libri.prezzo,
  vendite.data_vendita
from
  libri
  left join vendite on vendite.id_libro = libri.id
where
  libri.anno_pubblicazione between 2000 and 2010;

-- 3  INNER JOIN + WHERE + IN
-- Visualizzare i dati dei libri venduti nei negozi appartenenti a una lista specifica: ("9 Oriole Lane", "98558 Milwaukee Point", "98016 Esch Trail").
-- Mostrare titolo, negozio, quantita, prezzo totale (quantita * prezzo).
select
  libri.titolo,
  vendite.negozio,
  vendite.quantita,
  vendite.quantita * libri.prezzo as prezzo_totale
from
  libri
  join vendite on vendite.id_libro = libri.id
where
  vendite.negozio in (
    "9 Oriole Lane",
    "98558 Milwaukee Point",
    "98016 Esch Trail"
  );

-- 4 RIGHT JOIN + WHERE + LIKE + BETWEEN
-- Mostrare tutti i record di vendita, anche quelli che fanno riferimento a libri non più presenti nella tabella Libri (caso anomalo).
-- Mostrare: titolo (se esiste), data_vendita, prezzo, quantita.
-- Includere solo le vendite: avvenute tra il 2020-01-01 e il 2022-12-31 presso negozi il cui nome contiene la parola “Drive” (case-insensitive).
select
  libri.titolo,
  vendite.data_vendita,
  libri.prezzo,
  vendite.quantita
from
  libri
  right join vendite on libri.id = vendite.id_libro
where
  vendite.data_vendita between '2020-01-01' and '2022-12-31'
  and vendite.negozio like "%drive%";

-- 5 INNER JOIN + WHERE combinato
-- Mostrare titolo, autore, prezzo e data_vendita dei libri: 
-- con genere IN (‘Fantasy’, ‘Horror’, ‘Drama’) (ignora i libri con >1 genere) con data_vendita dopo il 2015, 
-- venduti in negozi il cui nome contiene ‘Plaza’,
-- ordinati dal più recente al più vecchio.
select
  libri.titolo,
  libri.autore,
  libri.prezzo,
  vendite.data_vendita
from
  libri
  join vendite on libri.id = vendite.id_libro
where
  libri.genere in ('Fantasy', 'Horror', 'Drama')
  and vendite.data_vendita >= '2016-01-01'
  and vendite.negozio like "%plaza%"
order by
  libri.anno_pubblicazione desc;