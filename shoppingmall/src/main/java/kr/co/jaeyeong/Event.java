package kr.co.jaeyeong;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {

    private String type;
    private String key;
    private String status;

    public Event(String type, String key, String status) {
        this.type = type;
        this.key = key;
        this.status = status;
    }
}
