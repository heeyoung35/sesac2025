'use client'

import { searchMenu } from "@/api/MenuAPI";
import MenuItem from "@/item/MenuItem";
import { useSearchParams } from "next/navigation";
import { useEffect, useState } from "react";

export default function MenuSearchResult() {

    const searchParam = useSearchParams();

    const menuName = searchParam.get('menuName') // 쿼리스트링의 '키(menuName)'에 해당하는 값(value)을 가져온다. 
    console.log(menuName);

    const [menuList, setMenuList] = useState([]);

    useEffect(() => {
        setMenuList(searchMenu(menuName));
    }, []);

    return (
        <>
            <h1>검색결과!!!</h1>
            <div>
                {menuList.map(menu => <MenuItem key={menu.menuCode} menu={menu}/>)}
            </div>
        </>
    )
}