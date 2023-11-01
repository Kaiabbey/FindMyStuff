package com.example.findmystuff;

import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;


public class DBConnection {

    private String Key;

    public DBConnection(){

        this.Key = "vwZud1wmqSxsOcHjdkHpIvDUvwXbCHWJf88eCzSYb3Mt2pwCXNyyjEal9zexHGlp";
    }

    private Map<String, String> resMapper(String res){
        String[] resArray = res.substring(12).replaceAll("[{\"}]","").split(",");
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < resArray.length; i++) {
            String[] A = resArray[i].split("[:]");
            //test log to verify object contents
            System.out.print(A[0] +": "+ A[1]+ "\n");
            map.put(A[0],A[1]);
        }
        return  map;
    }


    private Request ReqBuilder(String collection, String query, String action){
        if(collection == "API"){
            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            //makes use of new custom Http endpoint
            RequestBody body = RequestBody.create(mediaType, "body");
            Request request = new Request.Builder()
                    .url("https://ap-southeast-2.aws.data.mongodb-api.com/app/data-jeduj/endpoint/AddDevice"+query)
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Access-Control-Request-Headers", "*")
                    .addHeader("api-key", this.Key)
                    .build();
            return request;
        }else {
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType,
                    "{\n    \"dataSource\":\"FMSDB\"," + // selects source
                            "\n    \"database\":\"FMSDB1\"," + // selects database
                            "\n    \"collection\":\"" + collection + "\"," +  // selects collection
                            // this line is what the query parameters are built in BOTH the KEYS and VALUES need to be surrounded in \"
                            // example  query without all the '\' :
                            // filter : { "name.first" : "bob" , "name.last" : "builder },
                            // omission of the filter will return entire collection if using find
                            query
            );
            Request request = new Request.Builder()

                    .url("https://ap-southeast-2.aws.data.mongodb-api.com/app/data-jeduj/endpoint/data/v1/action/" + action)
                    .method("POST", body)
                    .addHeader("Access-Control-Request-Headers", "*")
                    .addHeader("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .addHeader("api-key", this.Key)
                    .build();
            return request;
        }
    }

    public void AddDevice(String name, int userID, String deviceType, String blueToothID){
        String collection = "API";
        String query = "?name="+name+"&userID="+userID+"&devicetype="+deviceType+"&bluetoothID="+blueToothID;
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = ReqBuilder(collection, query, "insertOne");

        try(Response response = client.newCall(request).execute()){
            String res = response.body().string();
            System.out.println(res);
        }
        catch (java.io.IOException exception){
            System.out.println("fail");
        }
    }
}
