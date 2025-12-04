package org.springframework.batch.core.step.item;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import org.springframework.batch.core.StepContribution;

@Weave(type = MatchType.Interface, originalName = "org.springframework.batch.core.step.item.ChunkProcessor")
public class ChunkProcessor_Instrumentation<I> {

    public void process(StepContribution contribution, Chunk<I> chunk) {
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","ChunkProcessor",getClass().getSimpleName(),"process"});
        Weaver.callOriginal();
    }
}
