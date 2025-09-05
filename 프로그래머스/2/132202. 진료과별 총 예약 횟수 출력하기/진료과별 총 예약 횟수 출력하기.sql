-- 코드를 입력하세요
SELECT a.MCDP_CD as 진료과코드, count(*) as 5월예약건수
from APPOINTMENT as a
where a.APNT_YMD >= '2022-05-01' and a.APNT_YMD < '2022-06-01'
group by a.MCDP_CD
order by count(*), a.MCDP_CD