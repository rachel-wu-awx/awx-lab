package demo

import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api")
class MessageResource(val service: MessageService) {
    @GetMapping("/message")
    fun index(): List<Message> = service.findMessages()

    @PostMapping("/message")
    fun post(@RequestBody message: Message) {
        service.post(message)
    }

}
