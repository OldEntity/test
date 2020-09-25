import com.google.common.io.Files;
import com.shuying.commons.utils.ThumbUtil;
import com.shuying.dataflying.service.SerNumService;
import com.shuying.dataflying.service.impl.SerNumServiceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.*;

public class DBtoDB {

    private  Connection getTchztConn() {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
        String username = "TIMSSP3";
        String password = "123123123";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private  Connection getDataflyingConn() {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
        String username = "yx";
        String password = "yx";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public   List<String[]>  queryCminfo(Connection connection) throws SQLException{
        PreparedStatement pstmt;

        String   sql="select * from ( select rownum as rn,A.*  from CM_INFO  A ) rt where rt.RN>='0' AND rt.RN<'1227'";
        List<String[]> list=new ArrayList<>();

        try {
            pstmt = connection.prepareStatement(sql);
            //建立一个结果集，用来保存查询出来的结果
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String[] tch=new String[3];
                String BUSI_SERIAL_NO = rs.getString("BUSI_SERIAL_NO");
                String BATCH_ID = rs.getString("BATCH_ID");
                String OPERATE_TIME = rs.getString("OPERATE_TIME");

                tch[2]=OPERATE_TIME;
                tch[1]=BATCH_ID;
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

    public   List<Map<String,String>>  queryCmfileinfo(String BATCH_ID,Connection connection) throws SQLException{
        PreparedStatement pstmt;
        String sql="select * from CM_FILE_INFO where BATCH_ID='"+BATCH_ID+"'";
        List<Map<String,String>> list=new ArrayList<>();

        try {
            pstmt = connection.prepareStatement(sql);
            //建立一个结果集，用来保存查询出来的结果
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                Map<String,String> map=new HashMap<>();

                map.put("CIP_",rs.getString("CIP"));

                map.put("DOCNAME_",rs.getString("DOC_NAME"));

                map.put("FILEFORMAT_","0");

                map.put("FILEMD5_",rs.getString("FILE_MD5"));

                map.put("FILENAME_",rs.getString("FILE_NAME"));

                map.put("FILESIZE_",rs.getString("FILE_SIZE"));

                map.put("SORT_",rs.getString("FILE_SEQ"));

                list.add(map);

            }
            rs.close();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertDataflyingCmIfo(Connection connection,String BATCH_ID,String BUSINESS_SERIAL_NO,String OPERATE_TIME) throws Exception {
            String sql = "INSERT INTO CM_INFO (ID,BATCH_ID,BUSINESS_SERIAL_NO,OPERATE_TIME) VALUES (?,?,?,?)" ;
            PreparedStatement pstmt ;

            // 下面是针对数据库的具体操作
            try
            {
          ;
                pstmt = connection.prepareStatement(sql) ;
                pstmt.setString(1, UUID.randomUUID().toString()) ;
                pstmt.setString(2,BATCH_ID) ;
                pstmt.setString(3,BUSINESS_SERIAL_NO) ;
                pstmt.setString(4,OPERATE_TIME) ;
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

    public void insertDataflyingCmFileInfo(Connection connection, Map<String,String> map,String fileId,String batchID,String createTime) throws Exception {
        String sql = "INSERT INTO IMAGE_FILES_INFO " +
                "(FILEID_, BATCHID_, CIP_, CREATETIME_, DOCNAME_, FILEFORMAT_, FILEMD5_, FILENAME_, FILESIZE_,   OPERATESTATE_, SORT_) " +
                "VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?)" ;
        PreparedStatement pstmt ;

        // 下面是针对数据库的具体操作
        try
        {
            pstmt = connection.prepareStatement(sql) ;
            pstmt.setString(1,fileId) ;
            pstmt.setString(2,batchID);
            pstmt.setString(3,map.get("CIP_"));
            pstmt.setString(4,createTime);
            pstmt.setString(5,map.get("DOCNAME_"));
            pstmt.setString(6,"old");
            pstmt.setString(7,map.get("FILEMD5_"));
            pstmt.setString(8,map.get("FILENAME_"));
            pstmt.setString(9,map.get("FILESIZE_"));
            pstmt.setString(10,"1");
            System.out.println(map.get("CIP_"));
            System.out.println(map.get("DOCNAME_"));
            System.out.println(map.get("FILEMD5_"));
            System.out.println(map.get("FILENAME_"));
            System.out.println(map.get("FILESIZE_"));
            System.out.println(Integer.valueOf(map.get("SORT_")));
            pstmt.setInt(11,Integer.valueOf(map.get("SORT_")));
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


    public static void main(String[] args) throws Exception {

        DBtoDB dBtoDB=new DBtoDB();

        List<String[]> tchcminfo= dBtoDB.queryCminfo(dBtoDB.getTchztConn());

        String tchztPath="D:\\tchzt\\tchzt";

       for(int i=0;i<tchcminfo.size();i++){

           String[] tchcminforesult=  tchcminfo.get(i);

           SerNumService serNumService=new SerNumServiceImpl();

           String BATCH_ID =tchcminforesult[1];

           String dataBatchId=serNumService.getNewBatchId();

           System.out.println(dataBatchId);

           String yyyy=tchcminforesult[2].substring(0,4);

           String mm=tchcminforesult[2].substring(5,7);

           String dd=tchcminforesult[2].substring(8,10);

           dBtoDB.insertDataflyingCmIfo(dBtoDB.getDataflyingConn(),dataBatchId,tchcminforesult[0],yyyy+mm+dd);

           List<Map<String,String>> tchcmfileinfo= dBtoDB.queryCmfileinfo(BATCH_ID,dBtoDB.getTchztConn());

           for(int j=0;j<tchcmfileinfo.size();j++){

               Map map=tchcmfileinfo.get(j);

               String fileName=map.get("FILENAME_").toString();

               String fileId=UUID.randomUUID().toString();

               dBtoDB.insertDataflyingCmFileInfo(dBtoDB.getDataflyingConn(),map,fileId,dataBatchId,yyyy+"-"+mm+"-"+dd);

               File file = new File(tchztPath+"/"+yyyy+"/"+mm+"/"+yyyy+mm+dd+"/"+BATCH_ID+"/"+map.get("DOCNAME_")+"/"+fileName);

               Long l = file.length();
               byte[] filecontent = new byte[l.intValue()];
               FileInputStream fileInputStream = new FileInputStream(file);
               fileInputStream.read(filecontent);
               fileInputStream.close();
               String imagePath = getFilesPath(dataBatchId, fileId);
               File dataFile = new File(imagePath);
               Files.createParentDirs(dataFile);
               Files.write(filecontent, dataFile);
               if (ThumbUtil.isImage(fileName)) {
                   ThumbUtil.createRatioThumb(file, 160, 600, imagePath + "_");
               }

           }

       }


        System.out.println(tchcminfo.size());

    }

    public static String getFilesPath(String batchId, String fileId) {

        String separator = File.separator;

        return "D:\\1111" + separator + batchId.substring(8, 12) + separator + batchId.substring(24, 26) + separator + batchId.substring(30, 32) + separator + batchId + separator + fileId;

    }

}
