package mylab.notification.di.annot.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.SmsNotificationService;
import myspring.di.annot.config.HelloBeanConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
		classes = NotificationConfig.class,
		loader=AnnotationConfigContextLoader.class)
class NotificationConfigTest {
	
	@Autowired
	NotificationManager notificationManager;

	@Test
	void testNotificationManager() {
		assertNotNull(notificationManager);
		
		assertNotNull(notificationManager.getEmailService());
		EmailNotificationService emailService = (EmailNotificationService) notificationManager.getEmailService();
		assertEquals("smtp.gmail.com", emailService.getSmtpServer());
		assertEquals(587, emailService.getPort());
		
		assertNotNull(notificationManager.getSmsService());
		SmsNotificationService smsService = (SmsNotificationService) notificationManager.getSmsService();
		assertEquals("SKT", smsService.getProvider());
		
		emailService.sendNotification("테스트 이메일");
		smsService.sendNotification("테스트 SMS");
	}

}
