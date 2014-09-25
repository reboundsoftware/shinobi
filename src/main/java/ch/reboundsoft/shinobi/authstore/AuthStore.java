/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.reboundsoft.shinobi.authstore;

/**
 *
 * @author rmaire
 */
public interface AuthStore {
    
    public boolean login(String name, String password);    
    public boolean logout(String name);    
    public boolean hasRole(String name, String role);    
    public boolean isPermitted(String name, String permission);
    
}
