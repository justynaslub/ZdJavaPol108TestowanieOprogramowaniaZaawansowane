package pl.sdacademy.unit.test.advance.exercises.task1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator = new Calculator();
 /*
 true:
 1,1
 0,0
 false:
 1,a
 a,b
  */
    @ParameterizedTest
    @MethodSource("provideDataForMultiply")
    void shouldMultiplyTwoDigits(int firstDigit, int secondDigit, int expectedResult) {
        //when
        int result = calculator.multiply(firstDigit,secondDigit);
        //then
        assertEquals(expectedResult,result); //junit
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideDataForMultiply() {
        return Stream.of(
                Arguments.of(2,3,6),
                Arguments.of(2,0,0),
                Arguments.of(0,3,0),
                Arguments.of(2,-3,-6)
        );
    }

    @ParameterizedTest
    @CsvSource({"2,0"})
    void shouldReturnExceptionIfDividedByZero(int a, int b) {
        //when & then
        //junit
        assertThrows(IllegalArgumentException.class,() ->calculator.divide(a,b));
        //assertJ
        assertThatThrownBy(() ->calculator.divide(a,b)).isInstanceOf(IllegalArgumentException.class).hasMessage("You can't divide by zero");
    }
}