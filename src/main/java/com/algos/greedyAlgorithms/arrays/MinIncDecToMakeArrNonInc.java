package com.algos.greedyAlgorithms.arrays;


/*@link
geeksforgeeks.org/minimum-incrementdecrement-to-make-array-non-increasing/*/

/*Given an array a, your task is to convert it into a non-increasing form such that we can either increment or
 decrement the array value by 1 in minimum changes possible.

        Examples :

        Input : a[] = {3, 1, 2, 1}
        Output : 1
        Explanation :
        We can convert the array into 3 1 1 1 by
        changing 3rd element of array i.e. 2
        into its previous integer 1 in one step
        hence only one step is required.

        Input : a[] = {3, 1, 5, 1}
        Output : 4
        We need to decrease 5 to 1 to make array sorted
        in non-increasing order.

        Input : a[] = {1, 5, 5, 5}
        Output : 4
        We need to increase 1 to 5.*/

//TODO
/*
Could not do it in first attempt


 */
// Java code to count the change required to
// convert the array into non-increasing array
import java.util.PriorityQueue;

class GFG
{
    public static int DecreasingArray(int a[], int n)
    {
        int sum = 0, dif = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Here in the loop we will
        // check that whether the upcoming
        // element of array is less than top
        // of priority queue. If yes then we
        // calculate the difference. After
        // that we will remove that element
        // and push the current element in
        // queue. And the sum is incremented
        // by the value of difference
        for (int i = 0; i < n; i++)
        {
            if (!pq.isEmpty() && pq.element() < a[i])
            {
                dif = a[i] - pq.element();
                sum += dif;
                pq.remove();
                pq.add(a[i]);
            }
            pq.add(a[i]);
            System.out.println(pq.toString());
        }

        return sum;
    }

    // Driver Code
    public static void main(String[] args)
    {

        int[] a = {5,4,9,8};

        int n = a.length;

        System.out.println(DecreasingArray(a, n));
    }
}

// This Code is contributed by sanjeev2552

