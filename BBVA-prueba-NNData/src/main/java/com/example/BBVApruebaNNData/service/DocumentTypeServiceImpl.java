package com.example.BBVApruebaNNData.service;

import com.example.BBVApruebaNNData.exceptions.ResourceNotFoundException;
import com.example.BBVApruebaNNData.model.DocumentType;
import com.example.BBVApruebaNNData.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DocumentTypeServiceImpl implements IDocumentTypeService{
@Autowired
    private DocumentTypeRepository documentTypeRepository;


    @Override
    public List<DocumentType> listAllDocuments() {
        return documentTypeRepository.findAll();
    }

    @Override
    public DocumentType saveDocumentType(DocumentType documentType) {
        return documentTypeRepository.save(documentType);
    }



    @Override
    public DocumentType findByIdDocumentType(int id) {
        return documentTypeRepository.findById(id).get();
    }

    @Override
    public void deleteDocumentType(int id) {
documentTypeRepository.deleteById(id);
    }
}
