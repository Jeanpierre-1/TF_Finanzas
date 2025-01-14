package pe.edu.upc.aaw.tf_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.tf_finanzas.dtos.ValorDolarDTO;
import pe.edu.upc.aaw.tf_finanzas.entities.ValorDolar;
import pe.edu.upc.aaw.tf_finanzas.servicesinterfaces.IValorDolarService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dolar")
public class ValorDolarController {
    @Autowired
    private IValorDolarService vrvDs;

    @PostMapping
    public void registrar(@RequestBody ValorDolarDTO vrdto) {
        vrdto.setFecha_registro(LocalDate.now()); // Establece la fecha actual

        ModelMapper vrm = new ModelMapper();
        ValorDolar vrc = vrm.map(vrdto, ValorDolar.class);
        vrvDs.insert(vrc);
    }

    @GetMapping
    public List<ValorDolarDTO> listar() {
        return vrvDs.list().stream().map(x->{
            ModelMapper vrm=new ModelMapper();
            return vrm.map(x,ValorDolarDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        vrvDs.delete(id);
    }

    @GetMapping("/{id}")
    public ValorDolarDTO listarDTO(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        ValorDolarDTO dto = m.map(vrvDs.listarId(id),ValorDolarDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody ValorDolarDTO dto){
        ModelMapper m = new ModelMapper();
        ValorDolar t = m.map(dto, ValorDolar.class);
        vrvDs.insert(t);
    }

    @GetMapping("/valor")
    public double getUltimoValorDolar() {
        Double valor = vrvDs.findLastDolarValue();
        return valor != null ? valor : 0.0;
    }
}
