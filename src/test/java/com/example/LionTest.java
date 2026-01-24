package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LionTest {

    @Mock
    private Feline felineMock;

    private Lion lion;
    private final String invalidSex = "Средний род";

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion("Самец", felineMock);
    }
    // Вспомогательный метод для подготовки мока
    private void prepareFelineMockForFood() throws Exception {
        when(felineMock.getFood("Хищник"))
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));
    }



    @Test
    public void testGetKittens() {
        when(felineMock.getKittens()).thenReturn(3);

        int actualKittens = lion.getKittens();

        assertEquals(3, actualKittens);
        verify(felineMock).getKittens();
    }

    @Test
    public void testGetFood_ReturnsCorrectSize() throws Exception {
        prepareFelineMockForFood();

        List<String> food = lion.getFood();

        assertEquals("Размер списка еды должен быть 3", 3, food.size());
    }

    @Test
    public void testGetFood_ReturnsCorrectContent() throws Exception {
        prepareFelineMockForFood();

        List<String> food = lion.getFood();

        assertEquals(
                "Содержимое списка еды не соответствует ожидаемому",
                List.of("Животные", "Птицы", "Рыба"),
                food
        );
    }

    @Test
    public void testGetFood_CallsFelineMethod() throws Exception {
        prepareFelineMockForFood();

        lion.getFood();

        verify(felineMock).getFood("Хищник");
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
