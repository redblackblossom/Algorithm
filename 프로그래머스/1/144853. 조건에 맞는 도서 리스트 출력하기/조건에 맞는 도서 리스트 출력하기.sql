-- 코드를 입력하세요
SELECT b.BOOK_ID, DATE_FORMAT( b.PUBLISHED_DATE, '%Y-%m-%d')
from BOOK as b
where b.PUBLISHED_DATE >='2021.01.01' and b.PUBLISHED_DATE <'2022.01.01' and b.CATEGORY = '인문'
order by b.PUBLISHED_DATE