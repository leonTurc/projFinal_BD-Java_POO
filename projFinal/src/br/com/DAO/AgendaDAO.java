
package br.com.DAO;

import br.com.DTO.AgendaDTO;
import br.com.bios.TelaAgenda;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AgendaDAO {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void AutoPesquisar(){
        String sql = "select * from tb_agenda";
        conexao = ConexaoDAO.connector();
        
        try{
            pst= conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) TelaAgenda.tbAgenda.getModel();
            model.setNumRows(0);
            
            while(rs.next()){
                int id = rs.getInt("id");
                Date data = rs.getDate("data");
                Time hora = rs.getTime("hora");
                String desc = rs.getString("descricao");
                String nome_cli = rs.getString("nome_cli");
                model.addRow(new Object[]{id, data, hora, desc, nome_cli});
            }
            conexao.close();
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    public void adicionar(AgendaDTO dto){
       String sql = "insert into tb_agenda (id, data, hora, descricao, nome_cli) values (?, ?, ?, ?, ?)";
       conexao = ConexaoDAO.connector();
       
       try{
           pst = conexao.prepareStatement(sql);
           pst.setInt(1, dto.getId());
           pst.setString(2, dto.getData());
           pst.setString(3, dto.getHora());
           pst.setString(4, dto.getDescricao());
           pst.setString(5, dto.getNome_cli());
           
           int go = pst.executeUpdate();
           
           if(go > 0){
               JOptionPane.showMessageDialog(null, "adicionado com sucesso");
           } else {
               JOptionPane.showMessageDialog(null, "erro ao adicionar evento");
           }
           pst.close();
           
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }
    
    public void deletar(AgendaDTO dto){
        String sql = "delete from tb_agenda where id = ?";
        conexao = ConexaoDAO.connector();
        
        try{
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, dto.getId());
            
            int go = pst.executeUpdate();
            
            if(go > 0){
                JOptionPane.showMessageDialog(null, "Deletado com sucesso");
            } else{
                JOptionPane.showMessageDialog(null, "Evento não registrado");
            }
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
