'use client'

import { getMenuByMenuCode } from "@/api/MenuAPI";
import { useParams } from "next/navigation"
import { useEffect, useState } from "react";

export default function MenuDetail() {
    // useParams: menucode에 1이라는 것을 구조분해 할당해서 가지고 온 것 pathvariable 값을 가져올 수 있다. 
    const {menuCode} = useParams(); // 동적 라우터로 메뉴 1번인지 2번인지를 menucode에 오는 위치로 useParams /menu/[menuCode]
    console.log(menuCode);

    const [menu, setMenu] = useState();

    useEffect(() => {
        setMenu(getMenuByMenuCode(menuCode))
    }, [])

    return (
        menu && 
        <>
            <h1>{menu.menuName}상세 페이지!</h1>
            <h3>메뉴가격 :{menu.menuPrice}</h3>
            <h3>메뉴종류 :{menu.categoryName}</h3>
            <h3>메뉴 설명: {menu.detail.description}</h3>
            <img src={menu.detail.image} style={{maxWidth: 500}}/>

        </>
    )
}