import javax.swing.*;
import java.util.Iterator;
import java.util.Objects;
import java.util.Stack;

public class metodos {

    public Stack<prenda> llenarpila(Stack<prenda> pila) {
        boolean continuar = true;
        String agregar = "";
        while (continuar) {
            boolean existe = false;
            prenda r = new prenda();
            r.setReferencia(JOptionPane.showInputDialog("ingrese la referencia: "));
            existe = buscarprenda2(pila, r.getReferencia());
            if (existe) {
                r.setCantidad(Integer.parseInt(JOptionPane.showInputDialog("la referencia ya existe. \n" +
                        "ingrese la cantidad a agregar: ")));
                for (prenda prenda : pila) {
                    if (Objects.equals(prenda.referencia, r.getReferencia())) {
                        prenda.setCantidad(prenda.getCantidad() + r.getCantidad());
                    }
                }
            } else {
                r.setMarca(JOptionPane.showInputDialog("ingrese la marca: "));
                r.setCantidad(Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad: ")));
                r.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("ingrese el precio: ")));
                pila.push(r);
            }


            agregar = JOptionPane.showInputDialog("Desea agregar mas registros? S/N");


            if (agregar.toLowerCase().equalsIgnoreCase("N")) {
                continuar = false;
            }
        }
        return pila;
    }

    public void buscarprenda(Stack<prenda> pila, String referencia) {

        if(buscarprenda2(pila, referencia)){
            for (prenda prenda : pila) {
                if (Objects.equals(prenda.referencia, referencia)) {
                    JOptionPane.showMessageDialog(null, "-------------------------------" +
                            "                                                 \nMarca: " + prenda.getMarca() +
                            "                                                 \nReferencia: " + prenda.getReferencia() +
                            "                                                 \nCantidad: " + prenda.getCantidad() +
                            "                                                 \nPrecio: " + prenda.getPrecio() +
                            "                                                 \n-------------------------------");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "prenda no encontrado");
        }
    }

    public void consultarstock(Stack<prenda> pila) {
        StringBuilder mensaje = new StringBuilder();
        for (prenda prenda : pila) {
            mensaje.append("\n-------------------------------")
                    .append("\nMarca: ")
                    .append(prenda.getMarca()).append("\nReferencia: ")
                    .append(prenda.getReferencia()).append("\nCantidad: ")
                    .append(prenda.getCantidad()).append("\nPrecio: ")
                    .append(prenda.getPrecio())
                    .append("\n-------------------------------\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    public boolean buscarprenda2(Stack<prenda> pila, String referencia) {
        boolean busqueda = false;
        for (prenda prenda : pila) {
            if (Objects.equals(prenda.referencia, referencia)) {
                busqueda = true;
                break;
            }
        }
        return busqueda;
    }

    public Stack<prenda> eliminaprenda(Stack<prenda> pila, String referencia) {
        for (prenda o : pila) {
            if (o.getMarca().equalsIgnoreCase(referencia)) {
                pila.remove(o);
            }
        }
        return pila;
    }

    public Stack<prenda> modificarPila(Stack<prenda> pila, String referencia) {
        for (prenda prenda : pila) {
            if (Objects.equals(prenda.referencia, referencia)) {
                JOptionPane.showMessageDialog(null, "-------------------------------" +
                        "                                                 \nMarca: " + prenda.getMarca() +
                        "                                                 \n Referencia: " + prenda.getReferencia() +
                        "                                                 \n Cantidad: " + prenda.getCantidad() +
                        "                                                 \nPrecio: " + prenda.getPrecio() +
                        "                                                 \n-------------------------------");
                boolean modificar = true;

                while (modificar) {
                    int opcion = Integer.parseInt(JOptionPane.showInputDialog("Que desea modificar?\n1.Marca" +
                            "                                                                        \n2.Referencia" +
                            "                                                                        \n3.Cantidad" +
                            "                                                                        \n4.Precio" +
                            "                                                                        \n0.Salir"));

                    switch (opcion) {
                        case 1:
                            prenda.setMarca(JOptionPane.showInputDialog("ingrese la nueva marca: "));
                            break;
                        case 2:
                            prenda.setReferencia(JOptionPane.showInputDialog("ingrese la nueva referencia: "));
                            break;
                        case 3:
                            prenda.setCantidad(Integer.parseInt(JOptionPane.showInputDialog("ingrese la nueva cantidad: ")));
                            break;
                        case 4:
                            prenda.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("ingrese el nuevo precio: ")));
                            break;
                        case 0:
                            modificar = false;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opcion invalida, ingresela de nuevo");
                            break;

                    }
                }
                JOptionPane.showMessageDialog(null, "Resultado:" +
                        "                                                 \nMarca: " + prenda.getMarca() +
                        "                                                 \nReferencia: " + prenda.getReferencia() +
                        "                                                 \nCantidad: " + prenda.getCantidad() +
                        "                                                 \nPrecio: " + prenda.getPrecio() +
                        "                                                 \n-------------------------------");

                return pila;
            } else {
                JOptionPane.showMessageDialog(null, "prenda no encontrado");
            }
        }
        return pila;
    }

    public Stack<prenda> venderprenda(Stack<prenda> pila) {
        String referencia = JOptionPane.showInputDialog("ingrese la referencia a vender: ");
        if (buscarprenda2(pila, referencia)) {
            for (prenda prenda : pila) {

                if (Objects.equals(prenda.referencia, referencia)) {
                    boolean modificar = true;
                    while (modificar) {
                        int opcion = Integer.parseInt(JOptionPane.showInputDialog("-------------------------------" +
                                "                                                 \nMarca: " + prenda.getMarca() +
                                "                                                 \nReferencia: " + prenda.getReferencia() +
                                "                                                 \nCantidad: " + prenda.getCantidad() +
                                "                                                 \nPrecio: " + prenda.getPrecio() +
                                "                                                 \n-------------------------------" +
                                "                                                 \ncuanta cantidad desea vender?"));

                        if (opcion > prenda.getCantidad()) {
                            JOptionPane.showMessageDialog(null, "Excede la cantidad ");
                        } else {
                            prenda.setCantidad(prenda.getCantidad() - opcion);
                            JOptionPane.showMessageDialog(null, "Resultado:" +
                                    "                                                 \nMarca: " + prenda.getMarca() +
                                    "                                                 \nReferencia: " + prenda.getReferencia() +
                                    "                                                 \nCantidad: " + prenda.getCantidad() +
                                    "                                                 \nPrecio: " + prenda.getPrecio() +
                                    "                                                 \n-------------------------------");
                            modificar = false;
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "prenda no encontrada\n registrela a continuacion: ");
            pila = llenarpila(pila);
        }
        return pila;
    }
}