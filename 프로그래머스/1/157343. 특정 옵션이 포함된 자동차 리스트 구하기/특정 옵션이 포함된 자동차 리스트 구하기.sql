-- 코드를 입력하세요
SELECT * 
from CAR_RENTAL_COMPANY_CAR as c
where c.OPTIONS like '%네비게이션%'
order by c.CAR_ID DESC