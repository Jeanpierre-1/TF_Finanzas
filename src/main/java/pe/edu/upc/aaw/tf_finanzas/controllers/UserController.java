package pe.edu.upc.aaw.tf_finanzas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.tf_finanzas.dtos.UserDTO;
import pe.edu.upc.aaw.tf_finanzas.entities.Users;
import pe.edu.upc.aaw.tf_finanzas.servicesinterfaces.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private IUserService uS;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public void registrar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        uS.insert(u);
    }

    @PutMapping
    public void modificar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);

        // Obtener el usuario existente con sus roles y datos
        Users existingUser = uS.listarId(u.getId());

        // Mantener los roles existentes
        u.setRoles(existingUser.getRoles());

        // Verificar si la contraseña enviada es diferente a la almacenada
        if (u.getPassword() != null && !u.getPassword().equals(existingUser.getPassword())) {
            // Solo codificar si es una nueva contraseña
            String encodedPassword = passwordEncoder.encode(u.getPassword());
            u.setPassword(encodedPassword);
        } else {
            // Mantener la contraseña existente sin modificar
            u.setPassword(existingUser.getPassword());
        }

        uS.insert(u);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        uS.delete(id);
    }

    @GetMapping("/{id}")
    public UserDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        UserDTO dto = m.map(uS.listarId(id), UserDTO.class);
        return dto;
    }

    @GetMapping
    public List<UserDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/buscar/{username}")
    public List<UserDTO> buscarPorUsername(@PathVariable("username") String username) {
        return uS.buscarUsername(username).stream().map(x->{
            ModelMapper vrm=new ModelMapper();
            return vrm.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }
}
