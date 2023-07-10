package com.algos.leetcode.slidingWindow;

public class LC904FruitIntoBaskets {

    public int totalFruit(int[] fruits) {

        // type, index, no
        WindowOfFruits windowOfFruits = new WindowOfFruits();
        int maxLength = 0;

        // find longest window of fruits that has only 2 digits
        // new int[]{1, 2, 3, 3, 3, 3}
        for (int i = 0; i < fruits.length; i++) {

            if (windowOfFruits.has(fruits[i])) {
              windowOfFruits.update(fruits[i], i);
            } else {
                windowOfFruits.add(fruits[i], i);
            }
            windowOfFruits.print();
            System.out.println(" WindowLength -> "+ windowOfFruits.windowLength());
            maxLength = Math.max(maxLength, windowOfFruits.windowLength());
        }

        return maxLength;
    }


    class Fruit{
        private int type;
        private int endIndex;
        private int quantity;

        public Fruit(int type, int endIndex, int quantity) {
            this.type = type;
            this.endIndex = endIndex;
            this.quantity = quantity;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public void setEndIndex(int endIndex) {
            this.endIndex = endIndex;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

    }

    class WindowOfFruits{

        private Fruit fruit1;
        private Fruit fruit2;

        public WindowOfFruits() {
            this.fruit1 = new Fruit(-1, -1, 0);
            this.fruit2 = new Fruit(-1, -1, 0);
        }

        public boolean has(int type){
            return fruit1.getType() == type || fruit2.getType() == type;
        }

        public void update(int type, int index){
            if (fruit1.getType() == type) {
                fruit1.setEndIndex(index);
                fruit1.setQuantity(fruit1.getQuantity()+1);
            }

            if (fruit2.getType() == type) {
                fruit2.setEndIndex(index);
                fruit2.setQuantity(fruit2.getQuantity()+1);
            }
        }

        public void add(int type, int endIndex){
            if (fruit1.getType() == -1) {
                fruit1 = new Fruit(type, endIndex, 1);
            } else if (fruit1.getEndIndex() < fruit2.getEndIndex()) {
                fruit1 = new Fruit(type, endIndex, 1);
            } else {
                fruit2 = new Fruit(type, endIndex, 1);
            }
        }

        public int windowLength(){
            return fruit1.getQuantity() + fruit2.getQuantity();
        }

        public void print(){
            System.out.printf("Fruit1 -> %d , %d, %d" , fruit1.getType(), fruit1.getEndIndex(), fruit1.getQuantity());
            System.out.println();
            System.out.printf("Fruit2 -> %d , %d, %d" , fruit2.getType(), fruit2.getEndIndex(), fruit2.getQuantity());
            System.out.println();
            System.out.println();
        }
    }

}
