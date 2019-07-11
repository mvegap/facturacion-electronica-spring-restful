package com.miguelvega.apifacturaelectronica.controller;

import com.miguelvega.apifacturaelectronica.exception.ResourceNotFoundException;
import com.miguelvega.apifacturaelectronica.model.Invoice;
import com.miguelvega.apifacturaelectronica.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
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
    
    // get a single invoice
    @GetMapping("/invoices/{id}")
    public Invoice getInvoiceById(@PathVariable(value = "id") Long id){
        return invoiceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invoice", "id", id));
    }

    // create a invoice
    @PostMapping("/invoices")
    public Invoice createInvoice(@Valid @RequestBody Invoice invoice){
        return invoiceRepository.save(invoice);
    }

    // update a invoice
    @PutMapping("/invoices/{id}")
    public Invoice updateInvoice(@PathVariable(value="id") Long id, @Valid @RequestBody Invoice invoiceDetails){
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invoice", "id", id));
        invoice.setOrder_id(invoiceDetails.getOrder_id());
        invoice.setInvoice_number(invoiceDetails.getInvoice_number());
        invoice.setIdentity_card(invoiceDetails.getIdentity_card());
        invoice.setFullname(invoiceDetails.getFullname());
        invoice.setStatus(invoiceDetails.getStatus());
        invoice.setComments(invoiceDetails.getComments());
        
        Invoice updatedInvoice = invoiceRepository.save(invoice);
        return updatedInvoice;
    }
    
    // delete a invoice
    @DeleteMapping("/invoices/{id}")
    public ResponseEntity<?> deleteInvoice(@PathVariable(value = "id") Long invoiceId){
        Invoice invoice = invoiceRepository.findById(invoiceId).orElseThrow(() -> new ResourceNotFoundException("Invoice", "id", invoiceId));
        invoiceRepository.delete(invoice);
        return ResponseEntity.ok().build();
    }

}
