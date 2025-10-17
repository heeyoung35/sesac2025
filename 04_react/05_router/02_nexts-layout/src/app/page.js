
import Link from "next/link"

export default function Home() {
  return (
    <>
    <h1>메인 페이지 입니다.</h1>
    <nav>
      <Link href="/">HOME</Link><br/>
      <Link href="/menu">메뉴</Link>
      <Link href="/about">소개</Link><br/>
      <Link href="/dashboard">대시보드</Link><br/>
    </nav>
    </>
  )
}
