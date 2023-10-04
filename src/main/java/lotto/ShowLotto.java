package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ShowLotto {
    public int number;

    public ShowLotto() {
        this.number = number;
    }

    public void howManyTickets(int number) {
        System.out.println();
        System.out.println(number + "개를 구매했습니다.");
    }

    public List randomLotto(int number) {
        List<List<Integer>> lottoList = new ArrayList<>();
        for (int i = 0; i < number; i++) { // 확인용 삭제 예정
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(numbers);
        }
        return lottoList;
    }
}
