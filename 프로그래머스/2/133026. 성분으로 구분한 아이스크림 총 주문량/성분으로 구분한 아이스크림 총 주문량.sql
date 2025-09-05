-- 코드를 입력하세요
SELECT i.INGREDIENT_TYPE, sum(f.TOTAL_ORDER) as TOTAL_ORDER
from FIRST_HALF as f
join ICECREAM_INFO as i
on f.FLAVOR = i.FLAVOR
group by i.INGREDIENT_TYPE
order by sum(f.TOTAL_ORDER)