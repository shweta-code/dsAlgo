package com.algos.binarySearch;


public class CountOccurences {

    public static void main(String[] args) {
        //Given a sorted array , count occurenecs of a given element
        int[] arr = {2, 2, 2, 2, 3, 4, 5, 5, 5, 5};

        findAns(arr, 3);

    }

    private static void findAns(int[] arr, int no) {

        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int mid;
        int leftIndex = -1;
        int rightIndex = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == no) {
                leftIndex = mid;
                rightIndex = mid;
                //find left index
                int _low = low;
                int _high = mid - 1;
                int _mid;
                while (_low <= _high) {
                    _mid = (_low + _high) / 2;
                    if (arr[_mid] == no) {
                        leftIndex = _mid;
                        _high = _mid - 1;
                    } else if (arr[_mid] < no) {
                        _low = _mid + 1;
                    }

                }

                _low = mid + 1;
                _high = high;
                _mid = 0;
                while (_low <= _high) {
                    _mid = (_low + _high) / 2;
                    if (arr[_mid] == no) {
                        rightIndex = _mid;
                        _low = _mid + 1;
                    } else if (arr[_mid] > no) {
                        _high = _mid - 1;
                    }

                }
                break;


            } else if (arr[mid] < no) {
                low = mid + 1;
            } else if (arr[mid] > no) {
                high = mid - 1;
            }
        }

        System.out.println(rightIndex - leftIndex + 1);


    }
}
