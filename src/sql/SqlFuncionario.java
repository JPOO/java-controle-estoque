
package sql;

import java.sql.*;
import javax.swing.JOptionPane;

public class SqlFuncionario extends SqlPessoa {
    
    private int idFuncionario;
    private float salario;
    
    public void setIdFuncionario(int idFuncionario){
        this.idFuncionario = idFuncionario;
    }
    
    public int getIdFuncionario(){
        return this.idFuncionario;
    }
    
    public void SetSalario(float salario){
        this.salario = salario;
    }
    
    public float GetSalario(){
        return this.salario;
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
