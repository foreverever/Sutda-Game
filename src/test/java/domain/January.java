package domain;

public class January extends Parent {
    // TODO : 광은 어떻게??
    public January() {
        super(1);
    }

    public String matched(Parent card1) {
        // TODO : Result 라는 객체를 생성해서 결과값 (순위, 족보)를 반환
        if (getMonth() == card1.getMonth()) {
            return "일땡";
        }

        if (card1.getMonth() == 9) {
            return "구삥";
        }
        return null;
    }
}
