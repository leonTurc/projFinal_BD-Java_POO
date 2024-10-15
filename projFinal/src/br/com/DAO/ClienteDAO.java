package br.com.DAO;

import br.com.DTO.ClienteDTO;
import br.com.bios.CadCli;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ClienteDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void limpar() {
        CadCli.txtMail.setText(null);
        CadCli.txtNome.setText(null);
        CadCli.txtEndereco.setText(null);
        CadCli.txtTelefone.setText(null);
        CadCli.txtCpfCnpj.setText(null);
    }

    public void criar(ClienteDTO dto) {
        String sql = "insert into tb_clientes(id, nome, endereco, telefone, email, cpf_cnpj) values(?, ?, ?, ?, ?, ?)";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);

            pst.setInt(1, dto.getIdCli());
            pst.setString(2, dto.getNome());
            pst.setString(3, dto.getEndereco());
            pst.setString(4, dto.getTelefone());
            pst.setString(5, dto.getEmail());
            pst.setString(6, dto.getCpf_cnpj());

            int add = pst.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
                limpar();
            }

            pst.close();

        } catch (Exception e) {
            if (e.getMessage().contains("for key 'tb_clientes.PRIMARY'")) {
                JOptionPane.showMessageDialog(null, "ID de ciente ja em uso");
            } else {
                JOptionPane.showMessageDialog(null, "metodo criar " + e);
            }
        }
    }

    public void pesquisar(ClienteDTO dto) {
        String sql = "select * from tb_clientes where id = ?";
        conexao = ConexaoDAO.connector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, dto.getIdCli());
            rs = pst.executeQuery();

            if (rs.next()) {
                CadCli.txtNome.setText(rs.getString(2));
                CadCli.txtEndereco.setText(rs.getString(3));
                CadCli.txtTelefone.setText(rs.getString(4));
                CadCli.txtMail.setText(rs.getString(5));
                CadCli.txtCpfCnpj.setText(rs.getString(6));
            } else {
                limpar();
                JOptionPane.showMessageDialog(null, "Usuario não cadastrado.");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "metodo pesquisar" + e);
        }

    }

    public void deletar(ClienteDTO dto) {
        int res = JOptionPane.showConfirmDialog(null, "Tem certeza que quer deletar o cliente de ID " + CadCli.txtId.getText() + "?",
                null, JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            String sql = "delete from tb_clientes where id = ? ";
            conexao = ConexaoDAO.connector();
            try {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, dto.getIdCli());
                int result = pst.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario deletado com sucesso");
                    CadCli.txtId.setText(null);
                    limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario não cadastrado");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "metodo deletar:" + e.getMessage());
            }
        }
    }

    public void atualizar(ClienteDTO dto) {
        int res = JOptionPane.showConfirmDialog(null, "Quer mesmo alterar o cliente de ID " + CadCli.txtId.getText() + "?",
                null, JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            String sql = "update tb_clientes set nome = ?, endereco= ?, telefone= ?, email= ?, cpf_cnpj= ? where id= ?";
            conexao = ConexaoDAO.connector();

            try {
                pst = conexao.prepareStatement(sql);

                pst.setString(1, dto.getNome());
                pst.setString(2, dto.getEndereco());
                pst.setString(3, dto.getTelefone());
                pst.setString(4, dto.getEmail());
                pst.setString(5, dto.getCpf_cnpj());
                pst.setInt(6, dto.getIdCli());

                int result = pst.executeUpdate();

                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Alterado com sucesso");
                    CadCli.txtId.setText(null);
                    limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "erro ao alterar");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "metodo criar " + e);
            }
        }
    }

}
