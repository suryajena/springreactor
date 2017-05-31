package org.surya;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.Environment;
import reactor.bus.EventBus;
import reactor.core.config.DispatcherType;

@Configuration
public class Config
{

	private static final int NUMBER_OF_THREAD_YOU_WANT_TO_ASSIGN =
		Runtime.getRuntime().availableProcessors();;

	@Bean
	Environment env()
	{
		return Environment.initializeIfEmpty().assignErrorJournal();
	}

	/*  @Bean
	EventBus createEventBus(Environment env) {
	    return EventBus.create(env, Environment.THREAD_POOL);
	}*/

	@Bean
	EventBus createEventBus(Environment env)
	{
		EventBus evBus = EventBus.create(env,
				Environment.newDispatcher(NUMBER_OF_THREAD_YOU_WANT_TO_ASSIGN,
						NUMBER_OF_THREAD_YOU_WANT_TO_ASSIGN,
						DispatcherType.THREAD_POOL_EXECUTOR));
		return evBus;
	}

}
