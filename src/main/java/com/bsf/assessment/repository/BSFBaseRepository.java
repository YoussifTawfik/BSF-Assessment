package com.bsf.assessment.repository;

import com.bsf.assessment.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

@Repository
public interface BSFBaseRepository<T extends BaseEntity, K extends Serializable> extends JpaRepository<T,K> {

}
