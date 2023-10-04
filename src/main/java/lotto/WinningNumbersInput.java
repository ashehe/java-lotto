package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WinningNumbersInput {
    public String InputWinningNumbers;

    public WinningNumbersInput() {
        this.InputWinningNumbers = InputWinningNumbers;
    }

    public List inputIntoList(String InputWinningNumbers) {
        StringTokenizer tokenizer = new StringTokenizer(InputWinningNumbers, ",");
        List<Integer> numbers = new ArrayList<>();

        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            int num = Integer.parseInt(token);
            numbers.add(num);
        }
        return numbers;
    }

}
