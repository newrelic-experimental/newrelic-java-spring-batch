package org.springframework.batch.integration.launch;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import org.springframework.messaging.Message;

@Weave(originalName = "org.springframework.batch.integration.launch.JobLaunchingGateway")
public class JobLaunchingGateway_Instrumentation {

    @Trace
    protected Object handleRequestMessage(Message<?> requestMessage) {
        return Weaver.callOriginal();
    }
}
