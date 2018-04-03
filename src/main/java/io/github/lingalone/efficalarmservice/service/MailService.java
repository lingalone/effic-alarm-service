package io.github.lingalone.efficalarmservice.service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author <a href="https://github.com/lingalone">lingalone</a>
 * @version 1.0.0
 * @link
 * @since 2018/4/3
 */

public interface MailService {

    void sendSimpleMail(String to, String subject, String content);
    void sendHtmlMail(String to, String subject, String content);
    void sendAttachmentsMail(String to, String subject, String content, String filePath);
    //发送带静态资源的邮件
    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
