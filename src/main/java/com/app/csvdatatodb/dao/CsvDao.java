package com.app.csvdatatodb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.csvdatatodb.domain.CsvDomain;

@Repository
public interface CsvDao extends JpaRepository<CsvDomain, Long> {


}
