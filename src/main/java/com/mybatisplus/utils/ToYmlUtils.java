package com.mybatisplus.utils;
import java.io.*;
public class ToYmlUtils {
    public static void main(String[] args) throws IOException {
        String result = propertiesToYml(new FileInputStream("F:\\idea-project\\mybatis-plus\\src\\main\\resources\\a.properties"));
        byte[] data = result.getBytes("utf-8");

    }
    public static String propertiesToYml(FileInputStream fis) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        StringBuilder builder = new StringBuilder();
        while(true){
            String line = br.readLine();
            if(line==null)break;
            if(line.isEmpty())break;
            String[] specialCondiction = line.split("=");
            String specialValue = specialCondiction[1];
            String[] exceptedValues = specialValue.split("\\.");

            if(exceptedValues.length==1){
                String ymlResult = oneLineToYml(line);
                builder.append(ymlResult);
                builder.append("\r\n");
            }else{
                String key = specialCondiction[0];
                String value =specialCondiction[1];

                String[] sections = key.split("\\.");

                int controlIndex = 0;

                for (int i = 0; i < sections.length; i++) {
                    for (int j = 0; j <controlIndex ; j++) {
                        builder.append("\s\s");
                    }
                    builder.append(sections[i]);
                    builder.append(":");
                    controlIndex++;
                    if(i== sections.length-1){
                        builder.append(" "+value);
                        break;
                    }
                    builder.append("\r\n");
                }
                builder.append("\r\n");

            }
        }
        System.out.println(builder);
        return builder.toString();
    }


    



    private static String oneLineToYml(String line){

        String[] sections = line.split("\\.");
        String[] newSections = new String[sections.length-1];
        for (int i = 0; i <sections.length-1; i++) {
            newSections[i] = sections[i];
        }
        String specialBottom = sections[sections.length-1];

        String[] keyValue = specialBottom.split("=");

        String key = keyValue[0];
        String value = keyValue[1];


        int controlIndex = 0;
        StringBuilder builder = new StringBuilder();
        for (String section : newSections) {
            for (int i = 0; i <controlIndex ; i++) {
                builder.append("\s\s");
            }
            builder.append(section);
            builder.append(":");
            builder.append("\r\n");
            controlIndex++;
        }

        for (int i = 0; i <controlIndex ; i++) {
            builder.append("\s\s");
        }
        builder.append(key+":"+"\s"+value);
        return builder.toString().trim();
    }

}
