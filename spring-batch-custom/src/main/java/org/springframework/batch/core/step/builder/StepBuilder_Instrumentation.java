package org.springframework.batch.core.step.builder;

import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.spring.batch.BatchUtils;
import org.springframework.batch.core.step.tasklet.Tasklet;

@Weave(type = MatchType.BaseClass, originalName = "org.springframework.batch.core.step.builder.StepBuilder")
public class StepBuilder_Instrumentation {

    public TaskletStepBuilder tasklet(Tasklet tasklet) {
        BatchUtils.instrument(tasklet);
        return Weaver.callOriginal();
    }
}
