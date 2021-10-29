import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class hackerrank {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size= sc.nextInt();
        List<Integer> lm= new ArrayList<>(size);
        for (int i=0;i<size;i++){
            lm.add(sc.nextInt());
        }
        int target= sc.nextInt();
        Solution n= new Solution();
        int x=   n.findInMountainArray(target, (ArrayList) lm);
        System.out.println(x);


    }
    static class Solution {
        private int n;
        private ArrayList mountainArr;

        public int findInMountainArray(int target, ArrayList mountainArr) {
            this.mountainArr = mountainArr;
            this.n = mountainArr.size();

            // find max element
            int peakIdx = findPeak();

            int res = search(target, 0, peakIdx, true);
            if (res != -1) return res;
            res = search(target, peakIdx, n-1, false);
            return res;
        }

        private int search(int target, int left, int right, boolean increase) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int curr = (int) mountainArr.get(mid);

                if (curr == target) return mid;

                else if (curr < target) {
                    if (increase) left = mid + 1;
                    else right = mid - 1;
                } else {
                    if (increase) right = mid - 1;
                    else left = mid + 1;
                }
            }
            return -1;
        }

        private int findPeak() {
            int left = 1, right = n-2;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int curr = (int) mountainArr.get(mid);

                if (curr < (int)mountainArr.get(mid-1)) right = mid - 1;
                else if (curr < (int)mountainArr.get(mid+1)) left = mid + 1;
                else return mid;
            }
            return left;
        }
    }
}