package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static void print(List<Integer> numbers) { // 입력한 당첨 번호 확인, 삭제 예정
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
    }

    public static List inputIntoList(String inputWinningNumbers) {
        StringTokenizer tokenizer = new StringTokenizer(inputWinningNumbers, ",");
        List<Integer> numbers = new ArrayList<>();

        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            int num = Integer.parseInt(token);
            if (betweenOneToFortyFive(num) == true) {
                numbers.add(num);
            }
        }
        return numbers;
    }

    public static boolean betweenOneToFortyFive(int num){ // 1부터 45 사이의 수인지 확인
        try {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
