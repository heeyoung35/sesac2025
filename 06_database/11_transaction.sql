# Transaction(트렌잭션) - all or nothing 모두 성공하거나, 모두 실패해야 하는 하나의 작업 묶음
-- mysql은 기본적으로 qutocommit모드가 켜져있다. 조절하고 싶다면 설정을 바꿔주야 한다.

set autocommit = off;  -- 키는건 on

-- 지금부터 트랜잭션을 시작하겟다. (수동 커밋 모드로 전환)
-- 확정이 아니라 나에게만 보이는 상태이다. 임시작업으로 저장하지 않으면 수정되지 않는다.
-- 여러 작업이 묶여있을 때 작업 하나의 단위도 누락없이 모두 해야할 때 트랜잭션을 이용하면 용이하다. 
-- 예를 들어 계좌이체나 장바구니 결제의 비지니스 로직에 유용하다. 
start transaction;

select * from tbl_menu;

-- 임시 작업
insert into tbl_menu values(null, '바나나해장국', 8500, 4, 'Y'); 
update tbl_menu set menu_name = '수정된 메뉴' where menu_code = 5;
delete from tbl_menu where  menu_code = 7;

-- start transaction 시점 이후에 수행했던 모드 작업을 전부 취소하고 트랜잭션 시잔 전의 상태로 되돌림
rollback;

-- 작업이 올바르다고 판단되면 최종 저장을 명령한다. 이 때는 rollback이 적용되지 않는다. 
commit;
select * from tbl_menu;