package com.cgi.commerceapp.repo;



import com.cgi.commerceapp.model.Cart;
import com.cgi.commerceapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CartRepo extends CrudRepository<Cart, Product> {
}
