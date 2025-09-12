select  r.FOOD_TYPE, r.REST_ID, r.REST_NAME, r.FAVORITES
from REST_INFO as r
where r.FAVORITES = (
    select max(rr.FAVORITES)
    from REST_INFO as rr
    where r.FOOD_TYPE = rr.FOOD_TYPE
)
order by r.FOOD_TYPE desc