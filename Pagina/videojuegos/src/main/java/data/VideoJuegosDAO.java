
package data;

import static data.Conexion.close;
import static data.Conexion.getConexion;
import entity.videoJuegos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VideoJuegosDAO {
    private static final String SQL_CREATE = "INSERT INTO libros(nombre, autor, cantJuegos, precio, copias) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_READ = "SELECT * FROM videojuegos";
    private static final String SQL_UPDATE_PRECIO = "UPDATE videojuegos SET precio = ? WHERE idvideoJuegos = ?";
    private static final String SQL_UPDATE_COPIAS = "UPDATE videojuegos SET copias = ? WHERE idvideoJuegos = ?";
    private static final String SQL_DELETE = "DELETE FROM videojuegos WHERE idvideoJuegos = ?";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM videojuegos WHERE idvideoJuegos = ?";
    
    public List<videoJuegos> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        videoJuegos videojuegos = null;
        List<videoJuegos> videojuego = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idvideoJuegos = rs.getInt(1);
                String nombre = rs.getString(2);
                String autor = rs.getString(3);
                int cantJuegos = rs.getInt(4);
                double precio = rs.getDouble(5);
                int copias = rs.getInt(6);

                videojuegos = new videoJuegos(idvideoJuegos, nombre, autor, cantJuegos, precio, copias);

                videoJuegos.add(videojuego);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return videojuego;
    }
    
    public videoJuegos findVideoByID(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        videoJuegos videojuegos = null;
        

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            rs = stmt.executeQuery();
            while (rs.absolute(1) ) {
                int idvideoJuegos = rs.getInt(1);
                String nombre = rs.getString(2);
                String autor = rs.getString(3);
                int cantJuegos = rs.getInt(4);
                double precio = rs.getDouble(5);
                int copias = rs.getInt(6);

                videojuegos = new videoJuegos(idvideoJuegos, nombre, autor, cantJuegos, precio, copias);

                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return videojuegos;
    }

    public int create(videoJuegos videojuego) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_CREATE);
            stmt.setString(1, videojuego.getNombre());
            stmt.setString(2, videojuego.getAutor());
            stmt.setInt(3, videojuego.getCantJuegos());
            stmt.setDouble(4, videojuego.getPrecio());
            stmt.setInt(5, videojuego.getCopias());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int updatePrecio(videoJuegos videojuego) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_PRECIO);
            stmt.setDouble(1, videojuego.getPrecio());
            stmt.setInt(2, videojuego.getIdvideoJuegos());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int updateCopias(videoJuegos videojuego) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_COPIAS);
            stmt.setInt(1, videojuego.getCopias());
            stmt.setInt(2, videojuego.getIdvideoJuegos());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int delete(videoJuegos videojuego) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, videojuego.getIdvideoJuegos());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
