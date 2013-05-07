
package sql;

import java.sql.*;
import javax.swing.JOptionPane;

public class SqlFornecedor extends Conexao implements Autenticar {
    
    private int idFornecedor;
    private String nome;
    private String cnpj;
    private int idEndereco;
    
     public void setIdEndereco(int idEndereco){
        this.idEndereco = idEndereco;
    }
    
    public int getIdEndereco(){
        return this.idEndereco;
    }
    
    public void setIdFornecedor(int idFornecedor){
        this.idFornecedor = idFornecedor;
    }
    
    public int getIdFornecedor(){
        return this.idFornecedor;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
    
    public String getCnpj(){
        
        return this.cnpj;
    }
    
    public String gravar(int idEndereco, String nome, String cnpj){
        conectar();
        try{
            stmt = con.prepareStatement("INSERT INTO FORNECEDOR(idFornecedor, Endereco_idEndereco, nome, cnpj) VALUES (0,?,?,?)");
            stmt.setInt(1, idEndereco);
            stmt.setString(2, nome);
            stmt.setString(3, cnpj);
            stmt.executeUpdate();
            stmt.executeQuery("COMMIT");
        }catch(Exception e){
            System.out.println(e);
        }
        desconectar();
        return null;
    }
    
    public String consultar(int idFornecedor){
        conectar();
        try{
            stm = con.createStatement();
            String sql = "SELECT * FROM FORNECEDOR WHERE idFornecedor="+idFornecedor;
            rs = stm.executeQuery(sql);
            if (rs.next()){
                setIdEndereco(Integer.parseInt(String.valueOf(rs.getObject("Endereco_idEndereco"))));
                setNome(String.valueOf(rs.getObject("nome")));
                setCnpj(String.valueOf(rs.getObject("cnpj")));
            }else{
                JOptionPane.showMessageDialog(null, "ID inválido!","Atenção!",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        desconectar();
        return null;
    }

    public String excluir(int idFornecedor){
        conectar();
        try{
            stm = con.createStatement();
            String sql = "DELETE FROM FORNECEDOR WHERE idFornecedor ="+idFornecedor;
            stm.execute(sql);
            stm.executeQuery("COMMIT");
        }catch (Exception e){
            System.out.println(e);
        }
        desconectar();
        return null;
    }
    
    public String editar(int idFornecedor, String nome, String cnpj){
        conectar();
        try{
            stm = con.createStatement();
            String sql = "UPDATE FORNECEDOR SET nome = '"+nome+"', cnpj = '"+cnpj+"' WHERE idFornecedor = "+idFornecedor;
            stm.executeUpdate(sql);
            stm.execute("COMMIT");
        }catch(Exception e){
            System.out.println(e);
        }
        desconectar();
        return null;
    }

    @Override
    public String editar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String gravar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String consultar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   

    @Override
    public String excluir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
