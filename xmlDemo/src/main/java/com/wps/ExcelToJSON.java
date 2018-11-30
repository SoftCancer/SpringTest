package com.wps;

import com.ygx.readxml.ReadXML;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.helpers.Util;

import java.io.File;
import java.io.IOException;

import static org.slf4j.helpers.Util.safeGetSystemProperty;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/23 15:21
 * @Version: 1.0
 */
public class ExcelToJSON {

    public static void ExcelToJson(){

        Sheet sheet;

        Workbook workbook;

        Cell cell, cell1,cell2,cell3,cell4,cell5,cell6,cell7;

        JSONArray jsonArray = new JSONArray();
        try {
            String path = "D://公司文件/bb.xls";
            String ext = path.substring(path.lastIndexOf("."));
            if (ext.equals(".xlsx")){
                //
                workbook = Workbook.getWorkbook(new File(path));
            }else if (".xls".equals(ext)){
                //
                workbook = Workbook.getWorkbook(new File(path));
            }else {
                //
                workbook = null;
            }

           //
           sheet = workbook.getSheet(0);
            System.out.println("Rows:"+sheet.getRows());
            System.out.println("Name:"+sheet.getName());
            System.out.println("getColumns::"+sheet.getColumns());
           //
//            for (int j = 0; j < sheet.getColumns(); j++) {

                for (int i = 1; i < sheet.getRows(); i++) {
                    // 列  ， 行
                    cell = sheet.getCell(0,i);
                    cell1 = sheet.getCell(1,i);
                    cell2 = sheet.getCell(2,i);
                    cell3 = sheet.getCell(3,i);
                    cell4 = sheet.getCell(4,i);
                    cell5 = sheet.getCell(5,i);
                    cell6 = sheet.getCell(6,i);
                    cell7 = sheet.getCell(7,i);
//                System.out.println(sheet.getCell(i,i));
                    System.out.println("cell.getContents():"+cell.getContents());
                    if("".equals(cell.getContents())){
                        break;
                    }

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("",cell.getContents());


                }
//            }



        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
//        ExcelToJson();

//        boolean boo = Util.safeGetBooleanSystemProperty();
        String value = safeGetSystemProperty("slf4j.detectLoggerNameMismatch");
       String  result = System.getProperty("slf4j.detectLoggerNameMismatch");
        System.out.println(result);
        System.out.println(value);
        System.out.println(value == null ? false : value.equalsIgnoreCase("true"));

    }
}
