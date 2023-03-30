package com.adfluence.resources.loader;

import com.adfluence.scheduling.serializer.Deserializer;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ResourceLoader{


    private static final String RESOURCES = "\\resources";
    private static final String PREFIX = System.getProperty("user.dir");
    private static final String PATH = PREFIX + RESOURCES;

    private final List<Resource> resources;
    private final Deserializer deserializer;

    public ResourceLoader(){
        resources = new ArrayList<>();
        deserializer = new Deserializer();
    }


    @PostConstruct
    public void loadResources(){

        // TODO: provide generic load resources
        File file = new File("C:\\Users\\omar.mahamid\\Documents\\GitHub\\adFluencer\\src\\main\\resources\\Schedule");

        for (File iteratedFile : Objects.requireNonNull(file.listFiles())){
            if (iteratedFile.getPath().endsWith(".json")) {
                resources.add(deserializer.deserialize(convertFileToString(iteratedFile)));
            }
        }
    }


    private final String convertFileToString(File file){
        StringBuilder content = new StringBuilder();

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String str;

            while ((str = br.readLine()) != null){
                content.append(str);
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return content.toString();
    }


    public List<Resource> getResources(){
        return resources;
    }

}
