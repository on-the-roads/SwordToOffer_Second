public class q38_GetNumberOfK_数字在排序数组中出现的次数 {
        /**
         * 思路：利用二分查找找到排序数组中目标元素的最左下标和最右下标，作差+1即为所求
         *
         * @param array
         * @param k
         * @return
         */
        public int GetNumberOfK1(int[] array, int k) {
            if (array == null || array.length == 0) return 0;
            int left = sortLeft(array, k);
            int right = sortRight(array, k);
            //说明数组中不存在该元素
            if (left == -1 && right == -1) return 0;
            return right - left + 1;
        }

        private int sortLeft(int[] arr, int k) {
            int r = arr.length - 1;
            int l = 0;
            while (l <= r) {
                int mid = (l + r) / 2;
                int temp = arr[mid];
                if (k <= temp)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            if (l < arr.length && arr[l] == k)
                return l;
            return -1;
        }

        private int sortRight(int[] arr, int k) {
            int r = arr.length - 1;
            int l = 0;
            while (l <= r) {
                int mid = (l + r) / 2;
                int temp = arr[mid];
                if (k >= temp) {
                    l = mid + 1;
                } else
                    r = mid - 1;
            }
            if (r >= 0 && arr[r] == k)
                return r;
            return -1;
        }
    }
