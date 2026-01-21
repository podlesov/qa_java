package com.example;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.runners.Parameterized.Parameters;
import java.util.*;

@RunWith(Parameterized.class)
public class LionTestParam {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false} });
    }

    @Parameter
    public String sex;

    @Parameter(1)
    public boolean expectedHasMane;

    @Mock
    private Feline felineMock;

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion(sex, felineMock);

    }

    @Test
    public void testDoesHaveMane() {
        System.out.println(sex);
        if (expectedHasMane == true){
            System.out.println("Должна быть грива");
        } else { System.out.println("Грива должна отсутствовать");
        }
        System.out.println(sex);
        if (lion.doesHaveMane() == true){
            System.out.println("Грива присутствует");
        } else { System.out.println("Грива отсутсует");
        }

        assertEquals("Наличие гривы определено не верно", expectedHasMane, lion.doesHaveMane());
    }

    @Test

    public void testGetKittens() {
        when(felineMock.getKittens()).thenReturn(3);
        assertEquals(3, lion.getKittens());
        verify(felineMock).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        when(felineMock.getFood("Хищник"))
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> food = lion.getFood();
        assertEquals(3, food.size());
        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
        assertTrue(food.contains("Рыба"));
        verify(felineMock).getFood("Хищник");
    }

}

