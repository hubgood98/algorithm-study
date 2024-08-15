package com;

@FunctionalInterface //함수형 인터페이스는 단 하나의 추상 메서드만 가져야 함.
public interface MyFunction {
    void m();
}
@FunctionalInterface
interface B {
    void m(String str);
}

@FunctionalInterface
interface C {
    String m();
}
@FunctionalInterface
interface D {
    int m(int x, int y);
}
