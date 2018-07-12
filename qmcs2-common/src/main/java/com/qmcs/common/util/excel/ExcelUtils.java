/**
 * ClassName:ExcelReader.java
 * Author: liuchunxu
 * CreateTime: 3 15, 2015 11:16:29 AM
 * Description:Excel数据工具类，POI实现，兼容Excel2003，及Excel2007
 **/
package com.qmcs.common.util.excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName(类名) : ExcelUtils
 * @Description(描述) : Excel数据工具类，POI实现，兼容Excel2003，及Excel2007
 * @author(作者) ：suyl
 */
public class ExcelUtils {
    static Workbook wb = null;

    /**
     *
     * @Description(功能描述) : EXCEL导出
     * @author(作者) ： suyl
     * @date (开发日期) : 2015年3月24日 下午4:23:14
     * @param response
     *            HttpServletResponse
     * @param title
     *            String sheet标签
     * @param headers
     *            String[] 表头数组  如：  {"姓名,name","性别,sex","年龄,age"}    数组中每一个元素格式：      表头,实体属性字段名
     * @param dataset
     *            List<T> 数据集合泛型为entity或vo
     * @param pattern
     *            String 日期格式字符串
     * @param filename
     *            void 文件名
     */
    @SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
    public static <T> void exportExcel(HttpServletResponse response, String title, String[] headers, List<T> dataset,
                                       String pattern, String filename) throws Exception{
        OutputStream out = new BufferedOutputStream(response.getOutputStream());
        try {
            response.reset();
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("gb2312"), "iso8859-1") + ".xls");
            // response.addHeader("Content-Length", "" + file.getFile_size());
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");// 定义输出类型
            response.setCharacterEncoding("utf-8");
            // 声明一个工作薄
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 生成一个表格
            HSSFSheet sheet = workbook.createSheet(title);
            // 设置表格默认列宽度为15个字节
            sheet.setDefaultColumnWidth((short) 18);
            // 生成一个样式
            HSSFCellStyle style = workbook.createCellStyle();
            // 设置这些样式
            style.setFillForegroundColor(HSSFColor.WHITE.index);
            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            style.setBorderRight(HSSFCellStyle.BORDER_THIN);
            style.setBorderTop(HSSFCellStyle.BORDER_THIN);
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            // 生成一个字体
            HSSFFont font = workbook.createFont();
            font.setColor(HSSFColor.BLACK.index);
            font.setFontHeightInPoints((short) 12);
            font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
            // 把字体应用到当前的样式
            style.setFont(font);

            // 声明一个画图的顶级管理器
            HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
            // 定义注释的大小和位置,详见文档
            // HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6,
            // 5));
            // 设置注释内容
            // comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
            // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
            // comment.setAuthor("leno");

            int type=0;    //0:全部集合内容与表头对应下载，  1： 指定集合中部分内容下载
            // 产生表格标题行
            HSSFRow row = sheet.createRow(0);
            for (short i = 0; i < headers.length; i++) {
                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(style);
                String[] strHeader=headers[i].split(",");
                HSSFRichTextString text = new HSSFRichTextString(strHeader[0]);
                cell.setCellValue(text);
                if(strHeader.length>1){
                    type=1;
                }
            }

            // 遍历集合数据，产生数据行
            Iterator<T> it = dataset.iterator();
            int index = 0;
            while (it.hasNext()) {
                index++;
                row = sheet.createRow(index);
                T t = (T) it.next();
                // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
                Field[] fields = t.getClass().getDeclaredFields();
                if(type==1){   //{"姓名,name","性别,sex","年龄,age"}   指定部分内容下载
                    for(short j = 0; j < headers.length; j++){
                        String[] strHeader=headers[j].split(",");
                        for (short i = 0; i < fields.length; i++) {
                            Field field = fields[i];
                            String fieldName = field.getName();
                            if(!fieldName.equals(strHeader[1])){
                                continue;
                            }
                            HSSFCell cell = row.createCell(j);
                            cell.setCellStyle(style);
                            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                            Class tCls = t.getClass();
                            Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
                            Object value = getMethod.invoke(t, new Object[] {});
                            // 判断值的类型后进行强制类型转换
                            String textValue = null;
                            if (value instanceof Date) {
                                Date date = (Date) value;
                                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                                textValue = sdf.format(date);
                            } else if (value instanceof byte[]) {
                                // 有图片时，设置行高为60px;
                                row.setHeightInPoints(60);
                                // 设置图片所在列宽度为80px,注意这里单位的一个换算
                                sheet.setColumnWidth(i, (short) (35.7 * 80));
                                // sheet.autoSizeColumn(i);
                                byte[] bsValue = (byte[]) value;
                                HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1023, 255, (short) 6, index, (short) 6,
                                        index);
                                anchor.setAnchorType(2);
                                patriarch.createPicture(anchor, workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
                            } else {
                                // 其它数据类型都当作字符串简单处理
                                textValue = null==value?"":value.toString();
                            }
                            // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                            if (textValue != null) {
                                Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                                Matcher matcher = p.matcher(textValue);
                                if (matcher.matches()) {
                                    // 是数字当作double处理
                                    cell.setCellValue(Double.parseDouble(textValue));
                                } else {
                                    HSSFRichTextString richString = new HSSFRichTextString(textValue);
                                    cell.setCellValue(richString);
                                }
                            }

                        }

                    }
                }else{
                    for (short i = 0; i < fields.length; i++) {
                        Field field = fields[i];
                        String fieldName = field.getName();
                        HSSFCell cell = row.createCell(i);
                        cell.setCellStyle(style);
                        String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                        Class tCls = t.getClass();
                        Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
                        Object value = getMethod.invoke(t, new Object[] {});
                        // 判断值的类型后进行强制类型转换
                        String textValue = null;
                        if (value instanceof Date) {
                            Date date = (Date) value;
                            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                            textValue = sdf.format(date);
                        } else if (value instanceof byte[]) {
                            // 有图片时，设置行高为60px;
                            row.setHeightInPoints(60);
                            // 设置图片所在列宽度为80px,注意这里单位的一个换算
                            sheet.setColumnWidth(i, (short) (35.7 * 80));
                            // sheet.autoSizeColumn(i);
                            byte[] bsValue = (byte[]) value;
                            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1023, 255, (short) 6, index, (short) 6,
                                    index);
                            anchor.setAnchorType(2);
                            patriarch.createPicture(anchor, workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
                        } else {
                            // 其它数据类型都当作字符串简单处理
                            textValue = null==value?"":value.toString();
                        }
                        // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                        if (textValue != null) {
                            Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                            Matcher matcher = p.matcher(textValue);
                            if (matcher.matches()) {
                                // 是数字当作double处理
                                cell.setCellValue(Double.parseDouble(textValue));
                            } else {
                                HSSFRichTextString richString = new HSSFRichTextString(textValue);
                                cell.setCellValue(richString);
                            }
                        }

                    }
                }
            }
            workbook.write(out);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
