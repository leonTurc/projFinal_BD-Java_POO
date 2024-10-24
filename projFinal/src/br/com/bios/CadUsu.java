/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bios;

import br.com.DAO.UsuarioDAO;
import br.com.DTO.UsuarioDTO;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon
 */
public class CadUsu extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadUsu
     */
    public CadUsu() {
        initComponents();
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
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        txtNomeUsu = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/cosmosBack.jpg"));
        Image img= icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(img,0,0,getWidth(),getHeight(), this);
            }
        };
        jLabel7 = new javax.swing.JLabel();
        btnUpd = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnCreate5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setBorder(null);
        setClosable(true);
        setTitle("Usuarios");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuarios Horizon");

        jLabel2.setText("Nome");

        jLabel6.setText("ID");

        txtId.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jLabel3.setText("e-mail");

        jLabel4.setText("nome de usuario");

        jLabel5.setText("senha");

        txtNome.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        txtMail.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        txtNomeUsu.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        txtPass.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jDesktopPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 3));

        jLabel7.setFont(new java.awt.Font("Arial Black", 3, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Funções por ID");

        btnUpd.setBackground(new java.awt.Color(255, 255, 0));
        btnUpd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        btnUpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdActionPerformed(evt);
            }
        });

        btnRead.setBackground(new java.awt.Color(255, 255, 0));
        btnRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnRead.setMaximumSize(new java.awt.Dimension(75, 51));
        btnRead.setMinimumSize(new java.awt.Dimension(75, 51));
        btnRead.setPreferredSize(new java.awt.Dimension(75, 51));
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        btnDel.setBackground(new java.awt.Color(255, 255, 0));
        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnUpd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnRead, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnDel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 53, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRead, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(btnUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(btnRead, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        btnCreate5.setBackground(new java.awt.Color(153, 0, 204));
        btnCreate5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/create.png"))); // NOI18N
        btnCreate5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreate5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel2)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNomeUsu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnCreate5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCreate5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jDesktopPane1)
        );

        setBounds(0, 0, 909, 509);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdActionPerformed

        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha a area de nome.");
        } else if (txtMail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha a area de Email");
        } else if (txtNomeUsu.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha a area de nome de usuario");
        } else if (txtPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha a area de senha");
        } else {

            int idUsu = Integer.parseInt(txtId.getText());
            String nomeUsu = txtNome.getText();
            String mailUsu = txtMail.getText();
            String nome_usuarioUsu = txtNomeUsu.getText();
            String pass = txtPass.getText();

            UsuarioDTO dto = new UsuarioDTO();

            dto.setId(idUsu);
            dto.setNome(nomeUsu);
            dto.setEmail(mailUsu);
            dto.setNome_usuario(nome_usuarioUsu);
            dto.setSenha(pass);

            UsuarioDAO dao = new UsuarioDAO();
            dao.atualizar(dto);

        }
    }//GEN-LAST:event_btnUpdActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed

        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite um ID a ser deletado");
        } else {
            UsuarioDTO dto = new UsuarioDTO();

            int idUsu = Integer.parseInt(txtId.getText());

            dto.setId(idUsu);

            UsuarioDAO dao = new UsuarioDAO();
            dao.deletar(dto);
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnCreate5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreate5ActionPerformed

        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha a area de nome");
        } else if (txtMail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha a area de email");
        } else if (txtNomeUsu.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha a area de nome de usuario");
        } else if (txtPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha a area de senha");
        } else if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha a area de ID");
        } else {

            int IdUsu = Integer.parseInt(txtId.getText());
            String nomeUsu = txtNome.getText();
            String mailUsu = txtMail.getText();
            String nome_usuarioUsu = txtNomeUsu.getText();
            String pass = txtPass.getText();

            UsuarioDTO dto = new UsuarioDTO();

            dto.setId(IdUsu);
            dto.setNome(nomeUsu);
            dto.setEmail(mailUsu);
            dto.setNome_usuario(nome_usuarioUsu);
            dto.setSenha(pass);

            UsuarioDAO dao = new UsuarioDAO();
            dao.criar(dto);
        }
    }//GEN-LAST:event_btnCreate5ActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o ID a ser pesquisado");
        } else {

            UsuarioDTO dto = new UsuarioDTO();

            int idUsu = Integer.parseInt(txtId.getText());
            dto.setId(idUsu);

            UsuarioDAO dao = new UsuarioDAO();
            dao.pesquisar(dto);

        }
    }//GEN-LAST:event_btnReadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate5;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnUpd;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtMail;
    public static javax.swing.JTextField txtNome;
    public static javax.swing.JTextField txtNomeUsu;
    public static javax.swing.JTextField txtPass;
    // End of variables declaration//GEN-END:variables
}
