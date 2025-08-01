package pe.edu.upc.logisticmaster.backendandroid.backend.reserve.domain.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "reserve")
public class ReserveAggregate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_huespedes", nullable = false)
    private String nombreHuespedes;

    @Column(name = "habitacion", nullable = false)
    private String habitacion;

    @Column(name = "hora_ingreso", nullable = false)
    private String horaIngreso;

    @Column(name = "hora_salida", nullable = false)
    private String horaSalida;

    /** Se ignora en INSERT/UPDATE desde la app */
    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    protected ReserveAggregate() { }

    /** Constructor SIN fechaCreacion: se genera automáticamente */
    public ReserveAggregate(Long id,
                            String nombreHuespedes,
                            String habitacion,
                            String horaIngreso,
                            String horaSalida) {
        this.id = id;
        this.nombreHuespedes = nombreHuespedes;
        this.habitacion = habitacion;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
    }

    // getters y setters (incluye getFechaCreacion, no setter)
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
