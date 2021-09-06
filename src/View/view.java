package View;
import Controller.database;
import Spending.*;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class view {
    public static void main(String[] args) {
        int choice = 0;
        String b,c;
        int a;
        var Spending = new Spending();
        var Receipt = new Receipts();
        var Paymets = new Payments();
        var Spend = new ArrayList<Spending>();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("_______________MENU_______________");
            System.out.println("1. Hien thi tất cả tiêu dùng.");
            System.out.println("2. Hiển thị phiếu thu");
            System.out.println("3. Thêm một phiếu thu");
            System.out.println("4. Tổng số tiền đã thu");
            System.out.println("5. Hiển thị phiếu chi");
            System.out.println("6. Thêm một phiếu chi");
            System.out.println("7. Tổng số tiền đã Chi");
            System.out.println("0. Thoát khỏi ứng dụng.");
            System.out.println("Bạn chọn ? ");

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("_____________________________________________");
                    System.out.println("Nom mà kiểm soát chi tiêu đấy :)))!");
                    break;
                case 1:
                    System.out.println("_________________Thông tin pb tiêu dùng_________________");
                    try {
                        Spend = Spending.getAllPb();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    finally {
                        if (Spend != null) {
                            showPbInfo(Spend);
                        }
                    }
                    break;
                case 2:
                    System.out.println("_________________Thông tin phiếu thu_________________");
                    try {
                        Spend = Receipt.getpt();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    finally {
                        if (Spend != null) {
                            showPbInfo(Spend);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Nhập Năm/Tháng/Ngày thu: ");
                    c = scanner.nextLine();
                    System.out.println("Phiếu thu cho : ");
                    b = scanner.nextLine();
                    System.out.println("Số tiền thu vào : ");
                    a = scanner.nextInt();
                    try {
                        Receipt.insertpb(a,b,c);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Tổng số tiền đã thu:" + Spending.sumpt());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("_________________Thông tin phiếu chi_________________");
                    try {
                        Spend = Paymets.getpt();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    finally {
                        if (Spend != null) {
                            showPbInfo(Spend);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Nhập Năm/Tháng/Ngày thu: ");
                    c = scanner.nextLine();
                    System.out.println("Phiếu thu cho : ");
                    b = scanner.nextLine();
                    System.out.println("Số tiền thu vào : ");
                    a = scanner.nextInt();
                    try {
                        Paymets.insertpb(a,b,c);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case 7:
                    try {
                        System.out.println("Tổng số tiền đã thu:" + Spending.sumpc());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
            }

        }while (choice != 0);
    }

    private static void showPbInfo(ArrayList<Spending> pb) {
        for (var b : pb) {
            System.out.println(b);
        }
    }
}
