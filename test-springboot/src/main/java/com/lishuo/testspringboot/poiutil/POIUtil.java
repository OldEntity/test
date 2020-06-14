package com.lishuo.testspringboot.poiutil;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2020-03-05 14:47
 */

public class POIUtil {


    public static void convert(){
        String path="C:\\Users\\20340\\Desktop\\NC单据数据.xls";
        Workbook wb=null;
        try {
            FileInputStream file=new FileInputStream(path);
            wb=new HSSFWorkbook(file);
            Sheet sheet =wb.getSheetAt(0);
            int firstRowNum=sheet.getFirstRowNum()+1;
            int lastRowNum=sheet.getLastRowNum();

            for (int rowNum=firstRowNum;rowNum<=lastRowNum;rowNum++){
                Row row=sheet.getRow(rowNum);
                int firstCellNum=row.getFirstCellNum()+1;
                int lastCellNum=row.getLastCellNum();
                if(null !=row){
                    for (int cellNum=firstCellNum;cellNum<lastCellNum;cellNum++){
                        Cell cell=row.getCell(cellNum);
                        if(cellNum!=lastCellNum-1){
                            System.out.print(cell.toString()+",");
                        }else{
                            System.out.print(cell.toString());
                        }
                    }
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(null!=wb){
                    wb.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }


    public static void main(String[] args) {
        convert();
    }

}
