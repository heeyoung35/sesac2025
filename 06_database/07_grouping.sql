# group by
-- 지정된 컬럼의 값이 같은 데이터들을 하나의 그룹으로 묶어라!
-- 그룹에 대한 조건 필터링도 가능하다.

select
	category_code
from
	tbl_menu
group by
	category_code; -- 카테고리 코드가 같은 것들끼리만 묶어준다. 그룹으로 묶어진 것이기 때문에 그룹함수 적용가능

-- 그룹 함수는 그룹으로 묶여 있어야만 사용할 수 있다. 
-- count() : 각 그룹에 속한 행의 개수를 센다.
select
	category_code,
    count(*) as '메뉴 개수'
from
	tbl_menu
group by
	category_code;
    
select
	category_code,
    -- menu_code, -- 주의 사항 : group by에 사용된 컬럼과 집계 함수만 올 수 있다. 
    sum(menu_price) as '가격 총합',
    avg(menu_price) as '가격 평균'
from
	tbl_menu
group by
	category_code;
    
-- having : 그룹에 대한 조건 필터링 (where는 그룹화 이전에 사용된다!)
-- 그룹화 하기 전에 조건에 대한 필터링은 where이고 그룹이 되어진 상태에서 필터링을 할 때는 having를 사용한다. 
select
	category_code,
    count(*) as '메뉴 개수'
from
	tbl_menu
group by
	category_code
having
	count(*) >= 3; -- 그룹화된 결과(메뉴개수)가 3개 이상인 그룹만 필터링
    
-- 작성 순서대로 작성해야 한다. from(join) -> where -> group by -> gaving -> order by

-- rollup(그룹별 집계 결과와 함께 그 그룹들의 소계와 총계를 보여줌)
-- 카테고리 별로 합계를 구하고 마지막 줄에 모든 카테고리의 가격의 합계를 보여주는 것이 with rollup이다.
select
	category_code,
    sum(menu_price)
from
	tbl_menu
group by
	category_code
with rollup;

-- 가격대별, 그 안에서 카테고리별로 그룹화 하고 rollup 적용
select
	menu_price,
    category_code,
    sum(menu_price)
from
	tbl_menu
group by
	menu_price,
    category_code
with rollup; -- 메뉴 가격의 소계와 마지막에 메뉴 가격에 대한 전체 소계가 나온다. 