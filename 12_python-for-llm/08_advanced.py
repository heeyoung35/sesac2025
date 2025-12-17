from typing import List, Dict, Optional, Union

# Enumerate & Zip


docs = ["공지사항.txt", "비밀문서.pdf", "이력서.docx"]
content = ["오늘은 월요일입니다.", "일급기밀...", "홍길동입니다."]

# zip() : 두 리스트를 묶어서 순회
for doc, content in zip(docs, content):
    print(f"파일: {doc} / 내용: {content}")


# enumerate(): 인덱스와 값을 동시에 꺼냄
for idx, doc in enumerate(docs):
    print(f"{idx + 1}번째 문서: {doc}")

# Type hint 심화
# Optional[int]: int일 수도 있고 None일 수도 있다.
# Union[int, str]: int일 수도 있고 str일 수도 있다.
# def search_db(query:str, limit: Optional[int] = 10) -> List[Dict[str, str]]:
def search_db(query: str, limit: int | None = 10) -> list[dict[str, str]]:
    """
    query: 검색어(필수)
    limit: 최대 결과 개수(선택, 기본값10개, None 허용) 
    return: 딕셔너리들의 리스트를 반환
    """
    # query가 빈 문자열("")이거나 None이면 False로 취급
    if not query:
        return []
    
    # 가상의 검색결과
    result = [
        {"title": "검색결과1", "snippet": "내용...."},
        {"title": "검색결과2", "snippet": "내용...."}
    ]

    # limit이 숫자 10이면 1번부터 9번 인덱스까지 자름
    # limit이 none이면 Python은 '끝까지'로 인식 -> 전체 반환(result[:])
    # 타입힌트를 통해서 None을 허용함으로 전체를 반환받을 수 있다는 것을 알 수 있다.
    return result[:limit]

data = search_db("파이선", limit=None)
print(data)