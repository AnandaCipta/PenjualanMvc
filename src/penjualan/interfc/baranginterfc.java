/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.interfc;

import java.sql.SQLException;
import java.util.List;
import penjualan.entity.barang;

/**
 *
 * @author User
 */
public interface baranginterfc {
    barang insert(barang o) throws SQLException;
    void update(barang o) throws SQLException;
    void delete(String kode_barang) throws SQLException;
    List getAll() throws SQLException;
    
}
