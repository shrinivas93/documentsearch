package com.shrinivas.documentsearch.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shrinivas.documentsearch.document.Index;

public interface IndexRepository extends MongoRepository<Index, String> {

}
