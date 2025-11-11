/* DDL (data definition language) */
-- 테이블과 같은 데이터베이스에 대한 작업
-- 데이터 정의 언어(create, alter, drop)

# create
-- 테이블 생성을 위한 구문
/*
create table 테이블명 (
	컬럼명 데이터타입(길이) [제약조건],
    컬럼명 데이터타입(길이) [제약조건],
    .....
*/
-- if not exists (tb1이) 존재하지 않을때만 생성하기 위한 구문
create table if not exists tb1(   
	pk int primary key,
    fk int,   -- 외래키
    col1 varchar(255),
    check(col1 in ('Y', 'N'))  -- 제약조건으로 이 컬럼은 y,n만 들어갈 수 있다는 조건
)engine=InnoDB;

describe tb1;

insert into tb1 values(1, 10, 'Y');

select * from tb1;

-- auto_increment
-- insert시 primary key에 해당하는 컬럼에 자동으로 번호를 발생(중복되지 않게)시켜 저장할 수 있다. 
-- tb2 생성
create table if not exists tb2(   
	pk int auto_increment primary key,
    fk int,   -- 외래키
    col1 varchar(255),
    check(col1 in ('Y', 'N'))  -- 제약조건으로 이 컬럼은 y,n만 들어갈 수 있다는 조건
)engine=InnoDB;

describe tb2;

-- pk값에 null을 주면 자동으로 번호가 채워진다.
insert into tb2 values(null, 10, 'Y');
insert into tb2 values(null, 20, 'N');

select * from tb2;


# alter
-- 테이블에 추가/변경/수정/삭제 하는 모든 것을 alter 명령어를 사용해 적용한다.

-- tb2 테이블에 col2 정수형 컬럼 추가
alter table tb2
add col2 int not null;

describe tb2;

-- 'col2' 컬럼 삭제
alter table tb2
drop column col2;

-- 'fk' 컬럼 이름과 데이터형식, 제약조건 바꾸기
alter table tb2
change column fk change_fk int not null;

alter table tb2
drop primary key; -- Error Code:  there can be only one auto column and it must be defined as a key	

-- modify : 컬럼의 정의 변경
alter table tb2
modify pk int; -- auto column해제 후

describe tb2;

alter table tb2
drop primary key; -- primary key 해제 가능

-- 다시 제약조건(primary key) 추가
alter table tb2 add primary key(pk);

# drop
-- 테이블의 구조와 데이터를 영구적으로 삭제(되돌릴 수 없다)
create table if not exists tb3(   
	pk int auto_increment primary key,
    fk int,   -- 외래키
    col1 varchar(255),
    check(col1 in ('Y', 'N'))  -- 제약조건으로 이 컬럼은 y,n만 들어갈 수 있다는 조건
)engine=InnoDB;

-- tb3 삭제. if exists를 붙이면 테이블이 없어도 에러가 나지 않음
drop table if exists tb3;  -- 콤마를 이용하여 여러 테이블도 삭제 가능 drop table table1, table2;

# truncate
-- 테이블 내용물만 비우고 초기화하기 (구조는 남겨두고, 데이터만 깨끗하게 비우고 싶을 때 사용하면 효율적이다)
-- delete는 한줄한줄 삭제하기 때문에 비효율적이지만 
-- truncate는 모두 지우고 구조만 다시 생성하기 때문에 효율적이다.

create table if not exists tb4(   
	pk int auto_increment primary key,
    fk int,   -- 외래키
    col1 varchar(255),
    check(col1 in ('Y', 'N'))  -- 제약조건으로 이 컬럼은 y,n만 들어갈 수 있다는 조건
)engine=InnoDB;

insert into tb4 values(null, 10, 'Y'), (null, 20, 'N');

select * from tb4;

-- 테이블 초기화
truncate table tb4; -- 구조만 남아있어서 설정값은 남아있다. 

-- 다시 데이털르 넣으면 pk가 1부터 시작한다. 
insert into tb4 values(null, 10, 'Y'), (null, 20, 'N');

select * from tb4;




