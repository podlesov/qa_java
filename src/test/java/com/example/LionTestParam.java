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

    @Parameters(name = "Тестовые данные: пол={0}, наличие гривы={1}")
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
        } else { System.out.println("Гривы быть не должно");
        }
        if (lion.doesHaveMane() == true){
            System.out.println("Грива есть");
        } else { System.out.println("Гривы нет");
        }

        assertEquals("Наличие гривы определено не верно", expectedHasMane, lion.doesHaveMane());
    }
}








