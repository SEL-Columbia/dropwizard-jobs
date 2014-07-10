package de.spinscale.dropwizard.jobs;

import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;
import de.spinscale.dropwizard.jobs.config.JobConfiguration;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.*;

public class JobsBundleTest {

    private final Environment environment = mock(Environment.class);
    private JobConfiguration jobConfiguration = mock(JobConfiguration.class);

    @Test
    public void assertJobsBundleIsWorking() {
        getJobsBundle().run(new Configuration(), environment);

        when(jobConfiguration.getScanUrl()).thenReturn("foo");

        final ArgumentCaptor<JobManager> jobManagerCaptor = ArgumentCaptor.forClass(JobManager.class);
        verify(environment).manage(jobManagerCaptor.capture());
        verify(jobConfiguration).getScanUrl();
        verify(jobConfiguration).getDefaultEveryScanInterval();

        JobManager jobManager = jobManagerCaptor.getValue();
        assertThat(jobManager, is(notNullValue()));
    }

    private JobsBundle<Configuration> getJobsBundle() {
        return new JobsBundle<Configuration>() {
            @Override
            public JobConfiguration getJobConfiguration(Configuration configuration) {
                return jobConfiguration;
            }
        };
    }
}
