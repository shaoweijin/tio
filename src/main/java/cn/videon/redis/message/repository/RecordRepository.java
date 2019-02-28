package cn.videon.redis.message.repository;

import cn.videon.redis.message.domain.Record;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecordRepository extends CrudRepository<Record, String> {

    @Override
    List<Record> findAll();
}
