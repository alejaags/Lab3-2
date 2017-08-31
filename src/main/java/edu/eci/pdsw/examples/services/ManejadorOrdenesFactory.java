/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.examples.services;
import com.google.inject.AbstractModule;
import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import edu.eci.pdsw.examples.beans.CalculadorCuenta;
import edu.eci.pdsw.examples.beans.CalculadorCuentaConPropina;
import edu.eci.pdsw.examples.beans.VerificadorIVA;
import edu.eci.pdsw.examples.beans.VerificadorIvaEstandar;
/**
 *
 * @author JuanCamilo
 */
public class ManejadorOrdenesFactory {
    private static ManejadorOrdenesFactory instance = new ManejadorOrdenesFactory();
    
    private static Injector injector;  
    
    private ManejadorOrdenesFactory(){
        injector = createInjector(new AbstractModule() {

                    
                    protected void configure() {
                        bind(CalculadorCuenta.class).to(CalculadorCuentaConPropina.class);
                        bind(VerificadorIVA.class).to(VerificadorIvaEstandar.class);
                    }
        }
        );
    }
    
    public CalculadorCuenta getCalculador(){
        return injector.getInstance(CalculadorCuenta.class);
    }
    
    public VerificadorIVA getVerificador(){
        return injector.getInstance(VerificadorIVA.class);
    }
    
    public static ManejadorOrdenesFactory getInstance(){
        return instance;
    }
}
