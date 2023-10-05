package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WinningNumbersInput {
    public String inputWinningNumbers;

    public WinningNumbersInput() {
        this.inputWinningNumbers = inputWinningNumbers;
    }

    public List inputIntoList(String inputWinningNumbers) {
        StringTokenizer tokenizer = new StringTokenizer(inputWinningNumbers, ",");
        List<Integer> numbers = new ArrayList<>();

        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            int num = Integer.parseInt(token);
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            numbers.add(num);
        }
        return numbers;
    }

}
