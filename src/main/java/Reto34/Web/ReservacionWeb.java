package Reto34.Web;

import Reto34.Modelo.Reservacion;
import Reto34.Repositorio.ContadorClientes;
import Reto34.Servicios.ServiciosReservacion;
import Reto34.Servicios.StatusReservas;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservacionWeb {

    @Autowired
    private ServiciosReservacion servicio;

    @GetMapping("/all")
    public List<Reservacion> getReservations() {
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservacion> getReservation(@PathVariable("id") int reservationId) {
        return servicio.getReservation(reservationId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion save(@RequestBody Reservacion reservation) {
        return servicio.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion update(@RequestBody Reservacion reservacion) {
        return servicio.update(reservacion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return servicio.deleteReservation(reservationId);
    }

    @GetMapping("/report-status")
    public StatusReservas getReservas() {
        return servicio.reporteStatusServicio();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservacion> getReservasTiempo(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo) {
        return servicio.reporteTiempoServicio(dateOne, dateTwo);
    }

    @GetMapping("/report-clients")
    public List<ContadorClientes> getClientes() {
        return servicio.reporteClientesServicio();
    }

}
