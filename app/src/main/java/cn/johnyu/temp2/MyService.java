package cn.johnyu.temp2;

import android.content.Context;
import android.webkit.JavascriptInterface;

import org.json.JSONArray;

public class MyService {
    private Context context;

    public MyService(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public String work(String info){
        return "Hello:"+info;
    }
    @JavascriptInterface
    public String findAllBooks(){
        JSONArray ary=new JSONArray();
        ary.put("abc");
        ary.put("xyz");
        return ary.toString();
    }
}
