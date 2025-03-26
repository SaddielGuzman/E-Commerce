package com.alayn.lista.productos.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alayn.commons.models.entities.ListaProductos;
import com.alayn.commons.services.CommonServiceImpl;
import com.alayn.lista.productos.dto.ListaProductoDTO;
import com.alayn.lista.productos.mapper.ListaProductosMapper;
import com.alayn.lista.productos.models.repositories.ListaProductoRepository;

@Service
public class ListaProductosServiceImpl extends CommonServiceImpl<ListaProductos, ListaProductoRepository> implements ListaProductosService {

    private final ListaProductosMapper mapper;

    public ListaProductosServiceImpl(ListaProductosMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public ListaProductos update(ListaProductoDTO listaProductoDTO, Long id) {
        Optional<ListaProductos> optListaProductos = repository.findById(id);
        if (optListaProductos.isPresent()) {
            ListaProductos listaProductosDb = optListaProductos.get();

            ListaProductos listaProductosActualizado = mapper.dtoToEntity(listaProductoDTO);
            listaProductosActualizado.setIdListaProductos(id);
            listaProductosActualizado.setPedido(listaProductosDb.getPedido());
            listaProductosActualizado.setProductosItems(listaProductoDTO.getProductosItems());
            return repository.save(listaProductosActualizado);
        }
        return null;
    }

    @Override
    @Transactional
    public ListaProductos createListaProductoDTO(ListaProductoDTO listaProductoDTO) {
        ListaProductos listaProductos = mapper.dtoToEntity(listaProductoDTO);
        return repository.save(listaProductos);
    }
}