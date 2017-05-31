package org.surya;

import static reactor.bus.selector.Selectors.$;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.surya.consumer.NotificationConsumer;

import reactor.bus.EventBus;

@SpringBootApplication
public class Application implements CommandLineRunner
{

	@Autowired
	private EventBus				eventBus;

	@Autowired
	private NotificationConsumer	notificationConsumer;

	@Override
	public void run(String... args)
		throws Exception
	{
		eventBus.on($("notificationConsumer"), notificationConsumer);
	}

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

}
