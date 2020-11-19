package com.zr.template.word;

import com.zr.template.domain.User;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class WordService {

    // 报告图片位置的书签名
    private static final String bookmark = "tpBookmark";


    public void exportBg(OutputStream out) throws Exception {
        String srcPath = "e://word//demoa.docx";
        String targetPath = "e://demo2.docx";
        // 在文档中需要替换插入表格的位置
        String key = "{{key}}";
        XWPFDocument doc = null;
        File targetFile = null;
        doc = new XWPFDocument(POIXMLDocument.openPackage(srcPath));
        List<XWPFParagraph> paragraphList = doc.getParagraphs();
        if (paragraphList != null && paragraphList.size() > 0) {
            for (XWPFParagraph paragraph : paragraphList) {
                System.out.println(paragraph);
                List<XWPFRun> runs = paragraph.getRuns();
                for (XWPFRun run : runs) {
                    if(run.getText(0)!=null){
                        String text = run.getText(0).trim();
                        System.out.println(text);
                        if (text.contains(key)) {
                            run.setText(text.replace(key, ""), 0);
                            XmlCursor cursor = paragraph.getCTP().newCursor();
                            // 在指定游标位置插入表格
                            XWPFTable table = doc.insertNewTbl(cursor);
                            CTTblPr tablePr = table.getCTTbl().getTblPr();
                            CTTblWidth width = tablePr.addNewTblW();
                            width.setW(BigInteger.valueOf(8500));
                            this.inserInfo(table);
                        }
                    }
                }
            }
        }
        doc.write(out);
        out.flush();
        out.close();
    }

    /**
     * 把信息插入表格
     * @param table
     */
    private void inserInfo(XWPFTable table) {
        //需要插入的数据
        List<User> data = new ArrayList<>();
        User user = new User();
        user.setAddress("xxx");
        data.add(user);
        XWPFTableRow row = table.getRow(0);
        XWPFTableCell cell = null;
        //默认会创建一列，即从第2列开始
        for (int col = 1; col < 6; col++) {
            // 第一行创建了多少列，后续增加的行自动增加列
            CTTcPr cPr =row.createCell().getCTTc().addNewTcPr();
            CTTblWidth width = cPr.addNewTcW();
            if(col==1||col==2||col==4){
                width.setW(BigInteger.valueOf(2000));
            }
        }
        row.getCell(0).setText("指标");
        row.getCell(1).setText("指标说明");
        row.getCell(2).setText("公式");
        row.getCell(3).setText("参考值");
        row.getCell(4).setText("说明");
        row.getCell(5).setText("计算值");


        for(User item : data){
            row = table.createRow();
            row.getCell(0).setText(item.getAddress());
            cell = row.getCell(1);
            cell.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000));
            cell.setText(item.getAddress());
            cell = row.getCell(2);
            cell.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000));
            cell.setText(item.getAddress());
            if(item.getAddress()!=null&&!item.getAddress().contains("$")){
                row.getCell(3).setText(item.getAddress());
            }
            cell = row.getCell(4);
            cell.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000));
            cell.setText(item.getAddress());
            row.getCell(5).setText(item.getAddress()==null?"无法计算":item.getAddress());
        }
    }

}
