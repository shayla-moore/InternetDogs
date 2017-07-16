package com.junald.controller;


import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.junald.dao.DogDAO;
import com.junald.dao.DogDAOImplementation;
import com.junald.model.Dog;
 
@WebServlet("/DogController")
public class DogController extends HttpServlet {
 
    private DogDAO dao;
    private static final long serialVersionUID = 1L;
    public static final String lIST_Dog = "/listDog.jsp";
    public static final String INSERT_OR_EDIT = "/Dog.jsp";
 
    public DogController() {
        dao = new DogDAOImplementation();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter( "action" );
 
        if( action.equalsIgnoreCase( "delete" ) ) {
            forward = lIST_Dog;
            int DogId = Integer.parseInt(request.getParameter(""));
            dao.deleteDog(DogId);
            request.setAttribute("Dogs", dao.getAllDogs() );
        }
        else if( action.equalsIgnoreCase( "edit" ) ) {
            forward = INSERT_OR_EDIT;
            int DogId = Integer.parseInt(request.getParameter("dog_id")) ;
            Dog Dog = dao.getDogById(DogId);
            request.setAttribute("Dog", Dog);
        }
        else if( action.equalsIgnoreCase( "insert" ) ) {
            forward = INSERT_OR_EDIT;
        }
        else {
            forward = lIST_Dog;
            request.setAttribute("Dogs", dao.getAllDogs() );
        }
        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dog Dog = new Dog();
        Dog.setdName( request.getParameter( "dname" ) );
        Dog.setBreed( request.getParameter( "breed" ) );
        Dog.setAge( Integer.parseInt( request.getParameter( "age" ) ) );
        Dog.setBirthday( request.getParameter( "birthday" ) );
        Dog.setOwner( request.getParameter( "owner_name" ) );
        
        String DogId = request.getParameter("dog_id");
 
        if( DogId == null || DogId.isEmpty() )
            dao.addDog(Dog);
        else {
            Dog.setDogId( Integer.parseInt(DogId) );
            dao.updateDog(Dog);
        }
        RequestDispatcher view = request.getRequestDispatcher( lIST_Dog );
        request.setAttribute("Dogs", dao.getAllDogs());
        view.forward(request, response);
    }
}