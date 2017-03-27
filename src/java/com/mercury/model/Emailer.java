package com.mercury.model;



import java.util.*;
import java.io.*;
import java.nio.file.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author fabio
 */
public class Emailer {

    /**
    public static void main(String args[]) throws AddressException, MessagingException {
        String toMail1 = "tomail1@blabla.com";
        String toMail2 = "tomail2@cocode.it";
        String toMail3 = "tomail3@ciaone.net";
        List<String> toMails = new ArrayList<>();
        toMails.add(toMail1);
        toMails.add(toMail2);
        toMails.add(toMail3);
        String titleMail = "Roba nel titolo";
        String bodyMail = "Corpo della mail";
        final String fromMail = "polomercury@gmail.com";
        final String fromPassword = "didattico";
        generateAndSendEmail(toMails, titleMail, bodyMail, fromMail, fromPassword);
        System.out.println("\n ===> Your Java Program has just sent an Email(s) successfully. Check your email(s)!");
    }
    **/

    /**
     * Metodo per spedire una mail a diverse mail destinatarie, spedite dallo stessa mail mittente, i quali dati (mail e password) saranno autenticati
     *
     * @param toMails è una lista contenente tutte le mail destinatarie a cui inviare la stessa tipo di mail
     * @param titleMail è una stringa che rappresenta il titolo della mail
     * @param bodyMail è una stringa che rappresenta il corpo della mail
     * @param fromMail è la stringa della mail del mittente (es. mailserver Mercury)
     * @param fromPassword è la stringa della password del mittente (es. mailserver Mercury)
     * @throws javax.mail.internet.AddressException
     */
    public static void generateAndSendEmail(List<String> toMails, String titleMail, String bodyMail, final String fromMail, final String fromPassword) throws AddressException, MessagingException {

        // Assuming you are sending email through relay.jangosmtp.net
        String auth = "true";
        String enable = "true";
        String host = "smtp.gmail.com";
        String port = "587";

        Properties props = new Properties();
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.starttls.enable", enable);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Get the Session object.
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromMail, fromPassword);
            }
        });

        for (String toMail : toMails) {
            try {
                // Create a default MimeMessage object.
                Message message = new MimeMessage(session);

                // Set From: header field of the header.
                message.setFrom(new InternetAddress(fromMail));

                // Set To: header field of the header.
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail));

                // Set Subject: header field
                message.setSubject(titleMail);

                // Now set the actual message
                message.setText(bodyMail);

                // Send message
                Transport.send(message);

                System.out.println("Sent message successfully for " + toMail);

            } catch (MessagingException e) {
                System.out.println("Message NOT sent for " + toMail + "... MessagingException!");
            }
        }

    }

}
