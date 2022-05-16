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
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import jdk.nashorn.internal.parser.JSONParser;

import services.ServiceUser;

/**
 *
 * @author Ramyy
 */
public class User {

    protected int id;
    protected String  email;
    protected String  roles;
    protected String password ;
    protected String name ;
    protected String last_name ;
    protected String face_id ;
    protected Role role;
    protected boolean is_verified ;
    protected boolean is_blocked ;
    
    
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
            this.password = mdp;
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
            if (response.toString().contains("ADMIN")){
                System.out.println("admin");
                
                return true;
            }
        }
        http.disconnect();
        return false;
    }

    public User(String email, String roles, String password, String name, String last_name, String face_id, String role, boolean is_verified, boolean is_blocked) {
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.name = name;
        this.last_name = last_name;
        this.face_id = face_id;
        this.role = Role.value(role);
        this.is_verified = is_verified;
        this.is_blocked = is_blocked;
    }

    public User(int id, String email, String roles, String password, String name, String last_name, String face_id, String role, int is_verified, int is_blocked) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.name = name;
        this.last_name = last_name;
        this.face_id = face_id;
        this.role = Role.value(role);
        this.is_verified = is_verified==1;
        this.is_blocked = is_blocked==1;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFace_id() {
        return face_id;
    }

    public void setFace_id(String face_id) {
        this.face_id = face_id;
    }

    public boolean isIs_verified() {
        return is_verified;
    }

    public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
    }

    public boolean isIs_blocked() {
        return is_blocked;
    }

    public void setIs_blocked(boolean is_blocked) {
        this.is_blocked = is_blocked;
    }

    public ServiceUser getsU() {
        return sU;
    }

    public void setsU(ServiceUser sU) {
        this.sU = sU;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", roles=" + roles + ", password=" + password + ", name=" + name + ", last_name=" + last_name + ", face_id=" + face_id + ", role=" + role + ", is_verified=" + is_verified + ", is_blocked=" + is_blocked + ", sU=" + sU + '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

}
