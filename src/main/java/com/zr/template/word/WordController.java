package com.zr.template.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * @Author: 曾睿
 * @Date: 2020/11/19 10:01
 */
@Controller
@RequestMapping("/")
public class WordController {

    @Autowired
    private WordService wordService;

    @RequestMapping("/ww")
    public void exportBg(HttpServletResponse response) throws Exception {
            response.setContentType("application/octet-stream");
            String name = "报告";
            response.addHeader("Content-Disposition", "attachment;filename="+new String(name.getBytes(),"iso-8859-1") +".docx");
            OutputStream out = response.getOutputStream();
            wordService.exportBg(out);
    }

}
