-- 1 Elenco tutti ordini-cliente
select clienti2.nome, ordini.data_ordine, ordini.importo
from clienti2
inner join ordini on clienti2.id = ordini.id_cliente
order by clienti2.nome asc;

-- 2 Elenco di tutti gli ordini e i clienti che li hanno effettuati
select clienti2.nome, ordini.data_ordine, ordini.importo
from ordini
inner join clienti2 on ordini.id_cliente = clienti2.id
order by clienti2.nome asc;

-- 3 Elenco di tutti i clienti che abbiano fatto ordini o meno
select clienti2.nome, ordini.data_ordine, ordini.importo
from clienti2
left join ordini on clienti2.id = ordini.id_cliente
order by ordini.importo asc;