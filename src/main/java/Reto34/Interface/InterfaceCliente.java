package Reto34.Interface;

import Reto34.Modelo.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceCliente extends CrudRepository<Cliente, Integer> {

}
