
package sql;

import java.sql.*;
import javax.swing.JOptionPane;

public class SqlCliente extends SqlPessoa implements Autenticar {
    private double limiteCompra;
    private int Pessoa_idPessoa;
   
    public void setPessoa_idPessoa(int Pessoa_idPessoa) {
        this.Pessoa_idPessoa = Pessoa_idPessoa;
    }
    
    public int getPessoa_idPessoa() {
        return this.Pessoa_idPessoa;
    }
        
    public void setLimiteCompra(double limiteCompra) {
        this.limiteCompra = limiteCompra;
    }
    
    public double getLimiteCompra() {
        return this.limiteCompra;
    }
    
    //mÃ©todos da interface autenticar
    public String gravar(int idEndereco, String nome, String dataNasc, String cpf, double limiteCompra){
        conectar();
        try{
            stmt = con.prepareStatement("INSERT INTO pessoa(idPessoa, Endereco_idEndereco, nome, dataNasc, cpf) VALUES(0,?,?,?,?)");
            stmt.setInt(1, idEndereco);
            stmt.setString(2, nome);
            stmt.setString(3, dataNasc);
            stmt.setString(4, cpf);
            stmt.executeUpdate();
            stmt.executeQuery("COMMIT");
            int idPessoa = consultarIdPessoa();
            stmt = con.prepareStatement("INSERT INTO cliente(Pessoa_idPessoa, limiteCompra) VALUES(?,?)");
            stmt.setInt(1, idPessoa);
            stmt.setDouble(2, limiteCompra);
            stmt.executeUpdate();
            stmt.executeQuery("COMMIT");
        }catch (Exception e) {
            System.out.println(e);
        }
        desconectar();
        return null;
    }
    
    public String consultar(int id){
        conectar();
        try{
            stm = con.createStatement();
            String sql = "SELECT * FROM Pessoa, Cliente WHERE cliente.Pessoa_idPessoa="+id+" AND pessoa.idPessoa="+id;
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                setIdEndereco(Integer.parseInt(String.valueOf(rs.getObject("pessoa.Endereco_idEndereco"))));
                setNome(String.valueOf(rs.getObject("pessoa.nome")));
                setDataNasc(String.valueOf(rs.getObject("pessoa.dataNasc")));
                setCpf(String.valueOf(rs.getObject("pessoa.cpf")));
                setLimiteCompra(Double.parseDouble(String.valueOf(rs.getObject("cliente.limiteCompra"))));
            }else{
                JOptionPane.showMessageDialog(null, "Id invÃ¡lida!", "AtenÃ§Ã£o!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e){
            System.out.println(e);
        }
        desconectar();
        return null;
    }
    
    public String excluir(int id){
        conectar();
        try{
            stm = con.createStatement();
            String sql = "DELETE FROM Cliente WHERE Pessoa_idPessoa="+id;
            stm.execute(sql);
            stm.executeQuery("COMMIT");
            stm = con.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
        desconectar();
        return null;
    }
    
    public String editar(int id, String nome, String dataNasc, String cpf, double limiteCompra){
        conectar();
        try{
            stm = con.createStatement();
            String sql ="UPDATE cliente SET limiteCompra ='"+limiteCompra+"' WHERE Pessoa_idPessoa="+id ;
            stm.executeUpdate(sql);
            stm.execute("COMMIT");
            String sql ="UPDATE pessoa SET nome ='"+nome+"', dataNasc ='"+dataNasc+"', cpf = '"+cpf+"' WHERE idPessoa="+id;
            stm.executeUpdate(sql);
            stm.execute("COMMIT");
        }catch(Exception e){
            System.out.println(e);
        }
        desconectar();
        return null;
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

    @Override
    public String editar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
