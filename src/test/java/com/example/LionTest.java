package com.example;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LionTest {
    @Mock
    private Feline felineMock;

    private Lion lion;
    private final String invalidSex = "Средний род"; // Константа для тестов

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        // Не создаём Lion здесь — тесты сами будут его создавать
    }



    @Test
    public void testLion_InvalidSex_ThrowsException() {
        try {
            new Lion(invalidSex, felineMock);
            fail("Ожидалось исключение для некорректного пола");
        } catch (Exception e) {
            // Проходим, если исключение было брошено
        }
    }
}
