package Spending;

import java.sql.*;
import java.util.ArrayList;

public class Receipts extends Spending{
//    int Status = setFormat(1);
    public Receipts(int idReceipt, int totalprice, String note, String date, int format) {
        super(idReceipt, totalprice, note, date, format);
    }
    public Receipts(){};
    //thêm phiếu thu

    public void insertpb(int a,String b,String c) throws SQLException {

        String sql="INSERT INTO `receipts`(`Totalprice`, `Note`, `Date`, `Format`) VALUES (?,?,?,1)";
        Connection con = conn.connection();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, a);
        stmt.setString(2, b);
        stmt.setString(3, c);
        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }
        conn.close();
    }
// danh sách phiếu thu
    public ArrayList<Spending> getpt() throws SQLException {
        ArrayList<Spending> pb = new ArrayList<Spending>();
        Connection con = conn.connection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM `receipts` WHERE `Format`=1");
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


}
