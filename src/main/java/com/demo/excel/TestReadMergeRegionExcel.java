/**
 * TestReadMergeRegionExcel.java  
 * Created on  9/9/15 6:26 PM
 * modify on                user            modify content
 * 9/9/15 6:26 PM        micx
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.excel;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by micx  on 2015/09/09 6:26 PM.
 */
public class TestReadMergeRegionExcel {

    private static Map<String, Object> cateMap = Maps.newHashMap();
    private static Map<String, Integer> cate2IdMap = Maps.newHashMap();
    private static List<String> cate_sql = Lists.newArrayList();
    private static List<String> poi2wm_sql = Lists.newArrayList();


    private static final String CATE_SQL = "INSERT INTO `TA_ShopMultiCategory` (`id`, `categoryname`, `parentid`, `status`, `updatetime`, `createtime`) " +
            "VALUES " +
            " (%d, '%s', %d, 1, now(), now());";
    private static final String CATE_MAPPING_SQL = "INSERT INTO `TA_ShopMultiCategoryPOI2WM` ( `poicate_id`, `poilevel`, `wmcate_id`, `valid`, `addtime`, `updatetime`)" +
            "VALUES " +
            " ( %d, %d, %d, 1, now(), now());";

    public static void main(String[] args) {
        TestReadMergeRegionExcel test = new TestReadMergeRegionExcel();
        test.readExcelToObj("/Users/micx/Desktop/shopcate.xlsx");
        parseMap();
        write2file();


    }

    private static void write2file() {

        File file = new File("/Users/micx/Desktop/shopcate.sql");
        FileWriter fw = null;
        BufferedWriter writer = null;
        try {
            fw = new FileWriter(file);
            writer = new BufferedWriter(fw);
            for (String sql:cate_sql){
                writer.write(sql);
                writer.newLine();//换行
            }

            for (String sql:poi2wm_sql){
                writer.write(sql);
                writer.newLine();//换行
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void parseMap() {
        int cate_id = 100;
        for (Map.Entry<String, Object> entry : cateMap.entrySet()){
            cate2IdMap.put(entry.getKey(), cate_id++);
        }

        for (Map.Entry<String, Object> entry_1 : cateMap.entrySet()){
            String cate1_name = entry_1.getKey();
            Integer cate1_id = cate2IdMap.get(cate1_name);
            String sqlStr = String.format(CATE_SQL, cate1_id, cate1_name, 0);
            cate_sql.add(sqlStr);
            Map<String, Object> cate2_map = (Map<String, Object>) entry_1.getValue();
            for (Map.Entry<String, Object> entry_2: cate2_map.entrySet()){
                String cate2_name = entry_2.getKey();
                Integer cate2_id = 0;
                if (!cate2_name.equals("-")) {
                    cate2_id = cate_id;
                    String sql2Str = String.format(CATE_SQL, cate2_id, cate2_name, cate1_id);
                    cate_sql.add(sql2Str);
                    cate2IdMap.put(cate2_name, cate_id++);
                }
                Map<String, Object> cateList = (Map<String, Object>) entry_2.getValue();
                List<Integer> cate1List = parseList((String) cateList.get("cate_1"));
                List<Integer> cate2List = parseList((String) cateList.get("cate_2"));
                List<String> sqlList = generatePOI2WMSql(cate1List, cate2List, cate1_id, cate2_id);
                poi2wm_sql.addAll(sqlList);


            }
        }
        System.out.printf(cate2IdMap.toString());
    }

    private static List<String> generatePOI2WMSql(List<Integer> cate1List, List<Integer> cate2List, Integer cate1_id, Integer cate2_id) {
        int wmId = cate2_id == 0 ? cate1_id : cate2_id;
        List<String> list = Lists.newArrayList();
        for (Integer poiId: cate1List){
            String sql = String.format(CATE_MAPPING_SQL, poiId, 2, wmId);
            list.add(sql);
        }

        for (Integer poiId: cate2List){
            String sql = String.format(CATE_MAPPING_SQL, poiId, 3, wmId);
            list.add(sql);
        }
        return list;
    }

    private static List<Integer> parseList(String strList) {
        List<Integer> list = Lists.newArrayList();
        if (StringUtils.isNotBlank(strList)){
            String[] split = strList.split(",");
            for (String val:split){
                int id = NumberUtils.toInt(val);
                if (id != 0){
                    list.add(id);
                }
            }
        }
        return list;
    }

    /**
     * 读取excel数据
     * @param  path
     */
    private void readExcelToObj(String path) {

        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(new File(path));
            readExcel(wb, 0, 1, 0);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取excel文件
     * @param  wb
     * @param sheetIndex sheet页下标：从0开始
     * @param startReadLine 开始读取的行:从0开始
     * @param tailLine 去除最后读取的行
     */
    private void readExcel(Workbook wb,int sheetIndex, int startReadLine, int tailLine) {

        Sheet sheet = wb.getSheetAt(sheetIndex);
        Row row = null;

        for(int i=startReadLine; i<sheet.getLastRowNum()-tailLine+1; i++) {
            Map<String, Object> map = cateMap;
            row = sheet.getRow(i);

            int col = 0;
            for(Cell c : row) {
                col++;
                c.setCellType(Cell.CELL_TYPE_STRING);
                boolean isMerge = isMergedRegion(sheet, i, c.getColumnIndex());
                //判断是否具有合并单元格
                if(isMerge) {
                    String rs = getMergedRegionValue(sheet, row.getRowNum(), c.getColumnIndex());
                    if ("null".equals(rs) || StringUtils.isBlank(rs)){
                        rs = StringUtils.EMPTY;
                    }
                    if (col < 3){
                        if (!map.containsKey(rs)) {
                            map.put(rs, Maps.newHashMap());
                        }
                        map = (Map<String, Object>) map.get(rs);
                    }else if (col == 4){
                        String old = (String) map.get("cate_2");
                        if ("null".equals(old) == false && old != null&& StringUtils.isNotBlank(old)){
                            rs =  old +","+ rs;
                        }
                        map.put("cate_2", rs);

                    }else if (col == 5){
                        String old = (String) map.get("cate_1");
                        if ("null".equals(old) == false && old != null&& StringUtils.isNotBlank(old)){
                            rs =  old +","+ rs;
                        }
                        map.put("cate_1", rs);
                    }
                    System.out.print(rs + "  ");
                }else {
                    System.out.print(c.getRichStringCellValue()+"  ");
                    String rs = c.getRichStringCellValue().toString();
                    if ("null".equals(rs) || StringUtils.isBlank(rs)){
                        rs = StringUtils.EMPTY;
                    }
                    if (col < 3){
                        if (!map.containsKey(rs)) {
                            map.put(rs, Maps.newHashMap());
                        }
                        map = (Map<String, Object>) map.get(rs);
                    }else if (col == 4){
                        String old = (String) map.get("cate_2");
                        if ("null".equals(old) == false && old != null&& StringUtils.isNotBlank(old)){
                            rs =  old +","+ rs;
                        }
                        map.put("cate_2", rs);
                    }else if (col == 5){
                        String old = (String) map.get("cate_1");
                        if ("null".equals(old) == false && old != null && StringUtils.isNotBlank(old)){
                            rs =  old +","+ rs;
                        }

                        map.put("cate_1", rs);

                    }

                }

            }
            System.out.println();

        }
        System.out.println(cateMap);

    }

    /**
     * 获取合并单元格的值
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    public String getMergedRegionValue(Sheet sheet ,int row , int column){

        int sheetMergeCount = sheet.getNumMergedRegions();

        for(int i = 0 ; i < sheetMergeCount ; i++){
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if(row >= firstRow && row <= lastRow){

                if(column >= firstColumn && column <= lastColumn){
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return getCellValue(fCell) ;
                }
            }
        }

        return null ;
    }

    /**
     * 判断合并了行
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    private boolean isMergedRow(Sheet sheet,int row ,int column) {

        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if(row == firstRow && row == lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断指定的单元格是否是合并单元格
     * @param sheet
     * @param row 行下标
     * @param column 列下标
     * @return
     */
    private boolean isMergedRegion(Sheet sheet,int row ,int column) {

        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {

            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if(row >= firstRow && row <= lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断sheet页中是否含有合并单元格
     * @param sheet
     * @return
     */
    private boolean hasMerged(Sheet sheet) {
        return sheet.getNumMergedRegions() > 0 ? true : false;
    }

    /**
     * 合并单元格
     * @param sheet
     * @param firstRow 开始行
     * @param lastRow 结束行
     * @param firstCol 开始列
     * @param lastCol 结束列
     */
    private void mergeRegion(Sheet sheet, int firstRow, int lastRow, int firstCol, int lastCol) {
        sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
    }

    /**
     * 获取单元格的值
     * @param cell
     * @return
     */
    public String getCellValue(Cell cell){

        if(cell == null) return "";

        if(cell.getCellType() == Cell.CELL_TYPE_STRING){

            return cell.getStringCellValue();

        }else if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){

            return String.valueOf(cell.getBooleanCellValue());

        }else if(cell.getCellType() == Cell.CELL_TYPE_FORMULA){

            return cell.getCellFormula() ;

        }else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){

            return String.valueOf(cell.getNumericCellValue());

        }
        return "";
    }
}
