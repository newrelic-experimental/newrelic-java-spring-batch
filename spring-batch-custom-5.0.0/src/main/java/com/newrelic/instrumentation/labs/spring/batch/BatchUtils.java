package com.newrelic.instrumentation.labs.spring.batch;

import com.newrelic.agent.bridge.AgentBridge;
import com.newrelic.api.agent.NewRelic;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

public class BatchUtils {

    private static final Set<String> instrumentedClasses = new HashSet<>();

    public static void instrument(ItemProcessor<?,?> processor) {
        String className = processor.getClass().getName();
        if(className.startsWith("org.springframework.batch")) {
            return;
        }
        if(!instrumentedClasses.contains(className)) {
            Class<?> clazz = processor.getClass();
            Method[] methods = clazz.getMethods();
            for(Method method : methods) {
                String methodName = method.getName();
                if(methodName.equals("process") && method.getParameterCount() == 1) {
                    AgentBridge.instrumentation.instrument(method,"Custom/ItemProcessor");
                    instrumentedClasses.add(className);
                    NewRelic.getAgent().getLogger().log(Level.FINE, "Instrumented ItemProcessor {0}", className);
                    return;
                }
            }
        }

    }

    public static void instrument(Tasklet tasklet) {
        String className = tasklet.getClass().getName();
        if(className.startsWith("org.springframework.batch")) {
            return;
        }
        if(!instrumentedClasses.contains(className)) {
            Class<?> clazz = tasklet.getClass();
            Method[] methods = clazz.getMethods();
            for(Method method : methods) {
                String methodName = method.getName();
                if(methodName.equals("execute") && method.getParameterCount() == 2) {
                    AgentBridge.instrumentation.instrument(method,"Custom/Tasklet");
                    instrumentedClasses.add(className);
                    NewRelic.getAgent().getLogger().log(Level.FINE, "Instrumented Tasklet {0}", className);
                    return;
                }
            }
        }
    }
}
