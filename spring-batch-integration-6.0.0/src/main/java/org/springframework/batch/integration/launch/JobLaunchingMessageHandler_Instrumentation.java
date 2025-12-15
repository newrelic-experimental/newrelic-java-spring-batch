package org.springframework.batch.integration.launch;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import org.springframework.batch.core.job.JobExecution;

@Weave(originalName = "org.springframework.batch.integration.launch.JobLaunchingMessageHandler")
public class JobLaunchingMessageHandler_Instrumentation {

    @Trace
    public JobExecution launch(JobLaunchRequest request) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Job", request.getJob().getName());
        return Weaver.callOriginal();
    }
}
