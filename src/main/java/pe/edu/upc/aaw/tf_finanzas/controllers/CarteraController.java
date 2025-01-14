package pe.edu.upc.aaw.tf_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.tf_finanzas.dtos.CarteraDTO;
import pe.edu.upc.aaw.tf_finanzas.dtos.CarteraUpdateDTO;
import pe.edu.upc.aaw.tf_finanzas.entities.Cartera;
import pe.edu.upc.aaw.tf_finanzas.entities.Users;
import pe.edu.upc.aaw.tf_finanzas.servicesinterfaces.ICarteraService;
import pe.edu.upc.aaw.tf_finanzas.servicesinterfaces.IUserService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartera")
public class CarteraController {
    @Autowired
    private ICarteraService vrCs;

    @Autowired
    private IUserService uS;

    @PostMapping
    public void registrar(@RequestBody CarteraDTO vrdto) {
        // Obtener el username del contexto de seguridad
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Buscar el usuario
        List<Users> usuarios = uS.buscarUsername(username);
        if (!usuarios.isEmpty()) {
            ModelMapper vrm = new ModelMapper();
            Cartera vrc = vrm.map(vrdto, Cartera.class);

            // Establecer el usuario actual
            vrc.setUsuarios(usuarios.get(0));

            // Establecer valores predeterminados
            vrc.setTotal_valor_nominal(0.0);
            vrc.setTotal_valor_neto(0.0);
            vrc.setTcea(0.0);
            vrCs.insert(vrc);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    @GetMapping
    public List<CarteraDTO> listar() {
        return vrCs.vrlist().stream().map(x->{
            ModelMapper vrm=new ModelMapper();
            return vrm.map(x,CarteraDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        vrCs.delete(id);
    }

    @GetMapping("/{id}")
    public CarteraDTO listarDTO(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        CarteraDTO dto = m.map(vrCs.listId(id),CarteraDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody CarteraUpdateDTO dto) {
        try {
            // Obtener la cartera existente
            Cartera carteraExistente = vrCs.listId(dto.getId());

            if (carteraExistente == null) {
                throw new RuntimeException("Cartera no encontrada");
            }

            // Actualizar solo los campos permitidos
            if (dto.getBancos() != null) {
                carteraExistente.setBancos(dto.getBancos());
            }
            if (dto.getFecha_descuento() != null) {
                carteraExistente.setFecha_descuento(dto.getFecha_descuento());
            }
            if (dto.getMoneda() != null && !dto.getMoneda().trim().isEmpty()) {
                carteraExistente.setMoneda(dto.getMoneda());
            }

            // Guardar los cambios
            vrCs.insert(carteraExistente);
        } catch (Exception e) {
            throw new RuntimeException("Error al modificar la cartera: " + e.getMessage());
        }
    }

    @GetMapping("/listar/carteraporusuario")
    public List<CarteraDTO> listarPorUsuarios() {
        // Obtener el username del contexto de seguridad
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Buscar el usuario
        List<Users> usuarios = uS.buscarUsername(username);
        if (!usuarios.isEmpty()) {
            Users usuario = usuarios.get(0);
            return vrCs.findCarteraByIdUser(usuario.getId()).stream().map(x->{
                ModelMapper vrm = new ModelMapper();
                return vrm.map(x, CarteraDTO.class);
            }).collect(Collectors.toList());
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    @GetMapping("/dias-cartera/{idCartera}")
    public List<LocalDate> listarDiasPorCartera(@PathVariable("idCartera") int idCartera) {
        return vrCs.getDiasCarteraById(idCartera).stream().map(x->{
            ModelMapper vrm=new ModelMapper();
            return vrm.map(x,LocalDate.class);
        }).collect(Collectors.toList());
    }

    @PutMapping("/calculos/{id}")
    public void actualizarCalculos(@PathVariable("id") Integer id) {
        vrCs.updateCalculos(id);
    }
}
