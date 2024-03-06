/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        try{
            conn = new conectaDAO().connectDB();
                
            Statement st = conn.createStatement(); 
            st.executeUpdate("INSERT INTO produtos (nome,valor,status) VALUES ('"+produto.getNome()+"','"+produto.getValor()+"','"+produto.getStatus()+"')");
        }
        catch(SQLException ex){ }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
                String sql = "SELECT * FROM produtos";
                
                try {
                    conn = new conectaDAO().connectDB();
                
                    PreparedStatement prep = conn.prepareStatement(sql);
                    ResultSet resultset = prep.executeQuery();            
                    
                    ArrayList<ProdutosDTO> lista = new ArrayList<>();
                    
                    while (resultset.next()) {
                            ProdutosDTO produto = new ProdutosDTO();
                            produto.setId(resultset.getInt("id"));        
                            produto.setNome(resultset.getString("nome"));
                            produto.setValor(resultset.getInt("valor"));
                            produto.setStatus(resultset.getString("status"));    
                                
                        
                        lista.add(produto);    
                    }
                    return lista;
                  
                } 
                catch (Exception e) {
                    return null;
                }
    }
    
    public void venderProduto (int p){
        try{
            conn = new conectaDAO().connectDB();
                
            Statement st = conn.createStatement(); 
            st.executeUpdate("UPDATE produtos SET status='Vendido' WHERE id = "+p);
        }
        catch(SQLException ex){ }      
    }
    
    public ArrayList<ProdutosDTO> listarProdutosVendidos(){
                String sql = "SELECT * FROM produtos WHERE status='Vendido'";
                
                try {
                    conn = new conectaDAO().connectDB();
                
                    PreparedStatement prep = conn.prepareStatement(sql);
                    ResultSet resultset = prep.executeQuery();            
                    
                    ArrayList<ProdutosDTO> lista = new ArrayList<>();
                    
                    while (resultset.next()) {
                            ProdutosDTO produto = new ProdutosDTO();
                            produto.setId(resultset.getInt("id"));        
                            produto.setNome(resultset.getString("nome"));
                            produto.setValor(resultset.getInt("valor"));
                            produto.setStatus(resultset.getString("status"));    
                                
                        
                        lista.add(produto);    
                    }
                    return lista;
                  
                } 
                catch (Exception e) {
                    return null;
                }
    }      
}

