package net.soroushjavdan.androidmandrillinterface;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by SoroushJavdan on 1/28/15.
 */
public class MandrillMessage {

        public final static String ENDPOINT = "https://mandrillapp.com/api/1.0/messages/send.json" ;

        public class SendResponse {
            public String email;
            public String status;
            public String reject_reason;
            public String _id;
        }

        public class SendError {
            public String status;
            public int code;
            public String name;
            public String message;
        }

        public interface IMandrillSendListener {
            void OnMandrillMessageSent(SendResponse[] responses);
            void OnMandrillMessageError(SendError error);
        }

        public MandrillMessage(String key){
            if(key == null) {
                throw new NullPointerException(
                        "'key' is null , please provide Mandrill API key");
            }
            this.key = key ;
        }

        private String key;
        private EmailMessage message;

        public String getKey() {
            return key;
        }
        public EmailMessage getMessage() {
            return message;
        }

        public void setMessage(EmailMessage message) {
            this.message = message;
        }

        public void setKey(String key){
            this.key = key ;
        }


        public String getJson(){
            if(message == null) {
                throw new NullPointerException(
                        "'message' is null , please make sure that you set message");
            }
            Gson gson = new Gson();
            return gson.toJson(this);
        }

        public void send() {
            send(null);
        }

        public void send(final IMandrillSendListener listener){
            if(message == null) {
                throw new NullPointerException(
                        "'message' is null , please make sure that you set message");
            }

            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... params) {
                    StringBuffer result = new StringBuffer("");
                    try{
                        URL url = new URL(ENDPOINT);
                        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                        connection.setRequestMethod("POST");
                        connection.connect();


                        OutputStream os = connection.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
                        osw.write(getJson());
                        osw.flush();
                        osw.close();

                        boolean isSuccess = connection.getResponseCode() < 300;

                        BufferedReader br = new BufferedReader(new InputStreamReader( isSuccess ? connection.getInputStream() : connection.getErrorStream(),"utf-8"));
                        String line = null;
                        while ((line = br.readLine()) != null) {
                            result.append(line + "\n");
                        }
                        br.close();

                        Log.d("MandrillMessage: ", result.toString());
                        if (listener != null) {
                            Gson gson = new Gson();
                            if (isSuccess) {
                                SendResponse[] responses = gson.fromJson(result.toString(), SendResponse[].class);
                                listener.OnMandrillMessageSent(responses);
                            } else {
                                SendError error = gson.fromJson(result.toString(), SendError.class);
                                listener.OnMandrillMessageError(error);
                            }
                        }
                    } catch (IOException e) {
                        // writing exception to log
                        e.printStackTrace();
                        if (listener != null) {
                            SendError error = new SendError();
                            error.message = "Error attempting to send email";
                            listener.OnMandrillMessageError(error);
                        }
                    }
                    return null;
                }
            }.execute();


        }

}

