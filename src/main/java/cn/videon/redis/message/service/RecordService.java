package cn.videon.redis.message.service;

import cn.videon.redis.message.domain.Record;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface RecordService {

    Record save(Record jsonObject);

    List<Record> findAll();

    void del(String id);
}
