package pl.sdacademy.unit.test.advance.exercises.parametrized.csvsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {

    /*
    true:
    kajak
    wow
    Radar
    oko
    ala
    kobyła ma mały bok

    false:
    java
    programowanie

     */

    //metoda na potrzeby testów, nie powinno się mieszać true-false, to tworzy bałagan
    @ParameterizedTest
    @CsvSource({
            "kajak, true",
            "wow, true",
            "Radar,true",
            "oko, true",
            "ala, true",
            "kobyła ma mały bok, true",
            "java, false",
            "programowanie,false"})
    void shouldVerifyPalindrome(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult,result); //junit
        assertThat(result).isEqualTo(expectedResult); //assertJ
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/palindrome.csv"
    )
    void shouldVerifyPalindrome_CsvFileSource(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult,result); //junit
        assertThat(result).isEqualTo(expectedResult); //assertJ
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/palindrome2.csv",
            numLinesToSkip = 1,
            delimiter = '|'
    )
    void shouldVerifyPalindrome_CsvFileSource_2(String input, boolean expectedResult) {
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult,result); //junit
        assertThat(result).isEqualTo(expectedResult); //assertJ
    }
}