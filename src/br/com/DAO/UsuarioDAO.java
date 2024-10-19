package br.com.DAO;

import br.com.DTO.UsuarioDTO;
import br.com.bios.CadUsu;
import br.com.bios.TelaPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void limpar() {
        CadUsu.txtMail.setText(null);
        CadUsu.txtNome.setText(null);
        CadUsu.txtNomeUsu.setText(null);
        CadUsu.txtPass.setText(null);
    }

    public int logar(UsuarioDTO dto) {
        String sql = "select * from tb_usuarios where nome_usuario = ? and senha = ?";
        conexao = ConexaoDAO.connector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, dto.getNome_usuario());
            pst.setString(2, dto.getSenha());

            rs = pst.executeQuery();

            if (rs.next()) {
                TelaPrincipal principal = new TelaPrincipal();
                principal.setVisible(true);
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "usuario e/ou senha invalidos");
                return 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "tela login" + e);
            return 0;
        }
    }

    public void criar(UsuarioDTO dto) {
        String sql = "insert into tb_usuarios(id, nome, email, nome_usuario, senha) values(?, ?, ?, ?, ?)";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);

            pst.setInt(1, dto.getId());
            pst.setString(2, dto.getNome());
            pst.setString(3, dto.getEmail());
            pst.setString(4, dto.getNome_usuario());
            pst.setString(5, dto.getSenha());

            int add = pst.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Adicionado com sucesso");

            }

            pst.close();

        } catch (Exception e) {
            if (e.getMessage().contains("for key 'tb_usuarios.PRIMARY'")) {
                JOptionPane.showMessageDialog(null, "ID ja em uso");
            } else if (e.getMessage().contains("for key 'tb_usuarios.nome_usuario_UNIQUE'")) {
                JOptionPane.showMessageDialog(null, "nome de usuario ja em uso");
            } else if (e.getMessage().contains("for key 'tb_usuarios.email_UNIQUE'")) {
                JOptionPane.showMessageDialog(null, "Email ja em uso");
            } else {
                JOptionPane.showMessageDialog(null, "metodo criar " + e);

            }
        }

    }

    public int criarAoLogar(UsuarioDTO dto) {
        String sql = "insert into tb_usuarios(id, nome, email, nome_usuario, senha) values(?, ?, ?, ?, ?)";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);

            pst.setInt(1, dto.getId());
            pst.setString(2, dto.getNome());
            pst.setString(3, dto.getEmail());
            pst.setString(4, dto.getNome_usuario());
            pst.setString(5, dto.getSenha());

            int add = pst.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
                TelaPrincipal pri = new TelaPrincipal();
                pri.setVisible(true);
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            if (e.getMessage().contains("for key 'tb_usuarios.PRIMARY'")) {
                JOptionPane.showMessageDialog(null, "ID ja em uso");
                return 0;
            } else if (e.getMessage().contains("for key 'tb_usuarios.nome_usuario_UNIQUE'")) {
                JOptionPane.showMessageDialog(null, "nome de usuario ja em uso");
                return 0;
            } else if (e.getMessage().contains("for key 'tb_usuarios.email_UNIQUE'")) {
                JOptionPane.showMessageDialog(null, "Email ja em uso");
                return 0;
            } else {
                JOptionPane.showMessageDialog(null, "metodo criar " + e);
                return 0;
            }
        }

    }

    public void pesquisar(UsuarioDTO dto) {
        String sql = "select * from tb_usuarios where id = ?";
        conexao = ConexaoDAO.connector();
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, dto.getId());
            rs = pst.executeQuery();

            if (rs.next()) {
                CadUsu.txtNome.setText(rs.getString(2));
                CadUsu.txtMail.setText(rs.getString(3));
                CadUsu.txtNomeUsu.setText(rs.getString(4));
                CadUsu.txtPass.setText(rs.getString(5));
            } else {
                limpar();
                JOptionPane.showMessageDialog(null, "Usuario não cadastrado.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "metodo pesquisar" + e);
        }

    }

    public void deletar(UsuarioDTO dto) {
        int res = JOptionPane.showConfirmDialog(null, "Tem certeza que quer deletar este usuario?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            String sql = "delete from tb_usuarios where id = ? ";
            conexao = ConexaoDAO.connector();
            try {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, dto.getId());
                int result = pst.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario deletado com sucesso");
                    CadUsu.txtId.setText(null);
                    limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario não cadastrado");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "metodo deletar:" + e.getMessage());
            }
        }
    }

    public void atualizar(UsuarioDTO dto) {
        int res = JOptionPane.showConfirmDialog(null, "Quer mesmo alterar este usuario?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            String sql = "update tb_usuarios set nome = ?, email= ?, nome_usuario= ?, senha= ? where id= ?";
            conexao = ConexaoDAO.connector();

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, dto.getNome());
                pst.setString(2, dto.getEmail());
                pst.setString(3, dto.getNome_usuario());
                pst.setString(4, dto.getSenha());
                pst.setInt(5, dto.getId());

                int result = pst.executeUpdate();

                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Alterado com sucesso");
                    CadUsu.txtId.setText(null);
                    limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "erro ao alterar");
                }

            } catch (Exception e) {
                if (e.getMessage().contains("tb_usuarios.nome_usuario")) {
                    JOptionPane.showMessageDialog(null, "nome de usuario ja em uso");
                } else if (e.getMessage().contains("tb_usuarios.email")) {
                    JOptionPane.showMessageDialog(null, "Email ja em uso");
                } else {
                    JOptionPane.showMessageDialog(null, "metodo criar " + e);

                }
            }
        }
    }

}
