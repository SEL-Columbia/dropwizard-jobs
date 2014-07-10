package de.spinscale.dropwizard.jobs;

import com.yammer.dropwizard.ConfiguredBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;
import de.spinscale.dropwizard.jobs.config.ConfigurationStrategy;
import de.spinscale.dropwizard.jobs.config.JobConfiguration;

public abstract class JobsBundle<T extends Configuration> implements ConfiguredBundle<T>, ConfigurationStrategy<T> {
    @Override
    public void initialize(Bootstrap<?> bootstrap) {
    }

    @Override
    public void run(T configuration, Environment environment) {
        JobConfiguration jobsConfiguration = getJobConfiguration(configuration);
        environment.manage(new JobManager(jobsConfiguration.getScanUrl(), jobsConfiguration.getDefaultEveryScanInterval()));
    }
}
