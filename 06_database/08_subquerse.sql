# subquerise(서브쿼리)
-- 실무에서는 하나의 질문에 답하기 위해서 다른 질문을 해야하는 경우가 있다.
-- 예를 들어 민트미역국이 몇번 카테고리인지 모르는데 민트 미역국과 같은 카테고리를 보여주고 싶을 때 
-- 두가지의 쿼리를 작성해야 한다. 그래서 서브쿼리를 사용한다. 쿼리 안에 select문이 포함된다.

-- 1단계 (서브쿼리)
-- 민트미역국의 카테고리 코드를 알아낸다.
select
	category_code
from
	tbl_menu
where
	menu_name = '민트미역국';
    
-- 2단계 (메인쿼리)
-- '민트미역국' 같은 카테고리의 메뉴 조회
select
	menu_name,
	category_code
from
	tbl_menu
where
	category_code = (select
						category_code
					from
						tbl_menu
					where
						menu_name = '민트미역국'); 
                        -- 괄로안을 먼저 데이터를 가져오기 때문에 4카테고리 코드를 조회 한 후 동일한 카테고리를 조회
                        
-- from 절에 서브쿼리 사용
-- 즉석에서 만들어 쓰는 임시 테이블처럼 동작 -> 파생 테이블 이라고도 부른다.
-- 가장 많은 메뉴가 포함된 카테고리는 메뉴를 총 몇개 가지고 있나요?

-- 1단계 : 카테고리 별로 메뉴가 몇 개씩 있는지?
-- 서브쿼리 
select
	count(*) as 'count'
from
	tbl_menu
group by
	category_code;
    
-- 2단계 : 가장 많은 메뉴가 포함된 카테고리의 메뉴 수
select
	max(count) as '최대 메뉴수' -- from에서 가져온 카운트 테이블에서 가장 큰 값을 구해오다.
from
	(select
		count(*) as 'count'
	from
		tbl_menu
	group by
		category_code) as count_table; -- 파생 테이블(임시 테이블을 만들어서 사용할 수 있다)은 반드시 별칭이 있어야 한다.  

-- 상관 서브쿼리(심화)
-- 카테고리별 평균 가격보다 높은 가격의 메뉴 조회
-- 원래는 서브쿼리가 먼저 실행되고 이것을 가지고 메인 쿼리가 조회되는데 상관 서브쿼리는 영향을 준다. 
-- 4번 카테고리의 평균을 가지고 오면 4번보다 높은 것은 구할 수 있지만 모든 카테고리에는 해당되지 않는다.
-- 일반 서브쿼리는 메인 쿼리가 실행 되기 전에 단 한번만 실행되어 메인 쿼리에게 이 값을 사용해라고 전달하는 방식
-- 상관 서브쿼리는 메인 쿼리의 값을 참조해서 메인 쿼리가 한 행을 처리할 때마다. 그 행의 값을 받아 서브쿼리가 매번 다시 실행된다. 
select
	avg(menu_price)
from
	tbl_menu
where
	category_code = 4;

select
	menu_code,
    menu_name,
    menu_price
from
	tbl_menu a
where
	menu_price > (select       -- 구한 평균의 값을 비교해서 true일 때 
					   avg(menu_price)   -- 참조한 카테고리 코드의 평균을 구하고 
				  from
						tbl_menu
				  where
						category_code = a.category_code); -- 메인 쿼리의 카테고리 코드를 참조해서 
        