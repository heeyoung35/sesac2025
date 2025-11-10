# WHERE
-- '조건 필터링'의 역할, 특정 조건에 맞는 레코드만을 선택하는데 사용된다.
-- 원하는 데이터를 조회해 오는 필터 특정 조건에 맞는 데이터를 조회해 올 때 조건을 필터링 할 수 있다.

-- (1) 비교 연산자 활용(=, <> , > , <= 는 비교연산자 사용)
select 
	menu_name,
    menu_price,
    orderable_status
from
	tbl_menu
where
 -- orderable_status = 'Y'; -- where절 뒤에 조건에 대한 값에 대해서 찹(true)이 되는 행(row)들만 결과에 포함되어 조회 
    orderable_status <> 'Y'; -- 비교연산자만 변경해서 Y가 아닌 것만 조회가 가능하다. 
    
select
	menu_name,
    menu_price
from
	tbl_menu
where
	menu_price < 10000;
    
-- 논리 연산자(AND, OR)를 활용하여 조건 조합
-- 카테고리가 주문가능하면서(Y), 카테고리가 10번인 메뉴 찾기(AND)
-- 연산자도 우선순위가 있다.
-- 주의 사항!! AND는 OR보다 연산 우선순위가 높다. 따라서 () 괄호를 사용해 우선순위를 명확히 해주는 것이 좋다. 
select
	menu_name,
    category_code,
    orderable_status
from
	tbl_menu
where
	orderable_status = 'y' and category_code = 10; -- 조건이 모두 참(true)인 것 조회

-- 카테고리가 주문가능하거나 카테고리가 10번인 메뉴 찾기(OR) 
 select
	menu_name,
    category_code,
    orderable_status
from
	tbl_menu
where
	orderable_status = 'y' or category_code = 10; -- 조건이 하나라도 참(true)인 것 조회
    
-- 우선순위 (AND > OR )
select 1 or 0 and 0; -- 0인 false가 먼저 연산이 되기 때문에 false의 결과값이 나오고 1과 false가 연산되기 때문에 true가 출력된다.
select (1 or 0) and 0; -- tuue 먼저 출력되고 이후 false alter

-- 가격이 만원 이상이고, 2만 5천원 이하인 메뉴 찾기
select
	menu_name,
	menu_price
from
	tbl_menu
where
	menu_price >= 10000 and menu_price <= 25000;

-- between (사이 값을 구하고자 할 때)
select
	menu_name,
	menu_price
from
	tbl_menu
where
	menu_price between 10000 and 25000; -- 10000원 이상 25000원 이하

-- not between
select
	menu_name,
	menu_price
from
	tbl_menu
where
	menu_price not between 10000 and 25000; -- 10000원 이상 25000이하를 제외한 나머지 데이터를 출력할 때 
    
-- like 연산자 (메뉴 이름에 '마늘'이 포함된 것을 찾고 싶을 때 사용)
select
	 menu_name
from
	tbl_menu
where
	menu_name like '%마늘%'; 
    -- %는 0개 이상의 모든 문자를 의미하는 와일드 카드 메유 이름 중에 중간에 마눌이 붙은 것을 모두 찾아오겠습니다. 
    -- like '마늘%' 이면 마늘로 시작하는 모든 메뉴, like '%마늘' 이면 마늘로 끝나는 모든 메뉴를 의미한다. 
--  not like 연산자
select
	 menu_name
from
	tbl_menu
where
	menu_name not like '%마늘%'; -- 부정은 not like

-- in 연산자
-- 카테고리 코드가 4번 이거나, 5번 이거나, 6번인 메뉴 찾기
select
	menu_name,
    category_code
from
	tbl_menu
where
	category_code in (4, 5, 6); -- 카테고리 코드가 4, 5, 6번이 있는 카테고리 코드를 찾아온다. 
    
-- not in 연산자
select
	menu_name,
    category_code
from
	tbl_menu
where
	category_code not in (4, 5, 6); -- not in으로 4,5,6을 제외한 카테고리 코드 검색
    
-- is null 연산자
select
	category_code,
    category_name,
    ref_category_code
from
	tbl_category
where
 -- ref_category_code = null; -- null 값 비교에는 = 를 사용할 수 없다. 
    ref_category_code is null;
    
-- is not null 연산자
select
	category_code,
    category_name,
    ref_category_code
from
	tbl_category
where
    ref_category_code is not null; -- null이 아닌 것을 찾아올 때


