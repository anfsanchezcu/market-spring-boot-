package com.anfsanchezcu.market.persistence;

import com.anfsanchezcu.market.domain.Product;
import com.anfsanchezcu.market.domain.repository.ProductRepository;
import com.anfsanchezcu.market.persistence.crud.ProductoCrudRepository;
import com.anfsanchezcu.market.persistence.entity.Producto;
import com.anfsanchezcu.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto>productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto> productos = productoCrudRepository.findByIdCategoria(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity){
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(producto -> mapper.toProducts(producto));
    }

    @Override
    public Optional<Product> getProduct(int productId){
        Optional<Producto> producto =  productoCrudRepository.findById(productId);
        return producto.map(pr -> mapper.toProduct(pr));
    }

    @Override
    public Product save(Product product){
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }

}
