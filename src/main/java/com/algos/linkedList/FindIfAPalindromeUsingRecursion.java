package com.algos.linkedList;

public class FindIfAPalindromeUsingRecursion {

    public static void main(String[] args) {

    }
    protected static boolean isPal(LinkedList ll){
        //find Length of list;

        //System.out.println(ll.getLength());
        Result result = isPal(ll.getHead(), ll.getLength());
        return result.isPal();
    }

    private static Result isPal(LinkedListNode node, int length){

        if(length == 0){
            return new Result(Result.aPal, node);
        }

        if(length == 1){
            return  new Result(Result.aPal, node.getNext());
        }

        Result result = isPal(node.getNext() , length - 2);

        if(result.isPal() && node.getData() == result.getNode().getData()){
            return new Result(Result.aPal ,result.getNode().getNext() );
        } else {
          return   new Result(Result.notAPal, null);
        }

    }


}


class Result{

    private boolean isPal;
    private LinkedListNode node;
    public static boolean notAPal = Boolean.FALSE;
    public static boolean aPal = Boolean.TRUE;

    public Result(boolean isPal, LinkedListNode node) {
        this.isPal = isPal;
        this.node = node;
    }

    public boolean isPal() {
        return isPal;
    }

    public LinkedListNode getNode() {
        return node;
    }
}