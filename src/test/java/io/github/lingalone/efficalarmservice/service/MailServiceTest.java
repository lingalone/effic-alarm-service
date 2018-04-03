package io.github.lingalone.efficalarmservice.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Autowired
    TemplateEngine templateEngine;

    @Test
    public void sendSimpleMail() throws Exception {
        mailService.sendSimpleMail("1020222580@qq.com","你好，你有一条告警信息。","xxxxx 系统异常");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("1020222580@qq.com","你好，你有一条告警信息。",content);
    }


    @Test
    public void sendAttachmentsMail() {
        String filePath="C:\\Users\\owner\\Downloads\\BBD增加 (1).png";
        mailService.sendAttachmentsMail("1020222580@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\owner\\Downloads\\BBD增加 (1).png";

        mailService.sendInlineResourceMail("1020222580@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }


    @Test
    public void sendTemplateMail() {

        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("1020222580@qq.com","主题：这是模板邮件",emailContent);
    }

}