package com.example.BBVApruebaNNData.controller;

import com.example.BBVApruebaNNData.model.DocumentType;
import com.example.BBVApruebaNNData.service.DocumentTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DocumentTypeController {
@Autowired
    private DocumentTypeServiceImpl documentTypeService;

    @GetMapping("/documents")
    public List<DocumentType> listAllDocumentsC(){
        return documentTypeService.listAllDocuments();
    }
    @PostMapping("/documents/add")
    public ResponseEntity<DocumentType> saveDocumentC(@RequestBody DocumentType documentType){
        documentTypeService.saveDocumentType(documentType);
        return new ResponseEntity<DocumentType>(documentType,null, HttpStatus.CREATED);
    }


    @GetMapping("/documents/{id}")
    public ResponseEntity<DocumentType> listDocumentByIdC(@PathVariable int id) {
    DocumentType documentType=documentTypeService.findByIdDocumentType(id);
        return ResponseEntity.ok(documentType);
    }
    @PutMapping("/documents/edit/{id}")
    public ResponseEntity<DocumentType> updateDocumentByIdC(@PathVariable int id, @RequestBody DocumentType documentType) {
        DocumentType documentUpdate= documentTypeService.findByIdDocumentType(id);
       documentUpdate.setName(documentType.getName());
        return ResponseEntity.ok(documentUpdate);
    }
    @DeleteMapping("/documents/delete/{id}")
    public ResponseEntity<?> deleteDocumentTypeC(@PathVariable int id){
       documentTypeService.deleteDocumentType(id);
        return ResponseEntity.ok().build();
    }




}
