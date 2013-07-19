package br.ufg.inf.es.fs.contpatri.web.controller;

import br.ufg.inf.es.fs.contpatri.contpatri.model.Gestor;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;


/**
 *
 * @author Gustavo
 */
    
@ManagedBean
@SessionScoped
public class GestorController implements Serializable {
 
    private Gestor gestor;
 
    public GestorController() {
        gestor = new Gestor();
        SecurityContext context = SecurityContextHolder.getContext();
        if (context instanceof SecurityContext){
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication){
                //gestor.setUsername(((User)authentication.getPrincipal()).getUsername());
            }
        }
    }
 
    public Gestor getGestor() {
        return gestor;
    }
 
    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }
     
}
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
