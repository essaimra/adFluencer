package com.adfluence.scheduling.serializer;

import com.adfluence.scheduling.pojo.Schedule;
import com.google.gson.Gson;

public class Deserializer{

    public Schedule deserialize(String json){

        Gson gson = new Gson();
        Schedule schedule = gson.fromJson(json, Schedule.class);

        return schedule;
    }
}
