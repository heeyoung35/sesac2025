-- 2-1번 문제
select
	emp_id,
    emp_name,
    phone,
    hire_date,
    ent_yn
from
	employee
where
	ENT_YN = 'N'
    and phone like '%2'
order by
	HIRE_DATE desc
limit 3;

-- 2-2번 문제
select
	a.emp_name,
    b.job_name,
    a.salary,
    a.emp_id,
    a.email,
    a.phone,
    a.hire_date
from
	employee as a
join job b on a.JOB_CODE = b.JOB_CODE
where
	b.JOB_NAME = '대리'
    and	ENT_YN = 'N'
order by
	SALARY desc;

	

    
	
