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
    private final ListaProductoRepository listaProductoRepository;

    public ListaProductosServiceImpl(ListaProductosMapper mapper, ListaProductoRepository listaProductoRepository) {
        this.mapper = mapper;
        this.listaProductoRepository = listaProductoRepository;
    }

    @Override
    @Transactional
    public ListaProductos update(ListaProductoDTO listaProductoDTO, Long id) {
        Optional<ListaProductos> optListaProductos = listaProductoRepository.findById(id);
        if (optListaProductos.isPresent()) {
            ListaProductos listaProductosDb = optListaProductos.get();
            
            listaProductosDb.setIdListaProductos(listaProductoDTO.getIdListaProductos());
            listaProductosDb.setProductos(listaProductoDTO.getProductos());

            return listaProductoRepository.save(listaProductosDb);
        }
        return null;
    }

    @Override
    @Transactional
    public ListaProductos createListaProductoDTO(ListaProductoDTO listaProductoDTO) {
        System.out.println("DTO de productos: " + listaProductoDTO.getProductos());
        ListaProductos listaProductos = mapper.dtoToEntity(listaProductoDTO);
        return listaProductoRepository.save(listaProductos);
    }

    @Transactional
    public ListaProductos obtenerListaConProductos(Long id) {
      
        ListaProductos lista = listaProductoRepository.findById(id).orElse(null);

        if (lista != null) {
          
            lista.getProductos().size(); 
        }
        
        return lista;
    }
}
