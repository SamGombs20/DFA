package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static String word1;
    private static String word2;
    private static String word3;
    private static String word4;

    @BeforeAll
    static void initializeStrings() {
        word1 = "ajaa";
        word2 = "akabab";
        word3 = "abbaa";
        word4 = "aababb";
    }

    @Test
    void string1IsLanguage1() {
        assertFalse(Main.language1(word1, 'a', 'b'));
    }

    @Test
    void string1IsNotValid() {
        assertFalse(Main.checkStringSymbols(word1, 'a', 'b'));
    }

    @Test
    void string2IsLanguage2() {
        assertFalse(Main.language2(word2, 'a','b'));
    }
    @Test
    void string2IsNotValid(){
        assertFalse(Main.checkStringSymbols(word2, 'a', 'b'));
    }
    @Test
    void string3IsLanguage1(){
        assertTrue(Main.language1(word3, 'a', 'b'));
    }
    @Test
    void string4isLanguage2(){
        assertTrue(Main.language2(word4,'a','b'));
    }
}