package network.message;

import java.io.Serializable;

public class MessageObject implements Serializable {
    MessageType type;
    public MessageObject(MessageType type){
        this.type = type;
    }
}
