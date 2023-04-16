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
    private String sex;
    @Mock
    Feline feline;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
    public LionTest(String sex, boolean HasMane ){
        this.sex = sex;
        this.HasMane = HasMane;
        }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHasManeReturn() throws Exception {
        Lion lion = new Lion(sex);
        boolean expected = HasMane;
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }
    @Test
    public void getKittensWithoutParamsReturnOne() throws Exception {
        Lion lion = new Lion(sex);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expected = 1;
        int actual = lion.getKittens();
        assertEquals(expected, actual);
    }
    @Test
    public void getFoodShouldReturnPredatorFoodList() throws Exception {
        Lion lion = new Lion(sex);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }
}
