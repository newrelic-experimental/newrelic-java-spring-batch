package org.springframework.batch.integration.chunk;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type = MatchType.Interface, originalName = "org.springframework.batch.integration.chunk.ChunkHandler")
public class ChunkHandler_Instrumentation<T> {

    @Trace
    public ChunkResponse handleChunk(ChunkRequest<T> chunk) {
        NewRelic.getAgent().getTracedMethod().setMetricName("Chunk", "ChunkHandler", getClass().getSimpleName(),"handleChunk");
        return Weaver.callOriginal();
    }
}
