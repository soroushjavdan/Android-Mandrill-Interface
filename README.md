# Android Mandrill Interface
An Android Mandrill API Connector


## What is it?
  -----------
It's simple library that make your Mandrill Api interaction much easier. 

easy library set up , just provide your api 
   key that you got from Mandrill.


Examples
--------
**Send Sample email email**

use your data same as below

```java
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
        
```

now if you want you can send() method from MandrillMessage Object .

```java
   allMessage.send();
```

also , you can get json format of your mail by calling  getJson() method from MandrillMessage Object .

**NOTE :**  the content of the attachment must be a base64-encoded 


