import javax.swing.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        metodos m = new metodos();
        Stack<prenda> prenda = new Stack<>();
        boolean modificar = true;
        String referencia = "";
        while (modificar) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    Que desea Hacer?
                    1.Ingresar prenda                                                                 \s
                    2.Buscar prenda                                                                 \s
                    3.Modificar prenda                                                                 \s
                    4.Eliminar prenda                                                                 \s
                    5.Vender prenda                                                                  \s
                    6.consultar stock                                                                 \s
                    0.Salir"""));

            switch (opcion) {
                case 1:
                    prenda = m.llenarpila(prenda);
                    break;
                case 2:
                    referencia = JOptionPane.showInputDialog("ingrese la referencia: ");
                    m.buscarprenda(prenda, referencia);
                    break;
                case 3:
                    referencia = JOptionPane.showInputDialog("ingrese la referencia a modificar: ");
                    prenda = m.modificarPila(prenda, referencia );
                    break;
                case 4:
                    referencia = JOptionPane.showInputDialog("ingrese la referencia a eliminar: ");
                    prenda = m.eliminaprenda(prenda, referencia);
                    break;
                case 5:
                    prenda = m.venderprenda(prenda);
                    break;
                case 6:
                    m.consultarstock(prenda);
                    break;
                case 0:
                    modificar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida, ingresela de nuevo");
                    break;

            }
        }
    }
}