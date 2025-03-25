package com.alayn.commons.models.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "LISTA_PRODUCTOS")
public class ListaProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LISTA_PRODUCTOS_SEQ")
    @SequenceGenerator(name = "LISTA_PRODUCTOS_SEQ", sequenceName = "LISTA_PRODUCTOS_SEQ", allocationSize = 1)
    @Column(name = "ID_LISTA_PRODUCTOS")
    private Long idListaProductos;

    @ElementCollection
    @CollectionTable(name = "LISTA_PRODUCTOS_ITEMS", joinColumns = @JoinColumn(name = "ID_LISTA_PRODUCTOS"))
    private List<ProductoItem> productosItems;

    @OneToOne
    @JoinColumn(name = "ID_PEDIDO")
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

    public List<ProductoItem> getProductosItems() {
        return productosItems;
    }

    public void setProductosItems(List<ProductoItem> productosItems) {
        this.productosItems = productosItems;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}