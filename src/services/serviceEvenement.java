/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IEvenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Evenement;
import model.Universite;
import util.MyConnection;

/**
 *
 * @author Nabil
 */
public class serviceEvenement implements IEvenement {
       public     ObservableList<Evenement>obList = FXCollections.observableArrayList();

    
    public Connection myConnection = MyConnection.getInstance2();
    @Override
    public void ajouterEvenement(Evenement Ev) {
      String request = "INSERT INTO `evenement`(`idEvent`, `idOrg`, `description`, `date`, `heure`, `lien`, `imgEv`,`nbrParticipant`) VALUES ('"+Ev.getIdEvent()+"','"+Ev.getIdOrg()+"','"+Ev.getDescription()+"','"+Ev.getDate()+"','"+Ev.getHeure()+"','"+Ev.getLien()+"','"+Ev.getImgEv()+"','"+Ev.getNbrParticipant()+"')";
        try {
            if(!Existe(Ev)==true) {
                Statement st =myConnection.createStatement();
             st.executeUpdate(request);
              System.out.println("Event ajoutee avec succes");
            }
            else {
            System.out.println("Evenement deja existe");

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    }

    @Override
    public ObservableList<Evenement> afficherEvenement() {
        String request1 = "SELECT * FROM `evenement`";
        try {
            Statement st = myConnection.createStatement();
            ResultSet rs = st.executeQuery(request1);
             while (rs.next()){
               Evenement Ev= new Evenement();
                Ev.setIdEvent(rs.getInt(1));
                Ev.setIdOrg(rs.getString("idOrg"));
                Ev.setDescription(rs.getString("description"));
                Ev.setDate(rs.getDate("date"));
                Ev.setHeure(rs.getString("heure"));
                Ev.setLien(rs.getString("lien"));
                Ev.setImgEv(rs.getString("imgEv"));
                                Ev.setNbrParticipant(rs.getInt("nbrParticipant"));

               obList.add(Ev);
             }
        } catch (SQLException ex) {
     System.err.println(ex.getMessage());
        }
    
        return obList; 
    }

    @Override
    public void supprimerEvenement(int id ) {
      String request2="DELETE FROM evenement WHERE idEvent="+id;
        try{
            Statement st = myConnection.createStatement();
              st.executeUpdate(request2);
              
              System.out.println("Event supprimee avec succes");
           
        }
        catch(SQLException ex){  
            System.err.println(ex.getMessage());
        }     }

    @Override
    public void modifierEvenement(Evenement Ev,int idE) {
     try{      
      
      String request3="UPDATE `evenement` SET `idOrg`='"+Ev.getIdOrg()+"',`description`='"+Ev.getDescription()+"',`date`='"
              +Ev.getDate()+"',`heure`='"+Ev.getHeure()+"',`lien`='"+Ev.getLien()+"',`nbrParticipant`='"+Ev.getNbrParticipant()+"', `imgEv`='"+Ev.getImgEv()+"' WHERE `idEvent` = "+idE ; 

            Statement st = myConnection.createStatement();
       st.executeUpdate(request3);
        System.out.println("evenement modifie avec succes");
   
     }
     catch(SQLException ex){
         
     System.err.println(ex.getMessage());
     } 
    } 

    @Override
    public List<Evenement> rechercheEvenementsOrganisteur(String idOrganisteur) {
        List<Evenement>evenements = new ArrayList<Evenement>();
        
        String req = "SELECT * FROM evenement WHERE idOrg = ?";
        try {
            PreparedStatement st = myConnection.prepareStatement(req);
                      st.setString(1, idOrganisteur);

            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                  Evenement Ev = new Evenement();
                Ev.setIdOrg(rs.getString("idOrg"));
                Ev.setDescription(rs.getString("description"));
                Ev.setDate(rs.getDate("date"));
                Ev.setHeure(rs.getString("heure"));
                Ev.setLien(rs.getString("lien"));
                Ev.setImgEv(rs.getString("imgEv"));
                Ev.setNbrParticipant(rs.getInt("nbrParticipant"));
               evenements.add(Ev);
               
               
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return evenements;
        
    }


    public boolean Existe(Evenement e) {
      String sql = "SELECT * FROM evenement WHERE idOrg= ? AND description =? AND date = ? AND heure =?";//getting username
        try {
                        Statement st = myConnection.createStatement();

            //setting value for ?
                        PreparedStatement ps=myConnection.prepareStatement(sql);

            ps.setString(1,e.getIdOrg());
            ps.setString(2, e.getDescription());
            ps.setDate(3, e.getDate());
            ps.setString(4, e.getHeure());
                 ResultSet rs = ps.executeQuery();
            //checking if record with zid exist if yes do below  
            if(rs.next()){
            //put alert here
            return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(serviceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public int nombreTotalEvenement() {
        int i = 0;

	try{
		try{
                        Statement st = myConnection.createStatement();
			String query = "SELECT COUNT(*) FROM evenement";
			ResultSet rs=st.executeQuery(query);			
			//Extact result from ResultSet rs
			while(rs.next()){
			    System.out.println("Nombre totale des evenements(*)="+rs.getInt("COUNT(*)"));
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
        return  i;
    }

    @Override
    public void topFiveEvents() {
        
        HashMap<String,Integer> map =  new HashMap<String, Integer>();
        
        for(int i = 0 ; i< afficherEvenement().size();i++) {
            map.put(afficherEvenement().get(i).getIdOrg(),afficherEvenement().get(i).getNbrParticipant());
            
        }
      
        int n = 5;
        List<Entry<String, Integer>> greatest = findGreatest(map, 5);
        System.out.println("Top "+n+" entries:");
        for (Entry<String, Integer> entry : greatest)
        {
            if(entry.getValue() >= 50) {
                
                System.out.println(entry);
            }
        }
        
        
    }
    

    private static <K, V extends Comparable<? super V>> List<Entry<K, V>> 
        findGreatest(Map<K, V> map, int n)
    {
        Comparator<? super Entry<K, V>> comparator = 
            new Comparator<Entry<K, V>>()
        {
            @Override
            public int compare(Entry<K, V> e0, Entry<K, V> e1)
            {
                V v0 = e0.getValue();
                V v1 = e1.getValue();
                return v0.compareTo(v1);
            }
        };
        PriorityQueue<Entry<K, V>> highest = 
            new PriorityQueue<Entry<K,V>>(n, comparator);
        for (Entry<K, V> entry : map.entrySet())
        {
            highest.offer(entry);
            while (highest.size() > n)
            {
                highest.poll();
            }
        }

        List<Entry<K, V>> result = new ArrayList<Map.Entry<K,V>>();
        while (highest.size() > 0)
        {
            result.add(highest.poll());
        }
        return result;
    }
}
    


