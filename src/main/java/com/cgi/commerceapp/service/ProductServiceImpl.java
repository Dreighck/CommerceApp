package com.cgi.commerceapp.service;


import com.cgi.commerceapp.exceptions.ProductWithTheIDAlreadyExistsException;
import com.cgi.commerceapp.exceptions.ProductWithTheIDDoesntExistException;
import com.cgi.commerceapp.model.Product;
import com.cgi.commerceapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo productRepo;


    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(int id) throws ProductWithTheIDDoesntExistException {
        Optional<Product> optional = productRepo.findById(id);
        if (optional.isPresent())
            return productRepo.getReferenceById(id);
        throw new ProductWithTheIDDoesntExistException();
    }

    @Override
    public Product addNewProduct(Product product) throws ProductWithTheIDAlreadyExistsException {
        Optional<Product> optional = productRepo.findById(product.getId());
        if (optional.isEmpty()){
            return productRepo.save(product);
        }
        throw new ProductWithTheIDAlreadyExistsException();
    }

    @Override
    public void deleteProduct(int id) throws ProductWithTheIDDoesntExistException {
        Optional<Product> optional = productRepo.findById(id);
        if (optional.isEmpty())
            throw new ProductWithTheIDDoesntExistException();
        productRepo.deleteById(id);
    }

    @Override
    public Product addProductToCart(int id) throws ProductWithTheIDDoesntExistException {
        Optional<Product> optional = productRepo.findById(id);
        if (optional.isEmpty())
            throw new ProductWithTheIDDoesntExistException();
        Product product = productRepo.findById(id).get();
        return productRepo.getReferenceById(id);
    }

    @Override
    public Product updateProduct(Product product) throws ProductWithTheIDDoesntExistException {
        Optional<Product> optional = productRepo.findById(product.getId());
        if (optional.isPresent()){
            return productRepo.save(product);
        }
        throw new ProductWithTheIDDoesntExistException();
    }

    @Override
    public void removeProduct(int id) throws ProductWithTheIDDoesntExistException {
        Optional<Product> optional = productRepo.findById(id);
        if (optional.isEmpty())
            throw new ProductWithTheIDDoesntExistException();
        productRepo.deleteById(id);
    }
}
