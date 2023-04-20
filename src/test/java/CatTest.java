import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Spy
    private Feline feline;
    @Test
    public void getSoundShouldReturnMeow(){
        Cat cat = new Cat(feline);
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals("Это не кошка!", expectedSound, actualSound);
    }
    @Test
    public void getFoodReturnFelineFoodList () throws Exception {
        Cat cat = new Cat(feline);
        List <String> actualFoodList = cat.getFood();
        List <String> expectedFoodList = feline.getFood("Хищник");
        assertTrue(expectedFoodList.equals(actualFoodList));
    }
}
