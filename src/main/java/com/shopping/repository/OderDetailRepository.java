package com.shopping.repository;

import com.shopping.entity.User;
import com.shopping.entity.shopping.OderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface OderDetailRepository extends JpaRepository<OderDetail, Long> {

    List<OderDetail> findByUser(User user);
}
