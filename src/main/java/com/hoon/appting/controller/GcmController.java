package com.hoon.appting.controller;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoon on 2015-05-05.
 */
@Controller
public class GcmController {

    @RequestMapping(value = "/sendMessage")
    public String sendMessage() throws UnsupportedEncodingException {
        Sender sender = new Sender("AIzaSyBFU5lHh3mAGN5-WxWcakC_goKaa3KVzdE"); // 서버 API Key 입력
        String regId = "APA91bEx-rGTeQm_48-62cUoW_BZJA71u2dIAasMys3mszPZhlBF8NSbwFqY_sFs4wdvYJuhus1Pjr9IWQlfc8QMfNV5WIIlfIjcxUrVgSf8rdxmSMjO7A7DPYnQTe9gV4izMdl023ZWm_i7bt3OAD9c_rSx-_Q-J1LI1SaL-HynKlbtHSaMdU0"; // 단말기 RegID 입력

        String messageKr = URLEncoder.encode("안녕하세요? 반가워요. ㅎㅎ \n 어디계세요?", "euc-kr");
        Message message = new Message.Builder().addData("msg", messageKr)
                .build();
        List<String> list = new ArrayList<String>();
        list.add(regId);
        MulticastResult multiResult;
        try {
            multiResult = sender.send(message, list, 5);
            if (multiResult != null) {
                List<Result> resultList = multiResult.getResults();
                for (Result result : resultList) {
                    System.out.println("result.getMessageId() : " + result.getMessageId());
                    System.out.println("result.getCanonicalRegistrationId() : " + result.getCanonicalRegistrationId());
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "sendMessage";
    }
}
