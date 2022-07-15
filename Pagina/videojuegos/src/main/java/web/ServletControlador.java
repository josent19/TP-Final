
package web;

import entity.videoJuegos;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String accion = req.getParameter("accion");

        if (accion != null){
            switch (accion){
                case "editar":
                    editarJuego(req, res);
                    break;
                case "eliminar":
                    eliminarJuegos(req,res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        } else {
            accionDefault(req, res);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    guardarJuego(req, res);
                    break;
                case "modificar":
                    modificarJuego(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;

            }
        }
    }
    
    private void accionDefault(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<videoJuegos> juegos = new videoJuegosDAO().findAll();
        HttpSession sesion = req.getSession();
        sesion.setAttribute("pepe", juegos);
        sesion.setAttribute("cantidadJuegos", calcularCant(juegos));
        sesion.setAttribute("precioTotal", calcularPrecio(juegos));
        //req.getRequestDispatcher("libros.jsp").forward(req, res);
        res.sendRedirect("videojuegos.jsp");
    }
    
    private void guardarJuego(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String autor = req.getParameter("autor");
        int cantJuegos = Integer.parseInt(req.getParameter("cantJuegos"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        int copias = Integer.parseInt(req.getParameter("copias"));

        videoJuegos juego = new videoJuegos(nombre, autor, cantJuegos, precio, copias);
        int regMod = new videoJuegosDAO().create(juego);
        System.out.println("Insertados: " + regMod);
        accionDefault(req, res);
    }

    private void editarJuego(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idvideoJuegos = Integer.parseInt(req.getParameter("idvideoJuegos"));
        videoJuegos lib = new videoJuegosDAO().findBookById(idvideoJuegos);
        req.setAttribute("juego", lib);
        req.getRequestDispatcher("/WEB-INF/paginas/operaciones/editarJuegos.jsp").forward(req, res);
    }

    private void modificarJuego(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String autor = req.getParameter("autor");
        int cantJuegos = Integer.parseInt(req.getParameter("cantJuegos"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        int copias = Integer.parseInt(req.getParameter("copias"));

        int idvideoJuegos = Integer.parseInt(req.getParameter("idvideoJuegos"));

        videoJuegos lib = new videoJuegos(idvideoJuegos, nombre, autor, cantJuegos, precio, copias);

        int regMod = new videoJuegosDAO().update(lib);

        System.out.println("SE ACTUALIZARON: " + regMod + " REGISTROS");

        accionDefault(req, res);
    }
    
    private void eliminarJuegos(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idvideoJuegos = Integer.parseInt(req.getParameter("idvideoJuegos"));
        
        int regDel = new videoJuegosDAO().delete(idvideoJuegos);
        
        System.out.println("REGISTROS ELIMINADOS: "+ regDel);
        
        accionDefault(req, res);
    }


    private Object calcularCant(List<videoJuegos> videojuegos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object calcularPrecio(List<videoJuegos> videojuegos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
