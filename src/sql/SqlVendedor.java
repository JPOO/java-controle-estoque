
package sql;

public class SqlVendedor extends SqlFuncionario{
    
    int idVendedor;
    
    public void setIdVendedor(int idVendedor){
        this.idVendedor = idVendedor;
    }
    
    public int getIdVendedor(){
        return this.idVendedor;
    }
    
    public String gravar(int idEndereco, String nome, String dataNasc, String cpf, double salario){
        conectar();
        try{
            stmt = con.prepareStatement("INSERT INTO FORNECEDOR(idFornecedor, Endereco_idEndereco, nome, dataNasc, cpf) VALUES (0,?,?,?,?)");
            stmt.setInt(1, idEndereco);
            stmt.setString(2, nome);
            stmt.setString(3, dataNasc);
            stmt.setString(4, cpf);
            stmt.executeUpdate();
            stmt.executeQuery("COMMIT");
            int idPessoa = consultarIdPessoa();
            stmt = con.prepareStatement("INSERT INTO FUNCIONARIO(Pessoa_idPessoa, salario) VALUES (?,?)");
            stmt.setInt(1, idPessoa);
            stmt.setDouble(2, salario);
            stmt.executeUpdate();
            stmt.executeQuery("COMMIT");
            stmt = con.prepareStatement("INSERT INTO VENDEDOR(Funcionario_Pessoa_idPessoa) VALUES (?)");
            stmt.setInt(1, idPessoa);
            stmt.executeUpdate();
            stmt.executeQuery("COMMIT");
        }catch(Exception e){
            System.out.println(e);
        }
        desconectar();
        return null;
    }
    
}
