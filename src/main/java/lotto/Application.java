package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // 1. 로또 구입 금액 입력 (1000원 단위가 아니라면 예외 발생)
        System.out.println("구입금액을 입력해 주세요.");
        int money;
        money = Integer.parseInt(readLine());
        try {
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        // 2. 발행한 로또 수량와 번호 출력
        int number = money / 1000;
        System.out.println();
        System.out.println(number + "개를 구매했습니다.");

        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lottoList = new Lotto(numbers);
            System.out.println(numbers);
        }

        // 3. 당첨 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        String InputWinningNumbers = readLine();
        StringTokenizer tokenizer = new StringTokenizer(InputWinningNumbers, ",");
        List<Integer> numbers = new ArrayList<>();

        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            int num = Integer.parseInt(token);
            numbers.add(num);
        }

        Lotto winningNumbers = new Lotto(numbers);
        winningNumbers.print(numbers); // 삭제 예정
    }
}
