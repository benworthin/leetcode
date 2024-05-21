package us.benworthington.dev.leetcode.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import us.benworthington.dev.leetcode.dto.PalindromeNumberResponse;
import us.benworthington.dev.leetcode.service.IsPalindromeService;

@Slf4j
@RestController
@RequestMapping("/solutions")
public class SolutionsController {

    private final IsPalindromeService isPalindromeService;

    @Autowired
    public SolutionsController(IsPalindromeService isPalindromeService) {
        this.isPalindromeService = isPalindromeService;
    }

    @GetMapping(path = "/isPalindromeNumber", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PalindromeNumberResponse> isPalindromeNumber(@Validated @RequestParam String number) {

        PalindromeNumberResponse palindromeNumberResponse = new PalindromeNumberResponse();

        try {

            int parsedNumber = Integer.parseInt(number);

            palindromeNumberResponse.setNumber(parsedNumber);
            palindromeNumberResponse.setPalindromeNumber(isPalindromeService.isPalindrome(parsedNumber));

            String message = palindromeNumberResponse.isPalindromeNumber() ? "Number is a palindrome." : "Number is not a palindrome";
            palindromeNumberResponse.setMessage(message);

            log.info("PalindromeNumberResponse: {}", palindromeNumberResponse);

            return ResponseEntity.ok(palindromeNumberResponse);

        } catch (NumberFormatException e) {

            palindromeNumberResponse.setMessage("Number parameter must be an integer.");
            return ResponseEntity.badRequest().body(palindromeNumberResponse);

        }

    }

}
