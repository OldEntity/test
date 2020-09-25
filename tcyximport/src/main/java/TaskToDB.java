import com.shuying.DBtoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskToDB {
    public static void main(String[] args) {

        TaskToDB taskToDB=new TaskToDB();
        DBtoDB dBtoDB=new DBtoDB();
        //获取源数据库链接
        Connection tchztConn = dBtoDB.getTchztConn();
        //获取目标数据库连接
        Connection dataflyingConn = dBtoDB.getDataflyingConn();
        try {
            List<String[]> strings = taskToDB.queryCminfo(tchztConn);
            taskToDB.insertDataflyingCmIfo(dataflyingConn,strings);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public List<String[]> queryCminfo(Connection connection) throws SQLException {
        PreparedStatement pstmt;

        String   sql="select * from ( select rownum as rn,A.*  from CURRENTTASK A ) rt where rt.RN>='0' AND rt.RN<'1677'";
        List<String[]> list=new ArrayList<>();

        try {
            pstmt = connection.prepareStatement(sql);
            //建立一个结果集，用来保存查询出来的结果
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String[] tch=new String[18];
                String BUSI_SERIAL_NO = rs.getString("BUSI_SERIAL_NO");
                String BILL_DATE = rs.getString("BILLDATE");
                String BILL_NUM = rs.getString("BILLNUM");
                String BILL_TYPE = rs.getString("BILLTYPE");
                String BILL_TYPE_NAME = rs.getString("BILLTYPENAME");
                String CASH = rs.getString("CASH");
                String GROUP_ID = rs.getString("GROUPID");
                String ORG_CODE = rs.getString("ORGCODE");
                String ORG_NAME = rs.getString("ORGNAME");
                String PK_BILL_TYPE = rs.getString("PK_BILLTYPE");
                String SCAN_TYPE = rs.getString("SCANTYPE");
                String SCAN_TYPE_NAME = rs.getString("SCANTYPENAME");
                String SYSTEM_CODE = rs.getString("SYSTEMCODE");
                String TASK_STATE = rs.getString("TASKTYPE");
                String TASK_STATE_NAME = rs.getString("TASKTYPENAME");
                String USER_ID = rs.getString("USER_NO");
                String USER_NAME = rs.getString("USER_NAME");
                String USER_NUM = rs.getString("USER_NUM");


                tch[17]=USER_NUM;
                tch[16]=USER_NAME;
                tch[15]=USER_ID;
                tch[14]=TASK_STATE_NAME;
                tch[13]=TASK_STATE;
                tch[12]=SYSTEM_CODE;
                tch[11]=SCAN_TYPE_NAME;
                tch[10]=SCAN_TYPE;
                tch[9]=PK_BILL_TYPE;
                tch[8]=ORG_NAME;
                tch[7]=ORG_CODE;
                tch[6]=GROUP_ID;
                tch[5]=CASH;
                tch[4]=BILL_TYPE_NAME;
                tch[3]=BILL_TYPE;
                tch[2]=BILL_NUM;
                tch[1]=BILL_DATE;
                tch[0]=BUSI_SERIAL_NO;
                list.add(tch);

            }
            rs.close();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertDataflyingCmIfo(Connection connection,List<String[]> list) throws Exception {
        String sql = "INSERT INTO CURRENT_TASK"+
                " (BUSI_SERIAL_NO,BILL_DATE,BILL_NUM,BILL_TYPE,BILL_TYPE_NAME,CASH,GROUP_ID,ORG_CODE,ORG_NAME,PK_BILL_TYPE,"+
                "SCAN_TYPE,SCAN_TYPE_NAME,SYSTEM_CODE,TASK_STATE,TASK_STATE_NAME,USER_ID,USER_NAME,USER_NUM)"+
                "VALUES"+
                "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
        PreparedStatement pstmt ;

        // 下面是针对数据库的具体操作
        try
        {
            ;
            pstmt = connection.prepareStatement(sql) ;
            pstmt.setString(1,list.get(0).toString()) ;
            pstmt.setString(2,list.get(1).toString()) ;
            pstmt.setString(3,list.get(2).toString()) ;
            pstmt.setString(4,list.get(3).toString()) ;
            pstmt.setString(5,list.get(4).toString()) ;
            pstmt.setString(6,list.get(5).toString()) ;
            pstmt.setString(7,list.get(6).toString()) ;
            pstmt.setString(8,list.get(7).toString()) ;
            pstmt.setString(9,list.get(8).toString()) ;
            pstmt.setString(10,list.get(9).toString()) ;
            pstmt.setString(11,list.get(10).toString()) ;
            pstmt.setString(12,list.get(11).toString()) ;
            pstmt.setString(13,list.get(12).toString()) ;
            pstmt.setString(14,list.get(13).toString()) ;
            pstmt.setString(15,list.get(14).toString()) ;
            pstmt.setString(16,list.get(15).toString()) ;
            pstmt.setString(17,list.get(16).toString()) ;
            pstmt.setString(18,list.get(17).toString()) ;
            // 进行数据库更新操作
            pstmt.executeUpdate() ;
            pstmt.close() ;
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        finally
        {
            // 关闭数据库连接
            connection.close() ;
        }
    }

}
