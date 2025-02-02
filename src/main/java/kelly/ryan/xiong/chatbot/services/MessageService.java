package kelly.ryan.xiong.chatbot.services;

import kelly.ryan.xiong.chatbot.models.Channel;
import kelly.ryan.xiong.chatbot.models.Message;
import kelly.ryan.xiong.chatbot.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageService {
    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    public Message findMessage(Long msgId) {
        return messageRepository.findById(msgId).get();
    }

    public List<Message> findAllMessages() {
        return messageRepository.findAll();
    }

    public Message updateMessageById(Long msgId, Message newMessageData) {
        Message ogMessage = messageRepository.findById(msgId).get();
        ogMessage.setMsgId(newMessageData.getMsgId());
        ogMessage.setMessageBody(newMessageData.getMessageBody());
        ogMessage.setTimeStamp(newMessageData.getTimeStamp());
        ogMessage.setSenderUserName(newMessageData.getSenderUserName());
        ogMessage.setChannel(newMessageData.getChannel());
        ogMessage.setDirectMessage(newMessageData.getDirectMessage());
        ogMessage.setSenderPic(newMessageData.getSenderPic());
        return messageRepository.save(ogMessage);
    }

    public Boolean deleteMessageById(Long msgId) {
        if (messageRepository.existsById(msgId)) {
            messageRepository.deleteById(msgId);
        }
        return false;
    }

    public void deleteAllMessages() {
        messageRepository.deleteAll();
    }

    public Iterable<Message> findByChannel(Long id) {
        return messageRepository.getMessageByChannel_Id(id);
    }
}