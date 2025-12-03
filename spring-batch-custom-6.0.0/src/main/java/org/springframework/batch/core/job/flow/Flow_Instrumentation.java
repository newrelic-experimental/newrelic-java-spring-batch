package org.springframework.batch.core.job.flow;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type = MatchType.Interface, originalName = "org.springframework.batch.core.job.flow.Flow")
public abstract class Flow_Instrumentation {

    public abstract String getName();
    public abstract State getState(String stateName);

    @Trace(dispatcher = true)
    public FlowExecution start(FlowExecutor executor) {
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","Flow","start",getName()});
        return Weaver.callOriginal();
    }

    @Trace(dispatcher = true)
    public FlowExecution resume(String stateName, FlowExecutor executor) {
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","Flow","resume",getName(), stateName});
        return Weaver.callOriginal();
    }

}
