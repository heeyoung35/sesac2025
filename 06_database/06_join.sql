# join
-- 흩어져 있는 여러개의 테이블의 데이터를 연결고리를 통해서 합쳐서 조회해 오는 것

-- 1. 컬럼 별칭
select
	menu_name as '메뉴 이름', -- as로 한글로 보고 싶을 때 사용하고 띄어 쓰기가 있는 경우 ''따옴표 사용
    menu_price price       -- 띄어 쓰기가 없거나 간단한 경우 as와 따옴표 제거 사용
from
	tbl_menu;
    
-- 2. 테이블 별칭 (join에서 필수)
-- tbl_menu 테이블에 'a' 라는 별칭을 붙여줌
-- 메뉴 이름과 메뉴 가격에도 .a를 통해서 별칭을 붙여준다. 
select
	a.menu_name,
    a.menu_price
from
	tbl_menu as a;  -- 메뉴 테이블에 a라는 별칭을 사용하겠습니다.
    
-- inner join - 교집합 (가장 기본적인 조인,  inner 키워드 생략 가능)
select
	a.menu_name,  -- 가져오는 테이블의 별칭을 a이라고 지정했기 때문에 a테이블에 메뉴 이름을 가져오겠습니다. 
    b.category_name -- 별칭이 b인 테이블에서 카테고리 이름을 가져오겠습니다. 
from
	tbl_menu a
inner join tbl_category b on a.category_code = b.category_code; 
-- b 테이블의 카테고리라고 별칭을 지어주고 a, b의 동일한 카테고리 코드의 연결고리로 일치하는 것들만 나오게 하는 것
-- 일치하는 결과 값이기 때문에 null 값이 없다. 

-- outer join (left / right)
-- 카테고리는 있지만 메뉴가 없는것

-- left join : join문을 기준으로 왼쪽 테이블의 데이터는 모두 보여주고,
            -- 오른쪽 테이블에서 짝이 맞는 데이터가 없으면 'null'로 채워서 보여준다. 
select
	a.category_name,
    b.menu_name
from
	tbl_category a -- 왼쪽 테이블
left join tbl_menu b on a.category_code = b.category_code; 
-- 왼쪽 테이블 기준으로 왼쪽 테이블의 정보는 다 보여주고 이것을 기준으로 메뉴 테이블의 메뉴 네임에서는 메뉴이름이 없는 것은 null값으로 보여준다.

-- self join (교집합이기 때문에 일차하는 것들만 가져온다)
-- 같은 테이블 안에서 행과 행의 관계가 있는 경우, 그 결 연결해서 보고 싶을 때 셀프조인을 할 수 있다. 
select
	a.category_name as '하위 카테고리',
    a.ref_category_code,
    b.category_code,
    b.category_name as '상위 카테고리'
from
	tbl_category a -- '하위'역할을 할 a 테이블
join tbl_category b on a.ref_category_code = b.category_code; 
-- 상위 역할을 할 a 테이블에서는 ref_category_code이고 동일하게 복사된 b 테이블은 category_code를 
-- 연결해서 한 줄에 상위와 하위 카테고리 이름을 같이 볼 수 있도록 한다.