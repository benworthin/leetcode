package us.benworthington.dev.leetcode.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PalindromeNumberResponse {

    private int number;

    private boolean isPalindromeNumber;

    private String message;

}
