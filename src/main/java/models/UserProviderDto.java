package models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserProviderDto {
    private int id;
    private String nombre;
    private String rut;
    private String direccion;
    private String telefono;
    private String correo;
    private String contacto;
    private String telefono_contacto;
}

