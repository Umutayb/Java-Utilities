package utils;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.*;

public class EmailUtilities {

    public EmailUtilities(String host){setHost(host);}

    private static final Printer log = new Printer(EmailUtilities.class);
    private String host;

    public Boolean sendEmail(String subject, String content, String receiver, String ID, String Password, Multipart attachment) {

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(ID, Password);
            }
        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(ID));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(content+"\n");
            if (attachment!=null)
                message.setContent(attachment);

            log.new Info("Sending...");
            Transport.send(message);// Send message
            log.new Success("Sent message successfully!");
            return true;
        }
        catch (MessagingException mex) {log.new Error(mex.getMessage(), mex);}
        return false;
    }

    private void setHost(String host){this.host = host;}
}
