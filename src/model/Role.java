/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.ResponseCache;

/**
 *
 * @author mrram
 */
public enum Role {
    etudiant,
    enseignant,
    Recruteur,
    admin,
    universite,
    societe,
    empty;

    public static Role value(String x) {

    
        Role r;
        switch (x.toLowerCase()) {
            case "role_enseignant":
                r = enseignant;
                break;
            case "role_etudiant":
                r = etudiant;
                break;
            case "recruteur":
                r = Recruteur;
                break;
            case "role_admin":
                r = admin;
                break;
            case "role_universite":
                r = universite;
                break;
            case "role_societe":
                r = societe;
                break;

            default:
                r = empty;
                break;
        }
        System.out.println("**role = " + r);
        return r;
    }
}
