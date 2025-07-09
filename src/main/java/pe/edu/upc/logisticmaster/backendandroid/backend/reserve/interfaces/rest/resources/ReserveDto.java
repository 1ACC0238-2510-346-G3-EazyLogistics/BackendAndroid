package pe.edu.upc.logisticmaster.backendandroid.backend.reserve.interfaces.rest.resources;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class ReserveDto {
    private Long id;
    private String nombreHuespedes;
    private String habitacion;
    private String horaIngreso;
    private String horaSalida;

    /** Solo de salida, no lo envía el cliente */
    @JsonProperty(value = "fechaCreacion", access = Access.READ_ONLY)
    private LocalDateTime fechaCreacion;

    public ReserveDto() { }

    /** Constructor completo de salida */
    public ReserveDto(Long id,
                      String nombreHuespedes,
                      String habitacion,
                      String horaIngreso,
                      String horaSalida,
                      LocalDateTime fechaCreacion) {
        this.id = id;
        this.nombreHuespedes = nombreHuespedes;
        this.habitacion = habitacion;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
        this.fechaCreacion = fechaCreacion;
    }

    // getters & setters (sin setFechaCreacion)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreHuespedes() { return nombreHuespedes; }
    public void setNombreHuespedes(String nombreHuespedes) { this.nombreHuespedes = nombreHuespedes; }

    public String getHabitacion() { return habitacion; }
    public void setHabitacion(String habitacion) { this.habitacion = habitacion; }

    public String getHoraIngreso() { return horaIngreso; }
    public void setHoraIngreso(String horaIngreso) { this.horaIngreso = horaIngreso; }

    public String getHoraSalida() { return horaSalida; }
    public void setHoraSalida(String horaSalida) { this.horaSalida = horaSalida; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
}
