/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bios;

import br.com.DAO.ConexaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon
 */
public class CadUsu extends javax.swing.JFrame {

    /**
     * Creates new form CadUsu
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public CadUsu() {
        initComponents();
        conexao = ConexaoDAO.connector();
    }

    public void criar() {
        String sql = "insert into tb_usuarios (nome, email, nome_usuario, senha) values(?, ?, ?, ?)";
        try {
            pst = conexao.prepareStatement(sql);

            if (txtNome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha a area de nome.");
            } else if (txtMail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha a area de Email");
            } else if (txtNomeUsu.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha a area de nome de usuario");
            } else if (txtPass.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha a area de senha");
            } else {
                pst.setString(1, txtNome.getText());
                pst.setString(2, txtMail.getText());
                pst.setString(3, txtNomeUsu.getText());
                pst.setString(4, txtPass.getText());
            }

            int add = pst.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Criado com sucesso");
                txtNome.setText(null);
                txtMail.setText(null);
                txtNomeUsu.setText(null);
                txtPass.setText(null);
            }

        } catch (Exception e) {
            if (e.getMessage().contains("tb_usuarios.nome_usuario")) {
                JOptionPane.showMessageDialog(null, "Nome de usuario ja em uso.");
            } else if (e.getMessage().contains("tb_usuarios.email")) {
                JOptionPane.showMessageDialog(null, "email ja em uso");
            } else {
                JOptionPane.showMessageDialog(null, "metodo criar " + e);
            }

        }
    }
    
    public void deletar(){
        int res= JOptionPane.showConfirmDialog(null, "Tem certeza que quer deletar este usuario?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION){
            String sql= "delete from tb_usuarios where id = ? ";
            try{
                pst= conexao.prepareStatement(sql);
                pst.setString(1, txtId.getText());
                int result = pst.executeUpdate();
                if(result > 0){
                    JOptionPane.showMessageDialog(null, "Usuario deletado com sucesso");
                    txtId.setText(null);
                    txtNome.setText(null);
                    txtMail.setText(null);
                    txtNomeUsu.setText(null);
                    txtPass.setText(null);
                } else{
                    JOptionPane.showMessageDialog(null, "Usuario não cadastrado");
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "metodo deletar:"+e.getMessage());
            }
        }
    }
    
    public void atualizar(){
        int res= JOptionPane.showConfirmDialog(null, "Quer mesmo alterar este usuario?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION){
            String sql= "update tb_usuarios set nome = ?, email= ?, nome_usuario= ?, senha= ? where id= ?";
            
            try{
                pst= conexao.prepareStatement(sql);
                pst.setString(1, txtNome.getText());
                pst.setString(2, txtMail.getText());
                pst.setString(3, txtNomeUsu.getText());
                pst.setString(4, txtPass.getText());
                pst.setString(5, txtId.getText());
                
                if (txtNome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha a area de nome.");
            } else if (txtMail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha a area de Email");
            } else if (txtNomeUsu.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha a area de nome de usuario");
            } else if (txtPass.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha a area de senha");
            } else{
                int result= pst.executeUpdate();
                
                if(result > 0){
                    JOptionPane.showMessageDialog(null, "Alterado com sucesso");
                    txtId.setText(null);
                    txtNome.setText(null);
                    txtMail.setText(null);
                    txtNomeUsu.setText(null);
                    txtPass.setText(null);
                } else {
                    JOptionPane.showMessageDialog(null, "erro ao alterar");
                    }
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "metodo Atualizar "+e.getMessage());
            }
        }
    }

    public void pesquisar() {
        String sql = "select * from tb_usuarios where id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtId.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                txtNome.setText(rs.getString(2));
                txtMail.setText(rs.getString(3));
                txtNomeUsu.setText(rs.getString(4));
                txtPass.setText(rs.getString(5));
            } else {
                txtNome.setText(null);
                txtMail.setText(null);
                txtNomeUsu.setText(null);
                txtPass.setText(null);
                JOptionPane.showMessageDialog(null, "Usuario não cadastrado.");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "metodo pesquisar" + e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        txtNomeUsu = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        btnUpd = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 27)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tela de usuarios");

        jLabel2.setText("Nome");

        jLabel3.setText("e-mail");

        jLabel4.setText("nome de usuario");

        jLabel5.setText("senha");

        btnCreate.setText("Criar");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnRead.setText("pesquisar");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        btnUpd.setText("atualizar");
        btnUpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdActionPerformed(evt);
            }
        });

        btnDel.setText("deletar");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        jLabel6.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMail))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeUsu, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPass)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRead)
                                .addGap(18, 18, 18)
                                .addComponent(btnDel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpd)))
                        .addGap(0, 22, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(btnCreate)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRead)
                            .addComponent(btnDel)
                            .addComponent(btnUpd))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNomeUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        pesquisar();
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        criar();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        deletar();
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnUpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdActionPerformed
        atualizar();
    }//GEN-LAST:event_btnUpdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadUsu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadUsu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadUsu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadUsu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadUsu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnUpd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeUsu;
    private javax.swing.JTextField txtPass;
    // End of variables declaration//GEN-END:variables
}
