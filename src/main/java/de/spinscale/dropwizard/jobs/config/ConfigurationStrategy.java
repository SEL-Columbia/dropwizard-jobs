package de.spinscale.dropwizard.jobs.config;

import com.yammer.dropwizard.config.Configuration;

public interface ConfigurationStrategy<T extends Configuration> {
    JobConfiguration getJobConfiguration(T configuration);
}
