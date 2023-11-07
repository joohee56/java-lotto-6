package lotto.domain;

import java.util.List;
import lotto.constants.ErrorMessage;

public class Lotto {
    public static final int LOTTO_NUMBER_RANGE_MIN = 1;
    public static final int LOTTO_NUMBER_RANGE_MAX = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if(!isCorrectSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_WRONG_SIZE.getMessage());
        }
        if(!isInRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE.getMessage());
        }
        if(!isUniqueNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_UNIQUE.getMessage());
        }
        if(!isAscending(numbers)){
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_ASCENDING.getMessage());
        }
    }

    private boolean isCorrectSize(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean isInRange(List<Integer> numbers) {
        for(Integer number : numbers) {
            if(number < LOTTO_NUMBER_RANGE_MIN || number > LOTTO_NUMBER_RANGE_MAX)
                return false;
        }
        return true;
    }

    private boolean isUniqueNumbers(List<Integer> numbers) {
        boolean[] isContained = new boolean[LOTTO_NUMBER_RANGE_MAX+1];
        for(Integer number : numbers) {
            if(isContained[number]) {
                return false;
            }
            isContained[number] = true;
        }
        return true;
    }

    private boolean isAscending(List<Integer> numbers) {
        for(int i = 1; i< numbers.size(); i++) {
            if(numbers.get(i) < numbers.get(i-1)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
