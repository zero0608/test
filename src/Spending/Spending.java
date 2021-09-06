package Spending;
import Controller.database;

import java.sql.*;
import java.util.ArrayList;

public class Spending {
    database conn = new database();
    Statement stmt = null;
    ResultSet rs = null;
    protected int IdReceipt;
    protected int Totalprice;
    protected String Note;
    protected String date;
    protected int format;
    private String note;
    public Spending(){}
    public Spending(int idReceipt, int totalprice, String note, String date, int format) {
        IdReceipt = idReceipt;
        Totalprice = totalprice;
        Note = note;
        this.date = date;
        this.format = format;
    }


    @Override
    public String toString() {
        if (format==1){
            note = "Phiếu thu";
        } else if (format == 0) {
            note = "Phiếu chi";
        }

        return "Spending{" +
                "IdReceipt=" + IdReceipt +
                ", Totalprice=" + Totalprice +
                ", Note='" + Note + '\'' +
                ", date='" + date + '\'' +
                ", format=" + note +
                '}';
    }
    public int getIdReceipt() {
        return IdReceipt;
    }

    public void setIdReceipt(int idReceipt) {
        IdReceipt = idReceipt;
    }

    public int getTotalprice() {
        return Totalprice;
    }

    public void setTotalprice(int totalprice) {
        Totalprice = totalprice;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFormat() {
        return format;
    }

    public int setFormat(int format) {
        this.format = format;
        return format;
    }
    /// list all
    public ArrayList<Spending> getAllPb() throws SQLException {
        ArrayList<Spending> pb = new ArrayList<Spending>();
        Connection con = conn.connection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM `receipts`");
        while (rs.next()) {
            int a= rs.getInt(1);
            int b= rs.getInt(2);
            String c= rs.getString(3);
            String d= rs.getString(4);
            int e= rs.getInt(5);
            Spending arr = new Spending(a,b,c,d,e);
            pb.add(arr);
        }
        conn.close();
        return pb;
    }

    public void deletepb(int a) throws SQLException{
        String sql = "DELETE FROM `receipts` WHERE `IdReceipt`=?";
        Connection con = conn.connection();
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, a);
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
        }
        conn.close();
    }
    /// tổng phiếu thu
    public int sumpt() throws SQLException {
        int sumpt = 0;
        Connection con = conn.connection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT `Totalprice` FROM `receipts` WHERE `Format`=1");
        while (rs.next()) {
            int a= rs.getInt(1);
            sumpt += a;
        }
        conn.close();
        return sumpt;
    }

    /// tổng phiếu chi
    public int sumpc() throws SQLException {
        int sumpc = 0;
        Connection con = conn.connection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT `Totalprice` FROM `receipts` WHERE `Format`=0");
        while (rs.next()) {
            int a= rs.getInt(1);
            sumpc += a;
        }
        conn.close();
        return sumpc;
    }

}
