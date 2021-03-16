/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import penjualan.entity.pelanggan;
import penjualan.interfc.pelangganinterfc;
import penjualan.koneksi.koneksi;

/**
 *
 * @author User
 */
public class pelangganimplement implements pelangganinterfc{
  
    public pelanggan insert(pelanggan o) throws SQLException{
    PreparedStatement st=koneksi.getConnection().prepareStatement
            ("insert into pelanggan values(?,?,?,?,?)");
        st.setString(1, o.getIdPelanggan());
        st.setString(2, o.getNama());
        st.setString(3, o.getJeniskel());
        st.setString(4, o.getAlamat());
        st.setString(5, o.getNotlp());
        st.executeUpdate();
        return o;
    }
    @Override
    public void update(pelanggan o) throws SQLException{
    PreparedStatement st= koneksi.getConnection().prepareStatement
            ("UPDATE pelanggan SET nama=?, jk=?, alamat=?, notlp=? WHERE id_pelanggan = ?");
        st.setString(1, o.getNama());
        st.setString(2, o.getJeniskel());
        st.setString(3, o.getAlamat());
        st.setString(4, o.getNotlp());
        st.setString(5, o.getIdPelanggan());
        st.executeUpdate();
    }
    @Override
    public void delete(String id_pelanggan) throws SQLException{
     PreparedStatement st=koneksi.getConnection().prepareStatement
             ("delete from pelanggan where id_pelanggan=?");
     st.setString(1, id_pelanggan);
     st.executeUpdate();
    }
    @Override
    public List<pelanggan>  getAll() throws SQLException {
   Statement st=koneksi.getConnection().createStatement();
    ResultSet rs=st.executeQuery("select * from pelanggan");
    List<pelanggan>list=new ArrayList<pelanggan>();
    while(rs.next()){
    pelanggan plg=new pelanggan();
    plg.setIdPelanggan(rs.getString("id_pelanggan"));
    plg.setNama(rs.getString("nama"));
    plg.setJeniskel(rs.getString("jk"));
    plg.setAlamat(rs.getString("alamat"));
    plg.setNotlp(rs.getString("notlp"));
    list.add(plg);
    }
    return list;  
    }    
}
