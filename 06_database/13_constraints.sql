/* constraints(제약조건) */

# not null
-- null값 허용하지 않음

create table if not exists user_notnull(
	user_no int not null,
	user_id varchar(255) not null,
    user_pwd varchar(255) not null,
    gender varchar(3)
)engine = innodb;

insert into user_notnull values(1, 'user01', 'pass01', '남');

select * from user_notnull;

insert into user_notnull values(2, 'user02', null, '여'); -- error user_pwd cannot be null

# unique
-- 중복값 허용하지 않음
create table if not exists user_unique(
	user_no int not null unique,   -- unique로 회원번호는 중복될 수 없다고 선언!! 컬럼레벨
	user_id varchar(255) not null,
    user_pwd varchar(255) not null,
    gender varchar(3),
    unique (user_id)     -- id도 중복될 수 없다. (테이블 레벨로 unique선언 방식)
)engine = innodb;

insert into user_unique values(1, 'user01', 'pass01', '남');
insert into user_unique values(1, 'user02', 'pass02', '여'); -- error duplicate unique_user_no

insert into user_unique values(2, 'user01', 'pass02', '남'); -- error duplicate unique_user_id
insert into user_unique values(3, 'user03', 'pass01', '남');

select * from user_unique;

# primary key 
-- 테이블에서 한 행의 정보를 찾기 위해 사용 할 컬럼을 의미한다.
-- 테이블에 대한 식별자 역할을 한다 (한 행씩 구분하는 역할)
-- not null _ unique 제약조건의 의미 (비어있을 수 없는데 중복될 수 없다.)
-- 테이블의 많은 행 중에 하나의 행을 구별하기 위한 대표 식별자이다. 
create table if not exists user_primarykey(
	-- user_no int primary key,   -- 이 컬럼이 이 테이블의 대표 식별자다.
	user_id varchar(255) not null,
    user_pwd varchar(255) not null,
    gender varchar(3),
    primary key (user_no)    -- 테이블 레벨 설정 가능
)engine = innodb;

-- 1. null값 시도 (not null 위반)
insert into user_primarykey values(null, 'user01', 'pass01', '남'); -- error user_no cannot be null

-- 2. 중복 값 시도 (unique 위반)
insert into user_primarykey values(1, 'user01', 'pass01', '남');
insert into user_primarykey values(1, 'user02', 'pass02', '여'); -- error duplicate user_primarykey.primary

# foreign key
-- 참조된 다른 테이블에서 제공하는 값만 사용할 수 있다.
-- 두 테이블을 연결하고 관계를 맺어준다.
-- 제공되는 값 외에는 null을 사용할 수 있음.

create table if not exists user_grade (
	grade_code int primary key,
    grade_name varchar(255) not null
    ) engine=InnoDB;

insert into user_grade values (10, '일반회원'),(20, '우수회원'),(30, '특별회원');

select * from user_grade;

create table if not exists user_foreignkey1 (
	user_no int primary key,
    grade_code int,
    -- 이 테이블의 grade_code는 user_grade 테이블의 grade_code를 참조한다.
    foreign key(grade_code) references user_grade(grade_code)
    ) engine=InnoDB;
    
insert into user_foreignkey1 values(1, 10);
-- 참조 컬럼에 없는 값을 적용하면 에러 발생 
insert into user_foreignkey1 values(2, 50); -- error connot add or update a child row foreign key 
-- 독립적으로 존재하지 않기 때문에 참조하지 않는 코드를 사용할 수 없다. 데이터 일관성이 깨지는 것을 막아줄 수 있다.
-- join 한 것처럼 두 테이블의 관계를 정리할 수 있고 어떤 테이블을 참조하느냐에 따라 제약조건이 달라질 수 있다.

# on update / on delete 옵션
-- set null : 부모(user_grade)가 바뀌거나 사라지면, 해당 값을 null로 바꾼다.
-- cascade : 부모가 바뀌면 자식도 따라 바뀌고, 부모가 사라지면 자식도 함께 사라진다.

create table if not exists user_foreignkey2 (
	user_no int primary key,
    grade_code int,
    -- 이 테이블의 grade_code는 user_grade 테이블의 grade_code를 참조한다.
    foreign key(grade_code) references user_grade(grade_code)
    on update set null
    on delete set null
) engine=InnoDB;

insert into user_foreignkey2 values(1, 10), (2, 20), (3, 30);
select * from user_foreignkey2;

drop table if exists user_foreignkey1;

-- 부모 테이블의 grade_code 수정
-- 부모가 바뀌면 null값으로 바뀐다.
update user_grade
set grade_code = 40
where grade_code = 10;

# check 
-- 들어올 수 있는 값의 범위나 조건을 직접 지정
create table if not exists user_check(
	user_no int auto_increment primary key,
    user_name varchar(255) not null,
    gender varchar(3) check (gender in ('남', '여')),
    age int check (age >= 19)
)engine=innodb;

insert into user_check values(null, '홍길동', '남', 25);

select * from user_check;

-- check 제약조건 위반
insert into user_check values(null, '유관순', '여성', 22); -- error Check constraint 'user_check_chk_1' 
insert into user_check values(null, '판다', '여', 5);

# default
-- insert시 특정 컬럼에 값을 주지 않으면, 자동으로 채워질 기본값을 지정한다.
create table if not exists tbl_country(
	country_code int auto_increment primary key,
    country_name varchar(255) default '한국',
    add_day date default (current_date),
    add_time datetime default (current_time)
)engine=innodb;

insert into tbl_country values(null, default, default, default);
insert into tbl_country (country_code, country_name) values (null, '미국');

select * from tbl_country;

drop table if exists tb1_country;
