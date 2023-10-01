package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // 1. 로또 구입 금액 입력 (1000원 단위 아니면 예외 처리)
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int money = Integer.parseInt(readLine());
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("!");
    }
}
