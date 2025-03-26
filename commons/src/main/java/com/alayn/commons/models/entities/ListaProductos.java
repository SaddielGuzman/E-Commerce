package com.alayn.commons.models.entities;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "LISTA_PRODUCTOS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ListaProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LISTA_PRODUCTOS") 
    private Long idListaProductos;



    @OneToOne(mappedBy = "listaProductos")
    @JsonIgnore
    private Pedido pedido;

    @Embeddable
    public static class ProductoItem {
        private Long idProducto;
        private Integer cantidad;
        private Double total;

   
        public Long getIdProducto() {
            return idProducto;
        }

        public void setIdProducto(Long idProducto) {
            this.idProducto = idProducto;
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
    }

   
    public Long getIdListaProductos() {
        return idListaProductos;
    }

    public void setIdListaProductos(Long idListaProductos) {
        this.idListaProductos = idListaProductos;
    }



    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}