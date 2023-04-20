import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class LionTest {
    private boolean HasMane;
    private String name;
    @Mock
    private static Feline feline;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
    public LionTest(String name, boolean HasMane, Feline feline){
        this.name = name;
        this.HasMane = HasMane;
        this.feline = feline;
        }

    @Parameterized.Parameters(name = "Самец. Тестовые данные: {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true, feline},
                {"Самка", false, feline},
                {"Небинарный вел", false, feline},
        };
    }

    @Test
    public void doesHasManeReturn() throws Exception {
        try {
            Lion lion = new Lion(name, feline);
            boolean expected = HasMane;
            boolean actual = lion.doesHaveMane();
            assertEquals(expected, actual);
        }catch (Exception exception) {
        System.out.println("Используйте допустимые значения пола животного - самец или самка");
        }
    }
    @Test
    public void getKittensWithoutParamsReturnOne() throws Exception {
       try {
           Lion lion = new Lion(name, feline);
            Mockito.when(feline.getKittens()).thenReturn(1);
            int expected = feline.getKittens();
            int actual = lion.getKittens();
            assertEquals(expected, actual);
       }catch (Exception exception){}
    }
    @Test
    public void getFoodShouldReturnPredatorFoodList() throws Exception {
        try {
            Lion lion = new Lion(name, feline);
            Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            List<String> actual = lion.getFood();
            List<String> expected = feline.getFood("Хищник");
            assertEquals(expected, actual);
        }catch (Exception exception){}
    }
}
