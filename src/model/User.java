/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

import component.SendEmail;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import services.ServiceUser;

/**
 *
 * @author Faty
 */
public class User {

    protected int id;
    protected String nom;
    protected String prenom;
    protected int phone;
    protected String email;
    protected String pwd;
    protected String carte_banq;
    protected Role role;
    protected boolean is_blocked;
    
    
    ServiceUser sU = new ServiceUser();

    public User() {
    }

    public User(int id) {
        this.id = id;
        // this.role
    }

    public boolean isBlocked() {
        return this.is_blocked;
    }

    public void Block() {
        this.is_blocked = !this.is_blocked;
    }

    public void json() throws MalformedURLException, IOException {
        // Create a neat value object to hold the URL
        URL url = new URL("http://127.0.0.1:8000/user/listUserJSON");

// Open a connection(?) on the URL(??) and cast the response(???)
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

// Now it's "open", we can set the request method, headers etc.
        connection.setRequestProperty("accept", "application/json");

// This line makes the request
        InputStream responseStream = connection.getInputStream();

// Manually converting the response body InputStream to APOD using Jackson
        ObjectMapper mapper = new ObjectMapper();
//        APOD apod = mapper.readValue(responseStream, APOD.class);

// Finally we have the response
//        System.out.println(apod.title);

    }

    public static void post(String url, String json) throws Exception {
        String charset = "UTF-8";
        URLConnection connection = new URL(url).openConnection();
        connection.setDoOutput(true); // Triggers POST.
        connection.setRequestProperty("Accept-Charset", charset);
        connection.setRequestProperty("Content-Type", "application/json;charset=" + charset);

        try (OutputStream output = connection.getOutputStream()) {
            output.write(json.getBytes(charset));
        }

        InputStream response = connection.getInputStream();
        System.out.println("ass");
                System.out.println(response.toString());

    }
    

    
    public void main() throws Exception{
        post("http://127.0.0.1:8000/user/listUserJSON",
                   "{}");
    }

    public void resetPassword() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String token = bytes.toString();

        SendEmail mail = new SendEmail(this, "Password reset", "this is your token \n" + token);
        System.out.println("Donner le token");
        Scanner in = new Scanner(System.in);
        String sent = in.nextLine();
        if (sent.equals(token)) {
            System.out.println("Verifier");
            System.out.println("Donner le nouveaux mot de pass");
            String mdp = in.nextLine();
            this.pwd = mdp;
            sU.update(this);
        } else {
            System.out.println("Non Verifier");
        }
    }

    public boolean Login(String mail, String password) throws NoSuchAlgorithmException, IOException {

        User u = sU.getByMail(mail);
        System.out.println(crypPassword(password));
//        return crypPassword(password).equals(u.getPwd());
        
        
        
        
        URL url = new URL("http://127.0.0.1:8000/loginJson"
                + "?email="+mail
                +"&password="+ password);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
//        http.setRequestProperty("Accept", "application/json");
System.out.println("URL== "+url);

//        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(http.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
        http.disconnect();
        
        return true;
    }

    public User(int id, String nom, String prenom, int phone, String email, String pwd, String carte_banq,
            String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.phone = phone;
        this.email = email;
        this.pwd = pwd;
        this.carte_banq = carte_banq;
        this.role = Role.value(role);
    }

    public User(int id, String nom, String prenom, int phone, String email, String pwd, String carte_banq) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.phone = phone;
        this.email = email;
        this.pwd = pwd;
        this.carte_banq = carte_banq;
    }

    public User(String nom, String prenom, int phone, String email, String pwd, String carte_banq, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.phone = phone;
        this.email = email;
        this.pwd = pwd;
        this.carte_banq = carte_banq;
        this.role = Role.valueOf(role);
    }

    public User(String nom, String prenom, int phone, String email, String pwd, String carte_banq) {
        this.nom = nom;
        this.prenom = prenom;
        this.phone = phone;
        this.email = email;
        this.pwd = pwd;
        this.carte_banq = carte_banq;
    }

    public User(Universite uni) {
        this.id = uni.getId();
        this.nom = uni.getNom();
        this.prenom = "";
        this.phone = 0;
        this.email = uni.getEmail();
        this.pwd = uni.getMdpuni();
        this.carte_banq = "";
        this.role = Role.universite;
    }

    public User(societe s) {
        this.id = Integer.valueOf(s.getIdsoc());
        this.nom = s.getNom();
        this.prenom = "";
        this.phone = 0;
        this.email = s.getEmail();
        this.pwd = s.getMdpsoc();
        this.carte_banq = "";
        this.role = Role.societe;
    }

    @Override
    public String toString() {
        return "{"
                + " id='" + getId() + "'"
                + ", nom='" + getNom() + "'"
                + ", prenom='" + getPrenom() + "'"
                + ", phone='" + getPhone() + "'"
                + ", email='" + getEmail() + "'"
                + ", pwd='" + getPwd() + "'"
                + ", carte_banq='" + getCarte_banq() + "'"
                + ", role='" + getRole() + "'"
                + "}";
    }

    // public hashing()
    public static String crypPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encoded = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        byte[] hash = encoded;
        // System.out.println(encoded);
        // to hex
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        String haja = encoded.toString();
        haja = haja.substring(2, haja.length());
        // return haja;
        return hexString.toString();
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCarte_banq() {
        return this.carte_banq;
    }

    public void setCarte_banq(String carte_banq) {
        this.carte_banq = carte_banq;
    }

}
