-- 1 Elenca i clienti attivi, cioè quelli che hanno effettuato almeno un ordine, mostrando per ciascuno: nome, tot ordini e somma tot importi spesi
select distinct
  (clienti2.nome),
  sum(ordini.importo),
  count(ordini.id)
from
  clienti2
  join ordini on clienti2.id = ordini.id_cliente
group by
  clienti2.nome
order by
  clienti2.nome asc;

-- 2 Elenca i clienti inattivi, cioè quelli che non hanno mai effettuato ordini, mostando solo: Nome e città
select
  clienti2.nome,
  clienti2.citta
from
  clienti2
  left join ordini on clienti2.id = ordini.id_cliente
where
  ordini.importo is null
order by
  clienti2.nome asc;

-- 3 Individua gli ordini orfani, cioè ordini presenti in tabella ma senza un cliente valido associato e mostra: id ordine, data ordine, importo e cliente = null
select
  ordini.id,
  ordini.data_ordine,
  ordini.importo,
  null as cliente
from
  clienti2
  right join ordini on clienti2.id = ordini.id_cliente
where
  clienti2.id is null
order by
  ordini.importo;
