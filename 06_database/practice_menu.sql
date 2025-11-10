-- 문제 1번
select
	category_code,
    category_name
from
	tbl_category
where
	ref_category_code is not null;
    
-- 문제 2번
select
	menu_name,
    menu_price
from
	tbl_menu
where
	menu_name like '%밥%' and menu_price between 20000 and 30000;

-- 문제 3번
select
	menu_code,
    menu_name,
    menu_price,
    category_code,
    orderable_status
from
	tbl_menu
where 
	menu_price < 10000  or menu_name like '%김치%'
order by
	menu_price,
    menu_name;
	
-- 문제 3번
-- 카페고리명에서 기타, 쥬스, 커피를 제외하고
-- 메뉴의 메뉴 가격이 > 13000

select
	a.menu_code,
	a.menu_name,
    a.menu_price,
    a.category_code,
    a.orderable_status
    
from
	tbl_menu as a
inner join
	tbl_category as b on a.category_code = b.category_code
where
	b.category_name not in ('기타','쥬스','커피') 
    and a.menu_price = 13000
    and a.orderable_status ='Y';
    


	
    