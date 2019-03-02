package domain;

public enum BettingType {
    DIE(1), CALL(2), DOUBLE(3), QUARTER(4), HALF(5);

    private int type;

    BettingType(int type) {
        this.type = type;
    }

    public static BettingType findType(int type) {
        for (BettingType bettingType : values()) {
            if (bettingType.type == type) {
                return bettingType;
            }
        }
        throw new IllegalArgumentException("배팅타입을 잘 못 입력했습니다.");
    }
}
