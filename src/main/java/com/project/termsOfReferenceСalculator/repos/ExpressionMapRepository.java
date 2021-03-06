package com.project.termsOfReferenceŠ”alculator.repos;

import com.project.termsOfReferenceŠ”alculator.domain.ExpressionMap;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;


public interface ExpressionMapRepository extends CrudRepository<ExpressionMap, Integer> {
    List<ExpressionMap> findByResult(String result);
    List<ExpressionMap> findByResultAfter(String result);
    List<ExpressionMap> findByResultBefore(String result);
}
