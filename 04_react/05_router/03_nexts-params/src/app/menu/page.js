'use client';
import { getMenuList } from "@/api/MenuAPI";
import MenuItem from "@/item/MenuItem";
import { useEffect, useState } from "react"
import boxStyle from"./Menu.module.css"
import { useRouter } from "next/navigation";


export default function Menu() {

    const[menuList, setMenuList] = useState([]);
    const[searchValue, setSearchValue] = useState('');

    const router = useRouter(); //next/navigation 임포트!! 페이지 이동

    useEffect(() => {
        setMenuList(getMenuList());
    }, [])

    const onChangeHandler = (e) => {
        setSearchValue(e.target.value);
    }

    const onClickHandler = () => {
        router.push(`/menu/search?menuName=${searchValue}`)  // URL을 변경해서 다른 페이지로 이동 ?이후에는 전달되는 값
    }

    return (
        <>
        <h1>메뉴 페이지 입니다.</h1>
        <div>
            <input 
            type="search"
                    name="menuName"
                    value={searchValue}
                    onChange={onChangeHandler}
                />
                {/**쿼리 스트링: 검색어로 찾아오는 방법 */}
                <button onClick={onClickHandler}>검색</button>
            
                
            
        </div>
        <div className={boxStyle.MenuBox}>
            {menuList.map(menu => <MenuItem key={menu.menuCode} menu={menu}/>)}
        </div>
        </>
    )
}