package pl.net.gazda.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class MessageBroadcaster {
    @Autowired
    WebSocketConfig.WebSocketTransactionsHandler handler;

    @Scheduled(fixedDelay = 1000)
    public void broadcast() throws IOException {
        handler.broadcastMessage(new TextMessage(LocalDateTime.now().toString()));
    }
}
