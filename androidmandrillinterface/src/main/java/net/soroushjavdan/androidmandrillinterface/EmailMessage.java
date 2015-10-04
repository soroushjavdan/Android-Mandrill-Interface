package net.soroushjavdan.androidmandrillinterface;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by SoroushJavdan on 1/28/15.
 */

public class EmailMessage {
    private String html;
    private String text;
    private String subject;
    @SerializedName("from_email")
    private String fromEmail;
    @SerializedName("from_name")
    private String fromName;
    private List<Recipient> to;
    private List<Attachment> images ;

    public EmailMessage(){

    }


    public void setImages(List<Attachment> image) {
        this.images = image;
    }


    public String getText() {
        return text;
    }
    public String setHtml(String html) {
        return this.html = html;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String from_email) {
        this.fromEmail = from_email;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String from_name) {
        this.fromName = from_name;
    }

    public List<Recipient> getTo() {
        return to;
    }

    public void setTo(List<Recipient> to) {
        this.to = to;
    }


}
