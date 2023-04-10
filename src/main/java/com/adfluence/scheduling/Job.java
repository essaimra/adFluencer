package com.adfluence.scheduling;

import com.adfluence.resources.loader.Resource;

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

    @Override
    public String toString(){
        return resource.toString();
    }
}
