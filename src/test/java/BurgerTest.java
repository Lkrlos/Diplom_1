import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "Кетчупчик", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "БИОКОТЛЕТА", 300));

        burger.moveIngredient(0, 1);
        assertEquals("Кетчупчик", burger.ingredients.get(1).name);
    }

    @Test
    public void testGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(100F * 2 + 100F, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        Mockito.when(bun.getName()).thenReturn("Бублик");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Кетчупчик");
        Mockito.when(ingredient.getPrice()).thenReturn(200f);
        burger.addIngredient(ingredient);

        String receiptExpected = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals(receiptExpected, burger.getReceipt());
    }
}
