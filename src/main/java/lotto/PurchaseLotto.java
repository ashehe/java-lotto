package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PurchaseLotto {
    public int money;

    public PurchaseLotto() {
        this.money = money;
    }

    public boolean isMoneyValid(int money) {
        try {
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
