import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SaleMachineTest {
    private SaleMachine saleMachine;

    @Before
    public void setup() {
        saleMachine = new SaleMachine();
    }

    public void renewsaleMachine(int fiveCents, int oneDollar, int numOfBeer, int numOfOrange) {
        saleMachine = new SaleMachine(fiveCents, oneDollar, numOfBeer, numOfOrange);
    }

    @Test
    public void testOperation1_1_1() {
        renewsaleMachine(0, 0, 1, 0);
        String type = "Beer";
        String money = "5C";
        String actual = saleMachine.operation(type, money);
        String expected = "Input Information\n" +
                "Type:Beer; Money:5 Cents; Change:0\n\n" + saleMachine.currentState();
        assertEquals(expected, actual);
    }

    @Test
    public void testOperation1_1_2() {
        renewsaleMachine(0, 0, 0, 0);
        String type = "Beer";
        String money = "5C";
        String actual = saleMachine.operation(type, money);
        String expected = "Failure Information\nBeer Shortage";
        assertEquals(expected, actual);
    }

    @Test
    public void testOperation1_2_1() {
        renewsaleMachine(0, 0, 0, 1);
        String type = "OrangeJuice";
        String money = "5C";
        String actual = saleMachine.operation(type, money);
        String expected = "Input Information\n" +
                "Type:OrangeJuice; Money:5 Cents; Change:0\n\n" + saleMachine.currentState();
        assertEquals(expected, actual);
    }

    @Test
    public void testOperation1_2_2() {
        renewsaleMachine(0, 0, 0, 0);
        String type = "OrangeJuice";
        String money = "5C";
        String actual = saleMachine.operation(type, money);
        String expected = "Failure Information\nOrangeJuice Shortage";
        assertEquals(expected, actual);
    }

    @Test
    public void testOperation1_3() {
        renewsaleMachine(0, 0, 1, 0);
        String type = "OrangeBeer";
        String money = "5C";
        String actual = saleMachine.operation(type, money);
        String expected = "Failure Information\nType Error";
        assertEquals(expected, actual);
    }

    @Test
    public void testOperation2_1_1() {
        renewsaleMachine(1, 0, 1, 0);
        String type = "Beer";
        String money = "1D";
        String actual = saleMachine.operation(type, money);
        String expected = "Input Information\n" +
                "Type:Beer; Money:1 Dollar; Change:5 Cents\n\n" + saleMachine.currentState();
        assertEquals(expected, actual);
    }

    @Test
    public void testOperation2_1_2() {
        renewsaleMachine(1, 0, 0, 1);
        String type = "OrangeJuice";
        String money = "1D";
        String actual = saleMachine.operation(type, money);
        String expected = "Input Information\n" +
                "Type:OrangeJuice; Money:1 Dollar; Change:5 Cents\n\n" + saleMachine.currentState();
        assertEquals(expected, actual);
    }

    @Test
    public void testOperation2_1_3_1() {
        renewsaleMachine(1, 0, 0, 0);
        String type = "Beer";
        String money = "1D";
        String actual = saleMachine.operation(type, money);
        String expected = "Failure Information\nBeer Shortage";
        assertEquals(expected, actual);
    }

    @Test
    public void testOperation2_1_3_2() {
        renewsaleMachine(1, 0, 0, 0);
        String type = "OrangeJuice";
        String money = "1D";
        String actual = saleMachine.operation(type, money);
        String expected = "Failure Information\nOrangeJuice Shortage";
        assertEquals(expected, actual);
    }

    @Test
    public void testOperation2_1_3_3() {
        renewsaleMachine(1, 0, 1, 1);
        String type = "OrangeBeer";
        String money = "1D";
        String actual = saleMachine.operation(type, money);
        String expected = "Failure Information\nType Error";
        assertEquals(expected, actual);
    }

    @Test
    public void testOperation2_2() {
        renewsaleMachine(0, 0, 1, 0);
        String type = "Beer";
        String money = "1D";
        String actual = saleMachine.operation(type, money);
        String expected = "Failure Information\nChange Shortage";
        assertEquals(expected, actual);
    }

    @Test
    public void testOperation3() {
        renewsaleMachine(1, 0, 1, 1);
        String type = "Beer";
        String money = "2D";
        String actual = saleMachine.operation(type, money);
        String expected = "Failure Information\nMoney Error";
        assertEquals(expected, actual);
    }
}