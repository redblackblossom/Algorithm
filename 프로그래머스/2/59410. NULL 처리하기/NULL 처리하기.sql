-- 코드를 입력하세요
SELECT  i.ANIMAL_TYPE, coalesce(i.NAME, 'No name') as NAME, i.SEX_UPON_INTAKE
from ANIMAL_INS as i 