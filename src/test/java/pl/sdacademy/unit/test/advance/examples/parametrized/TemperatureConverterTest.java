package pl.sdacademy.unit.test.advance.examples.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TemperatureConverterTest {

    @ParameterizedTest
    @EnumSource(TemperatureConverter.class)
    void shouldConvertToValueHigherThanMinInteger(TemperatureConverter converter) {
        assertTrue(converter.convertTemp(10) > Integer.MIN_VALUE);
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void shouldVerifyConverter(TemperatureConverter converter, float input, float expectedResult) {
        //when
        float result = converter.convertTemp(input);
        //then
        assertEquals(expectedResult,result);
    }
    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(TemperatureConverter.CELSIUS_KELVIN,100,373.15f),
                Arguments.of(TemperatureConverter.KELVIN_CELSIUS,100,-173.15f),
                Arguments.of(TemperatureConverter.CELSIUS_FAHRENHEIT,100,212f)
        );
    }


    @ParameterizedTest
    @EnumSource(
            value = TemperatureConverter.class,
            names = {"KELVIN_CELSIUS"},
            mode = EnumSource.Mode.EXCLUDE)
    void shouldConvertToTemperatureLowerThanMaxInteger(TemperatureConverter converter) {
        assertTrue(converter.convertTemp(10) < Integer.MAX_VALUE);
    }
}