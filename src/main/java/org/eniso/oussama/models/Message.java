package org.eniso.oussama.models;

public class Message {
    public String content;

    public Message(String content) {
        this.content = content;
    }

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                '}';
    }
}
