import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Кетпчупчик", 199);
    }

    @Test
    public void testGetPrice() {
        assertEquals(199, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetName() {
        assertEquals("Кетпчупчик", ingredient.getName());
    }

    @Test
    public void testGetType() {
        String actual = ingredient.getType().toString();
        assertEquals("SAUCE", actual);
    }
}
