package org.springframework.batch.core.step.tasklet;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;

@Weave(type = MatchType.Interface, originalName = "org.springframework.batch.core.step.tasklet.Tasklet")
public class Tasklet_Instrumentation {

    @Trace(dispatcher = true)
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","Tasklet",getClass().getName(),"execute"});
        return Weaver.callOriginal();
    }
}
