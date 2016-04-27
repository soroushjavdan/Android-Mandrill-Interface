# Android Mandrill Interface
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0) [![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-ProgressProfileView-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/2597)

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

        attachment.setType("audio/mpeg");
        attachment.setName("Image name");
        attachment.setContent("set your Base64 encode of your file");
        attachments.add(attachment);

        message.setTo(recipients);
        message.setAttachments(attachments);

        // If you are sending images, use:
        // message.setImages(attachments);

        allMessage.setMessage(message);
        
```

now if you want you can send() method from MandrillMessage Object .

```java
   allMessage.send();
```

also , you can get json format of your mail by calling  getJson() method from MandrillMessage Object .

**NOTE :**  the content of the attachment must be a base64-encoded 


## Gradle
  **Step 1 :**
  Select your build system: Gradle 
  
  **Step 2 :**
  Add the specific repository to your build file:
  ```
  repositories {
    maven {
        url "https://jitpack.io"
    }
  }
  ```
  **step 3 :**
  Add the dependency in your build file (do not forget to specify the correct qualifier, usually 'aar'):
   ```
  dependencies {
    compile 'com.github.soroushjavdan:Android-Mandrill-Interface:master-SNAPSHOT'
  }
  ```


## License

```
Copyright 2015 Soroushjavdan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


