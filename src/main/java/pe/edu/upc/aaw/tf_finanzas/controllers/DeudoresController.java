package pe.edu.upc.aaw.tf_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.tf_finanzas.dtos.DeudoresDTO;
import pe.edu.upc.aaw.tf_finanzas.entities.Deudores;
import pe.edu.upc.aaw.tf_finanzas.servicesinterfaces.IDeudoresService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/deudores")
public class DeudoresController {
    @Autowired
    private IDeudoresService vrDs;

    @PostMapping
    public void registrar(@RequestBody DeudoresDTO vrdto) {
        ModelMapper vrm = new ModelMapper();
        Deudores vrc = vrm.map(vrdto, Deudores.class);
        vrDs.insert(vrc);
    }

    @GetMapping
    public List<DeudoresDTO> listar() {
        return vrDs.vrlist().stream().map(x->{
            ModelMapper vrm=new ModelMapper();
            return vrm.map(x,DeudoresDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        vrDs.delete(id);
    }

    @GetMapping("/{id}")
    public DeudoresDTO listarDTO(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        DeudoresDTO dto = m.map(vrDs.listId(id),DeudoresDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody DeudoresDTO dto){
        ModelMapper m = new ModelMapper();
        Deudores t = m.map(dto, Deudores.class);
        vrDs.insert(t);
    }
}
