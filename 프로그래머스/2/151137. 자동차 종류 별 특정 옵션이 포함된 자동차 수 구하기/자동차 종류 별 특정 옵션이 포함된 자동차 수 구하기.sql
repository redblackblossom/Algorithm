-- 코드를 입력하세요
SELECT 
c.CAR_TYPE,
count(*) as CARS
from CAR_RENTAL_COMPANY_CAR as c
where c.OPTIONS like '%열선시트%' or c.OPTIONS like '%통풍시트%' or c.OPTIONS like '%가죽시트%'
group by CAR_TYPE
order by CAR_TYPE
