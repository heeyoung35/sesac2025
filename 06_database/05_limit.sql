# limit [개수]
-- 결과중에 딱 내가 원하는 만큼만 잘라서 줘!! 라고 요청하는 키워드alter

-- limit [개수]
-- 상위 5개만 잘라줘!
select
	menu_code,
    menu_name,
    menu_price
from
	tbl_menu
order by
	menu_price desc
limit 5;

-- limit [시작 위치(건너뛸 개수)], [개수] (게시판 페이징의 핵심 원리)
-- 2번째 행부터 4개 가져오기
-- 정렬 이후에 잘라오기 때문에 order by 이후 가장 마지막에 사용
select
	menu_code,
    menu_name,
    menu_price
from
	tbl_menu
order by
	menu_price desc
limit 1, 4; -- 두번째 행부터 가져올 행의 개수