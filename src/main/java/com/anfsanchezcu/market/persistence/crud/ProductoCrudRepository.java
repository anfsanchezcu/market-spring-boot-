package com.anfsanchezcu.market.persistence.crud;

import com.anfsanchezcu.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto ,Integer> {

    //QUERY nativo
    // @Query(value ="SELECT * FROM productos WHERE id_categoria = ?", nativeQuery=true)

    List<Producto> findByIdCategoria(int idCategoria);
    //List<Producto> findByIdCategoriaOrderByMobreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean stado);


}
