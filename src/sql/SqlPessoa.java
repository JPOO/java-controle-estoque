
package sql;

import javax.swing.JOptionPane;

public abstract class SqlPessoa extends Conexao implements Autenticar {
    
    int idPessoa;
    int idEndereco;
    String nome;
    String dataNasc;
    String cpf;
    
    
    public void setIdPessoa(int idPessoa){
        this.idPessoa = idPessoa;
    }
    
    public int getIdPessoa(){
        return this.idPessoa;
    }
    
    public void setIdEndereco(int idEndereco){
        this.idEndereco = idEndereco;
    }
    
    public int getIdEndereco(){
        return this.idEndereco;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setDataNasc(String dataNasc){
        this.dataNasc = dataNasc;
    }
    
    public String getDataNasc(){
        return this.dataNasc;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    public int consultarIdPessoa(){
        try{
            stm = con.createStatement();
            String sql = "SELECT idPessoa FROM PESSOA";
            rs = stm.executeQuery(sql);
            if(rs.last()){
                setIdPessoa(Integer.parseInt(String.valueOf(rs.getObject("idPessoa"))));
            }
        }catch (Exception e){
            System.out.println(e);
        }return getIdPessoa();
    }
    
}
