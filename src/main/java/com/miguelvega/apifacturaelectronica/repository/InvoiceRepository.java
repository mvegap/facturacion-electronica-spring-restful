package com.miguelvega.apifacturaelectronica.repository;

import com.miguelvega.apifacturaelectronica.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
