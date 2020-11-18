package com.zr.template.word;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.word.Word07Writer;
import com.deepoove.poi.XWPFTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WordTest {

    @Test
    public void test() {
        Word07Writer writer = new Word07Writer();
        // 添加段落（标题）
        writer.addText(new Font("宋体", Font.PLAIN, 22), "我是第一部分", "我是第二部分");
        // 添加段落（正文）
        writer.addText(new Font("宋体", Font.PLAIN, 22), "我是正文第一部分", "我是正文第二部分");
        // 写出到文件
        writer.flush(FileUtil.file("e:/wordWrite.docx"));
        // 关闭
        writer.close();
    }

    @Test
    public void test2() throws IOException {
        //核心API采用了极简设计，只需要一行代码
        XWPFTemplate.compile("e://template.docx").render(new HashMap<String, Object>(){{
            put("title", "poi-tl 模板引擎");
        }}).writeToFile("e://out_template.docx");
    }
}