import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawPlayerTest {
        private DrawPlayer drawPlayer;
        @BeforeEach
            void beforEach() {
                drawPlayer = new DrawPlayer();
            }

        @Test
            public void shouldCheckIfEqualTrue() {
            //given
            int num1 = 4;
            int num2 = 4;

            //when
            boolean result = drawPlayer.checkIfEqual(num1, num2);

            //then
            Assertions.assertEquals(true, result);
        }

        @Test
          public void shouldCheckIfEqualFalse() {
            //given
            int num1 = 4;
            int num2 = 5;

            //when
            boolean result = drawPlayer.checkIfEqual(num1, num2);

            //then
            Assertions.assertEquals(false, result);
        }

        @Test
        public void shouldCheckCorrectNumberGivenByUser() {
            //given
            int num1 = 33;

            //when
            boolean result = drawPlayer.checkRange(num1);

            //then
            Assertions.assertEquals(false, result);
        }

    @Test
    public void shouldCheckIncorrectNumberGivenByUser() {
        //given
        int num1 = 102;

        //when
        boolean result = drawPlayer.checkRange(num1);

        //then
        Assertions.assertEquals(true, result);
    }
}