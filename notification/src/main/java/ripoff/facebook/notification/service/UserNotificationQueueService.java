package ripoff.facebook.notification.service;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationQueueService {

    private final RabbitAdmin userRabbitAdmin;

    public UserNotificationQueueService(@Qualifier("userContainerFactory-admin") RabbitAdmin userRabbitAdmin) {
        this.userRabbitAdmin = userRabbitAdmin;
    }

    public void createQueue(Long userId) {

        Queue queue = new Queue(Long.toString(userId), true);
        Binding binding = new Binding(
                Long.toString(userId),
                Binding.DestinationType.QUEUE,
                "",
                Long.toString(userId),
                null
        );
        userRabbitAdmin.declareQueue(queue);
        userRabbitAdmin.declareBinding(binding);
    }

    public void deleteQueue(Long userId) {
        userRabbitAdmin.deleteQueue(userId.toString());
    }
}