
package tr.gov.ptt.rehberwebprj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tr.gov.ptt.rehberwebprj.dao.GirisDAO;
import tr.gov.ptt.rehberwebprj.dto.GirisDTO;


@WebServlet(name = "GirisKontrolServlet", urlPatterns = {"/girisKontrol"})
public class GirisKontrolServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String kullanici = request.getParameter("kullanici");
            String sifre     = request.getParameter("sifre");
            
            GirisDTO giris = new GirisDTO();
            giris.setKullanici(kullanici);
            giris.setSifre(sifre);
            boolean  sonuc    =GirisDAO.giriseYetkilimi(giris);
            RequestDispatcher rd ;
            
            if(sonuc){
                HttpSession session = request.getSession(true);
                session.setAttribute("kullanici", giris.getKullanici());
                rd = request.getRequestDispatcher("menu.jsp");
                rd.forward(request, response);
            }else{
                request.setAttribute("Hata", "Kullanıcı adı ya da şifre hatalı");
                rd = request.getRequestDispatcher("giris.jsp");
                rd.forward(request, response);
            }
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GirisKontrolServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GirisKontrolServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
