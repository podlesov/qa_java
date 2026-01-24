package com.example;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class CatTest {

    @Mock
    private Feline felineMock;

    private Cat cat;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        cat = new Cat(felineMock);
    }

    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFoodSize() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> food = cat.getFood();
        System.out.println("Тестируем что еда содержит следующие комплоненты: " + food);
        assertEquals(3, food.size());
    }
    @Test
    public void testGetFoodList() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> food = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
    @Test
    public void testGetFoodEatMeat() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> food = cat.getFood();
        verify(felineMock).eatMeat();
    }
}
