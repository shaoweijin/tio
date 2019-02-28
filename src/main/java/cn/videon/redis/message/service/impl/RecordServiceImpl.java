package cn.videon.redis.message.service.impl;

import cn.videon.redis.message.domain.Record;
import cn.videon.redis.message.repository.RecordRepository;
import cn.videon.redis.message.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RecordRepository jsonObjectRepository;

    @Override
    public Record save(Record jsonObject) {
        log.debug("save Record is {}",jsonObject);
        return jsonObjectRepository.save(jsonObject);
    }

    @Override
    public List<Record> findAll() {
        log.debug("find all Record");
        return jsonObjectRepository.findAll();
    }

    @Override
    public void del(String id) {
        log.debug("del record id: {}",id);
        jsonObjectRepository.deleteById(id);
    }
}
