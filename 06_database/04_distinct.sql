# distinct (중복 제거)
-- 중복된 값을 제거하고 유니크한(고유한)값들의 목록만 보고 싶을 때 사용
-- 특정 컬럼에 어떤 값들이 종류 별로 있는지 확인 할 때 유용

select 
	category_code
from
	tbl_menu
order by
	category_code; -- 같은 카테고리 코드가 여러 개가 반복해서 나온다. 각 메뉴가 전부 어떤 카테고리인지가 아니라 고유한 값의 목록만 보고 싶을 때 사용
    
-- distinct 사용
select 
	distinct category_code
from
	tbl_menu
order by
	category_code; 

-- null  값을 포함한 열의 distinct
 select
	distinct ref_category_code
from
	tbl_category; -- distinct는 null도 코드로 인식한다.

-- 열이 여러 개인 distinct (지정된 모드 열의 조합이 똑같을 때만 중복으로 간주하여 제거한다.) 
-- 두개의 열을 묶음으로 보고 중복을 제거한다.
-- select 뒤에 distinct 사용
select distinct
	category_code,
    orderable_status
from
	tbl_menu;
