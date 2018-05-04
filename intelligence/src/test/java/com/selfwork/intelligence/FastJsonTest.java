package com.selfwork.intelligence;

import com.alibaba.fastjson.JSONReader;
import com.selfwork.intelligence.model.DemoUser;
import org.junit.Test;

import java.io.StringReader;

/**
 * Created by zzc on 2018/5/5.
 */
public class FastJsonTest {

    @Test
    public void readBigJson(){
        String json = "{" +
                "\"array\": [1,2,3]," +
                "\"arraylist\": [" +
                "{\"name\": \"jack\"," +
                "\"age\": \"40\"," +
                "\"sex\": \"1\"}," +
                "{\"name\": \"tom\"," +
                "\"age\": \"19\"," +
                "\"sex\": \"男\"}," +
                "{\"name\": \"lily\"," +
                "\"age\": \"20\"," +
                "\"sex\": \"0\"}  " +
                "]," +
                "\"object\": {" +
                "\"a\": \"b\"," +
                "\"c\": \"d\"," +
                "\"e\": \"f\"}," +
                "\"string\": \"Hello World\"" +
                "}";

        String json2 = "{\n" +
                "    \"ph\":[\n" +
                "        {\n" +
                "            \"rule\":\"require\",\n" +
                "            \"value\":\"true\",\n" +
                "            \"message\":\"ph不可为空\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"rule\":\"minLength\",\n" +
                "            \"value\":\"6\",\n" +
                "            \"message\":\"ph最短为6个字符\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"hb\":[\n" +
                "        {\n" +
                "            \"rule\":\"require\",\n" +
                "            \"value\":\"true\",\n" +
                "            \"message\":\"hb不可为空\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        // 如果json数据以形式保存在文件中，用FileReader进行流读取，path为json数据文件路径。
        // JSONReader reader = new JSONReader(new FileReader(path));
        // 为了直观，方便运行，就用StringReader做示例！
        JSONReader reader = new JSONReader(new StringReader(json));
        reader.startObject();
        System.out.print("start read json with fastjson");
        while (reader.hasNext())
        {
            String key = reader.readString();
            System.out.println("key " + key);
            if (key.equals("array"))
            {
                reader.startArray();
                System.out.println("start " + key);
                while (reader.hasNext())
                {
                    String item = reader.readString();
                    System.out.println(item);
                }
                reader.endArray();
                System.out.println("end " + key);
            }
            else if (key.equals("arraylist"))
            {
                reader.startArray();
                System.out.println("start " + key);
                while (reader.hasNext())
                {
                    reader.startObject();
                    System.out.println("start arraylist item");
                    while (reader.hasNext())
                    {
                        String arrayListItemKey = reader.readString();
                        String arrayListItemValue = reader.readObject().toString();
                        System.out.print("key " + arrayListItemKey);
                        System.out.println(":value " + arrayListItemValue);
                    }
                    reader.endObject();
                    System.out.println("end arraylist item");
                }
                reader.endArray();
                System.out.println("end " + key);
            }
            else if (key.equals("object"))
            {
                reader.startObject();
                System.out.println("start object item");
                while (reader.hasNext())
                {
                    String objectKey = reader.readString();
                    String objectValue = reader.readObject().toString();
                    System.out.print("key " + objectKey);
                    System.out.println(":value " + objectValue);
                }
                reader.endObject();
                System.out.println("end object item");
            }
            else if (key.equals("string"))
            {
                System.out.println("start string");
                String value = reader.readObject().toString();
                System.out.println("value " + value);
                System.out.println("end string");
            }
        }
        reader.endObject();
        System.out.println("start fastjson");
    }


    @Test
    public void readBigJson2(){

        String json2 = "{\n" +
                "    \"ph\":[\n" +
                "        {\n" +
                "            \"rule\":\"require\",\n" +
                "            \"value\":\"true\",\n" +
                "            \"message\":\"ph不可为空\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"rule\":\"minLength\",\n" +
                "            \"value\":\"6\",\n" +
                "            \"message\":\"ph最短为6个字符\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"hb\":[\n" +
                "        {\n" +
                "            \"rule\":\"require\",\n" +
                "            \"value\":\"true\",\n" +
                "            \"message\":\"hb不可为空\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        JSONReader reader = new JSONReader(new StringReader(json2));
        reader.startObject();
        System.out.print("start read json with fastjson");
        while (reader.hasNext())
        {
            String key = reader.readString();
            System.out.println("key " + key);
            reader.startArray();
            System.out.println("start " + key);
            while (reader.hasNext())
            {
                reader.startObject();
                System.out.println("start arraylist item");
                while (reader.hasNext())
                {
                    String arrayListItemKey = reader.readString();
                    String arrayListItemValue = reader.readObject().toString();
                    System.out.print("key " + arrayListItemKey);
                    System.out.println(":value " + arrayListItemValue);
                }
                reader.endObject();
                System.out.println("end arraylist item");
            }
            reader.endArray();
            System.out.println("end " + key);
        }
        reader.endObject();
        System.out.println("start fastjson");
    }

    @Test
    public void test (){
        String name = "ffff.txt";
        String a = name.split("\\.")[0];
        System.out.println(a);
    }
}
