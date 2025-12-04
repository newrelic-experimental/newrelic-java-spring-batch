package org.springframework.batch.core.step.item;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.Chunk;

@Weave(type = MatchType.Interface, originalName = "org.springframework.batch.core.step.item.ChunkProcessor")
public class ChunkProcessor_Instrumentation<I> {

    @Trace
    public void process(StepContribution contribution, Chunk<I> chunk) {
        StepExecution stepExecution = contribution.getStepExecution();
        if(stepExecution != null) {
            String stepName = stepExecution.getStepName();
            NewRelic.getAgent().getTracedMethod().addCustomAttribute("StepName", stepName);
        }
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","ChunkProcessor",getClass().getSimpleName(),"process"});
        Weaver.callOriginal();
    }
}
