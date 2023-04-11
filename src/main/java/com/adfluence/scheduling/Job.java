package com.adfluence.scheduling;

import com.adfluence.resources.loader.Resource;
import lombok.ToString;

@ToString
public class Job{

    private Resource resource;

    public Job(Resource resource){
        this.resource = resource;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
