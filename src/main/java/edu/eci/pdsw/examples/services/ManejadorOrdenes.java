package edu.eci.pdsw.examples.services;

import java.util.LinkedList;
import java.util.List;

import edu.eci.pdsw.examples.model.ExcepcionManejadorOrdenes;
import edu.eci.pdsw.examples.model.Orden;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.examples.beans.CalculadorCuenta;

@Singleton
public class ManejadorOrdenes {

    @Inject
    private CalculadorCuenta cc;
    List<Orden> ordenes;

    public ManejadorOrdenes() {
        ordenes = new LinkedList<>();
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void registrarOrden(Orden o) {
        ordenes.add(o);
    }

    public Orden consultarOrden(int n) throws ExcepcionManejadorOrdenes {
        if (n >= ordenes.size()) {
            throw new ExcepcionManejadorOrdenes("Orden inexistente:");
        }
        return ordenes.get(n);
    }

    public int calcularTotalOrden(int n) throws ExcepcionManejadorOrdenes {
        if (n >= ordenes.size()) {
            throw new ExcepcionManejadorOrdenes("Orden inexistente:");
        }
        return cc.calcularCosto(ordenes.get(n));
    }

}
