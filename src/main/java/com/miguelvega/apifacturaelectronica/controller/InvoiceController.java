package com.miguelvega.apifacturaelectronica.controller;

import com.miguelvega.apifacturaelectronica.model.Invoice;
import com.miguelvega.apifacturaelectronica.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    InvoiceRepository invoiceRepository;

    // get all invoices
    @GetMapping("/invoices")
    public List<Invoice> getAllInvoices(){
        return invoiceRepository.findAll();
    }

    // create a invoice
    @PostMapping("/invoices")
    public Invoice createInvoice(@Valid @RequestBody Invoice invoice){
        return invoiceRepository.save(invoice);
    }

    // update a invoice

    // delete a invoice

}
