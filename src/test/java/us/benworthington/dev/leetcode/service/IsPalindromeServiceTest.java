package us.benworthington.dev.leetcode.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import us.benworthington.dev.leetcode.service.impl.IsPalindromeServiceImpl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class IsPalindromeServiceTest {

    @InjectMocks
    private IsPalindromeService isPalindromeService = new IsPalindromeServiceImpl();

    @Test
    public void negativeNumberIsNotAPalindrome() {

        int negativeNumber = -1;

        boolean isPalindromeNumber = isPalindromeService.isPalindrome(negativeNumber);

        assertFalse(isPalindromeNumber);

    }

    @Test
    public void oneHundredIsNotAPalindrome() {

        int number = 100;

        boolean isPalindromeNumber = isPalindromeService.isPalindrome(number);

        assertFalse(isPalindromeNumber);

    }

    @Test
    public void elevenIsAPalindrome() {

        int number = 11;

        boolean isPalindromeNumber = isPalindromeService.isPalindrome(number);

        assertTrue(isPalindromeNumber);

    }

}
