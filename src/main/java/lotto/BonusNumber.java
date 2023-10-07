package lotto;

import java.util.List;

public class BonusNumber {
    public static boolean isBonusNumberValid (int bonusNumber, List<Integer> winningNumbers){ // 중복되거나 범위 밖의 수가 아닌지 확인
        boolean isRangeValid = false;
        boolean isUniqueNumber = true;
        if (1 <= bonusNumber && bonusNumber <= 45) {
            isRangeValid = true;
        }
        for (int i = 0; i < winningNumbers.size(); i++) {
            if (bonusNumber == winningNumbers.get(i)) {
                isUniqueNumber = false;
            }
        }
        boolean result = isRangeValid & isUniqueNumber;
        return result;
    }

    public static boolean bonusError(boolean result){ // 보너스 번호 잘못 입력하면 에러 메시지 출력
        try {
            if (!result) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자이며, 당첨 번호와 중복되면 안됩니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
