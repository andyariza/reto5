package Reto34.Servicios;

import Reto34.Modelo.Mensaje;
import Reto34.Repositorio.MensajeRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosMensaje {

    @Autowired
    private MensajeRepositorio metodosCrud;

    public List<Mensaje> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Mensaje> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }

    public Mensaje save(Mensaje message) {
        if (message.getIdMessage() == null) {
            return metodosCrud.save(message);
        } else {
            Optional<Mensaje> evt = metodosCrud.getMessage(message.getIdMessage());
            if (evt.isEmpty()) {
                return metodosCrud.save(message);
            } else {
                return message;
            }
        }
    }

    public Mensaje update(Mensaje message) {
        if (message.getIdMessage() != null) {
            Optional<Mensaje> e = metodosCrud.getMessage(message.getIdMessage());
            if (!e.isEmpty()) {
                if (message.getMessageText() != null) {
                    e.get().setMessageText(message.getMessageText());
                }
                if (message.getClient()!= null) {
                    e.get().setClient(message.getClient());
                }
                if (message.getFarm()!= null) {
                    e.get().setFarm(message.getFarm());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
