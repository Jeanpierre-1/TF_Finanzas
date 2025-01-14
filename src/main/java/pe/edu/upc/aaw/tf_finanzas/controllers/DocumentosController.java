package pe.edu.upc.aaw.tf_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.tf_finanzas.dtos.DocumentosDTO;
import pe.edu.upc.aaw.tf_finanzas.entities.Documentos;
import pe.edu.upc.aaw.tf_finanzas.servicesinterfaces.IDocumentosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/documentos")
public class DocumentosController {
    @Autowired
    private IDocumentosService vrDs;

    @PostMapping
    public void registrar(@RequestBody DocumentosDTO vrdto) {
        ModelMapper vrm = new ModelMapper();
        Documentos vrc = vrm.map(vrdto, Documentos.class);
        vrDs.insert(vrc);
    }

    @GetMapping
    public List<DocumentosDTO> listar() {
        return vrDs.vrlist().stream().map(x->{
            ModelMapper vrm=new ModelMapper();
            return vrm.map(x,DocumentosDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        vrDs.delete(id);
    }

    @GetMapping("/{id}")
    public DocumentosDTO listarDTO(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        DocumentosDTO dto = m.map(vrDs.listId(id),DocumentosDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody DocumentosDTO dto){
        ModelMapper m = new ModelMapper();
        Documentos t = m.map(dto, Documentos.class);
        vrDs.insert(t);
    }

    @GetMapping("/listar/{idCartera}")
    public List<DocumentosDTO> listarPorCartera(@PathVariable("idCartera") int idCartera) {
        return vrDs.findDocumentosByIdCartera(idCartera).stream().map(x->{
            ModelMapper vrm=new ModelMapper();
            return vrm.map(x,DocumentosDTO.class);
        }).collect(Collectors.toList());
    }
}
