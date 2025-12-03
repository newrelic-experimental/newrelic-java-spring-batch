package org.springframework.batch.core.partition;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import org.springframework.batch.core.StepExecution;

import java.util.Collection;

@Weave(type = MatchType.Interface, originalName = "org.springframework.batch.core.partition.PartitionHandler")
public class PartitionHandler_Instrumentation {

    @Trace(dispatcher = true)
    public Collection<StepExecution> handle(StepExecutionSplitter stepSplitter, StepExecution stepExecution) {
        NewRelic.getAgent().getTracedMethod().setMetricName("Custom", "PartitionHandler",getClass().getSimpleName(), "handle");
        return Weaver.callOriginal();
    }
}
