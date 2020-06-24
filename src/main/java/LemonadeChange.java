public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int _5 = 0;
        int _10 = 0;
        for (int b : bills) {
            if (b == 5) {
                _5++;
            } else if (b == 10) {
                if (_5 > 0) {
                    _5--;
                    _10++;
                } else {
                    return false;
                }
            } else if (b == 20) {
                if (_5 > 0 && _10 > 0) {
                    _5--;
                    _10--;
                } else if (_5 > 2) {
                    _5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
