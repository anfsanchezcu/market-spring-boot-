package com.anfsanchezcu.market.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name="compras_productos")
public class ComprasProducto {
    @EmbeddedId
    private ComprasProductoPK Id;

    private Integer cantidad;
    private Double total;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name ="id_compra", insertable = false, updatable = false)
    private Compra compra;


    @ManyToOne
    @JoinColumn(name="id_producto", insertable = false, updatable = false)
    private Producto producto;



    public ComprasProductoPK getId() {
        return Id;
    }

    public void setId(ComprasProductoPK id) {
        Id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
