package org.springframework.batch.core.step.builder;

import com.newrelic.agent.bridge.AgentBridge;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.spring.batch.BatchUtils;
import org.springframework.batch.item.ItemProcessor;

@Weave(type = MatchType.BaseClass, originalName = "org.springframework.batch.core.step.builder.SimpleStepBuilder")
public class SimpleStepBuilder_Instrumentation<I,O> {

    public SimpleStepBuilder<I, O> processor(ItemProcessor<? super I, ? extends O> processor) {
        BatchUtils.instrument(processor);
        return Weaver.callOriginal();
    }
}
