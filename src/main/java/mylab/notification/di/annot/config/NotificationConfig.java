package mylab.notification.di.annot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.SmsNotificationService;

@Configuration
@ComponentScan(basePackages = {"mylab.notification.di.annot"})
public class NotificationConfig {
	@Bean
	public EmailNotificationService emailNotificationService() {
		return new EmailNotificationService("smtp.gmail.com", 587);
	}
	
	@Bean
	public SmsNotificationService smsNotificationService() {
		return new SmsNotificationService("SKT");
	}
	
	@Bean
	public NotificationManager notificationManager() {
		return new NotificationManager(emailNotificationService(), smsNotificationService());
	}

}
