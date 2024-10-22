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

    public void limpar() {
        TelaAgenda.txtAno.setText(null);
        TelaAgenda.txtDia.setText(null);
        TelaAgenda.txtHora.setText(null);
        TelaAgenda.txtId.setText(null);
        TelaAgenda.txtMes.setText(null);
        TelaAgenda.txtMin.setText(null);
        TelaAgenda.txtNomeCli.setText(null);
        TelaAgenda.txtDesc.setText(null);
    }

    public void AutoPesquisar() {
        String sql = "select * from tb_agenda";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) TelaAgenda.tbAgenda.getModel();
            model.setNumRows(0);

            while (rs.next()) {
                int id = rs.getInt("id");
                Date data = rs.getDate("data");
                Time hora = rs.getTime("hora");
                String desc = rs.getString("descricao");
                String nome_cli = rs.getString("nome_cli");
                model.addRow(new Object[]{id, data, hora, desc, nome_cli});
            }
            conexao.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void adicionar(AgendaDTO dto) {
        String sql = "insert into tb_agenda (id, data, hora, descricao, nome_cli) values (?, ?, ?, ?, ?)";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, dto.getId());
            pst.setString(2, dto.getData());
            pst.setString(3, dto.getHora());
            pst.setString(4, dto.getDescricao());
            pst.setString(5, dto.getNome_cli());

            int go = pst.executeUpdate();

            if (go > 0) {
                JOptionPane.showMessageDialog(null, "adicionado com sucesso");
                limpar();
            } else {
                JOptionPane.showMessageDialog(null, "erro ao adicionar evento");
                limpar();
            }
            conexao.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(e.getMessage().contains("for key 'tb_agenda.PRIMARY'")){
                JOptionPane.showMessageDialog(null, "ID ja em uso");
            } else if (e.getMessage().contains("Data truncation: Incorrect date value:")){
                JOptionPane.showMessageDialog(null, "Data invalida para registro");
            } else if(e.getMessage().contains("Data truncation: Incorrect time value:")){
                JOptionPane.showMessageDialog(null, "Horario invalido para registro");
            }else {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    public void deletar(AgendaDTO dto) {
        int res = JOptionPane.showConfirmDialog(null, "quer mesmo deletar este evento?", null, JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            String sql = "delete from tb_agenda where id = ?";
            conexao = ConexaoDAO.connector();

            try {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, dto.getId());

                int go = pst.executeUpdate();

                if (go > 0) {
                    JOptionPane.showMessageDialog(null, "Deletado com sucesso");
                    limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "Evento não registrado");
                    limpar();
                }
                conexao.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    public void atualizar(AgendaDTO dto) {
        int res = JOptionPane.showConfirmDialog(null, "quer mesmo atualizar este evento?", null, JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            String sql = "update tb_agenda set data = ?, hora = ?, descricao = ?, nome_cli = ? where id = ?";
            conexao = ConexaoDAO.connector();

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, dto.getData());
                pst.setString(2, dto.getHora());
                pst.setString(3, dto.getDescricao());
                pst.setString(4, dto.getNome_cli());
                pst.setInt(5, dto.getId());
                int go = pst.executeUpdate();

                if (go > 0) {
                    JOptionPane.showMessageDialog(null, "Alterado com sucesso");
                    limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar");
                    limpar();
                }
                
                conexao.close();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro método atualizar " + e.getMessage());
                limpar();
            }
        }

    }

}
