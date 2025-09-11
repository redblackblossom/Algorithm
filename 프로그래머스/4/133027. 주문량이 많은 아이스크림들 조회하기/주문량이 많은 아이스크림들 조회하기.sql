-- 코드를 입력하세요
WITH jj AS(
select j.FLAVOR, sum(j.TOTAL_ORDER) as TOTAL_ORDER
from JULY as j
group by j.FLAVOR
)

select f.FLAVOR
from FIRST_HALF as f
join jj
on f.FLAVOR = jj.FLAVOR
order by jj.TOTAL_ORDER + f.TOTAL_ORDER desc
limit 3
