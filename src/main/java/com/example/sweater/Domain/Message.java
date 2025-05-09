package com.example.sweater.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    private String message;
    private String tag;

    public Message() {
    }

    public Message(String message, String tag) {
        this.message = message;
        this.tag = tag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
