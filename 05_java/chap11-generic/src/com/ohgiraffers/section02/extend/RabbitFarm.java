package com.ohgiraffers.section02.extend;

// 토끼의 자손만 들어올 수 있도록 제한을 걸 때 제네릭스 타입에 함께 작성 extends Rabbit
// T는 Rabbit 또는 Rabbit의 자손이어야만 한다. (타입 제한)
public class RabbitFarm<T extends Rabbit> {

    private T animal;

    public RabbitFarm() {}

    public RabbitFarm(T animal) {
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }
}
