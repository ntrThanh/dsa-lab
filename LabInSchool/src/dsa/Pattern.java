package dsa;

public class Pattern {
    public int match(int[] a, int[] b)
    {
        if (a.length > b.length) {
            return -1;
        }

        int result = -1;

        for (int i = 0; i < b.length; i++) {
            if (b[i] != a[0]) {
                continue;
            }

            if (b.length - i < a.length) {
                return -1;
            }

            int k = i;
            result = k;
            boolean check = true;

            for (int j = 0; j < a.length; j++) {
                if (k >= b.length) {
                    return -1;
                }

                if (b[k++] != a[j]) {
                    check = false;
                    break;
                }
            }

            if (check) {
                return result;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 0, -1, 5, 1, 2, 3, 4, 7, 0, 1, 1, 2, 3, 5, 1, 2, 3};
        int[] a = new int[] {1, 2, 3, 4};

        System.out.println(new Pattern().match(a, arr));
    }
}