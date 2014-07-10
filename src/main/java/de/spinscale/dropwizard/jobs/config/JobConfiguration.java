package de.spinscale.dropwizard.jobs.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class JobConfiguration {
    @NotNull
    @JsonProperty
    private String scanUrl = null;

    @NotNull
    @JsonProperty
    private String defaultEveryScanInterval = null;

    public String getScanUrl() {
        return scanUrl;
    }

    public void setScanUrl(String scanUrl) {
        this.scanUrl = scanUrl;
    }

    public String getDefaultEveryScanInterval() {
        return defaultEveryScanInterval;
    }

    public void setDefaultEveryScanInterval(String defaultEveryScanInterval) {
        this.defaultEveryScanInterval = defaultEveryScanInterval;
    }
}
