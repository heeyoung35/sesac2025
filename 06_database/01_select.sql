# SELECT 
-- select 컬럼명 from 테이블 명;
-- 특정 테이블에서 원하는 데이터를 조회하는데 사용
-- select는 내가 무엇을 보여주고 싶은지 form은 내가 어디서 가지고 올지를 결정
-- ;는 문장의 끝을 의미한다. 여러 정보는 ,로 구분

-- 단일 열(컬럼) 데이터 검색 menudb가 선택되어 있는 상태에서 조회해 올것인데 그중에서 메뉴 이름을 조회해 오겠다.
select menu_name from tbl_menu;   -- 단일열 검색

-- 여러 열의 데이터 검색
select 
	menu_code,
    menu_name,
    menu_price
from
	tbl_menu;

-- 모든 열에서 데이터 검색 *와일드 카드 문자로 편리하게 모든 컬럼을 조회
-- (* : 모든 컬럼을 의미하는 와일드 카드)
select
	*
from
	tbl_menu;
    
-- from절 없이 단순 테스트를 위해 사용 할 수 있다.
-- 간단한 영산
select 6+3;
select 6*3;

-- 내장 함수를 사용
select now();  -- 현재 날짜와 시간을 보여준다. 
select concat('홍' , '길동'); -- 여러 문자열을 합쳐준다.

-- 컬럼 별칭 (Alias) 사용
select concat('홍' , '길동') as name;  -- 컬럼이 작성한 대로가 아니라 컬럼명이 무엇인지 지정한 별칭으로 사용가능한 것이 as이다. 
