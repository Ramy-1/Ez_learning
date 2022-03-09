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

    public Role value(String x) {

        Role r;
        switch (x.toLowerCase()) {
            case "enseignant":
                r = enseignant;
                break;
            case "etudiant":
                r = etudiant;
                break;
            case "recruteur":
                r = Recruteur;
                break;
            case "admin":
                r = admin;
                break;
            case "universite":
                r = universite;
                break;
            case "societe":
                r = societe;

            default:
                r = empty;
                break;
        }
        System.out.println("**role = " + r);
        return r;
    }
}
