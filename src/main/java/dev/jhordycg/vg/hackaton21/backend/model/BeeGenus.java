package dev.jhordycg.vg.hackaton21.backend.model;

import java.io.Serializable;

public class BeeGenus implements Serializable {

    private String tagName;
    private Double probability;

    public String getTagName() {
        return tagName;
    }

    public Double getProbability() {
        return probability;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }
}