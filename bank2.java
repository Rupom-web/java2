import java.util.*;
class account{
    String name ;
    int accNo;
    int balance;
    account(int accNo, String name,int balance){
        this.accNo=accNo;
        this.name=name;
        this.balance=balance;
    }

    void diposit(int amount){
        if(amount<0)
            return;
        balance+=amount;
        System.out.println("dipposite"+amount);}
        void widrow(int amount){
            if (amount>balance)
               return ;
            System.out.println("widrow"+amount);
            balance-=amount;
        }
               void displayBalance(){
            System.out.println(balance);
        }
        
    }


    class save extends account{

save(int  accNo,String name,int balance){
    super(accNo,name,balance);
}

        void widrow(int amount){
if((balance-amount) <100){
    System.out.println("widrow cant possible");
    return ;}
System.out.println("widrow"+amount);
balance-=amount;
        }
        void displayBalance(){
            System.out.println(balance);
        }




    }
    
    public class bank2 {
     public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String s=sc.nextLine();
        int b=sc.nextInt();
        save ac=new save(n,s,b);
        ac.diposit(sc.nextInt());
  ac.displayBalance();
        ac.widrow(sc.nextInt());
        ac.displayBalance();

     
     }
}
