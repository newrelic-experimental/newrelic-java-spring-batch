package org.springframework.batch.core.job.flow;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import org.springframework.batch.core.step.Step;

@Weave(type = MatchType.Interface, originalName = "org.springframework.batch.core.job.flow.FlowExecutor")
public class FlowExecutor_Instrumentation {

    @Trace(dispatcher = true)
    public String executeStep(Step step) {
        TracedMethod traced = NewRelic.getAgent().getTracedMethod();
        traced.setMetricName("Custom", "FlowExecutor",getClass().getSimpleName(), "executeStep");
        traced.addCustomAttribute("Step", step.getName());
        return Weaver.callOriginal();
    }
}
