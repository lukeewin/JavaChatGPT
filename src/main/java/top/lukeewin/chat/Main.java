package top.lukeewin.chat;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import top.lukeewin.dto.Message;
import top.lukeewin.dto.RequestBody;
import top.lukeewin.dto.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Luke Ewin
 * @create 2023-04-08 18:21
 */
public class Main {
    private static final String URL = "https://api.openai.com/v1/chat/completions";
    private static final String API_KEY = "";

    public static void main(String[] args) {
        List<Message> list = new ArrayList<>();
        while (true) {
            System.out.print("请输入：");
            Scanner sc = new Scanner(System.in);
            String str = sc.next();

            if ("exit".equals(str)) {
                System.out.println("已推出程序");
                break;
            }

            Message message = new Message();
            message.setRole("user");
            message.setContent(str);

            list.add(message);

            RequestBody requestBody = new RequestBody();
            requestBody.setModel("gpt-3.5-turbo");
            requestBody.setMessages(list);

            String jsonString = JSON.toJSONString(requestBody);

            String replyJSONString = HttpRequest.post(URL)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + API_KEY)
                    .body(jsonString)
                    .execute()
                    .body();

            ResponseBody responseBody = JSON.parseObject(replyJSONString, ResponseBody.class);
            String content = responseBody.getChoices().get(0).getMessage().getContent();
            System.out.println(content);
        }
    }
}
