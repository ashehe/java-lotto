package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        int money;

        // 1. 로또 구입 금액 입력 (1000원 단위가 아니라면 예외 발생)
        System.out.println("구입금액을 입력해 주세요.");
        try {
            money = Integer.parseInt(readLine());
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

    }


}
