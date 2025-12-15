package org.springframework.batch.integration.partition;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import org.springframework.batch.core.step.StepExecution;

@Weave(originalName = "org.springframework.batch.integration.partition.StepExecutionRequestHandler")
public class StepExecutionRequestHandler_Instrumentation {

    @Trace
    public StepExecution handle(StepExecutionRequest request) {
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("Step", request.getStepName());
        NewRelic.getAgent().getTracedMethod().addCustomAttribute("StepExecutionId", request.getStepExecutionId());
        return Weaver.callOriginal();
    }
}
