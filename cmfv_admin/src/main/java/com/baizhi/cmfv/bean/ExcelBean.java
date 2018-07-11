package com.baizhi.cmfv.bean;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.io.Serializable;

/**
 * @ClassName ExcelBean
 * @Description 运用POI 实现 excel表格中的数据导入、导出
 * @Author Chao
 * @Date 2018/7/7 19:19
 */

public class ExcelBean implements Serializable {
    private String headTextName;//列头（标题）名
    private String propertyName;//对应字段名
    private Integer cols;//合并单元格数
    private XSSFCellStyle cellStyle;
    public ExcelBean(){
    }
    public ExcelBean(String headTextName, String propertyName){
        this.headTextName = headTextName;
        this.propertyName = propertyName;
    }
    public ExcelBean(String headTextName, String propertyName, Integer cols) {
        super();
        this.headTextName = headTextName;
        this.propertyName = propertyName;
        this.cols = cols;
    }

    @Override
    public String toString() {
        return "ExcelBean{" +
                "headTextName='" + headTextName + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", cols=" + cols +
                ", cellStyle=" + cellStyle +
                '}';
    }

    public String getHeadTextName() {
        return headTextName;
    }

    public void setHeadTextName(String headTextName) {
        this.headTextName = headTextName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Integer getCols() {
        return cols;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }

    public XSSFCellStyle getCellStyle() {
        return cellStyle;
    }

    public void setCellStyle(XSSFCellStyle cellStyle) {
        this.cellStyle = cellStyle;
    }
}
