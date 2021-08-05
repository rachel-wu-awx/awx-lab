package demo
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MessageService(val db: MessageRepository) {

    var logger = LoggerFactory.getLogger(MessageService::class.java)

    fun findMessages(): List<Message> = db.findMessages()

    fun post(message: Message):Message{
        logger.info("Receive message ${message.text}")
        db.save(message)
        return  message
    }
}
