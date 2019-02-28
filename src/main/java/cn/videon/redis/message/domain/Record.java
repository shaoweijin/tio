package cn.videon.redis.message.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("people")
public class Record {
    @Id
    private String id;

    private String jsonObject;

    public Record() {
    }

    public Record(String jsonObject) {
        this.jsonObject = jsonObject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(String jsonObject) {
        this.jsonObject = jsonObject;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id='" + id + '\'' +
                ", jsonObject=" + jsonObject +
                '}';
    }
}
