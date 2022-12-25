
package view;

/**
 *
 * @author Edilson Ricardo
 */
import dao.ModuloConexao;
import java.sql.*;
import javax.swing.JOptionPane;

public class TelaCadUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaCadUsuario
     */
    public TelaCadUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
        lblSelecioneTipodePerfil.setVisible(false);
    }

    private void consultar() {
        String sql = "Select * from tbusuarios where iduser=?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, txtId.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                String nomeDoUsuario = rs.getString(2);
                String nrTelefone = rs.getString(3);
                String nomeLogin = rs.getString(4);
                String senha = rs.getString(5);
                String niveldeAcesso = rs.getString(6);
                txtNome.setText(nomeDoUsuario);
                txtTelefone.setText(nrTelefone);
                txtNomeLogin.setText(nomeLogin);
                txtSenha.setText(senha);
                cbPerfil.setSelectedItem(niveldeAcesso);
            } else {
                JOptionPane.showMessageDialog(null, "Id inexistente.");
                txtNome.setText("");
                txtId.setText("");
                txtTelefone.setText("");
                txtNomeLogin.setText("");
                txtSenha.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void cadastrarUsuario() {
        String sql = "Insert into tbusuarios (usuario, fone, login, senha, perfil) values (?,?,?,?,?)";
        try {
            ps = conexao.prepareStatement(sql);
            // ps.setString(1, txtId.getText());
            ps.setString(1, txtNome.getText());
            ps.setString(2, txtTelefone.getText());
            ps.setString(3, txtNomeLogin.getText());
            ps.setString(4, txtSenha.getText());
            ps.setString(5, cbPerfil.getSelectedItem().toString());
            // Validação da campos obrigatorios
            if (txtNome.getText().isEmpty() || txtNomeLogin.getText().isEmpty() || String.valueOf(txtSenha.getPassword()).isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatorios");

            } else {
                if (cbPerfil.getSelectedItem().toString().equals("seleccione")) {
                    lblSelecioneTipodePerfil.setVisible(true);
                } else {

                    //As linhas abaixo sao usadas para confirmar a insercao de dados na tabela
                    int adicionar = ps.executeUpdate();//A linha actualiza a tabela usuarios com os dados do formulario. Poderia ter sido somente "ps.executeUpdate()"

                    if (adicionar > 0) {
                        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso.");
                        txtNome.setText("");
                        txtId.setText("");
                        txtTelefone.setText("");
                        txtNomeLogin.setText("");
                        txtSenha.setText("");
                        lblSelecioneTipodePerfil.setVisible(false);
                    }
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void actualizarDados() {
        String sql = "Update tbusuarios set usuario=?, fone=?, login=?, senha=?, perfil=? where iduser=?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, txtNome.getText());
            ps.setString(2, txtTelefone.getText());
            ps.setString(3, txtNomeLogin.getText());
            ps.setString(4, String.valueOf(txtSenha.getPassword()));
            ps.setString(5, cbPerfil.getSelectedItem().toString());
            ps.setString(6, txtId.getText());
            // Validação da campos obrigatorios
            if (txtNome.getText().isEmpty() || txtNomeLogin.getText().isEmpty() || String.valueOf(txtSenha.getPassword()).isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatorios");

            } else {
                if (cbPerfil.getSelectedItem().toString().equals("seleccione")) {
                    lblSelecioneTipodePerfil.setVisible(true);
                } else {

                    //As linhas abaixo sao usadas para confirmar a actualizar de dados na tabela
                    int adicionar = ps.executeUpdate();//A linha actualiza a tabela usuarios com os dados do formulario. Poderia ter sido somente "ps.             executeUpdate()"

                    if (adicionar > 0) {
                        JOptionPane.showMessageDialog(null, "Dado(s) actualizado(s) com sucesso.");
                        txtNome.setText("");
                        txtId.setText("");
                        txtTelefone.setText("");
                        txtNomeLogin.setText("");
                        txtSenha.setText("");
                        lblSelecioneTipodePerfil.setVisible(false);
                    }
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void apagarUsuario() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tbusuarios where iduser=?";
            try {
                ps = conexao.prepareStatement(sql);
                ps.setString(1, txtId.getText());
                int apagado = ps.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso.");
                    txtNome.setText("");
                    txtId.setText("");
                    txtTelefone.setText("");
                    txtNomeLogin.setText("");
                    txtSenha.setText("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
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
        jLabel6 = new javax.swing.JLabel();
        cbPerfil = new javax.swing.JComboBox<>();
        txtNomeLogin = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblSelecioneTipodePerfil = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(876, 620));

        jLabel1.setText("id:");

        jLabel2.setText("* Nome:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("* Nome de Login:");

        jLabel5.setText("* Senha:");

        jLabel6.setText("Perfil:");

        cbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione", "admin", "padrao" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setText("CADASTRO DE USUARIOS");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setToolTipText("Adicionar mais um usuário ao sistema");
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnConsultar.setText("Consultar");
        btnConsultar.setToolTipText("Verificar um usuário do Sistema");
        btnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.setToolTipText("Actualizar Dados do Usuário");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnApagar.setText("Apagar");
        btnApagar.setToolTipText("Eliminar um usuário");
        btnApagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        jLabel8.setText("* Campos obrigatórios");

        lblSelecioneTipodePerfil.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblSelecioneTipodePerfil.setForeground(new java.awt.Color(255, 0, 0));
        lblSelecioneTipodePerfil.setText("Seleccione um tipo de perfil");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(58, 58, 58)
                .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(84, 84, 84)
                .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(73, 73, 73)
                .addComponent(btnApagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(140, 140, 140))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNome)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSelecioneTipodePerfil)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNomeLogin)
                        .addComponent(cbPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(txtNomeLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSelecioneTipodePerfil)
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnConsultar)
                    .addComponent(btnActualizar)
                    .addComponent(btnApagar))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        setBounds(0, 0, 875, 621);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        consultar();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        cadastrarUsuario();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        actualizarDados();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        // TODO add your handling code here:
        apagarUsuario();
    }//GEN-LAST:event_btnApagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JComboBox<String> cbPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblSelecioneTipodePerfil;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeLogin;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
