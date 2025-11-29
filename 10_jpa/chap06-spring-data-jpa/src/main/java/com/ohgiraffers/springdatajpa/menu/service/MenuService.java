package com.ohgiraffers.springdatajpa.menu.service;

import com.ohgiraffers.springdatajpa.menu.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.menu.dto.MenuRequestDTO;
import com.ohgiraffers.springdatajpa.menu.dto.MenuResponseDTO;
import com.ohgiraffers.springdatajpa.menu.entity.Category;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.repository.CategoryRepository;
import com.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
/* 파이널 필드는 초기화를 해주어야 하는데 필수필드를 대상으로 생성자를 자동으로 만들어준다.
 lombok에 있어서 final 필드만을 파라미터로 받는 생성자를 자동으로 생성해줌*/
public class MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    /* @RequiredArgsConstructor 가 자동으로 생성해주는 구문이다.
       @Autowired
       public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
        }*/

    /* 1. 메뉴 코드로 상세 조회*/
    public MenuResponseDTO findMenuByMenuCode(int menuCode) {
        // findById가 옵셔널인 경우 널포인트 인셉션을 방지하고 만약에 값이 없으면 예외를 던지라는 것이다.
        Menu foundMenu = menuRepository.findById(menuCode).orElseThrow(
                () -> new IllegalArgumentException("메뉴가 존재하지 않습니다."));

        // foundMenu를 MenuResponseDTO.clas로 변환해 주겠다. 엔티티와 디티오로 쉽게 변경할 수 있다.
        return modelMapper.map(foundMenu, MenuResponseDTO.class);
    }

    /* 2. 메뉴 목록 전체 조회*/
   /* public List<MenuResponseDTO> findMenuList() {
        List<Menu> menuList = menuRepository.findAll(Sort.by("menuCode").descending());
        *//*데이터베이스에서 가져온 원본 메뉴 엔티티 객체(menuList)들을 하나하나 꺼내서,
        클라이언트에게 보여주기 위한 형식인 MenuResponseDTO 객체로 깔끔하게 변환한 다음,
        최종적으로 이 변환된 DTO 객체들로 이루어진 새로운 리스트를 만들어서 반환해라*//*
        return menuList.stream().map(menu -> modelMapper.map(menu, MenuResponseDTO.class))
                .collect(Collectors.toList());
    }*/

    /* 전체 메뉴 목록 조회 (페이징 처리) */
    /* Pageable 객체를 통해 */
    public Page<MenuResponseDTO> findMenuList(Pageable pageable) {

       // 페이지 번호 보정 몇페이지를 몇 개의 데이터를 가져올 건지 지정해주기 위한 변수선언
        int page = pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1;
        int size = pageable.getPageSize();
        String sortDir = "menuCode";

        // PageRequest 객체 생성( 페이지 번호, 사이즈, 정렬방법)
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortDir).descending());

        // 조회 (findAll에 PageRequest를 넘기면 끝!!)
        // Page는 map을 가지고 있다. findAll(pageRequest); count 쿼리도 날려준다.
       Page<Menu> menuList = menuRepository.findAll(pageRequest);

        return menuList.map(menu -> modelMapper.map(menu, MenuResponseDTO.class));
    }

    /* 가격으로 검색 (쿼리 메소드)*/
    public List<MenuResponseDTO> findByMenuPrice (Integer menuPrice) {
        // 쿼리 메소드 호출
        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThanOrderByMenuPriceDesc(menuPrice);

        return menuList.stream()
                .map(menu -> modelMapper.map(menu, MenuResponseDTO.class))
                .collect(Collectors.toList());
    }

    public Page<MenuResponseDTO> findByMenuPriceSort(Integer menuPrice, Pageable pageable) {

        //    Sort sort = Sort.by("menuPrice").descending();

        Page<Menu> menuList = menuRepository.findByMenuPriceGreaterThan(menuPrice, pageable);
        return menuList.map(menu -> modelMapper.map(menu, MenuResponseDTO.class));
    }

    public List<CategoryDTO> findAllCategory() {
        List<Category> categoryList = categoryRepository.findAllCategory();

        return categoryList.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();
    }

    /* 메뉴 등록 */
    @Transactional
    public MenuResponseDTO registMenu(MenuRequestDTO requestDTO) {

        Category category = categoryRepository.findById(requestDTO.getCategoryCode())
                .orElseThrow(()  -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));

        // DTO -> Entity 변환 (builder 패턴 사용)
        Menu newMenu = Menu.builder()
                .menuName(requestDTO.getMenuName())
                .menuPrice(requestDTO.getMenuPrice())
                .orderableStatus(requestDTO.getOrderableStatus())
                .category(category)
                .build();

        // 내부적으로 EntityManager.persist() 호출되어 영속성 컨텍스트로 들어간다.
        Menu saveMenu = menuRepository.save(newMenu);

        // 저장 후, 생성된 Entity를 다시 DTO로 변환하여 반환
        return modelMapper.map(saveMenu, MenuResponseDTO.class);
    }

    /* 메뉴 수정 */
    @Transactional
    public MenuResponseDTO modifyMenu(int menuCode, MenuRequestDTO requestDTO) {

        Menu foundMenu = menuRepository.findById(menuCode)
                /* 메뉴를 수정할 때 setter를 열어두지 않아야 의미있는 메소드를 엔티티에 따로 만들어 두고
                *  사용해야 한다. */
                .orElseThrow(() -> new  IllegalArgumentException("수정할 메뉴가 존재하지 않습니다."));

                // 변경할 카테고리 조회
        Category newCategory = categoryRepository.findById(requestDTO.getCategoryCode())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리 입니다."));

//              foundMenu.modifyMenuName(requestDTO.getMenuName());
//              foundMenu.modifyMenuPrice(requestDTO.getMenuPrice());

                foundMenu.modify(
                        requestDTO.getMenuName(),
                        requestDTO.getMenuPrice(),
                        newCategory,
                        requestDTO.getOrderableStatus()

                );
        // 엔티티와 서버의 값을 비교해서 변경을 감지해서 업데이트 쿼리를 보내준다.
        return modelMapper.map(foundMenu, MenuResponseDTO.class);
    }

    /* 메뉴 삭제 */
    @Transactional
    public void deleteMenu(int menuCode) {

        if(!menuRepository.existsById(menuCode)) {
            throw new IllegalArgumentException("삭제할 메뉴가 존재하지 않습니다.");
        }
        menuRepository.deleteById(menuCode);
    }
}
