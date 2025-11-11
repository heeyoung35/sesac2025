/* DML (Data Manipulation Language)*/

-- insert, update, delete, select(DQL)

# insert
-- 새로운 행을 추가하는 구문이다. (테이블의 행의 수가 증가한다.)

-- 테이블의 컬럼 순서에 맞춰 모든 값을 순서대로 제공
insert into tbl_menu values(null, '바나나해장국', 8500, 4, 'Y'); 
-- primary key이고 auto increment이기 때문에 null 값으로 지정하면 자동으로 다음숫자가 들어간다.

-- insert 하고 싶은 데이터 컬럼을 지정해서 insert 가능하다.
-- 테이블 이름 뒤에 값을 넣을 컬럼들을 내가 명시하면 테이블의 순서는 중요하지 않다. 
insert into tbl_menu(menu_name, menu_price, category_code, orderable_status) -- 여기에 값을 넣을 것이기 때문에 values에 값을 담아주면 된다.
values ('초콜릿죽', 6500, 7, 'Y');

-- 한번에 여러 행 추가하기
insert into 
	tbl_menu
values
	(null, '참치맛아이스크림', 1700, 12, 'Y'),
    (null, '멸치맛아이스크림', 1500, 11, 'Y'),
    (null, '소시지맛커피', 2500, 8, 'Y');

select * from tbl_menu;

# update
-- 테이블에 이미 존재하는 행의 컬럼의 삾을 수정하는 구문이다. 
-- 가장 중요한 것은 어느행에 대해서 컬럼의 값을 수정할것인지 where절에 지정해야 한다.
-- 그래서 실무에서는 select문으로 확인 후 수정한다.

-- 1단계: 내가 바꾸려는 대상이 맞는지 select로 확인
select
	menu_code,
    category_code
from
	tbl_menu
where
	menu_name ='바나나해장국';
    
-- 2단계 : 확인된 대상을 where 절에 넣고 update 실행!
update tbl_menu
set
	category_code = 7  -- 바꿀내용 
where
	menu_code = 22;  -- 메뉴코드가 22번을 바꾸겠습니다. 바꿀 대상을 where절로 지정해주지 않으면 모든 메뉴코드가 7번으로 바뀌게 된다.

# delete
-- 테이블에서 특정 행을 삭제하는 구문이다.

-- 1단계 : 삭제할 대상 확인!
select * from tbl_menu	where menu_code = 22;

-- 2단계 : 확인된 대상을 where 절에 넣고 delete 실행!!
delete
from
	tbl_menu
where
	menu_code = 22;  -- where절이 빠지면 모든 행을 삭제하게 된다.

# replace
-- insert시 primary key(행을 나타내는 고유한 키) 또는 unique key(고유한 값)가 충돌이 발생할 수 있다면 (중복될 수 없는 고유한 키)
-- replace를 통해 중복 된 데이터를 덮어 쓸 수 있다. 

insert into tbl_menu values(17, '참기름소주', 5000, 10, 'Y'); -- Error Code:'17' for key 'tbl_menu.PRIMARY'

replace 	



    