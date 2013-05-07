
package sql;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SqlEndereco extends Conexao implements Autenticar {
    
    private int idEndereco;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    
    public void setIdEndereco(int idEndereco){
        this.idEndereco = idEndereco;
    }
    
    public int getIdEndereco(){
        return this.idEndereco;
    }
    
    public void setRua(String rua){
        this.rua = rua;
    }
    
    public String getRua(){
        return this.rua;
    }
    
    public void setBairro (String bairro){
        this.bairro = bairro;
    }
    
    public String getBairro(){
        
        return this.bairro;
    }
    
    public void setCidade (String cidade){
        this.cidade = cidade;
    }
    
    public String getCidade(){
        
        return this.cidade;
    }
    
    public void setEstado (String estado){
        this.estado = estado;
    }
    
    public String getEstado(){
        
        return this.estado;
    }
    
    public String gravar(String rua, String bairro, String cidade, String estado){
        conectar();
        try{
            stmt = con.prepareStatement("INSERT INTO ENDERECO(idEndereco, rua, bairro, cidade, estado) VALUES (0,?,?,?,?)");
            stmt.setString(1, rua);
            stmt.setString(2, bairro);
            stmt.setString(3, cidade);
            stmt.setString(4, estado);
            stmt.executeUpdate();
            stmt.executeQuery("COMMIT");
        }catch(Exception e){
            System.out.println(e);
        }
        desconectar();
        return null;
    }
    
    public String consultar(int idEndereco){
        conectar();
        try{
            stm = con.createStatement();
            String sql = "SELECT * FROM ENDERECO WHERE idEndereco="+idEndereco;
            rs = stm.executeQuery(sql);
            if (rs.next()){
                setRua(String.valueOf(rs.getObject("rua")));
                setBairro(String.valueOf(rs.getObject("bairro")));
                setCidade(String.valueOf(rs.getObject("cidade")));
                setEstado(String.valueOf(rs.getObject("estado")));
            }else{
                JOptionPane.showMessageDialog(null, "ID inválido!","Atenção!",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        desconectar();
        return null;
    }
    
    /**
     *
     * @param idEndereco
     * @return
     */
    public String excluir(int idEndereco){
        conectar();
        try{
            stm = con.createStatement();
            String sql = "DELETE FROM ENDERECO WHERE idEndereco ="+idEndereco;
            stm.execute(sql);
            stm.executeQuery("COMMIT");
        }catch (Exception e){
            System.out.println(e);
        }
        desconectar();
        return null;
    }
    
    public String editar(int id, String rua, String bairro, String cidade, String estado){
        conectar();
        try{
            stm = con.createStatement();
            String sql = "UPDATE ENDERECO SET rua = '"+rua+"', bairro = '"+bairro+"', cidade = '"+cidade+"', estado = '"+estado+"' WHERE idEndereco = "+id;
            stm.executeUpdate(sql);
            stm.execute("COMMIT");
        }catch(Exception e){
            System.out.println(e);
        }
        desconectar();
        return null;
    }
    
    public int consultarId(){
        conectar();
        try{
            stm = con.createStatement();
            String sql = "SELECT idEndereco FROM ENDERECO";
            rs = stm.executeQuery(sql);
            if (rs.last()){
                setIdEndereco(Integer.parseInt(String.valueOf(rs.getObject("idEndereco"))));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        desconectar();    
        return getIdEndereco();
        

        
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

    

