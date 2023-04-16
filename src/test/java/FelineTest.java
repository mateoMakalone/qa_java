import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FelineTest {
    Feline feline;
    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void getFamilyShouldReturnFeline(){
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensWithoutParamsReturnOne(){
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensWithParamsReturnCorrectValue(){
        int expected = 5;
        int actual = feline.getKittens(5);
        assertEquals(expected, actual);
    }

    @Test
    public void eatMeatShouldReturnPredatorFoodList() throws Exception {
        Animal animal = new Animal();
        List<String> expected = animal.getFood("Хищник");
        List<String> actual = feline.eatMeat();
        assertTrue(expected.equals(actual));
    }
}
