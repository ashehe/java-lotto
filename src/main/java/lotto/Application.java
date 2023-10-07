package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.BonusNumber.isBonusNumberValid;

public class Application {
    public static void main(String[] args) {
        // 1. 로또 구입 금액 입력
        PurchaseLotto purchase = new PurchaseLotto();
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(readLine());
        if (!purchase.isMoneyValid(money)) { // 1000원 단위가 아니면 예외 발생 후 종료
            return;
        };

        // 2. 발행한 로또 수량와 번호 출력
        ShowLotto show = new ShowLotto();
        int number = money / 1000;
        show.howManyTickets(number); // 로또 수량 출력
        List lottoList = show.randomLotto(number);
        for (int i = 0; i < number; i++) { // 로또 번호 출력
            System.out.println(lottoList.get(i));
        }

        // 3. 당첨 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = readLine();
        List winningNumbers = Lotto.inputIntoList(inputWinningNumbers);

        Lotto.print(winningNumbers); // 확인용 - 삭제 예정

        // 4. 보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(readLine());
        boolean result = BonusNumber.isBonusNumberValid(bonusNumber, winningNumbers); // 유효한 수인지 확인
        BonusNumber.bonusError(result); // 잘못된 입력이라면 에러메시지 출력 후 종료
        if (isBonusNumberValid(bonusNumber, winningNumbers)) {
            System.out.println(bonusNumber); // 확인용 - 삭제 예정
        }

    }
}
