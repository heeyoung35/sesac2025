# 문자열 핵심 기능
# 슬라이싱: 문자열의 일부를 잘라낸다. [시작인덱스:끝인덱스]
# 끝 인덱스는 포함되지 않는다.

txt = "helloworld"
print(f"슬라이싱[0:5]: {txt[:5]}")   # 0번째부터 5인덱스까지 잘라오겠다는 뜻이다. 시작을 생략하면 처음부터
print(txt[5:])                     # 끝을 생략하면 끝까지 5번째 인덱스부터 끝까지 잘라오겠다.
print(txt[:])                      # 처음부터 끝까지
print(txt[::-1])                   # step를 음수 -1로 주면 뒤에서부터 가져온다.

# .split() : 긴 텍스트를 문장 단위로 나누거나, CSV 데이터를 콤마(,)기준으로 나눌 때 많이 사용
# 문자열을 특정 기준으로 나눠 리스트로 만든다.
csv_data = "홍길동,20,서울"
user_list = csv_data.split(',')
print(f"split 결과 : {user_list}, 이름: {user_list[0]}")

# 제어문 : if, for
score = 85

# 파이썬은 중괄호 대신 들여쓰기로 코드 불록을 구분한다.
# if문이나 for문 선언 끝에 콜론(:)을 찍고, 그 다음줄에 들여쓰기 된 부분 전체가 하난의 코드 블럭으로 인식된다.
# 중괄호가 아닌 들여쓰기로 하나의 코드블럭으로 인식된다. 조건에 따라서 코드블럭이 실행된다.
if score >= 90:
    grade = 'A'
elif score >= 80:
    grade = 'B'
else:
    grade = 'F'
print(f"점수 : {score}, 등급: {grade}")

foods = ['햄버거', '피자', '보쌈']
for food in foods:
    print(f"오늘의 메뉴: {food}")

# 키와 벨류에 따라 어떤 메소드를 실행할지 달라진다.
user_info = {'name': '판다', 'age': '5'}
# .keys() : key값을 가져온다.
# .values() : value 값을 가져온다.
# .items() : key와 value를 한 쌍으로 가져온다.
for key, value in user_info.items():
    print(f"- {key}: {value}")


