package domain;

public enum BettingType {
    DIE(1), CALL(2), HALF(3), DOUBLE(4), QUARTER(5), BBING(6);

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
