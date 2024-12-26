//package com.example.data;
//
//public class Program2{
//
//    public static void main(String[] args) {
//
//        Account<String> acc1 = new Account<String>("1876", 4500);
//        Account<String> acc2 = new Account<String>("3476", 1500);
//
//        Transaction<Account<String>> tran1 = new Transaction<Account<String>>(acc1,acc2, 4000);
//        tran1.execute();
//        tran1 = new Transaction<Account<String>>(acc1,acc2, 4000);
//        tran1.execute();
//    }
//}
//class Transaction<T extends Account<String>>{
//
//    private T from;     // с какого счета перевод
//    private T to;       // на какой счет перевод
//    private int sum;    // сумма перевода
//
//    Transaction(T from, T to, int sum){
//        this.from = from;
//        this.to = to;
//        this.sum = sum;
//    }
//    public void execute(){
//
//        if (from.getSum() > sum)
//        {
//            from.setSum(from.getSum() - sum);
//            to.setSum(to.getSum() + sum);
//            System.out.printf("Account %s: %d \nAccount %s: %d \n",
//                from.getId(), from.getSum(),to.getId(), to.getSum());
//        }
//        else{
//            System.out.printf("Operation is invalid");
//        }
//    }
//}
//class Account<T>{
//
//    private T id;
//    private int sum;
//
//    Account(T id, int sum){
//        this.id = id;
//        this.sum = sum;
//    }
//
//    public T getId() { return id; }
//    public int getSum() { return sum; }
//    public void setSum(int sum) { this.sum = sum; }
//}