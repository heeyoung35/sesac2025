# ORDER BY
-- select문의 가장 마지막에 위치하며, 결과 집합을 하나의 열로 정렬
-- 출력 순서를 보장하지 않고 출력이 되기 때문에 가져온 결과 집합에 순서를 부여
-- 오름차순과 내림차순이 존재

select
	menu_code,
    menu_name,
    menu_price
from
	tbl_menu
order by
	-- menu_price ASC;   -- menu price를 기준으로 정렬을 하되 ASC는 오름차순을 의미 하지만 생략된 것이 기본값이다. 
    menu_price;

-- 내림차순 정력
select
	menu_code,
    menu_name,
    menu_price
from
	tbl_menu
order by
	menu_price desc,  -- desc는 내림차순, 가격으로 정렬할 때 동일 가격일 때 메뉴 이름을 추가 정력하고 싶을 때 조건을 추가한다. 
    menu_name ASC;  -- 2차 기준 : 가격이 같다면, 이름 오름차순 정렬
    
-- 연산 결과로 정렬 (보통 별칭을 사용한다.)
select
	menu_code,
    menu_price,
    menu_code * manu_price as calulated_value
from
	tbl_menu
order by
	calulated_value desc; -- descs는 내림차순으로 생략 불가능
    
-- field(컬럼, 첫번째, 두번째, ...) : 컬럼 값이 목록의 몇 번째에 있는지 숫자로 알려준다. 
select field('B' , 'A', 'B', 'C');   -- 컬럼값이 목록의 몇번째인지 숫자로 알려준다. 

-- 'N'을 1tnsdnl, 'Y'를 2순위로 정렬
select
	menu_name,
    orderable_status
from
	tbl_menu
order by field(orderable_status, 'N', 'Y'); 
-- orderable_status 'N'이면 숫자로 1이고 'Y'이면 숫자로 2를 반환한다 그래서 숫자를 기준으로 오름차순 정렬가능

-- null값이 있는 칼럼에 대한 오름차순 정렬 
-- mysql에서 null은 가장 작은 값으로 취급한다. 
select
	category_code,
    category_name,
    ref_category_code
from
	tbl_category
order by
	ref_category_code is null; 
    -- is null을 통해 null이면 true를 반환해서 숫자로 1로 취급 false는 0이기 때문에 1인 true가 뒤로 가게 되어서 0이 앞에오고 뒤에 1이 오게 되어 오름차순이 된 것이다. 

-- 내람차순 시 null을 처음으로 (is null desc)
select
	category_code,
    category_name,
    ref_category_code
from
	tbl_category
order by
	ref_category_code is null desc,
    ref_category_code desc; -- null값은 가장 처음 나머지는 3,2,1 순으로 정렬

    