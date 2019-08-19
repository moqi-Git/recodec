package com.github.moqi.libmoqidebug;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class MoqiDingTalk {

    private static final MediaType TYPE_JSON = MediaType.get("application/json; charset=utf-8");

    //双叶bot
    private final String HOOK_LINK = "https://oapi.dingtalk.com/robot/send?access_token=a3a25872a27d429cf49c42e01b183876296e1c320ac512058023ee159ada3858";

    private OkHttpClient mClient;

    public MoqiDingTalk(){
        mClient = new OkHttpClient.Builder()
                .build();
    }

    public void sendText(String text){

        String json = "{\"msgtype\":\"text\",\"text\":{\"content\":\"" + text + "\"}}";

        Request request = new Request.Builder()
                .header("Content-Type", "application/json")
                .post(RequestBody.create(json, TYPE_JSON))
                .url(HOOK_LINK)
                .build();

        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

            }
        });
    }

}
