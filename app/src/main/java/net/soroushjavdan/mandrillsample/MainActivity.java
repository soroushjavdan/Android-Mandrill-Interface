package net.soroushjavdan.mandrillsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.soroushjavdan.androidmandrillinterface.Attachment;
import net.soroushjavdan.androidmandrillinterface.EmailMessage;
import net.soroushjavdan.androidmandrillinterface.MandrillMessage;
import net.soroushjavdan.androidmandrillinterface.Recipient;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    public void sendEmail(){


        MandrillMessage allMessage = new MandrillMessage("put Mandrill Api key here");
        // create your message
        EmailMessage message = new EmailMessage();
        message.setFromEmail("info@soroushjavdan.net");
        message.setFromName("buddy");
        message.setHtml("<p>Crash report</p>");
        message.setText("blah blah blah .... ");
        message.setSubject("error");

        // add recipients
        Recipient recipient = new Recipient();
        List<Recipient> recipients = new ArrayList<Recipient>();
        recipient.setEmail("soroushjavdan@gmail.com");
        recipient.setName("soroush");
        recipients.add(recipient);

        // add attachment if you want
        Attachment attachment = new Attachment();
        List<Attachment> attachments = new ArrayList<Attachment>();

        attachment.setType("image/png");
        attachment.setName("Image name");
        attachment.setContent(" set your base64 encode of your file");
        attachments.add(attachment);

        message.setTo(recipients);
        message.setImages(attachments);

        allMessage.setMessage(message);
        allMessage.send();
    }

}
