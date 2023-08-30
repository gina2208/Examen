/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Examen {

    static List<Contacto> agenda = new ArrayList<>();

    public static void main(String[] args) {
         mostrarMenu();
    }

    public static void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            String opcionStr = JOptionPane.showInputDialog(
                    "-------------------------------------\n"
                    + "         LISTA DE CONTACTOS         \n"
                    + "-------------------------------------\n"
                    + "1. Agregar un numero a agenda de contactos\n"
                    + "2. Buscar un contacto por número \n"
                    + "3. Eliminar  contacto de la agenda\n"
                    + "4. Mostrar agenda completa\n"
                    + "0. Salir\n"
                    + "-------------------------------------\n"
                    + "Ingrese la opción que desea realizar:"
            );
            int opcion = Integer.parseInt(opcionStr);

            switch (opcion) {
                case 1:
                    agregarNumero();
                    break;
                case 2:
                    buscarContactoPorNumero();
                    break;
                case 3:
                    eliminarContacto();
                    break;
                case 4:
                    mostrarAgenda();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
                    break;
            }
        }

        JOptionPane.showMessageDialog(null, "Gracias por utilizar la agenda. ¡Hasta luego!");
    }

    public static void agregarNumero() {
        long numero = Long.parseLong(JOptionPane.showInputDialog("Ingrese el numero del contacto"));
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del contacto:");

        Contacto nuevoContacto = new Contacto(nombre, numero);
        agenda.add(nuevoContacto);
        JOptionPane.showMessageDialog(null, "¡El contacto ha sido agregado a la agenda correctamente!\n" + nuevoContacto.toString());
    }

    public static void buscarContactoPorNumero() {
        long numero = Long.parseLong(JOptionPane.showInputDialog("Ingrese el numero del contacto:"));
        for (Contacto contacto : agenda) {
            if (contacto.numero == numero) {
                JOptionPane.showMessageDialog(null, "Contacto encontrado:\n" + contacto.toString());
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Contacto no encontrado en la agenda.");
    }

    public static void eliminarContacto() {
        long numero = Long.parseLong(JOptionPane.showInputDialog("Ingrese el numero del contacto:"));
        for (Contacto contacto : agenda) {
            if (contacto.numero == numero) {
                agenda.remove(contacto);
                JOptionPane.showMessageDialog(null, "El contacto ha sido eliminado de la agenda.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Contacto no encontrado en la agenda.");
    }

    public static void mostrarAgenda() {
        StringBuilder agendaCompleta = new StringBuilder("Agenda Completa:\n");

        for (Contacto contacto : agenda) {
            agendaCompleta.append(contacto.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, agendaCompleta.toString());
    }
}
