package com.algos.codeForces.math;



import java.util.Scanner;

public class MixingWater {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i< n ; i++){
            int h = sc.nextInt();
            int c = sc.nextInt();
            int t = sc.nextInt();
            System.out.println(findMinNoOfCups(h,c,t));
        }

    }

    protected static int findMinNoOfCups(int h,int c,int t){


        if(t == c){
            return 2;
        }else if(h == t){
            return 1;
        }  else if(2*t == (h+c)){
            return 2;
        } else {
            int diffBetweenHotAndDesired = h-t;
            double x = (2*t)-(h+c);
            if (x < 0) {
                //if diff between c and t is lesser than h and t. because h cups is always 1 greater than c cups
                return 2;
            }
            double noOfCups = Math.floor(diffBetweenHotAndDesired / x);


            //Should we go for for x  or x+1 as no of cups.
            //DO the comparison
            //minimize Math.abs(t - tb)
            return (int)  compare(h, c, t ,noOfCups);

            //return (int) ((2*Math.ceil(diffBetweenHotAndDesired / x))+1);
        }

    }

    //999977 ,17, 499998
    private static double compare(int h, int c, int t, double x) {
        //x+ 1 cups
        double _xPlus1 = Math.abs(t - (((h * (x + 1)) + (c * x)) / ((2 * x) + 1)));
        //x+2 cups
        double _xPlusThree = Math.abs(t - (((h * (x+2)) + (c * (x + 1))) / ((2 * x) + 3)));

        return _xPlus1 <= _xPlusThree ? ((2*x)+1) : ((2*x)+3);
        //double _xPlus2 = Math.abs(t - (((h * (x+2)) + (c * (x+1))) / ((2 * x)+3) ));
        //System.out.println(_xPlus1);
        //System.out.println(_xPlus2);
        //System.out.println(PlusThree);
        //return _xPlus1 < PlusThree ? _xPlus1 < _xPlus2 ? ((2*x)+1) : ((2*x)+3) : PlusThree < _xPlus2 ? x : ((2*x)+3);
    }
}

//Accepted Solution

// ====================================
//   author: M_sea
//   website: https://m-sea-blog.com/
// ====================================
/*
#include <bits/stdc++.h>
        #define file(x) freopen(#x".in","r",stdin); freopen(#x".out","w",stdout)
        using namespace std;
        typedef long long ll;

        int read() {
        int X=0,w=1; char c=getchar();
        while (c<'0'||c>'9') { if (c=='-') w=-1; c=getchar(); }
        while (c>='0'&&c<='9') X=X*10+c-'0',c=getchar();
        return X*w;
        }

        ll h,c,t;

        bool cmp(ll a,ll b) {
        return (h*a+c*(a-1)-t*(2*a-1))*(2*b-1)<=(t*(2*b-1)-h*b-c*(b-1))*(2*a-1);
        }

        int main() {
        int T=read();
        while (T--) {
        h=read(),c=read(),t=read();
        if (t==h) puts("1");
        else if (2*t<=h+c) puts("2");
        else {
        ll x=floor(1.0*(t-c)/(2*t-h-c))+0.5;
        printf("%lld\n",cmp(x,x+1)?2*x-1:2*x+1);
        }
        }
        return 0;
        }*/
