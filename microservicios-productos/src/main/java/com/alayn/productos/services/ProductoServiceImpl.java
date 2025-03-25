package com.alayn.productos.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alayn.commons.models.entities.Producto;
import com.alayn.commons.services.CommonServiceImpl;
import com.alayn.productos.models.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl extends CommonServiceImpl<Producto, ProductoRepository> implements ProductoService {

    @Override
    @Transactional
    public Producto actualizar(Producto producto, Long id) {
        Optional<Producto> optProducto = repository.findById(id);
        if (optProducto.isPresent()) {
            Producto productoDb = optProducto.get();
            productoDb.setNombre(producto.getNombre());
            productoDb.setDESCRIPCION(producto.getDESCRIPCION());
            productoDb.setPRECIO(producto.getPRECIO());
            productoDb.setSTOCK(producto.getSTOCK());
            repository.save(productoDb);
            return productoDb;
        }
        return null;
    }
}