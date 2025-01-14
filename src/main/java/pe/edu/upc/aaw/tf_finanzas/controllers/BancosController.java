package pe.edu.upc.aaw.tf_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.tf_finanzas.dtos.BancosDTO;
import pe.edu.upc.aaw.tf_finanzas.entities.Bancos;
import pe.edu.upc.aaw.tf_finanzas.servicesinterfaces.IBancosService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bancos")
public class BancosController {
    @Autowired
    private IBancosService vrbRs;

    @PostMapping
    public void registrar(@RequestBody BancosDTO vrdto) {
        ModelMapper vrm = new ModelMapper();
        Bancos vrc = vrm.map(vrdto, Bancos.class);
        vrbRs.insert(vrc);
    }

    @GetMapping
    public List<BancosDTO> listar() {
        return vrbRs.vrlist().stream().map(x->{
            ModelMapper vrm=new ModelMapper();
            return vrm.map(x,BancosDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        vrbRs.delete(id);
    }

    @GetMapping("/{id}")
    public BancosDTO listarDTO(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        BancosDTO dto = m.map(vrbRs.listId(id),BancosDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody BancosDTO dto){
        ModelMapper m = new ModelMapper();
        Bancos t = m.map(dto, Bancos.class);
        vrbRs.insert(t);
    }
}
