class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }
        long nr = Math.abs((long) numerator);
        long dr = Math.abs((long) denominator);
        long q = nr / dr;
        long r = nr % dr;
        sb.append(q);

        if (r == 0) {
            return sb.toString();
        }
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();

        while (r != 0) {
            if (map.containsKey(r)) {
                int index = map.get(r);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }

            map.put(r, sb.length());
            r *= 10;
            q = r / dr;
            r = r % dr;
            sb.append(q);
        }

        return sb.toString();
    }
}