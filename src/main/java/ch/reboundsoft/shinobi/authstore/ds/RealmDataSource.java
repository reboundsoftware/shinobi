/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.reboundsoft.shinobi.authstore.ds;

import javax.sql.DataSource;

/**
 *
 * @author rma
 */
public interface RealmDataSource {
    public DataSource getDataSource();
}
