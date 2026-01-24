package com.example;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class FelineTest {

    @Mock
    private Animal animalMock;

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> food = feline.eatMeat();  // Предполагаем, что eatMeat() вызывает getFood("Хищник")
        assertEquals(3, food.size());
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens_Default() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittens_WithParam() {
        assertEquals(5, feline.getKittens(5));
    }
}

