package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.BonusNumber.isBonusNumberValid;

public class Application {
    public static void main(String[] args) {
        // 1. 로또 구입 금액 입력
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(readLine());
        if (!PurchaseLotto.isMoneyValid(money)) { // 1000원 단위가 아니면 예외 발생 후 종료
            return;
        }
        ;

        // 2. 발행한 로또 수량와 번호 출력
        int number = money / 1000;
        ShowLotto.howManyTickets(number); // 로또 수량 출력
        List<List<Integer>> lottoList = ShowLotto.randomLotto(number);
        for (int i = 0; i < number; i++) { // 로또 번호 출력
            System.out.println(lottoList.get(i));
        }

        // 3. 당첨 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = readLine();
        List<Integer> winningNumbers = Lotto.inputIntoList(inputWinningNumbers);
        Lotto.print(winningNumbers); // 확인용 - 삭제 예정

        // 4. 보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(readLine());
        boolean result = BonusNumber.isBonusNumberValid(bonusNumber, winningNumbers); // 유효한 수인지 확인
        BonusNumber.bonusError(result); // 잘못된 입력이라면 에러메시지 출력 후 종료
        if (isBonusNumberValid(bonusNumber, winningNumbers)) {
            System.out.println(bonusNumber); // 확인용 - 삭제 예정
        }

        // 5-1. 당첨 내역 출력
        List<String> winningCount = new ArrayList<>(); // 장별 번호 일치 개수 리스트
        for (int i = 0; i < number; i++) { // 메서드로 분리 수정 필요
            int count = 0;
            boolean bonus = false;
            for (int j = 0; j < 6; j++) {
                int target = winningNumbers.get(j);
                for (int num : lottoList.get(i)) {
                    if (num == target) {
                        count += 1;
                    }
                    if (num == bonusNumber) { // 보너스 번호 있으면 bonus 불리언을 true로 수정
                        bonus = true;
                    }
                }
            }
            if (count != 5 || !bonus) {
                winningCount.add(String.valueOf(count));
            }
            if (count == 5 && bonus) { // 당첨 번호가 5개이고, 보너스 번호를 맞췄다면 리스트에 5b 추가
                winningCount.add("5b");
            }
        }

        int three = 0;
        int four = 0;
        int five = 0;
        int five_bonus = 0;
        int six = 0;
        for (String s : winningCount) { // 확인용 이후 삭제
            if (s.equals("3")) {
                three += 1;
            }
            if (s.equals("4")) {
                four += 1;
            }
            if (s.equals("5")) {
                five += 1;
            }
            if (s.equals("5b")) {
                five_bonus += 1;
            }
            if (s.equals("6")) {
                six += 1;
            }
        }

        System.out.println("3개 일치 (5,000원) - " + three + "개");
        System.out.println("4개 일치 (50,000원) - " + four + "개");
        System.out.println("5개 일치 (1,500,000원) - " + five + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + five_bonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + six + "개");

        // 5-2. 수익률 출력
        int earning = 0;
        earning += 5000 * three;
        earning += 50000 * four;
        earning += 1500000 * five;
        earning += 30000000 * five_bonus;
        earning += 2000000000 * six;

        double profit = (double) earning / money * 100;
        double profitRate = Math.round(profit * 10.0) / 10.0;
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
