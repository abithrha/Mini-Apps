import java.util.*;

class Atm {
    static Scanner sc;
    static int[] amount = { 0, 0, 0, 0 };
    static int[] amount1 = { 100, 200, 500, 2000 };
    static int[] wit = {0 ,0, 0, 0};
    static int[] dep = {0,0,0,0};
    static int bal = 10000;
    static int count=0;
    static int abc =0;
    static int abcd =0;
    static int b = 1234;
    static int giv =0;
    static int rem =0;


    // add money
    static void addmoney() {

        System.out.println("Enter the amount in 100 200 500 1000");
        for (int i = 0; i < 4; i++) {
           
            System.out.print("Enter the amount " + amount1[i] + " = ");
            amount[i] += sc.nextInt();
            abc=(abc+amount1[i]*amount[i]);
        }
        System.out.println("Press enter to back");
        sc.nextLine();
        String g = sc.nextLine();
        if (g.equals(""))
            admin();

    }
    //reminder
    static void reminder(int giv){
        if(giv/2000!=0){
        wit[3] = giv/2000;
        giv = giv%2000;
        amount[3] = amount[3]-wit[3];
        }
        else if(giv/500!=0){
        wit[2] = giv/500;
        giv = giv%500;
        amount[2] = amount[2]-wit[2];
        }
        else if(giv/200!=0){
        wit[1] = giv/200;
        giv = giv%200;
        amount[1] = amount[1]-wit[1];
        }
        else if(giv/100!=0){
        wit[0] = giv/100;
        giv = giv%100;
        amount[0] = amount[0]-wit[0];
        }
    }
    //reminder depos
    static void depos(int abcd){
        if(abcd/2000!=0){
        dep[3] = abcd/2000;
        abcd = abcd%2000;
        amount[3] = amount[3]+dep[3];
        }
        else if(abcd/500!=0){
        dep[2] = abcd/500;
        abcd = abcd%500;
        amount[2] = amount[2]+dep[2];
        }
        else if(abcd/200!=0){
        dep[1] = abcd/200;
        abcd = abcd%200;
        amount[1] = amount[1]+dep[1];
        }
        else if(abcd/100!=0){
        dep[0] = abcd/100;
        abcd = abcd%100;
        amount[0] = amount[0]+dep[0];
        }
    }

    // admin
    static void admin() {
        System.out.print("\033[H\033[2J");
        System.out.println("Hello Abith");
        int b = 0;
        System.out.println("Welcome Admin Have a Good day!!!");
        System.out.println("1.Load money");
        System.out.println("2.Show Money");
        System.out.println("3.Exit");
        System.out.println("4.Back");
        b = sc.nextInt();
        System.out.print("\033[H\033[2J");
        switch (b) {
            case 1:
                addmoney();
                break;
            case 2:
                showmoney();
                break;
            case 3:
                System.exit(0);
                break;
            case 4:
                Rate();
                break;
        }
    }

    // show money
    static void showmoney() {
        System.out.println("Balance");
        
        for (int i = 0; i < 4; i++) {

            System.out.println("Balance amount " + amount1[i] + " = " + amount[i]);
            
        }
        System.out.println("Total amount = "+(abc+abcd));
      
        System.out.println("Press enter to go back");
        sc.nextLine();
        String f = sc.nextLine();
        if (f.equals("")) {
            admin();
        }

    }
    // my money
    static void my() {
        System.out.print("\033[H\033[2J");
        System.out.println("Hello Abith");
        int to = 0;
        System.out.println("1.Check Balance ");
        System.out.println("2.Withdraw");
        System.out.println("3.Deposit");
        System.out.println("4.Change pin");
        System.out.println("5.Mini statement");
        System.out.println("6.Exit");
        System.out.println("7.Back");
        to = sc.nextInt();
        switch (to) {
            case 1:
                check();
                break;
            case 2:
                with();
                break;
            case 3:
            deposit();
                break;
            case 4:
                pin();
                break;
            case 5:
            mini();
                break;
            case 6:
                System.exit(0);
                break;
            case 7:
                Rate();
                break;
        }

    }
    //ministatement
    static void mini(){
        for(int i=1;i<=count;i++){
            Date ab = java.util.Calendar.getInstance().getTime();
            System.out.println(ab+" "+giv+" "+bal);
            System.out.println("Press enter to back");
        sc.nextLine();
        String g = sc.nextLine();
        if (g.equals(""))
        my();
        }
    }
    //deposit
    static void deposit(){
        System.out.println("Enter the amount in 100 200 500 1000");
        for (int i = 0; i < 4; i++) {
           
            System.out.print("Enter the amount " + amount1[i] + " = ");
            amount[i] += sc.nextInt();
            abcd += amount[i]*amount1[i];
            count++;
        }
            depos(abcd);
        System.out.println(" Total amount deposit : "+abcd);
        System.out.println("Press enter to back");
        sc.nextLine();
        String g = sc.nextLine();
        if (g.equals(""))
            my();
    }
    
    //pin change
    static void pin(){
        System.out.print("\033[H\033[2J");
        System.out.print("Enter the old pin : ");
        int ab = sc.nextInt();
        if(ab==b){
            System.out.print("Enter the new pin : ");
            int ac = sc.nextInt();
            b=ac;
            System.out.println("Your pin has changed sucessfully!!!");
            sc.nextLine();
            System.out.println("Press enter to next !!!");
            String gh = sc.nextLine();
            if(gh.equals("")){
                my();
            }
        }
        else{
            System.out.println("Invalid password !");
            sc.nextLine();
            System.out.println("Press enter to next !!!");
            String gh = sc.nextLine();
            if(gh.equals("")){
                my();
            }
        }
    }
    //withdraw
    static void with(){
        System.out.print("\033[H\033[2J");
        System.out.print("Enter the amount = ");
        giv = sc.nextInt();
        if(abc>=giv  && giv%100==0){
        bal -=giv;
        abc =abc-giv;
        reminder( giv);
        count++;
        System.out.println("Current balance is"+bal);
        sc.nextLine();
        System.out.println("Press enter to next !!!");
        String gh = sc.nextLine();
        if(gh.equals("")){
            my();
        }
    }
    else{
        System.out.println("Invalid amount");
        sc.nextLine();
        System.out.println("Press enter to next !!!");
        String gh = sc.nextLine();
        if(gh.equals("")){
            my();
        }
    }

    }

    // check Balance
    static void check() {
        System.out.print("\033[H\033[2J");
        bal=abcd+bal;
        System.out.println("Your amount is " +bal);
        System.out.println("Press Enter!");
        
        sc.nextLine();
        String gh = sc.nextLine();
        if(gh.equals("")){
        my();
    }
    }
    // Main
    static void Rate() {
        int a = 0;
        System.out.print("\033[H\033[2J");
        System.out.println("     ATM machine     ");
        System.out.println("1. Admin Login");
        System.out.println("2. User Login");
        System.out.println("3. Exit");
        System.out.println("4.Transation");
        System.out.println("Enter your choice");
        a = sc.nextInt();
        switch (a) {
            case 1:
                System.out.print("\033[H\033[2J");
                System.out.print("Enter your name :");
                String user = sc.next();
                System.out.print("Enter the pin :");
                int pin = sc.nextInt();
                if (user.equals("admin") && pin == 1234)
                    admin();

                else {
                    
                    System.out.println("Invalid user");
                }

                break;
            case 2:
             System.out.print("\033[H\033[2J");
                System.out.print("Enter your name :");
                String user1 = sc.next();
                System.out.print("Enter your pin :");
                int c = sc.nextInt();
                if (user1.equals("Abith") && c==b ) {
                    my();
                }
                else{
                    System.out.println("Wrong password !!!");
                    sc.nextLine();
                    System.out.println("Press Enter to Back!!!");
                    String gh = sc.nextLine();
                    if(gh.equals("")){
                    Rate();
                    }
                }
                break;
            case 3:
                System.exit(0);
                break;
            case 4:
                System.out.print("\033[H\033[2J");
                 System.out.print("No of transaction = "+count);
                 sc.nextLine();
                 String df = sc.nextLine();
                 System.out.println("Press Enter");
                 if(df.equals("")){
                     my();
                 }
                 break;
            default:
                System.out.println("Invalid input");

        }
    }

    public static void main(String arg[]) {
        sc = new Scanner(System.in);
        Rate();
    }
}