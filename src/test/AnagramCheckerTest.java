package test;

import com.code.test.AnagramChecker;
import com.code.test.InvalidInputException;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnagramCheckerTest {

    @Test
    public void testIsAnagramForCaseSensitive() throws InvalidInputException {
        assertTrue(AnagramChecker.isAnagram("Listen", "Silent"));
        assertTrue(AnagramChecker.isAnagram("Debit card", "Bad credit"));
        assertFalse(AnagramChecker.isAnagram("Hello", "world"));
        assertFalse(AnagramChecker.isAnagram("Foo", "bar"));
    }

    @Test
    public void testIsAnagramForHappyCase() throws InvalidInputException {
        assertTrue(AnagramChecker.isAnagram("java", "vaja"));
        assertFalse(AnagramChecker.isAnagram("hello", "world"));
    }


    @Test
    public void testIsAnagramForNullInputs() {
        try {
            AnagramChecker.isAnagram("", "world");
            fail("Expected InvalidInputException");
        } catch (InvalidInputException e) {
            assertEquals("Both words must be non-null", e.getMessage());
        }

        try {
            AnagramChecker.isAnagram("Hello", "");
            fail("Expected InvalidInputException");
        } catch (InvalidInputException e) {
            assertEquals("Both words must be non-null", e.getMessage());
        }
    }
}
