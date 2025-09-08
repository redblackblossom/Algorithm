-- 코드를 작성해주세요
select i.ITEM_ID, i.ITEM_NAME
from ITEM_INFO as i
join ITEM_TREE as t
on t.ITEM_ID = i.ITEM_ID
where t.PARENT_ITEM_ID is null
order by i.ITEM_ID