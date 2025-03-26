package com.alayn.commons.models.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "ID_PEDIDO")
    private Long idPedido;

    @OneToOne(mappedBy = "listaProductos")
    @JsonIgnore
    private Pedido pedido;

    @ElementCollection
    @CollectionTable(name = "LISTA_PRODUCTOS_ITEMS", joinColumns = @JoinColumn(name = "ID_LISTA_PRODUCTOS"))
    private List<ProductoItem> productos;

    public void imprimirProductos() {
        System.out.println("Productos en ListaProductos " + idListaProductos + ":");
        if (productos != null) {
            for (ProductoItem producto : productos) {
                System.out.println("  ID Producto: " + producto.getIdProducto());
            }
        } else {
            System.out.println("  Lista de productos es nula.");
        }
    }
    @Embeddable
    public static class ProductoItem {
        private Long idProducto;

        public Long getIdProducto() {
            return idProducto;
        }

        public void setIdProducto(Long idProducto) {
            this.idProducto = idProducto;
        }
    }

   
    public ListaProductos() {
        this.productos = new ArrayList<>();
    }


 
    public Long getIdListaProductos() {
        return idListaProductos;
    }

    public void setIdListaProductos(Long idListaProductos) {
        this.idListaProductos = idListaProductos;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<ProductoItem> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoItem> productos) {
        if (productos == null) {
            this.productos = new ArrayList<>();
        }
        this.productos = productos;
    }
}