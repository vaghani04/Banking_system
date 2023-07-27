import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileInputStream;
import java.io.IOException;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import java.util.Random;

class Datas {

    public static void write_to_excel(User new_node) {

        File file = new File("User.csv");
        try {

            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter out = new PrintWriter(br);

            out.printf("%s, %s,%s, %s, %s, %s, %s, %s ,%s,%s\n", new_node.userId, new_node.accountNo, new_node.mobileNo,
                    new_node.fullName,
                    new_node.gmail, new_node.adress, new_node.panNo, new_node.adharNo, new_node.password,
                    new_node.balance);

            out.close();
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static int count(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        } finally {
            is.close();
        }
    }

    public static String convert(String str) {

        String result = str.substring(1, str.length() - 1);

        return result;
    }

    public static String chekcDoubleQuates(String str) {
        String strp = "\"\"";
        char x = strp.charAt(0);
        char y = str.charAt(0);

        if (x == y) {
            String result = convert(str);
            return result;
        } else {
            return str;
        }
    }

    public static int columCount(String filename) throws IOException {
        Path path = Paths.get(filename);
        List<String> arr = Files.readAllLines(path);
        String[] arr2;
        int row = count(filename);
        int colums = 0;

        arr2 = arr.get(1).split(",");
        colums = arr2.length;

        return colums;
    }

    public static void updateCSV(String fileToUpdate, String replace, int row, int col) throws IOException {

        File inputFile = new File(fileToUpdate);

        // Read existing file
        CSVReader reader = new CSVReader(new FileReader(inputFile));
        List<String[]> csvBody = reader.readAll();
        // get CSV row column and replace with by using row and column
        csvBody.get(row)[col] = replace;
        reader.close();

        // Write to CSV file which is open
        CSVWriter writer = new CSVWriter(new FileWriter(inputFile));
        writer.writeAll(csvBody);
        writer.flush();
        writer.close();
    }

    public static int loginUserRow(String filename, String uid) throws IOException {
        Path path = Paths.get(filename);
        List<String> arr = Files.readAllLines(path);
        String[] arr2;
        int row = count(filename);

        for (int i = 0; i < row; i++) {
            arr2 = arr.get(i).split(",");
            String quates = arr2[0];
            arr2[0] = chekcDoubleQuates(arr2[0]);
            if (arr2[0].matches(uid)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean passwordCheck(String filename, String password) throws IOException {
        Path path = Paths.get(filename);
        List<String> arr = Files.readAllLines(path);
        String[] arr2;
        int row = count(filename);
        for (int i = 0; i < row; i++) {
            arr2 = arr.get(i).split(",");

            arr2[8] = chekcDoubleQuates(arr2[8]);
            if (arr2[8].matches(password)) {
                return true;
            }
        }
        return false;
    }

    public static String currenBalance(String filename, int logincheck) throws IOException {
        Path path = Paths.get(filename);
        List<String> arr = Files.readAllLines(path);
        String[] arr2;
        int row = count(filename);
        arr2 = arr.get(logincheck).split(",");
        arr2[9] = chekcDoubleQuates(arr2[9]);
        return arr2[9];
    }

    public static String logindataa(String filename, int logincheck, int i) throws IOException {
        Path path = Paths.get(filename);
        List<String> arr = Files.readAllLines(path);

        String[] arr2;

        int row = count(filename);
        arr2 = arr.get(logincheck).split(",");
        arr2[i] = chekcDoubleQuates(arr2[i]);
        return arr2[i];
    }
}

class User {

    String userId;
    String accountNo;
    String mobileNo;
    String fullName;
    String gmail;
    String adress;
    String panNo;
    String adharNo;
    String password;
    String balance = "1000";

    public User() {
        this.userId = null;
        this.accountNo = null;
        this.mobileNo = null;
        this.fullName = null;
        this.gmail = null;
        this.adress = null;
        this.panNo = null;
        this.adharNo = null;
        this.password = null;
    }

    public User(String uid, String an, String mn, String fn, String gm, String ad, String pn, String adn, String pass) {
        this.userId = uid;
        this.accountNo = an;
        this.mobileNo = mn;
        this.fullName = fn;
        this.gmail = gm;
        this.adress = ad;
        this.panNo = pn;
        this.adharNo = adn;
        this.password = pass;
    }
}

public class Main extends Datas {
    public static void designspace(String str) {
        System.out.print("\t\t\t\t\t\t");
        System.out.println(str);
    }

    public static void inputformat(String str) {
        System.out.print("\t\t\t\t\t\t");
        System.out.print(str);
    }

    static String password;

    public static void loading1() {
        System.out.println();
        System.out.print(ANSI_CYAN + "\t\t\t\t\t\tLoading.");
        try {
            Thread.sleep(1000);
            System.out.print(".");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        try {
            Thread.sleep(1000);
            System.out.print(".");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        try {
            Thread.sleep(1000);
            System.out.print(".");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        try {
            Thread.sleep(1000);
            System.out.print(".");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        try {
            Thread.sleep(1000);
            System.out.print("." + ANSI_RESET);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        try {
            Thread.sleep(1000);
            System.out.print("." + ANSI_RESET);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        try {
            Thread.sleep(1000);
            System.out.print("." + ANSI_RESET);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void loading() {
        System.out.println();
        System.out.print(ANSI_CYAN + "\t\t\t\t\t\tLoading.");
        try {
            Thread.sleep(800);
            System.out.print(".");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        try {
            Thread.sleep(800);
            System.out.print(".");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        try {
            Thread.sleep(800);
            System.out.print(".");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        try {
            Thread.sleep(800);
            System.out.print(".");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        try {
            Thread.sleep(800);
            System.out.print("." + ANSI_RESET);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public static void register() throws IOException {
        String userId, fullName, mobileNo, gmail, adress, panNo, adharNo, accountNo;
        Scanner sc = new Scanner(System.in);
        System.out.println(
                ANSI_RED + "\t--------------------------------------------------------------------------------------------------"
                        + ANSI_RESET);

        System.out.println(
                ANSI_RED + "\t__________________________________________________________________________________________________"
                        + ANSI_RESET);
        System.out.println();

        loading();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        designspace(ANSI_BLUE + "First create your account" + ANSI_RESET);
        System.out.println();
        System.out.println(ANSI_BLUE + "\t\t\t\t\t\tPlease Don't Give Comma(,) In Any Of Details  \n" + ANSI_RESET);

        Random rand = new Random(System.currentTimeMillis());

        long accountNoInt = rand.nextInt(100000000);

        System.out.print("\n\t\t\t\t\t\tPlease Enter FullName : ");
        fullName = sc.nextLine();
        int count = 0;
        do {
            if (count == 0) {
                System.out.print("\n\t\t\t\t\t\tPlease Enter Mobile Number : ");
            } else {
                System.out.print(ANSI_RED + "\n\t\t\t\t\t\tPlease Re-Enter Mobile Number : " + ANSI_RESET);
            }
            count++;
            mobileNo = sc.nextLine();
        } while (mobileNo.length() != 10);

        System.out.print("\n\t\t\t\t\t\tPlease Enter Your Gmail : ");
        gmail = sc.nextLine();
        System.out.print("\n\t\t\t\t\t\tPlease Enter adress : ");
        adress = sc.nextLine();
        System.out.print("\n\t\t\t\t\t\tPlease Enter Pancard Number : ");
        panNo = sc.nextLine();
        count = 0;
        do {
            if (count == 0) {
                System.out.print("\n\t\t\t\t\t\tPlease Enter Your Adharcard Number : ");
            } else {
                System.out.print(ANSI_RED + "\n\t\t\t\t\t\tPlease Re-Enter Your Adharcard Number : " + ANSI_RESET);
            }
            count++;
            adharNo = sc.nextLine();
        } while (adharNo.length() != 14);

        designspace(ANSI_GREEN + "\n\n\nNow set your UserId and Password\n" + ANSI_RESET);
        System.out.print("\t\t\t\t\t\tPlease Enter userid : ");
        userId = sc.nextLine();
        String temppassword;
        count = 0;
        System.out.print("\n\t\t\t\t\t\tSet Your Password : ");
        password = sc.nextLine();
        do {
            if (count == 0) {
                System.out.print("\n\t\t\t\t\t\tConfirm Your Password : ");
            } else {
                System.out.print(ANSI_RED + "\n\t\t\t\t\t\tRe-Confirm Your Password : " + ANSI_RESET);
            }
            count++;
            temppassword = sc.nextLine();
        } while (!password.equals(temppassword));
        do {

            accountNo = String.format("%d", accountNoInt);
        } while ((accountNoInt / 10000000) == 1);
        System.out.println("\n");
        designspace(ANSI_GREEN + "Your Account No is : " + accountNo + ANSI_RESET);
        User new_node = new User(userId, accountNo, mobileNo, fullName, gmail, adress, panNo, adharNo, password);
        write_to_excel(new_node);
        System.out.println("\n");
        designspace(ANSI_YELLOW + "Now Restart Your Application\n" + ANSI_RESET);
    }

    public static void login() throws IOException {
        Scanner sc = new Scanner(System.in);
        String uid, ps;
        System.out.println(
                ANSI_RED + "\t--------------------------------------------------------------------------------------------------"
                        + ANSI_RESET);

        System.out.println(
                ANSI_RED + "\t__________________________________________________________________________________________________"
                        + ANSI_RESET);
        System.out.println();
        System.out.println();
        inputformat("Please Enter UserId : ");
        uid = sc.next();
        System.out.println();
        inputformat("Enter password : ");
        ps = sc.next();
        System.out.println("\n");
        loading();
        System.out.print("\033[H\033[2J");
        System.out.flush();

        int row = count(".\\User.csv");

        int loginCheck = loginUserRow(".\\User.csv", uid);
        if (loginCheck == -1) {
            designspace(ANSI_RED + "No user Found with this User-ID" + ANSI_RESET);
        } else {
            boolean passcheck = passwordCheck(".\\User.csv", ps);
            if (passcheck) {
                designspace(ANSI_GREEN + "Congo, Login Successfully !!\n" + ANSI_RESET);
                System.out.println();
                services(loginCheck);
            } else {
                designspace(ANSI_RED + "Invalid credentials !!! \n" + ANSI_RESET);
                System.out.println("\n");
                designspace("1. If You Want To Login Again");
                System.out.println();
                designspace("2. Exit");
                int now_choice;
                System.out.println();
                System.out.print("\n\t\t\t\t\t\tEnter Your Choice : ");
                now_choice = sc.nextInt();
                System.out.println();
                switch (now_choice) {
                    case 1:
                        login();
                        break;

                    case 2:
                        System.out.println("\n");
                        System.out.print(ANSI_GREEN + "\t\t\t\t\t\tThanks For Using Our Application" + ANSI_RESET);
                        System.exit(0);
                        break;
                    default:
                        designspace(ANSI_RED + "Enter Valid Choice" + ANSI_RESET);
                }
            }
        }
    }

    public static void services(int logincheck) throws IOException {

        int serviceschoice = 0;
        do {
            System.out.println(
                    ANSI_RED + "\t__________________________________________________________________________________________________"
                            + ANSI_RESET);
            System.out.println(
                    ANSI_RED + "\t--------------------------------------------------------------------------------------------------"
                            + ANSI_RESET);
            System.out.println();
            Scanner sc = new Scanner(System.in);
            designspace(ANSI_CYAN + "To Use Our Services Enter Correct Mention Below\n");
            designspace("1. Deposite");
            designspace("2. Withdraw");
            designspace("3. Check Balance");
            designspace("4. Check Bank Details");
            designspace("5. Update Bank Details");
            designspace("6. Exit" + ANSI_RESET);
            System.out.println();

            System.out.println(
                    ANSI_RED + "\t__________________________________________________________________________________________________"
                            + ANSI_RESET);

            System.out.println(
                    ANSI_RED + "\t--------------------------------------------------------------------------------------------------"
                            + ANSI_RESET);
            System.out.print("\n\n\t\t\t\t\t\tPlease Enter Choice : ");
            serviceschoice = sc.nextInt();
            int changechoice;
            switch (serviceschoice) {
                case 1:
                    String deposite_ammount;
                    System.out.println();
                    inputformat("Enter Amount To Deposite : ");
                    deposite_ammount = sc.next();
                    String curr = currenBalance(".\\User.csv", logincheck);

                    int currentBalance = Integer.parseInt(curr);
                    int deposite = Integer.parseInt(deposite_ammount);
                    currentBalance += deposite;
                    String current = String.valueOf(currentBalance);

                    updateCSV(".\\User.csv", current, logincheck, 9);
                    System.out.println();
                    designspace(ANSI_GREEN + "Congo, Your Ammount Deposited Successfully In Your Account" + ANSI_RESET);
                    System.out.println("\n");
                    System.out.println();
                    loading();
                    break;

                case 2:
                    int withdrwal_amount;
                    System.out.println();
                    inputformat("Enter Amout to Withdraw : ");
                    withdrwal_amount = sc.nextInt();
                    int currBalance = Integer.parseInt(currenBalance(".\\User.csv", logincheck));
                    if (withdrwal_amount > currBalance) {
                        System.out.println();
                        designspace(ANSI_RED + "Not Enough Balance in your Acccount" + ANSI_RESET);
                        System.out.println("\n");
                        System.out.println();
                        loading();
                    } else {
                        String update_balance = String.valueOf((currBalance - withdrwal_amount));
                        updateCSV(".\\User.csv", update_balance, logincheck, 9);
                        System.out.println("\n");

                        System.out.println();
                        System.out.print(ANSI_BLUE + "\t\t\t\t\t\tYour Withdrwal Is In Process.");
                        try {
                            Thread.sleep(800);
                            System.out.print(".");
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        try {
                            Thread.sleep(800);
                            System.out.print(".");
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        try {
                            Thread.sleep(800);
                            System.out.print(".");
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        try {
                            Thread.sleep(800);
                            System.out.print(".");
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        try {
                            Thread.sleep(800);
                            System.out.print("." + ANSI_RESET);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        System.out.println(ANSI_GREEN
                                + "\n\n\n\t\t\t\t\t\tCongrats, You Have Successfully Withdrawn Your Ammount.\n"
                                + ANSI_RESET);
                        loading();
                    }
                    break;

                case 3:
                    String balancebank = currenBalance(".\\User.csv", logincheck);
                    System.out.println(ANSI_GREEN + "\n\t\t\t\t\t\tYour Bank Balance Is : " + balancebank + ANSI_RESET);
                    System.out.println("\n");
                    loading();
                    break;

                case 5:
                    System.out.println("\n");
                    designspace("1. To Change gmail Adress");
                    System.out.println();
                    designspace("2. To Reset password");
                    System.out.print("\n\t\t\t\t\t\tTo Change Details Enter Number Accrodingly : ");
                    changechoice = sc.nextInt();
                    System.out.println();
                    switch (changechoice) {
                        case 1:
                            String updategmail;
                            System.out.println();
                            inputformat("Enter New Email Which You want To link : ");
                            updategmail = sc.next();

                            updateCSV(".\\User.csv", updategmail, logincheck, 4);
                            System.out.println();
                            designspace(ANSI_GREEN + "Gmail Updated !!" + ANSI_RESET);
                            System.out.println();
                            break;

                        case 2:
                            String newpass, newconfirm;
                            System.out.println();
                            inputformat("Enter New Password : ");
                            newpass = sc.next();
                            System.out.println();
                            inputformat("Confirm Password : ");
                            newconfirm = sc.next();

                            if (newpass.equals(newconfirm)) {
                                updateCSV(".\\User.csv", newpass, logincheck, 8);
                                System.out.println();
                                designspace(ANSI_GREEN + "PassWord Updated !!" + ANSI_RESET);
                            } else {
                                System.out.println();
                                designspace(ANSI_RED + "Please Enter Same Password !!\n" + ANSI_RESET);
                            }
                            System.out.println("\n");
                            System.out.print(ANSI_YELLOW + "\t\t\t\t\t\tNow Restart Your Application" + ANSI_RESET);
                            System.exit(0);
                            break;

                        default:

                            designspace(ANSI_RED + "Enter Valid Choice To Chnage Details !!!" + ANSI_RESET);
                            break;
                    }
                    loading();
                    break;

                case 4:
                    System.out.println();
                    System.out.println("\n\t\t\t\t\t\tBank Details Are Shown Below\n");
                    System.out.println("\n\t\t\t\t\t\t User ID : " + logindataa(".\\User.csv", logincheck, 0));
                    System.out.println(
                            "\n\t\t\t\t\t\t Bank Account Number : " + logindataa(".\\User.csv", logincheck, 1));
                    System.out.println("\n\t\t\t\t\t\t Mobile Number : " + logindataa(".\\User.csv", logincheck, 2));
                    System.out.println("\n\t\t\t\t\t\t Accountant Name : " + logindataa(".\\User.csv", logincheck, 3));
                    System.out.println("\n\t\t\t\t\t\t Gmail Adress : " + logindataa(".\\User.csv", logincheck, 4));
                    System.out.println("\n\t\t\t\t\t\t Home Adress : " + logindataa(".\\User.csv", logincheck, 5));
                    System.out.println("\n\t\t\t\t\t\t Pancard Number : " + logindataa(".\\User.csv", logincheck, 6));
                    System.out.println("\n\t\t\t\t\t\t Adharcard Number : " + logindataa(".\\User.csv", logincheck, 7));
                    System.out.println("\n\t\t\t\t\t\t PassWord : " + logindataa(".\\User.csv", logincheck, 9));
                    System.out.println("\n");
                    loading1();
                    break;

                case 6:
                    System.out.println("\n");
                    System.out.print(ANSI_GREEN + "\t\t\t\t\t\tThanks For Using Our Application" + ANSI_RESET);
                    System.exit(0);
                    break;

                default:
                    System.out.println(ANSI_RED
                            + "\n\n\n\t\t\t\t\t\tPlease Enter Valid Choice To Use Our Services\n\n\n" + ANSI_RESET);
                    loading();

                    break;
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();

        } while (serviceschoice != 6);
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK = "\u001B[30m";

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println(
                ANSI_RED + "\t__________________________________________________________________________________________________"
                        + ANSI_RESET);
        System.out.println(
                ANSI_RED + "\t--------------------------------------------------------------------------------------------------"
                        + ANSI_RESET);

        System.out.println();
        designspace(ANSI_YELLOW + "Welcome to My Bank Aplicatoin\n" + ANSI_RESET);
        System.out.println(
                ANSI_RED + "\t__________________________________________________________________________________________________"
                        + ANSI_RESET);
        System.out.println(
                ANSI_RED + "\t--------------------------------------------------------------------------------------------------"
                        + ANSI_RESET);

        System.out.println();

        designspace(ANSI_GREEN + "1. Register\n" + ANSI_RESET);
        designspace(ANSI_GREEN + "2. Login\n" + ANSI_RESET);

        System.out.println(
                ANSI_RED + "\t--------------------------------------------------------------------------------------------------"
                        + ANSI_RESET);

        int registerChoice;
        System.out.println();
        inputformat("Please Enter Choice : ");
        registerChoice = sc.nextInt();
        System.out.println();

        switch (registerChoice) {
            case 1:
                register();

                break;

            case 2:
                login();
                break;

            default:
                designspace("Please Enter Valid Choice To Use Our App\n");
        }
    }
}