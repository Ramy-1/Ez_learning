/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.ICours;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Categorie;
import model.Cours;
import model.Enseignant;
import model.Recruteur;
import util.MyConnection;

/**
 *
 * @author Nabil
 */
public class serviceCours implements ICours{

    
        public Connection myConnection = MyConnection.getInstance2();
   public     ObservableList<Cours>obList = FXCollections.observableArrayList();

    @Override
    public void ajouterCours(Cours C) {
 String request = "INSERT INTO `cours`( `titre`, `description`, `duree`, `datecreate`, `support`, `idcat`,`etat` ) VALUES ('"+C.getTitre()+"','"+C.getDescription()+"','"+C.getDuree()+"','"+C.getDatecreate()+"','"+C.getSupport()+"','"
         
         +C.getIdcat()+"','"+
         1+
         "')";
           try {
            if(!Existe(C)==true) {
                Statement st =myConnection.createStatement();
             st.executeUpdate(request);
              System.out.println("Cours ajoutee avec succes");
            }
            else {
            System.out.println("Cours deja existe");

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    }


    @Override
    public ObservableList<Cours> afficherCours() {
        String request1 = "SELECT * FROM `cours`";
        try {
            Statement st = myConnection.createStatement();
            ResultSet rs = st.executeQuery(request1);
             while (rs.next()){
               Cours C= new Cours();
               C.setId(rs.getInt(1));
               C.setTitre(rs.getString("titre"));
                C.setDescription(rs.getString("description"));
                C.setDuree(rs.getInt("duree"));
                                C.setDatecreate(rs.getDate("datecreate"));

                C.setSupport(rs.getString("support"));
                C.setIdcat(rs.getInt("idcat"));
               
               obList.add(C);
             }
        } catch (SQLException ex) {
     System.err.println(ex.getMessage());
        }
    
        return obList;     }

    @Override
    public void supprimerCours(int id) {
String request2="DELETE FROM `cours` WHERE `id`='"+id+"'";
        try{
            Statement st = myConnection.createStatement();
              st.executeUpdate(request2);
              
              System.out.println("Cours supprimee avec succes");
           
        }
        catch(SQLException ex){  
            System.err.println(ex.getMessage());
        }    }

    @Override
    public void modifierCours(Cours C, int idC) {
        try{      
        String request3="UPDATE `cours` SET `titre`='"+C.getTitre()+"',`description`='"+C.getDescription()+"',`duree`='"+C.getDuree()+"',`datecreate`='"+C.getDatecreate()+"',`support`='"+C.getSupport()+"',`idcat`='"+C.getIdcat()+"' WHERE `id` ="+idC ;  
            Statement st = myConnection.createStatement();
        st.executeUpdate(request3);
        System.out.println("cours modifie avec succes");
   
     }
     catch(SQLException ex){
     System.err.println(ex.getMessage());
     } 
    }
    
    //JOINTURE
        @Override
    public List<Cours> afficherCoursParCategorie(int idcat) {
 
        
        String sql ="SELECT *" +
"  FROM cours cou" +
"  JOIN categorie cat ON cou.idcat ="+idcat ;        
  List<Cours>list = new ArrayList<Cours>();
    try {
        PreparedStatement st = myConnection.prepareStatement(sql);
      ResultSet rs = st.executeQuery();
            
      while (rs.next()) {
          String titre = rs.getString("titre");
        String desc = rs.getString("description");
        Date date = rs.getDate("datecreate");
        int duree  = rs.getInt("duree");
        int iduni = rs.getInt("idcat");
        boolean etat = rs.getBoolean("etat");
        if(iduni ==idcat) {
                    Cours c = new Cours(titre, desc, duree, date,etat);
        list.add(c);

        }
        
      }
    }catch(Exception ex) {
        ex.printStackTrace();
    }
    return list;
    }


    
    //METIER
    
    
    
    public boolean Existe(Cours c) {
      String sql = "SELECT * FROM cours WHERE titre= ? AND description =? AND duree = ? AND datecreate =?";//getting username
        try {
                        Statement st = myConnection.createStatement();

            //setting value for ?
                        PreparedStatement ps=myConnection.prepareStatement(sql);

            ps.setString(1,c.getTitre());
            ps.setString(2, c.getDescription());
            ps.setInt(3, c.getDuree());
            ps.setDate(4, c.getDatecreate());
                 ResultSet rs = ps.executeQuery();
            //checking if record with zid exist if yes do below  
            if(rs.next()){
            //put alert here
            return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(serviceCours.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    
    
    

    @Override
    public boolean likeCours(int iduser, int idcours,int like) {
        
        try{
                   if(userLikeExist(iduser, idcours) == true) {
                System.out.println("tu as deja liker ce cours d'id="+idcours);
                return false;
            }
            if(like == 1 || like == 0) {
                
            } String request = "INSERT INTO `like_cours`( `iduser`, `id`,`like_etat`) VALUES ('"+iduser+"','"+idcours+"','"+like+"')";
            Statement st = myConnection.createStatement();
             st.executeUpdate(request);
             if(like == 1) {
                System.out.println("Like cours ajoutee avec succes");

             }else if(like == 0) {
                System.out.println("Dislike cours ajoutee avec succes");

             }
             else {
                 System.out.println("Like € [1,0]");
             }
       
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }       
        
        return true;
    }

    @Override
    public int countLikes() {
   int i = 0;
   	try{
		try{
                        Statement st = myConnection.createStatement();
			String query = "SELECT COUNT(*) FROM like_cours WHERE like_etat ="+1;
			ResultSet rs=st.executeQuery(query);			
			//Extact result from ResultSet rs
			while(rs.next()){
			    System.out.println("Nombre totale des Likes(*)="+rs.getInt("COUNT(*)"));
                            i++;
			  }
			// close ResultSet rs
		   } catch(SQLException s){						
				s.printStackTrace();
			 }
		// close Connection and Statement
		}catch (Exception e){
			e.printStackTrace();
		 }
        return  i;    }

    @Override
    public int countDislike() {
        int i=0;
      try{
		try{
                        Statement st = myConnection.createStatement();
			String query = "SELECT COUNT(*) FROM like_cours WHERE like_etat ="+0;
			ResultSet rs=st.executeQuery(query);			
			//Extact result from ResultSet rs
			while(rs.next()){
			    System.out.println("Nombre totale des Dislike(*)="+rs.getInt("COUNT(*)"));
                            i++;
			  }
			// close ResultSet rs
		   } catch(SQLException s){						
				s.printStackTrace();
			 }
		// close Connection and Statement
		}catch (Exception e){
			e.printStackTrace();
		 }
        return  i;    }

    @Override
    public String statLikeParRapportCours() {
        
        int nb = 0;
         float res;
         int nbTotalCours = 0;
        try{
        String req1 = "SELECT count(*) FROM `cours`";
                PreparedStatement preparedStatement = myConnection.prepareStatement(req1);

        ResultSet result = preparedStatement.executeQuery(req1);
        if (result.first()) {
            nb = result.getInt(1);
        }
        nbTotalCours = nb;

   
        
        
        
        
          
        }catch(Exception exx) {
            exx.printStackTrace();
        }
         res= ((float) countLikes() / nbTotalCours);
        
         //statistique like par rapport le total des cours
         System.out.println("Statistique like cours par rapport total des cours :\n"+new DecimalFormat("##.##").format(res * 100) + "%");
        
         //cours le plus liker
     
         
         
        
        
        
        
        
        
        
     
        return new DecimalFormat("##.##").format(res * 100);    }
     @Override
    public boolean userLikeExist(int iduser, int idcours) {
         String sql = "SELECT * FROM like_cours WHERE iduser= ? AND id =? ";
        try {
                        Statement st = myConnection.createStatement();

            //setting value for ?
                        PreparedStatement ps=myConnection.prepareStatement(sql);

            ps.setInt(1,iduser);
            ps.setInt(2, idcours);
          
                 ResultSet rs = ps.executeQuery();
            //checking if record with zid exist if yes do below  
            if(rs.next()){
            //put alert here
            return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(serviceCours.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    
    
    
    
    
    //JOINTURE COURS LIKER :
        
    //JOINTURE
        @Override
    public List<Cours> afficherCoursLiker() {
 
        
        String sql ="SELECT *" +
"  FROM cours cou" +
"  JOIN like_cours lic ON cou.id = lic.id" ;        
  List<Cours>list = new ArrayList<Cours>();
    try {
        PreparedStatement st = myConnection.prepareStatement(sql);
      ResultSet rs = st.executeQuery();
            
      while (rs.next()) {
          String titre = rs.getString("titre");
        String desc = rs.getString("description");
        Date date = rs.getDate("datecreate");
        int duree  = rs.getInt("duree");
        int iduni = rs.getInt("idcat");
        boolean etat = rs.getBoolean("etat");
                    Cours c = new Cours(titre, desc, duree, date,etat);
        list.add(c);
        

        
        
      }
    }catch(Exception ex) {
        ex.printStackTrace();
    }
    return list;
    }

    @Override
    public void traiterCours(Cours c) {
        
        try{      
        String request3="UPDATE `cours` SET `etat`='"+c.isEtat()+"' WHERE `id` ="+c.getId() ;
            Statement st = myConnection.createStatement();
        st.executeUpdate(request3);
        
        if(c.isEtat() == true)
        System.out.println("cours activé");
   
        else
            System.out.println("cours desactivé");
     }
     catch(SQLException ex){
     System.err.println(ex.getMessage());
     } 
    
        
        
        
    }
    
    public List getAll() {
        List<Cours> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `cours`";
            Statement st = myConnection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Cours e = new Cours(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5),rs.getString(6),rs.getInt(7));
                list.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    
    public List getCoursByCategorie(int id) {
        List<Cours> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `cours` WHERE idcat="+id;
            Statement st = myConnection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Cours e = new Cours(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5),rs.getString(6),rs.getInt(7));
                list.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    
    public Object getById(int id) {
        Enseignant u = new Enseignant();
        try {
            String req = "SELECT * FROM `Enseignant` where id = " + id;
            // Statement st = cnx.createStatement();
            Statement st = myConnection.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Enseignant us = new Enseignant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                u = us;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return u;
    }

     public Object SearchCours(String s) {
        List<Cours> list = new ArrayList<>();
  
        try {
            String req = "SELECT * FROM `cours` where titre like '%" + s+"%'";
            // Statement st = cnx.createStatement();
            Statement st = myConnection.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Cours e = new Cours(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5),rs.getString(6),rs.getInt(7));
                list.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
}



