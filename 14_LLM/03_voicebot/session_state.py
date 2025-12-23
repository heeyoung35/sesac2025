import streamlit as st

st.title("Session State")

st.subheader("일반 변수 Count")
count = 0

if st.button("기본 버튼"):
    count += 1

st.write(f"Count: {count}")

# ------------------------------------------ #

st.subheader("st.session_state Count")
# 초기화: 값이 없을 때만 0으로 설정
if 'count' not in st.session_state:
    st.session_state['count'] = 0

if st.button('Session State 버튼'):
    st.session_state['count'] += 1

st.write(f"Count: {st.session_state['count']}")
