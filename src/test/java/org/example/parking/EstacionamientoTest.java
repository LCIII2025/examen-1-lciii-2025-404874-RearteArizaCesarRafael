package org.example.parking;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        //TODO---- test
        Estacionamiento estacionamiento = new Estacionamiento();
        Vehiculo auto = new Vehiculo("af904sn","cronos", Vehiculo.Tipo.AUTO);

        estacionamiento.ingresarVehiculo("123456", "rafa rearte", auto);

        Ticket ticket = estacionamiento.retirarVehiculo("af904sn");
        assertNotNull(ticket);
        assertEquals("af904sn", ticket.getVehiculo().getPatente());
    }

    @Test
    public void testCalcularPrecio() throws Exception {
        // TODO---- test
        Cliente cliente = new Cliente("123456", "rafa rearte");
        Vehiculo auto = new Vehiculo("af904sn","cronos", Vehiculo.Tipo.AUTO);
        Vehiculo suv = new Vehiculo("ag999fh", "tiguan", Vehiculo.Tipo.SUV);
        Vehiculo chata = new Vehiculo("onj284","ranger", Vehiculo.Tipo.PICKUP);

        Ticket ticket1 = new Ticket(cliente, auto);
        Ticket ticket2 = new Ticket(cliente, suv);
        Ticket ticket3 = new Ticket(cliente, chata);

        ticket1.setHoraSalida(ticket1.getHoraEntrada().plusMinutes(60));
        ticket2.setHoraSalida(ticket2.getHoraEntrada().plusMinutes(60));
        ticket3.setHoraSalida(ticket3.getHoraEntrada().plusMinutes(60));

        assertEquals(100.0, ticket1.calcularPrecio());
        assertEquals(130.0, ticket2.calcularPrecio());
        assertEquals(180.0, ticket3.calcularPrecio());
    }

}