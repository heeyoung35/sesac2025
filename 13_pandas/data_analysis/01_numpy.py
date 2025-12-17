import numpy as np

# Numpy: 파이썬에서 숫자 데이터(배열)을 빠르고 편하게 다루기 위한 라이브러리

# python 리스트
prices_list = [1000,2000,3000]
# prices_list + 100
# list는 사람이 보기에는 편하다. 하지만 데이터에는 시간이 많이 걸려서 사용하지 않는다.
new_list = [price + 100 for price in prices_list]
print(new_list)

# Numpy 배열
# 리스트처럼 보이지만 C언어로 되어 백터화되어 있다.
prices_array = np.array([1000,2000,3000])
new_prices = prices_array + 100  # for문 없이 모든 에디어테 100원을 더함 -> 백터화
print(f"오른 가격: {new_prices}")

# Shape (데이터 모양)
data = np.array([
    [1,2,3,],
    [4,5,6]
])

print(data.shape) # (2,3) -> 2행 3열
print(data.dtype)

# LLM과의 연결고리 (임베딩)
embedding_vector = np.random.rand(5)   # 0~1 사이의 실수 5개
print(f"임베딩 벡터 예시: {embedding_vector}")