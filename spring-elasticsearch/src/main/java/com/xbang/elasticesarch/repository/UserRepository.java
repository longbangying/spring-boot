package com.xbang.elasticesarch.repository;

import com.xbang.elasticesarch.entity.UserEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<UserEs, Long> {
}
