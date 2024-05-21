package us.benworthington.dev.leetcode.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import us.benworthington.dev.leetcode.service.IsPalindromeService;

@Slf4j
@Service
public class IsPalindromeServiceImpl implements IsPalindromeService {

    @Override
    public boolean isPalindrome(int number) {

        log.info("Number: {}", number);

        // Negative numbers cannot be palindromes
        if (number < 0) {
            log.info("{} is negative. Cannot be a palindrome.", number);
            return false;
        }

        long temp = number;
        long reversed = 0;

        // Reverse the number
        while (temp != 0) {
            int digit = (int) (temp % 10);
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        log.info("Reversed Number: {}", reversed);

        return (reversed == number);

    }

}
