package com.algos.codeForces.string;

import java.util.Scanner;

//https://codeforces.com/contest/1368/problem/B
public class CodeforcesSubsequences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextInt();
        main(k);
    }

    protected static String find(long n){

        char[] arr = new char[10];
        arr[0] = 'c';
        arr[1] = 'o';
        arr[2] = 'd';
        arr[3] = 'e';
        arr[4] = 'f';
        arr[5] = 'o';
        arr[6] = 'r';
        arr[7] = 'c';
        arr[8] = 'e';
        arr[9] = 's';

        for (char c : arr) {
            System.out.printf("%s", c);
        }
        for (int i = 10; i < (n-1)+10 ; i++) {
            System.out.printf("%s", "s");
        }
        return null;
    }

    protected static int main(long k) {
        long  cur;
        double lim;
        char[] arr = new char[10];
        arr[0] = 'c';
        arr[1] = 'o';
        arr[2] = 'd';
        arr[3] = 'e';
        arr[4] = 'f';
        arr[5] = 'o';
        arr[6] = 'r';
        arr[7] = 'c';
        arr[8] = 'e';
        arr[9] = 's';


        lim = Math.pow(k, 0.1);
        cur = (long)Math.pow(lim, 10);
        for (char c : arr) {
            for (int i = 0; i < lim; i++) {
                System.out.printf("%s",c);
            }
            if (cur < k) {
                System.out.printf("%s",c);
                cur /= lim;
                cur *= lim + 1;
            }
        }
        //cout << endl;

        return 0;
    }


}

    /*int main() {
        long long k, lim, cur;
        string s = "codeforces";

        cin >> k;

        lim = pow(k, 0.1);
        cur = pow(lim, 10);
        for (char c : s) {
            for (int i = 0; i < lim; i++) {
                cout << c;
            }
            if (cur < k) {
                cout << c;
                cur /= lim;
                cur *= lim + 1;
            }
        }
        cout << endl;

        return 0;
    }*/
