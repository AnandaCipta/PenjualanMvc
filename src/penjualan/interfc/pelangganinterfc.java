/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.interfc;

import java.sql.SQLException;
import java.util.List;
import penjualan.entity.pelanggan;

/**
 *
 * @author User
 */
public interface pelangganinterfc {
    pelanggan insert(pelanggan o) throws SQLException;
    void update(pelanggan o) throws SQLException;
    void delete(String id_pelanggan) throws SQLException;
    List getAll() throws SQLException;
}
