package com.miguelvega.apifacturaelectronica.repository;

import com.miguelvega.apifacturaelectronica.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
