# set operators(집합 연산자)

-- union : 두 결과를 합치기(중복은 제거) 합집합과 같다. 
-- 카테고리 코드가 10번인 메뉴들과
-- 가격이 9,000원 미만인 메뉴들
select
	menu_name,
    menu_price,
    category_code
from
	tbl_menu
where
	category_code = 10
union   -- 두 결과를 합쳐줘~~(중복은 제거하고!!!) 10번 카테고리와 9000원 미만인 카테고리가 중복은 제외하고 보여준다.
select
	menu_name,
    menu_price,
    category_code
from
	tbl_menu
where
	menu_price < 9000;
    
-- union all : 두 결과를 그 냥 다 합치기 (중복 포함)
select
	menu_name,
    menu_price,
    category_code
from
	tbl_menu
where
	category_code = 10
union all  -- 두 결과를 합쳐줘~~ (중복도 포함해서!!!)  
select
	menu_name,
    menu_price,
    category_code
from
	tbl_menu
where
	menu_price < 9000;
    
-- 교집합 :inner join 또는 in을 활용해서 구현한느 것은 가능
-- 1) INNER JOIN 활용
SELECT 
    a.menu_code,
    a.menu_name,
    a.menu_price,
    a.category_code,
    a.orderable_status
FROM
    tbl_menu a
INNER JOIN (SELECT 
				menu_code,
				menu_name,
				menu_price,
				category_code,
				orderable_status
			FROM
				tbl_menu 
			WHERE
				menu_price < 9000) b on (a.menu_code = b.menu_code)  -- 파생테이블과 같은 결과고 교집합을 사용할 수 있다. 
WHERE
    a.category_code = 10;
    
-- 2) IN 연산자 활용
SELECT 
    menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
FROM
    tbl_menu
WHERE
    category_code = 10 AND
    menu_code IN (	SELECT 
						menu_code
					FROM
						tbl_menu 
					WHERE
						menu_price < 9000);

/* intersect(교집합) */
-- MySQL은 MINUS를 제공하지 않는다. 하지만 LEFT JOIN을 활용해서 구현하는 것은 가능하다.
SELECT 
    a.menu_code,
    a.menu_name,
    a.menu_price,
    a.category_code,
    a.orderable_status
FROM
    tbl_menu a
LEFT JOIN (	SELECT 
				menu_code,
				menu_name,
				menu_price,
				category_code,
				orderable_status
			FROM
				tbl_menu 
			WHERE
				menu_price < 9000) b on (a.menu_code = b.menu_code)
WHERE
    a.category_code = 10 AND
    b.menu_code IS NULL;

