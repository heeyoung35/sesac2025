package com.ohgiraffers.section02.annotation;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    private Pokemon pokemon;

    // 생성자가 하나 뿐이면 오토와이어드를 달지 않아도 생성자 주입을 받을 수 있다.
    // 하지만 명시적으로 달아주었다.
    @Autowired
    // @Qualifier: 여러개의 빈(bean)객체중에 특정 객체를 이름으로 지정하는 어노테이션. 포켓몬을 주입받는데 squirtle를 주입받겠다고 설정
    // @Primary 어노테이션과 함께 쓰였을 때 @Qualifier 가 우선으로 연결된다.
    // 프라이머리 어노테이션 보다 퀄리파이어 어노테이션이 우선순위가 된다.
    public PokemonService(@Qualifier("squirtle") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
